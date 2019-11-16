package StepDefinitions;

import BasePage.BaseUtils;
import Pages.LoginPage;
import Pages.NavigatePage;
import Pages.PersonalDetails;
import Pages.UserLoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyStepdefs extends BaseUtils {

    @Given("^I navigate to application \"([^\"]*)\"$")
    public void iNavigateToApplication(String url) {
        NavigatePage navigatePage = new NavigatePage(driver);
        Assert.assertThat(navigatePage.LaunchBrowser(url),is(equalTo(true)));
    }

    @And("^I click on sign in link$")
    public void iClickOnSignInLink() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignInButton();
    }

    @When("^I enter username and password$")
    public void iEnterUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
    }

    @And("^I click on signin button$")
    public void iClickOnSigninButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnSignInButton();
    }

    @And("^I click on Tshirt menu$")
    public void iClickOnTshirtMenu() {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.clickTshirtMenu();
    }

    @And("^I select unique Tshirt and add to cart$")
    public void iSelectUniqueTshirtAndAddToCart() {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.selectTShirtAndAddToCart();
    }

    @And("^I click on proceed to checkout in summary page$")
    public void iClickOnProceedToCheckoutInSummaryPage() {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.clickProceedToCheckOutButtonSummaryPage();
    }

    @And("^I click on proceed to checkout in address page$")
    public void iClickOnProceedToCheckoutInAddressPage() {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.clickProceedToCheckoutButtonAddressPage();
    }

    @And("^I click on proceed to checkout in shipping page$")
    public void iClickOnProceedToCheckoutInShippingPage() {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.clickProceedToCheckoutButtonShippingPage();
    }

    @Then("^I complete payment using pay by bank wire method$")
    public void iCompletePaymentUsingPayByBankWireMethod() {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.clickPayByBankWireOption();
    }

    @And("^I click on back to order link$")
    public void iClickOnBackToOrderLink() {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        userLoginPage.clickBackToOrderLink();
    }

    @And("^I check order placed successfully for \"([^\"]*)\"$")
    public void iCheckOrderPlacedSuccessfullyFor(String price)  {
        UserLoginPage userLoginPage = new UserLoginPage(driver);
        Assert.assertThat(userLoginPage.checkOrderHistory(price),is(equalTo(true)));
    }

    @And("^I click on myaccount link$")
    public void iClickOnMyaccountLink() {
        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.clickMyAccountLink();
    }

    @And("^I click on personal details link$")
    public void iClickOnPersonalDetailsLink() {
        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.clickPersonalDetailsLink();
    }

    @Then("^I update first name to \"([^\"]*)\"$")
    public void iUpdateFirstNameTo(String updateName)  {
        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.updateFirstName(updateName);
    }

    @And("^I click on save button$")
    public void iClickOnSaveButton() {
        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.clickSaveButton();
    }

}
