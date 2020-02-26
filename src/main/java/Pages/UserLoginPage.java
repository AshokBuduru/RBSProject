package Pages;

import BasePage.BaseUtils;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class UserLoginPage extends BaseUtils {

    @Inject
    public UserLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//li[3]//a[@title='T-shirts']")
    private WebElement TshirtMenu;

    @FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts']//img")
    private WebElement uniqueTShirt;

    @FindBy(xpath="//div[@class='button-container']//a//span[contains(text(), \"Add to cart\")]")
    private WebElement tShirtAddToCart;

    @FindBy(xpath = "//*[contains(text(), \"Proceed to checkout\")]")
    private WebElement proceedCheckOut;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
    private WebElement proceedCheckOut_SummaryPage;

    @FindBy(xpath = "//*[@name='processAddress']//span[text()='Proceed to checkout']")
    private WebElement proceedCheckOut_AddressPage;

    @FindBy(xpath = "//*[@name='processCarrier']//span")
    private WebElement proceedCheckOut_ShippingPage;

    @FindBy(xpath = "//*[@id='uniform-cgv']//span")
    private WebElement acceptTermsCheckbox;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    private WebElement payByBankWire;

    @FindBy(xpath = "//*[@type='submit']//span[text()='I confirm my order']")
    private WebElement confirmOrder;

    @FindBy(xpath = "//a[@title='Back to orders']")
    private WebElement backToOrdersLink;

    @FindBy(xpath = "//tr[@class='first_item ']//td[3]")
    private WebElement orderPrice;

    public void clickTshirtMenu(){TshirtMenu.click();}
    public void selectTShirtAndAddToCart(){
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(uniqueTShirt).perform();
        tShirtAddToCart.click();
        proceedCheckOut.click();
    }
    public void clickProceedToCheckOutButtonSummaryPage(){ proceedCheckOut_SummaryPage.click(); }
    public void clickProceedToCheckoutButtonAddressPage(){ proceedCheckOut_AddressPage.click(); }
    public void clickProceedToCheckoutButtonShippingPage(){acceptTermsCheckbox.click(); proceedCheckOut_ShippingPage.click();    }
    public void clickPayByBankWireOption(){ payByBankWire.click(); confirmOrder.click(); }
    public void clickBackToOrderLink(){ backToOrdersLink.click();  }
    public boolean checkOrderHistory(String price){
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        return orderPrice.getText().equals("$" + price);
    }

}
