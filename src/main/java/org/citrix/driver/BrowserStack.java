package org.citrix.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStack implements IDriver {
    @Override
    public WebDriver getDriver(Map<String, String> map) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/src/test/resources/apkfiles/ApiDemos-debug.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // Not mandatory
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S9"); // Not mandatory

        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
    }
}
