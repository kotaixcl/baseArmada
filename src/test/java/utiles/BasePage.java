package utiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public abstract class BasePage {
    private final static int defaultTimeout = 5;
    protected final SoftAssert softAssert;
    private final int timeOut = 3;

    public BasePage(int timeOut){
        softAssert = new SoftAssert();
    }

    public BasePage(){
        this(defaultTimeout);
    }

    protected WebDriver getDriver(){
        return WebDriverProvider.threadLocal.get();

    }
    protected void waitPage(By locator, String pageName){
        //espera que la pagina cargue
        final var wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(this.timeOut));
        Logs.info("Espera la carga de la pagina %s",pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement find(By locator){
        return getDriver().findElement(locator);
    }
    protected List<WebElement> findAll(By locator){
        return getDriver().findElements(locator);
    }
    public abstract void waitPageToLoad ();
    public abstract void verifyPage ();
}
