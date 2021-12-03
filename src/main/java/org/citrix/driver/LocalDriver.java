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

public class LocalDriver implements IDriver {
    @Override
    public WebDriver getDriver(Map<String, String> map) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

       // map.forEach(capabilities::setCapability); // It reads all key value from map and store in capabilities
        /*capabilities.setCapability(MobileCapabilityType.APP, getApkFilePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");*/
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.citrix.Receiver");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.citrix.client.Receiver.ui.activities.SplashActivity");
        capabilities.setCapability("noReset", true);

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // Not mandatory
        /*capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Not mandatory
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); // Not mandatory
        capabilities.asMap().forEach((k, v) -> System.out.println(k + ":" + v));*/

        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
    }
}
