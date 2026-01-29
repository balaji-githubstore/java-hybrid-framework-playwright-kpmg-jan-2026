package com.kpmg.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Utility class for working with .properties files.
 */
public class PropertiesUtil {
    private Properties properties = new Properties();

    /**
     * Loads properties from a file.
     * @param filePath Path to the .properties file
     * @throws IOException if file not found or cannot be read
     */
    public void load(String filePath) throws IOException {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        }
    }

    /**
     * Gets a property value by key.
     * @param key Property key
     * @return Property value or null if not found
     */
    public String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Sets a property value.
     * @param key Property key
     * @param value Property value
     */
    public void set(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * Saves properties to a file.
     * @param filePath Path to the .properties file
     * @throws IOException if file cannot be written
     */
    public void save(String filePath) throws IOException {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        }
    }
}
