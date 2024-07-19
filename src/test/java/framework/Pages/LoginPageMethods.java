package framework.Pages;

import framework.Maps.LoginPageMap;
import framework.Utils.CommonActions;

public class LoginPageMethods {
    CommonActions commands;
    LoginPageMap lg = new LoginPageMap();

    public LoginPageMethods(CommonActions commands) {
        this.commands = commands;
    }

    public void login(){
        commands.enterText(lg.inpuUserName, "test888999000@gmail.com");
        commands.enterText(lg.inputPassword, "Test1234");
        commands.clickElement(lg.btnsubmit);
    }
}
