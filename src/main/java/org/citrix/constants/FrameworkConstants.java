package org.citrix.constants;

public class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String resourcePath = System.getProperty("user.dir") + "/src/test/resources";
    private static final String apkFilePath = resourcePath + "/apkfiles/ApiDemos-debug.apk";
    private static final String configFilePath = resourcePath + "/configs/config.properties";

    public static String getApkFilePath() {
        return apkFilePath;
    }

    public static String getConfigFilePath() {
        return configFilePath;
    }
}
