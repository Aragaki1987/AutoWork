package com.san.auto.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nguye on 3/25/2017.
 */
public class PropertyUtil {
    private static String url = "auto.properties";

    public static Properties loadProperties() {
        InputStream input = null;
        Properties result = null;
        try {
            input = new FileInputStream(url);
            result = new Properties();
            result.load(input);
        } catch (IOException e) {
            System.out.println("ERROR : Cannot find property file at : " + url);
        }

        return result;
    }

    public static Properties loadProperties(String url) {
        PropertyUtil.url = url;
        return loadProperties();
    }
}
