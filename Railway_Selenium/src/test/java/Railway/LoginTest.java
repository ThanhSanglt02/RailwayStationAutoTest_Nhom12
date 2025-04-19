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
    @Test
    public void T01() {
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualResult = homePage.msgWelcomHomePage();
        Assert.assertEquals(actualResult, "Welcome to Safe Railway",
                "Title of HomePage is not match");
    }

    @Test
    public void T02() {
        loginPage = homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actual = loginPage.getErrorMsgInvalid();
        Assert.assertEquals(actual, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void T03() {
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,"1234568111");
        String actual = loginPage.getErrorMsgInvalid();
        Assert.assertEquals(actual, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC05() {
        loginPage = homePage.gotoLoginPage();
        for (int i = 0; i<4 ; i++) {
            loginPage.login(Constant.USERNAME,"1234568111");
            i++;
        }
        String actual = loginPage.getErrorMsgInvalid();
        Assert.assertEquals(actual, "Invalid username or password. Please try again.");
//        Assert.assertFalse(loginPage.isMsgErrorDisplayed(), "Message error is displayed" );
    }

    @Test
    public void TC06() {
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
//        System.out.println("URL sau khi login: " + loginPage.getCurrentUrlPageAfteLogin());'
        boolean actual = loginPage.isLoginSuccessful();
        Assert.assertTrue(actual, "Tabs not showing after successful login");

    }

    @Test
    public void TC08() {
        loginPage = homePage.gotoLoginPage();
        loginPage.setUsername(Constant.USERNAME);
    }

}
