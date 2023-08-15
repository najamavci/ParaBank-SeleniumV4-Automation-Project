package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class Checkbox_Selection extends Base {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test
    public void testCheckbox(){
        driver.get(ConfigReader.getProperty(("ui_base_url")));
        driver.manage().window().maximize();
        WebElement productsButton = driver.findElement(By.linkText("Products"));
        productsButton.click();
        try{
            WebElement alertAccept = driver.findElement(By.linkText("Accept"));
            alertAccept.click();
        } catch (Exception e) {
            System.out.println("No alert visible");
        }
        WebElement solutions = driver.findElement(By.xpath("//*[@id=\"heading-1\"]"));
        solutions.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement checkboxElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapse-1\"]/li[4]/label")));
        js.executeScript("arguments[0].click();",checkboxElement);
        Driver.closeDriver();
        }
    }
