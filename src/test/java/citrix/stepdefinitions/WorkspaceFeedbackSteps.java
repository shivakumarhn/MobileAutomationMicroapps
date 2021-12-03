package citrix.stepdefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.citrix.screens.ActionsPage;
import org.citrix.screens.HomePage;
import org.citrix.screens.WorkspaceFeedbackPage;

import java.util.concurrent.TimeUnit;

public class WorkspaceFeedbackSteps {

    private HomePage homePage = new HomePage();
    private ActionsPage actionsPage = new ActionsPage();
    private WorkspaceFeedbackPage WorkspaceFeedbackPage = new WorkspaceFeedbackPage();

    @Given("Launch the workspace app")
    public void launch_the_workspace_app() {
        Uninterruptibles.sleepUninterruptibly(12, TimeUnit.SECONDS);
        System.out.println("Application is launched");
    }

    @And("Click on actions tab")
    public void click_on_actions_tab() {
        homePage.clickOnActions();
    }

    @When("Click on digitalWorkspace feedback")
    public void click_on_digital_workspace_feedback() {
        actionsPage.clickOnDigitalWorkspaceFeedback();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @When("Enter feedback details")
    public void enter_feedback_details() {
        WorkspaceFeedbackPage.choseOtherOption()
                .enterService()
                .chooseAccessing()
                .enterAccessingMethod()
                .feedbackDetails()
                .rate();
    }

    @Then("Click on submit button")
    public void click_on_submit_button() {
        WorkspaceFeedbackPage.submit();
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
    }

}
