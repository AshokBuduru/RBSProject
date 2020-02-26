package Pages;

import BasePage.BaseUtils;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PersonalDetails extends BaseUtils {

    @Inject
    public PersonalDetails(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    private PropertyFile propertyFile = new PropertyFile();
    @FindBy(xpath = "//*[@title='View my customer account']//span")
    private WebElement myUserLink;

    @FindBy(xpath="//*[@title='Information']//span")
    private WebElement personalLink;

    @FindBy(id="firstname")
    private WebElement firstName;

    @FindBy(name="submitIdentity")
    private WebElement saveButton;

    @FindBy(id="old_passwd")
    private WebElement oldPassword;

    public void clickMyAccountLink(){
        myUserLink.click();
    }
    public void clickPersonalDetailsLink(){
        personalLink.click();
    }
    public void updateFirstName(String updateName){
        firstName.clear(); firstName.sendKeys(updateName);
    }
    public void clickSaveButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        oldPassword.sendKeys(propertyFile.password);
        saveButton.click();
    }

}
