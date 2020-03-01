package Pages;

import BasePage.BaseUtils;
import com.google.inject.Inject;
import org.bridj.cpp.std.list;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ScreenCapture extends BaseUtils {

    @Inject
    public ScreenCapture(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='panel-title']//a")
    private list<WebElement> expandAccordion;

    @FindBy(xpath="//button[@id='btnSaveImagePDF']//span")
    private WebElement savePDF;

    public void loadURL(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.getPageSource().contains("200");
    }
    public void exandAllAccordion(){

    }
    public void chromeScreenCaptureExtension() throws AWTException, InterruptedException {
        String pWindow = driver.getWindowHandle();
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_Y);
        Thread.sleep(1000);
        Set<String> allPages = driver.getWindowHandles();
        String cWindow =allPages.iterator().next();
        if(!pWindow.equals(cWindow)) {
            driver.switchTo().window(cWindow);
        }
        savePDF.click();
        driver.switchTo().alert().accept();
    }

}
