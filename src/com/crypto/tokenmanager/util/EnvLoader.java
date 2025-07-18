package com.crypto.tokenmanager.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class EnvLoader {

    private static final Logger logger = Logger.getLogger(EnvLoader.class.getName());

    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(".env")) {
            props.load(fis);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load .env file: ", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
