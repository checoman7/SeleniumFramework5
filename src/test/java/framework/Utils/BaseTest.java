package framework.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected CommonActions commands ;
    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--window-size=1920,1080"); // Specify window size to prevent issues with default size
        options.addArguments("--no-sandbox"); // Required in some CI environments
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/client");
        commands  = new CommonActions(driver);
    }

    @AfterMethod(groups = {"regression","smoke"})
    public void tearDown(){
        driver.quit();
    }

}
