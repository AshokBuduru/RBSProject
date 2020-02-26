package StepDefinitions;

import BasePage.BaseUtils;
import Pages.PropertyFile;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.reflect.misc.FieldUtil;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseUtils {
    private PropertyFile propertyFile = new PropertyFile();

    @Before
    public void launchBrowser() throws MalformedURLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\Automation\\RBSProject\\Drivers\\chromedriver.exe");
        switch (propertyFile.gridRun){
            case "true":
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setPlatform(Platform.LINUX);
                cap.setVersion("");
                driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"),cap);
                break;
            case "false":
                ChromeOptions options = new ChromeOptions();
                //options.addExtensions(new File("C:\\Ashok\\Automation\\One-Click-Full-Page-Screenshot_v0.0.3.crx"));
                options.addExtensions (new File("C:\\Users\\dell\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\fdpohaocaechififmbbbbbknoalclacl\\6.5_0.crx"));
                DesiredCapabilities capabilities = new DesiredCapabilities ();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(capabilities);
                driver = new ChromeDriver(options);
                String childWindow = driver.getWindowHandle();
                Set<String> allPages = driver.getWindowHandles();
                allPages.remove(childWindow);
                String currentPage =allPages.iterator().next();
                if(childWindow!=currentPage) {
                    driver.switchTo().window(currentPage);
                }
                driver.get("https://www.santander.co.uk/personal/credit-cards/everyday-credit-card");
                driver.navigate().to("chrome-extension://fdpohaocaechififmbbbbbknoalclacl/popup.html");

//                driver = new FirefoxDriver();
//                driver.get("https://www.santander.co.uk/personal/credit-cards/everyday-credit-card");
//               // Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save();
//                Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE,true).save();
        }
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @After
    public void exitBrowser() throws IOException {
        String path;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        path = "./target/" + scrFile.getName();
        FileHandler.copy(scrFile,new File(path));
        driver.quit();

        //take screenshot of the entire page
//        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//        try {
//            ImageIO.write(screenshot.getImage(),"PNG",new File("path of the file"));
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
