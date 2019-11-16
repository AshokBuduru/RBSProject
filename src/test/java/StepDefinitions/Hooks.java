package StepDefinitions;

import BasePage.BaseUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Hooks extends BaseUtils {

//    public Hooks(WebDriver driver){
//        PageFactory.initElements(driver,this);
//    }

    @Before
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\Automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        // driver.manage().window().fullscreen();
    }

    @After
    public void exitBrowser() throws IOException {
        String path;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        path = "./target/" + scrFile.getName();
        FileHandler.copy(scrFile,new File(path));
        driver.quit();    }
}
