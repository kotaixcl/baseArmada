package automatizado;

import org.testng.Assert;
import utiles.BaseTest;
import org.testng.annotations.Test;
import utiles.Logs;

public class navegacionTests extends BaseTest{
    @Test
    public void ejercicioTest(){
        final var url = "https://www.saucedemo.com/";
        Logs.info("asigna url");
        driver.get(url);
        final var currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,url);
    }
}
