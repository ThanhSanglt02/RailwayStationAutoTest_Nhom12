package Railway;

import Common.Constant.Constant;
import PageObjects.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    @BeforeMethod
    public void navigatetoLoginPageBeforePerformTesting() {
        loginPage = homePage.gotoLoginPage();
    }
    @Test (description = "User can log into Railway with valid username and password")
    public void login_withValidUsernameAndPassword_shouldDisplayWelcomeMsg() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualResult = homePage.msgWelcomHomePage();
        Assert.assertEquals(actualResult, "Welcome to Safe Railway",
                "Title of HomePage is not match");
    }

    @Test (description = "User can't login with blank \"Username\" textbox")
    public void login_withBlankUsername_shoudDisplayErrorMsg () {
        loginPage.login("", Constant.PASSWORD);
        String actual = loginPage.getErrorMsgInvalid();
        Assert.assertEquals(actual, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test (description = "User cannot log into Railway with invalid password ")
    public void login_withInvalidPassword_shoudDisplayErrorMsg() {
        loginPage.login(Constant.USERNAME,"1234568111");
        String actual = loginPage.getErrorMsgInvalid();
        Assert.assertEquals(actual, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test (description = "System shows message when user enters wrong password several times (3 times)")
    public void login_withThreeWrongPasswords_shouldShowErrorMessage() {
        for (int i = 0; i<4 ; i++) {
            loginPage.login(Constant.USERNAME,"1234568111");
            i++;
        }
        String actual = loginPage.getErrorMsgInvalid();
        Assert.assertEquals(actual, "Invalid username or password. Please try again.");
//        Assert.assertFalse(loginPage.isMsgErrorDisplayed(), "Message error is displayed" );
    }

    @Test (description = "Additional pages display once user logged in")
    public void login_withValidAccount_SomePageDisplayed() {
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
//        System.out.println("URL sau khi login: " + loginPage.getCurrentUrlPageAfteLogin());'
        boolean actual = loginPage.isLoginSuccessful();
        Assert.assertTrue(actual, "Tabs not showing after successful login");

    }

    @Test
    public void TC08() {
        loginPage.setUsername(Constant.USERNAME);
    }

}
