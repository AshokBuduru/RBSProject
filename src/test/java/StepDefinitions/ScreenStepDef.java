package StepDefinitions;

import BasePage.BaseUtils;
import Pages.ScreenCapture;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ScreenStepDef extends BaseUtils {

    private ScreenCapture screenCapture = new ScreenCapture(driver);

    @Given("^I navigate to below page \"([^\"]*)\"$")
    public void iNavigateToBelowPage(String url) throws Throwable {
        screenCapture.loadURL(url);
    }

    @Then("^I capture page from top to bottom$")
    public void iCapturePageFromTopToBottom() throws InterruptedException, AWTException {
        screenCapture.chromeScreenCaptureExtension();
    }

    @When("^I open all the accordion$")
    public void iOpenAllTheAccordion() {
    }
}
