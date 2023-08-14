package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base {
    protected WebDriver driver;

    public Base() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void PlatformURL() {
        driver.get(ConfigReader.getProperty("ui_base_url"));
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void closeDriver() {Driver.closeDriver();
    }
}

