package automatizado;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paginas.loginPage;
import utiles.BaseTest;

public class LoginTests extends BaseTest {
    private final loginPage loginPage = new loginPage();
    @BeforeMethod (alwaysRun = true)
    public void setUp(){
        driver.get("https://www.saucedemo.com/");
        loginPage.waitPageToLoad();
    }
    @Test
    public void usuariaInvalidoTest (){
        loginPage.rellenaFormulario("nadauser","nadapass");
        loginPage.validaMensaje(
                "Epic sadface: Username and password do not match any user in this service");
    }

}
