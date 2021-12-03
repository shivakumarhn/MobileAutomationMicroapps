package org.citrix.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.citrix.driver.DriverManager.getDriver;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String getBase64Image() {
        return ((TakesScreenshot)
                getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static byte[] getByteImage() {
        return ((TakesScreenshot)
                getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
