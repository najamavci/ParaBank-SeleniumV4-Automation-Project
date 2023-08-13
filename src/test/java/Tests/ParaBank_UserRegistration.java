package Tests;

import Pages.userRegisterPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base;
import utilities.ConfigReader;

import java.time.Duration;

public class ParaBank_UserRegistration extends userRegisterPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test
    public void test_register_new_user(){
        driver.get(ConfigReader.getProperty("ui_base_url"));
        WebElement registerButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loginPanel']/p[2]/a")));
        registerButton.click();

        First_Name.sendKeys("Naja");
        Last_Name.sendKeys("MA");
        Address.sendKeys("Valhornsvagen,66");
        Address_city.sendKeys("Stockholm");
        Address_state.sendKeys("Sweden");
        Address_zipCode.sendKeys("145 89");
        phoneNumber.sendKeys("1234567890");
        ssn.sendKeys("12365478965");
        username.sendKeys("Nike");
        password.sendKeys("123456");
        RepeatedPassword.sendKeys("123456");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        RegisterSubmit.click();

        String actual = ErrorMessage.getText();
        String expected = "Please enter a username and password.";
        Assert.assertEquals(actual,expected);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.close();
    }
}
