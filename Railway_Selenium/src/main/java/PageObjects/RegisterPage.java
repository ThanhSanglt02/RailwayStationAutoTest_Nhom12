package PageObjects;

import org.openqa.selenium.By;

import static Common.Common.Utilities.getPseudoBeforeJS;

public class RegisterPage extends HomePage{
    private By emailInput = By.xpath("//input[@id='email']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By confirmPassInput = By.xpath("//input[@id='confirmPassword']");
    private By PIDInput = By.xpath("//input[@id='pid']");
    private By btnRegister = By.xpath("//input[@title='Register']");

    private By msgRegistratonConfirm = By.xpath("//div[@id='content']//p[contains(text(),'Registration Confirmed')]");
    private By msgErrorRegiter = By.xpath("//p[@class='message error']");
    private By msgErrorPassWordBefore = By.xpath("//label[@for='password'][@class='validation-error']");
    private By msgErrorPIDBefore = By.xpath("//label[@for='pid'][@class='validation-error']");

    public void setConfirmPass(By locator, String text) {
        find(locator).sendKeys(text);
    }
    public void setPID(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public void performRegister(String email, String password, String confirmPass, String pid) {
        set(emailInput,email);
        set(passwordInput, password);
        setConfirmPass(confirmPassInput,confirmPass);
        setPID(PIDInput, pid);
        find(btnRegister).click();
    }

    public boolean isMsgRefistratrionConfirmDisplayed() {
        return find(msgRegistratonConfirm).isDisplayed();
    }
    public String getTextErrorMessageRegister() {
        return getTextError(msgErrorRegiter);
    }

    public String getTextErrMsgPassword() {
        return getTextError(msgErrorPassWordBefore);
    }
    public String getTextErrMsgPID() {
        return getTextError(msgErrorPIDBefore);
    }

    public String getMsgErrorPasswodPseudo() {
        return getPseudoBeforeJS(msgErrorPassWordBefore);
    }
    public String getMsgErrorPIDPseudo() {
        return getPseudoBeforeJS(msgErrorPIDBefore);
    }

}
