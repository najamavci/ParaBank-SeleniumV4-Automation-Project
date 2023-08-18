package Tests;

import Pages.CheckboxPage;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.Base;

public class Checkbox_Selection extends CheckboxPage{
    Base base = new Base();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @Test
    public void testCheckbox(){
       base.PlatformURL();
       base.maximizeWindow();
        ProductsButton.click();
        try{
        AcceptPopUp.click();
        } catch (Exception e) {
            System.out.println("No alert visible");
        }
        Solution_Button.click();
        js.executeScript("arguments[0].click();",Checkbox_ContinuousIntegration);
        base.closeDriver();        }
    }
