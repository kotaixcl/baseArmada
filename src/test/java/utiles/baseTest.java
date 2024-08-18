package utiles;

import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utiles.WebDriverProvider;

@Listeners ({TestListeners.class})
public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected WebDriverProvider driverProvider;

    @BeforeMethod(alwaysRun = true)
    public void mastersetUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driverProvider = new WebDriverProvider(); // Asigna el WebDriverProvider al campo
        driverProvider.set(driver);
    }
    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }


}