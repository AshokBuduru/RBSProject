package StepDefinitions;

import BasePage.BaseUtils;
import Pages.PropertyFile;
import Pages.ScreenCapture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
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
    public void launchBrowser() throws MalformedURLException, InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\Automation\\chromedriver_win32\\chromedriver.exe");
        switch (propertyFile.gridRun){
            case "true":
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setPlatform(Platform.LINUX);
                cap.setVersion("");
                driver = new RemoteWebDriver(new URL("http://192.168.1.105:4444/wd/hub"),cap);
                break;
            case "false":
                ChromeOptions options = new ChromeOptions();
                options.addExtensions (new File("C:\\Users\\dell\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\mcbpblocgmgfnpjjppndjkmgjaogfceg\\0.98.97.2_0.crx"));
                DesiredCapabilities capabilities = new DesiredCapabilities ();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(capabilities);
                driver = new ChromeDriver(options);
                String childWindow = driver.getWindowHandle();
                driver.close();
                Set<String> allPages = driver.getWindowHandles();
                allPages.remove(childWindow);
                String currentPage =allPages.iterator().next();
                if(!childWindow.equals(currentPage)) {
                    driver.switchTo().window(currentPage);
                }
                driver.manage().window().maximize();
        }
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
