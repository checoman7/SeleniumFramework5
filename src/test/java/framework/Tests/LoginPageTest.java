package framework.Tests;
import framework.Maps.LandingPageMap;
import framework.Pages.LoginPageMethods;
import framework.Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    LandingPageMap landingPageMap = new LandingPageMap();


    @Test(groups = {"regression","smoke"})
    public void logInValidCredentials(){
        LoginPageMethods lpm= new LoginPageMethods(commands);
        lpm.login();
        commands.waitForElementToBeClickable(landingPageMap.btnSignOut);
        Assert.assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/client/dashboard/dash");
    }

    @Test(groups = {"smoke"})
    public void Test1(){
        System.out.println("Test1");
    }

    @Test(groups = {"smoke","test"})
    public void Test2(){
        System.out.println("Test2");
    }

    @Test(groups = {"regression"})
    public void Test3(){
        System.out.println("Test3");
    }




}
