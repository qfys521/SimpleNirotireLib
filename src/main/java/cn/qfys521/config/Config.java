package cn.qfys521.config;

import lombok.Data;

/**
 * An abstract base class representing a configuration for data storage and retrieval.
 * Subclasses of this class provide concrete implementations for saving and loading data
 * to/from specific file formats (e.g., JSON, XML, YAML).
 *
 * @param <T> The type of data this configuration holds.
 */
@Data
public abstract class Config<T> {

    /**
     * Saves the data object to a file in a format specific to the implementing subclass.
     * Throws an IOException if any errors occur during file operations.
     *
     */
    public abstract void saveOrFail();

    /**
     * Loads data from a file in a format specific to the implementing subclass and casts it to the type `T`.
     * Throws an IOException if any errors occur during file operations.
     *
     * @return The data object loaded from the configuration file, cast to the type `T`.
     */
    public abstract T loadOrFail();
}