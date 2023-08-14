package Tests;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base;
import utilities.ConfigReader;
import java.time.Duration;

public class ProductsClick_and_SrollSupport extends Base {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Actions action = new Actions(driver);
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
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOf(support)).click();
        driver.close();
    }}
