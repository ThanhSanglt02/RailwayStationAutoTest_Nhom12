package Railway;

import Common.Constant.Constant;
import PageObjects.ChangePasswordPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest{


    @Test (description = "TC09: User can change password")
    public void TC09() {
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.delay(2000);
        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.NEWPASSWORD, Constant.CONFIRMNEWPASSWORD);
        changePasswordPage.clickBtnRegister();
        String actual = changePasswordPage.getTextMsgPassUpdated();
        String expected = "Your password has been updated!";

        Assert.assertEquals(actual,expected, "The message of actual is not match expect's message");
    }
}
