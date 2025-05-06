package Railway;

import Common.Constant.Constant;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    RegisterPage registerPage;
    @BeforeMethod
    public void navigateToRegisterPage() {
        registerPage = homePage.gotoRegisterPage();
    }
    @Test
    public void TC07() {
        registerPage.performRegister(Constant.EMAIL_REGISTER,Constant.PASSWORD, Constant.CONFIRMPASSWORD, Constant.PID);
        boolean actualResult = registerPage.isMsgRefistratrionConfirmDisplayed();
        Assert.assertTrue(actualResult, "The message confirm register suscess is not displayed");
    }

    @Test (description = "User can't create account with Confirm password is not the same with Password")
    public void TC10() {
        registerPage.performRegister(Constant.EMAIL_REGISTER,Constant.PASSWORD,"12039231", Constant.PID);
        String actual = registerPage.getTextErrorMessageRegister();
        String expect = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actual,expect,
                "\n Actual and Expected are not match\n");
    }
    @Test (description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        registerPage.performRegister(Constant.EMAIL_REGISTER,"",Constant.CONFIRMPASSWORD, "");
        String actualTitle = registerPage.getTextErrorMessageRegister();
        String expect = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualTitle,expect,
                "\n Actual and Expected are not match\n");
        String actualMsgErrPassword = registerPage.getTextErrMsgPassword();
        Assert.assertEquals(actualMsgErrPassword,"Invalid password length");
        String actualMsgErrPID = registerPage.getTextErrMsgPID();
        Assert.assertEquals(actualMsgErrPID,"Invalid ID length");
    }

}
