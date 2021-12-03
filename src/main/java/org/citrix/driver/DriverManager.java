package org.citrix.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {
    }

    //Thread safe
    static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static void unload() {
        threadLocalDriver.remove();
    }
}
