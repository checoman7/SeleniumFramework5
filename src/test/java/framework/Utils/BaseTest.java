package framework.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected CommonActions commands ;
    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp(){
        driver = new ChromeDriver();
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
