package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void closeDriver() {
        Driver.closeDriver();
    }
}