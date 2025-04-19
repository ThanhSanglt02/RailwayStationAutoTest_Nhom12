package PageObjects;

import org.openqa.selenium.By;

public class LoginPage extends HomePage {
    private By userNameInput = By.xpath("//input[@id='username']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@title='Login']");
    private By forgetPasswordLink = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");

    private By msgError = By.xpath("//p[contains(@class,'message')]");
    private By titleLoginPage =By.xpath("//div[@id='content']//h1[text() ='Login page']");

    public HomePage login(String username, String password) {
        set(userNameInput,username);
        set(passwordInput,password);
        find(btnLogin).click();
        return new HomePage();
    }
    public void setUsername(String username)
    {
        set(userNameInput,username);
    }
    public void setPassword(String password) {

        set(passwordInput,password);
    }
    public HomePage clickBtnLogin() {
        find(btnLogin).click();
        return new HomePage();
    }
    // From LoginPage navigate BookTicketPage
    public BookTicketPage gotoBookTicketPage() {
        find(tabBookTicket).click();
        return new BookTicketPage();
    }
    public ForgetPasswordPage gotoForgetPasswordPage() {
        click(forgetPasswordLink);
        return new ForgetPasswordPage();
    }

    public String getErrorMsgInvalid() {
        return getTextError(msgError);
    }

    public boolean isLoginPageDisplay() {
        return find(titleLoginPage).isDisplayed();
    }

    public String getCurrentUrlPageAfteLogin() {
        return driver.getCurrentUrl();
    }

}
