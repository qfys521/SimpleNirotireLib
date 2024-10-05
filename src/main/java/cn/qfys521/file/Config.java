package cn.qfys521.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;

/**
 * This class provides a configuration utility for managing generic data loaded from and saved to files.
 * It utilizes Jackson for serialization and deserialization.
 *
 * @param <T> The type of data stored in the configuration file.
 */
@Data
public class Config<T> {

    /**
     * An instance of ObjectMapper used for serialization and deserialization.
     */
    private final ObjectMapper mapper = new ObjectMapper();
    /**
     * The data object stored in the configuration.
     */
    private T t;
    /**
     * The file path where the configuration data is stored.
     */
    private File file;
    /**
     * The class representing the type of data stored in the configuration.
     */
    private Class<T> tClazz;

    /**
     * Creates a new Config instance with the provided file name and data class.
     *
     * @param t        The initial data object to store in the configuration.
     * @param fileName The name of the configuration file.
     * @param clazz    The class representing the type of data to be stored.
     */
    public Config(T t, String fileName, Class<T> clazz) {
        this.t = t;
        file = new File(fileName);
        tClazz = clazz;
        createNewFile(); // Create the file if it doesn't exist
    }

    /**
     * Creates a new Config instance with the provided file and data class.
     *
     * @param t     The initial data object to store in the configuration.
     * @param file  The File object representing the configuration file.
     * @param clazz The class representing the type of data to be stored.
     */
    public Config(T t, File file, Class<T> clazz) {
        this.t = t;
        this.file = file;
        tClazz = clazz;
        createNewFile(); // Create the file if it doesn't exist
    }

    /**
     * Saves the current configuration data to the specified file, throwing an exception on failure.
     */
    @SneakyThrows
    public void saveOrFail() {
        this.mapper.writeValue(file, t);
    }

    /**
     * Loads the configuration data from the configured file, throwing an exception on failure.
     * If the file doesn't exist, it will be created with default data (provided `t` field).
     *
     * @return The loaded configuration data as an instance of type T.
     */
    @SneakyThrows
    public T loadOrFail() {
        createNewFile();
        return this.mapper.readValue(file, tClazz);
    }

    /**
     * Creates a new configuration file if it doesn't exist, initializing it with the provided `t` data (using `writeValue`).
     * This method is called internally by `loadOrFail`.
     *
     * @throws Exception If there's an error during file creation or writing initial data.
     */
    @SneakyThrows
    @SuppressWarnings("all") // Suppress unchecked cast warning for getMapper().writeValue(file, t)
    private void createNewFile() {
        if (!file.exists()) {
            file.createNewFile();
            mapper.writeValue(file, t);
        }
    }

    /**
     * Converts the current configuration data to a JSON string.
     *
     * @return The JSON representation of the configuration data.
     */
    @SneakyThrows
    public String toJson() {
        return mapper.writeValueAsString(t);
    }
}