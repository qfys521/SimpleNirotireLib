package cn.qfys521.config;

import cn.qfys521.string.SuppressWarningsStrings;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

/**
 * A configuration class specifically for handling YAML serialization and deserialization of data. Extends the generic
 * `Config` class and provides methods for saving and loading data to/from a YAML file.
 *
 * @param <T> The type of data this configuration holds.
 */
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings(SuppressWarningsStrings.UNUSED)
@Data
public class YamlConfig<T> extends Config<T> {

    /**
     * An ObjectMapper configured as a YAMLMapper for YAML handling, with WRITE_DOC_START_MARKER disabled. Disabling
     * this feature prevents an unnecessary "---" (document start marker) from being written to the YAML output.
     */
    private final ObjectMapper objectMapper = YAMLMapper.builder()
            .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
            .build();
    /**
     * The data object to be serialized or deserialized.
     */
    private Object t;
    /**
     * The file path where the YAML data will be stored or loaded.
     */
    private File file;

    /**
     * Creates a new YamlConfig instance with the provided data object and file name.
     *
     * @param t        The data object to be serialized or deserialized.
     * @param fileName The name of the file to store or load the YAML data.
     */
    @SneakyThrows
    public YamlConfig(T t, String fileName) {
        this.t = t;
        this.file = new File(fileName);
    }

    /**
     * Saves the data object `t` to the configured file path in YAML format. Throws an IOException if any errors occur
     * during file operations.
     */
    @SneakyThrows
    public void saveOrFail() {
        objectMapper.writeValue(file, t);
    }

    /**
     * Loads the data object from the configured file path and casts it to the type `T`. Creates a new file if it
     * doesn't exist before loading. Throws an IOException if any errors occur during file operations.
     *
     * @return The data object loaded from the YAML file, cast to the type `T`.
     */
    @SneakyThrows
    @SuppressWarnings("unchecked")
    public T loadOrFail() {
        createNewFile();
        return (T) (t = objectMapper.readValue(file, t.getClass()));
    }

    /**
     * Creates a new file at the configured file path if it doesn't already exist. If the file is created successfully,
     * writes the data object `t` to it. Throws an IOException if any errors occur during file operations.
     */
    @SneakyThrows
    private void createNewFile() {
        if (!file.exists()) {
            var a = file.createNewFile();
            objectMapper.writeValue(file, t);
        }
    }

    /**
     * Converts the data object `t` to a YAML string format. Throws an IOException if any errors occur during
     * serialization.
     *
     * @return The YAML string representation of the data object `t`.
     */
    @SneakyThrows
    public String toYaml() {
        return objectMapper.writeValueAsString(t);
    }
}