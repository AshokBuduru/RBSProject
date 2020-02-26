package StepDefinitions;

import BasePage.BaseUtils;
import BasePage.PageObjectManager;
import Pages.LoginPage;
import Pages.NavigatePage;
import Pages.PersonalDetails;
import Pages.UserLoginPage;
import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyStepdefs extends BaseUtils {

      private NavigatePage navigatePage = new NavigatePage(driver);
      private LoginPage loginPage = new LoginPage(driver);
      private PersonalDetails personalDetails = new PersonalDetails(driver);
      private UserLoginPage userLoginPage = new UserLoginPage(driver);

    @Given("^I navigate to application \"([^\"]*)\"$")
    public void iNavigateToApplication(String url) {
        Assert.assertThat(navigatePage.LaunchBrowser(url),is(equalTo(true)));
    }

    @And("^I click on sign in link$")
    public void iClickOnSignInLink() {
        loginPage.clickSignInButton();
    }

    @When("^I enter username and password$")
    public void iEnterUsernameAndPassword() {
        loginPage.enterUsername();
        loginPage.enterPassword();
    }

    @And("^I click on signin button$")
    public void iClickOnSigninButton() {
        loginPage.clickOnSignInButton();
    }

    @And("^I click on Tshirt menu$")
    public void iClickOnTshirtMenu() {
        userLoginPage.clickTshirtMenu();
    }

    @And("^I select unique Tshirt and add to cart$")
    public void iSelectUniqueTshirtAndAddToCart() {
        userLoginPage.selectTShirtAndAddToCart();
    }

    @And("^I click on proceed to checkout in summary page$")
    public void iClickOnProceedToCheckoutInSummaryPage() {
        userLoginPage.clickProceedToCheckOutButtonSummaryPage();
    }

    @And("^I click on proceed to checkout in address page$")
    public void iClickOnProceedToCheckoutInAddressPage() {
        userLoginPage.clickProceedToCheckoutButtonAddressPage();
    }

    @And("^I click on proceed to checkout in shipping page$")
    public void iClickOnProceedToCheckoutInShippingPage() {
        userLoginPage.clickProceedToCheckoutButtonShippingPage();
    }

    @Then("^I complete payment using pay by bank wire method$")
    public void iCompletePaymentUsingPayByBankWireMethod() {
        userLoginPage.clickPayByBankWireOption();
    }

    @And("^I click on back to order link$")
    public void iClickOnBackToOrderLink() {
        userLoginPage.clickBackToOrderLink();
    }

    @And("^I check order placed successfully for \"([^\"]*)\"$")
    public void iCheckOrderPlacedSuccessfullyFor(String price)  {
        Assert.assertThat(userLoginPage.checkOrderHistory(price),is(equalTo(true)));
    }

    @And("^I click on myaccount link$")
    public void iClickOnMyaccountLink() {
        personalDetails.clickMyAccountLink();
    }

    @And("^I click on personal details link$")
    public void iClickOnPersonalDetailsLink() {
        personalDetails.clickPersonalDetailsLink();
    }

    @Then("^I update first name to \"([^\"]*)\"$")
    public void iUpdateFirstNameTo(String updateName)  {
        personalDetails.updateFirstName(updateName);
    }

    @And("^I click on save button$")
    public void iClickOnSaveButton() {
        personalDetails.clickSaveButton();
    }

}
