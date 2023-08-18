package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Base;

public class CheckboxPage extends Base{
    public CheckboxPage(){
        super();
    }
    @FindBy(linkText = "Products" )
    public static WebElement ProductsButton;

    @FindBy(linkText = "Accept" )
    public static WebElement AcceptPopUp;

    @FindBy(linkText = "//*[@id=\"heading-1\"]")
    public static WebElement Solution_Button;

    @FindBy(xpath = "//*[@id=\"collapse-1\"]/li[4]/label")
    public static WebElement Checkbox_ContinuousIntegration;
}
