package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Base;
import utilities.ConfigReader;


import java.time.Duration;

public class ParaBank_NonValid_Credention_LogIn extends Base {


    @Test
    public void test_non_valid_credention_login() {
        //navigate to the ParaBank url
        driver.get(ConfigReader.getProperty(("ui_base_url")));

        //click on username and send text "username"
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("username");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //click on password and send text "password"
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");

        //click on Log In button
        WebElement Log_In = driver.findElement(By.xpath("//*[@value ='Log In']"));
        Log_In.click();

        //Verify the Error title
        String expectedTitle = "ParaBank | Error";
        String actualMessage = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualMessage);

        //wait two seconds before closing the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.close();
    }
}
