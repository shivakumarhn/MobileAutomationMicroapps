package org.citrix.driver;

import org.citrix.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.citrix.driver.DriverManager.*;

public final class Driver {

    // Class should be closed for modification and open for extension
    // Factory pattern --> Generating child classes for super class or Interfaces

    // Local variables are thread safe
    private Driver() {
    }

    public static void initDriver(Map<String, String> map) throws MalformedURLException {
        if (isNull(getDriver())) {
            String modeValue = PropertyUtils.getValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modeValue.toUpperCase()), map);
            setDriver(driver);
        }
    }

    public static void quitDriver() {
        if (nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}
