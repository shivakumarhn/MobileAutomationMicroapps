package org.citrix.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.citrix.constants.FrameworkConstants.getConfigFilePath;

public class PropertyUtils {

    private static final Properties properties = new Properties();
    private static Map<String, String> map = new HashMap<>();

    static {
        //Implementing AutoCloseable
        try (FileInputStream stream =
                     new FileInputStream(getConfigFilePath())) {
            properties.load(stream);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                map.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        //Finally --> close the connection
    }

    public static String getValue(String key) {
        return map.get(key);
    }
}
