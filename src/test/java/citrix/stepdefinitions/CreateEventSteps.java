package citrix.stepdefinitions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.en.When;
import org.citrix.screens.ActionsPage;
import org.citrix.screens.CreateEventPage;

import java.util.concurrent.TimeUnit;

public class CreateEventSteps {

    private ActionsPage actionsPage = new ActionsPage();
    private CreateEventPage createEventPage = new CreateEventPage();

    @When("Click on create event on account")
    public void click_on_create_event() {
        actionsPage.clickOnCreateEvent();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    @When("Enter create event details")
    public void enter_create_event_details() {
        createEventPage.searchAccount()
                .enterSubject()
                .enterDescription()
                .enterLocation();
    }

}
