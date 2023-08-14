package Tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.Base;
import utilities.ConfigReader;

public class TitleVerification extends Base {

    @Test
    public void test_title_verification() {
        driver.get(ConfigReader.getProperty("ui_base_url"));
       String actualTitle = driver.getTitle();
       String expectedTitle = "ParaBank | Welcome | Online Banking";
       Assert.assertEquals(expectedTitle,actualTitle);


    }
}

