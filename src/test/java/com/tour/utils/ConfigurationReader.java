package com.tour.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigurationReader.class
                .getClassLoader()
                .getResourceAsStream("configuration.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties file not exist.");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
