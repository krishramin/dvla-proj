package selenium.pageobjects;

import cucumber.api.java.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * This is the base class that initializes the webdriver instance and cleans up the driver instance after tests
 */

public class BaseTestClass {

    protected static WebDriver driver;

    @Before
    public static void setUp(){
        //Set the system properties to point to chrome and gecko drivers
        System.setProperty("webdriver.gecko.driver","./src/test/resources/drivers/gecko/geckodriver");
        System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        //set Implicit timeouts for the webdriver as default
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    /**
     * Webdriver cookies are deleted and instance is killed after the test is complete
     */
    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    public void tearDown(){
        driver.quit();
    }
}
