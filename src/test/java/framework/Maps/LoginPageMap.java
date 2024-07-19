package framework.Maps;

import org.openqa.selenium.By;

public class LoginPageMap {


    public By inpuUserName = By.cssSelector("input#userEmail");
    public By inputPassword = By.cssSelector("input[formcontrolname= userPassword]");
    public By btnsubmit = By.cssSelector("input[type=submit]");

}
