package org.citrix.screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.citrix.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ActionsPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Digital Workspace Feedback Citrite Concierge']")
    private AndroidElement btnDigitalWorkspaceFeedback;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Create Event on Account Salesforce 2021']")
    private AndroidElement btnCreateEvent;


    public ActionsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public WorkspaceFeedbackPage clickOnDigitalWorkspaceFeedback() {
        scrollToSpecificElementAndClick(By.
                xpath("//android.widget.Button[@text='Digital Workspace Feedback Citrite Concierge']"), true);
        return new WorkspaceFeedbackPage();
    }

    public CreateEventPage clickOnCreateEvent() {
        scrollToSpecificElementAndClick(By.
                xpath("//android.widget.Button[@text='Create Event on Account Salesforce 2021']"), true);
        return new CreateEventPage();
    }

}
