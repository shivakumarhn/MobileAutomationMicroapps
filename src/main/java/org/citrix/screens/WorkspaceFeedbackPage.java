package org.citrix.screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.citrix.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class WorkspaceFeedbackPage extends BasePage {

    @AndroidFindBy(xpath = "(//android.view.View[@text='Choose One...'])[1]")
    private AndroidElement chooseProduct;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Other']")
    private AndroidElement other;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private AndroidElement serviceName;

    @AndroidFindBy(xpath = "(//android.view.View[@text='Choose One...'])[1]")
    private AndroidElement accessing;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private AndroidElement accessMethod;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    private AndroidElement feedbackDetails;

    @AndroidFindBy(xpath = "(//android.view.View[@text='Choose One...'])[1]")
    private AndroidElement rate;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='4']")
    private AndroidElement four;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Submit']")
    private AndroidElement submit;

    public WorkspaceFeedbackPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public WorkspaceFeedbackPage choseOtherOption() {
        click(chooseProduct, "ChooseProduct");
        click(other, "other");
        return this;
    }

    public WorkspaceFeedbackPage enterService() {
        serviceName.sendKeys("Digital workspace services");
        return this;
    }

    public WorkspaceFeedbackPage chooseAccessing() {
        click(accessing, "AccessingType");
        click(other, "other");
        return this;
    }

    public WorkspaceFeedbackPage enterAccessingMethod() {
        scrollToSpecificElementAndClick(By.xpath("(//android.widget.EditText)[2]"), false);
        accessMethod.sendKeys("Through mobile");
        return this;
    }


    public WorkspaceFeedbackPage feedbackDetails() {
        scrollToSpecificElementAndClick(By.xpath("(//android.widget.EditText)[3]"), false);
        feedbackDetails.sendKeys("Lot of things are missing");
        return this;
    }

    public WorkspaceFeedbackPage rate() {
        scrollToSpecificElementAndClick(By.xpath("(//android.view.View[@text='Choose One...'])[1]"), false);
        click(rate, "AccessingType");
        click(four, "four");
        return this;
    }

    public WorkspaceFeedbackPage submit() {
        click(submit, "submit");
        return this;
    }
}
