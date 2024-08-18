package paginas;

import org.openqa.selenium.By;
import utiles.BasePage;

public class loginPage extends BasePage {
    private final By nombreUsuario = By.id("user-name");
    private final By claveUsuario = By.id("password");
    private final By btnLogin = By.id ("login-button");
    private final By msjError = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");


    @Override
    public void waitPageToLoad() {
        waitPage(nombreUsuario,this.getClass().getName());

    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(nombreUsuario).isDisplayed());
        softAssert.assertTrue(find(claveUsuario).isDisplayed());
        softAssert.assertTrue(find(btnLogin).isDisplayed());
        softAssert.assertAll();
    }
    public void rellenaFormulario (String usuario, String pass){
        find(nombreUsuario).sendKeys(usuario);
        find(claveUsuario).sendKeys(pass);
        find(btnLogin).click();
    }
    public void validaMensaje (String errorTxt){
        final var errorMsg = find(msjError);
        //"Epic sadface: Username and password do not match any user in this service"
        softAssert.assertTrue(errorMsg.isDisplayed());
        softAssert.assertEquals(errorMsg.getText(),errorTxt);
        softAssert.assertAll();
    }
}
