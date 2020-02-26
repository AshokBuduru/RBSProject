package Pages;

import BasePage.BaseUtils;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class NavigatePage extends BaseUtils {

       public NavigatePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public boolean LaunchBrowser(String url){
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.getTitle().equals("My Store");
    }

}
