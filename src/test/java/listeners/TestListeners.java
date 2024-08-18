package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utiles.Logs;
import utiles.FileManager;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("iniciando test: %s", result.getName());
        }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("Aprobado test: %s", result.getName());
        String nombreEvidencia = "Aprobado "+ result.getName();
        FileManager.screenShoot(nombreEvidencia);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("Fallado test: %s", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("Ignorado test: %s", result.getName());
    }
}
