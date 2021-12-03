package org.citrix.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.citrix.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {

   /* Parent of Android and IOS is Mobile element
    Android(Android element), IOS(IOS element) and mobile chrome (Webelement)*/

    protected String getText(MobileElement element) {
        System.out.println("Inner text value is " + element.getText());
        return element.getText();
    }

    protected void click(MobileElement element, String elementName) {
        explicitWait(element);
        element.click();
    }

    private void explicitWait(MobileElement element) {
        new WebDriverWait(DriverManager.getDriver(), 15)
                .withMessage(() -> "Some problem while finding element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(By by, String elementName) {
        click((MobileElement) DriverManager.getDriver().findElement(by), elementName);
    }

    protected void click(String locatorType, String value, String elementName) {
        //Todo - java8
        if (locatorType.equalsIgnoreCase("xpath"))
            click(By.xpath(value), elementName);
        else if (locatorType.equalsIgnoreCase("id"))
            click(By.id(value), elementName);
    }

    protected void chooseItemAndClick(List<MobileElement> list, String value) {

        MobileElement mobileElement = list.parallelStream()
                .filter(e -> e.getText().contains(value))
                .findFirst().get();
        click(mobileElement, value);
    }

    protected void scrollToSpecificElementAndClick(By by, boolean flag) {

        while (DriverManager.getDriver().findElements(by).isEmpty()) {
            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.5;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimension.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();
            int centre = (int) (dimension.width * 0.5);
            new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                    .press(PointOption.point(centre, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
                    .moveTo(PointOption.point(centre, scrollEnd)).release()
                    .perform();
        }
        if (flag)
            if (!DriverManager.getDriver().findElements(by).isEmpty())
                DriverManager.getDriver().findElement(by).click();
    }

    protected void dragAndDrop(MobileElement source, MobileElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
        System.out.println("Drag and Drop is success");
    }

    protected void swipe(MobileElement source, MobileElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }

    protected void longPress(MobileElement element) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .perform();
    }

    protected void tapUsingCoordinates(int x, int y) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver()).tap(PointOption.point(x, y)).perform();
    }

    protected void tap(AndroidElement views) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver()).
                tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).
                perform();
    }

}
