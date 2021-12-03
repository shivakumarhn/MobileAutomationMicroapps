package org.citrix.screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.citrix.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @AndroidFindBy(id = "home, current page")
    private AndroidElement activityFeed;

    @AndroidFindBy(accessibility = "all")
    private AndroidElement action;

    @AndroidFindBy(id = "apps")
    private AndroidElement apps;

    @AndroidFindBy(id = "files")
    private AndroidElement files;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public HomePage clickOnActions() {
        click(action, "Actions");
        return this;
    }


}
