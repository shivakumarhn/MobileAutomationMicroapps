package org.citrix.screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.citrix.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class CreateEventPage extends BasePage {

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private AndroidElement inputSearchAccount;

    @AndroidFindBy(xpath = "//android.view.View[@text='IBM 51435435']")
    private AndroidElement optionIBM;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private AndroidElement inputSubject;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    private AndroidElement inputDescription;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
    private AndroidElement inputLocation;

    public CreateEventPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public CreateEventPage searchAccount() {
        inputSearchAccount.sendKeys("IBM");
        click(optionIBM, "IBM");
        return this;
    }

    public CreateEventPage enterSubject() {
        inputSubject.sendKeys("SFDC event creation");
        return this;
    }

    public CreateEventPage enterDescription() {
        inputDescription.sendKeys("creating event in tester admin account");
        return this;
    }

    public CreateEventPage enterLocation() {
        inputLocation.sendKeys("Bengaluru");
        return this;
    }


}
