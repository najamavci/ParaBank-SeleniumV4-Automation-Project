package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Base;

public class userRegisterPage extends Base {
    public userRegisterPage(){
        super();
    }
    @FindBy(id = "customer.firstName")
    public static WebElement First_Name;

    @FindBy(id = "customer.lastName")
    public static WebElement Last_Name;

    @FindBy(id = "customer.address.street")
    public static WebElement Address;

    @FindBy(id = "customer.address.city")
    public static WebElement Address_city;

    @FindBy(id = "customer.address.state")
    public static WebElement Address_state;

    @FindBy(id = "customer.address.zipCode")
    public static WebElement Address_zipCode;

    @FindBy(id = "customer.phoneNumber")
    public static WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    public static WebElement ssn;

    @FindBy(id = "customer.username")
    public static WebElement username;

    @FindBy(id = "customer.password")
    public static WebElement password;

    @FindBy(id = "repeatedPassword")
    public static WebElement RepeatedPassword;

    @FindBy(xpath =("//*[@type='submit']"))
    public static WebElement RegisterSubmit;

    @FindBy(xpath =("//*[@class='error']"))
    public static WebElement ErrorMessage;
}
