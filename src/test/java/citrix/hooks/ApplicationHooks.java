package citrix.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.citrix.driver.Driver;
import org.citrix.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static org.citrix.utils.ScreenshotUtils.getByteImage;

public class ApplicationHooks {


    Map<String, String> map = new HashMap<>();

    @Before()
    public void getProperty() throws MalformedURLException {
        map.put("udid", PropertyUtils.getValue("udid"));
        map.put("udid", PropertyUtils.getValue("os_version"));
    }

    @Before()
    public void launchApp() throws MalformedURLException {
        Driver.initDriver(map);
    }

    @After(order = 0)
    public void quitApp() {
        Driver.quitDriver();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            scenario.attach(getByteImage(), "image/png", screenshotName);

        }
    }

}
