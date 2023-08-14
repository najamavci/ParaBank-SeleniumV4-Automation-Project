package utilities;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import java.util.concurrent.TimeUnit;

public class Driver {

    public Driver(){
    }

    //access modifiers public, private, default, protected

    private static WebDriver driver;

    static public WebDriver getDriver(){
        if(driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--proxy-server='direct://'");
                    options.addArguments("--proxy-bypass-list=*");
                    options.addArguments("--start-maximized");
                    //options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
            }
        }

        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    static public void closeDriver(){
        if (driver != null){
            driver.close();
        }
    }
}

