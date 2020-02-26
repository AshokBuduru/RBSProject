package Pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @Inject
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    private PropertyFile propertyFile = new PropertyFile();

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signinButton;

    @FindBy(id="email")
    private WebElement enterEmailAddress;

    @FindBy(id="passwd")
    private WebElement enterPassword;

    @FindBy(id="SubmitLogin")
    private WebElement loginButton;

    public void clickSignInButton(){
        signinButton.click();
    }
    public void enterUsername() {
        enterEmailAddress.sendKeys(propertyFile.username);
    }
    public void enterPassword() {
        enterPassword.sendKeys(propertyFile.password);
    }
    public void clickOnSignInButton(){
        loginButton.click();
    }

}
