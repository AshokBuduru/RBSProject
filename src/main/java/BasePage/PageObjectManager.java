package BasePage;

import Pages.LoginPage;
import Pages.NavigatePage;
import Pages.PersonalDetails;
import Pages.UserLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    public PageObjectManager(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    private WebDriver driver;
    private LoginPage loginPage = new LoginPage(driver);
    private NavigatePage navigatePage = new NavigatePage(driver);
    private PersonalDetails personalDetails = new PersonalDetails(driver);
    private UserLoginPage userLoginPage = new UserLoginPage(driver);
}
