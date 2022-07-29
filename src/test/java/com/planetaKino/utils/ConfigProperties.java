package com.planetaKino.utils;

import java.io.FileInputStream;
import java.io.IOException;

public class ConfigProperties {
    protected static FileInputStream fileInputStream;
    protected static java.util.Properties PROPERTIES;
    static {
        try {
            fileInputStream = new FileInputStream("config.properties");
            PROPERTIES = new java.util.Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }
    /**
     * method return string with value from file with settings
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key); }




}
