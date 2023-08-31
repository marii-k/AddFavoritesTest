package ru.avito;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/test/resources/conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}