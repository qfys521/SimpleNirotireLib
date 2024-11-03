package cn.qfys521.config;

import cn.qfys521.string.SuppressWarningsStrings;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

/**
 * A configuration class specifically for handling XML serialization and deserialization of data. Extends the generic
 * `Config` class and provides methods for saving and loading data to/from an XML file.
 *
 * @param <T> The type of data this configuration holds.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings(SuppressWarningsStrings.UNUSED)
public class XmlConfig<T> extends Config<T> {

    /**
     * An instance of ObjectMapper configured as an XmlMapper for XML handling.
     */
    private final ObjectMapper mapper = new XmlMapper();

    /**
     * The data object to be serialized or deserialized.
     */
    private Object t;

    /**
     * The file path where the XML data will be stored or loaded.
     */
    private File file;

    /**
     * Creates a new XmlConfig instance with the provided data object and file name. Enables
     * {@link SerializationFeature#INDENT_OUTPUT} for human-readable XML output.
     *
     * @param t        The data object to be serialized or deserialized.
     * @param fileName The name of the file to store or load the XML data.
     */
    public XmlConfig(T t, String fileName) {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.t = t;
        file = new File(fileName);
    }

    /**
     * Saves the data object `t` to the configured file path in XML format. Throws an IOException if any errors occur
     * during file operations.
     */
    @SneakyThrows
    public void saveOrFail() {
        mapper.writer().writeValue(file, t);
    }

    /**
     * Loads the data object from the configured file path and casts it to the type `T`. Creates a new file if it
     * doesn't exist before loading. Throws an IOException if any errors occur during file operations.
     *
     * @return The data object loaded from the XML file, cast to the type `T`.
     */
    @SneakyThrows
    @SuppressWarnings(SuppressWarningsStrings.UNCHECKED)
    public T loadOrFail() {
        createNewFile();
        return (T) (t = this.mapper.readValue(file, t.getClass()));
    }

    /**
     * Creates a new file at the configured file path if it doesn't already exist. If the file is created successfully,
     * writes the data object `t` to it. Throws an IOException if any errors occur during file operations.
     */
    @SneakyThrows
    public void createNewFile() {
        if (!file.exists()) {
            var a = file.createNewFile();
            mapper.writeValue(file, t);
        }
    }

    /**
     * Converts the data object `t` to an XML string format. Throws an IOException if any errors occur during
     * serialization.
     *
     * @return The XML string representation of the data object `t`.
     */
    @SneakyThrows
    public String toXml() {
        return mapper.writeValueAsString(t);
    }
}