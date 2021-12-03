package org.citrix.driver;

import org.citrix.exception.FrameworkException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver get(Modes mode, Map<String, String> map) throws MalformedURLException {

        WebDriver driver = null;

        if (mode.equals(Modes.LOCAL)) {
            driver = new LocalDriver().getDriver(map);
        } else if (mode.equals(Modes.BS)) {
            driver = new BrowserStack().getDriver(map);
        } else if (mode.equals(Modes.SAUCELABS)) {
            driver = new SauceLabs().getDriver(map);
        } else {
            throw new FrameworkException("No cloud provider is configured with the name mentioned");
        }
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

}
