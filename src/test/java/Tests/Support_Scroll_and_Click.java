package Tests;

import org.junit.Test;
import org.openqa.selenium.*;
import utilities.Base;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class Support_Scroll_and_Click extends Base {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test
    public void testProducts() {
        driver.get(ConfigReader.getProperty("ui_base_url"));
        driver.manage().window().maximize();
        WebElement productsButton = driver.findElement(By.linkText("Products"));
        productsButton.click();
        try{
        WebElement alertAccept = driver.findElement(By.linkText("Accept"));
        alertAccept.click();
        } catch (Exception e) {
            System.out.println("No alert visible");
        }
        WebElement support = driver.findElement(By.xpath("//*[@id=\"menu-item-1803\"]/a"));
        js.executeScript("arguments[0].click();",support);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Driver.closeDriver();
    }
}
