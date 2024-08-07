package utiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class fileManager {
    private final static String rutaEvidencia = "src/test/resources/screenshots";
    public static void tomaEvidencia (WebDriver driver,String nombreEvidencia){
        final var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        final var ruta =    String.format("%s/%s.png",rutaEvidencia,nombreEvidencia);
        try {
            FileUtils.copyFile(screenshot, new File(ruta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
