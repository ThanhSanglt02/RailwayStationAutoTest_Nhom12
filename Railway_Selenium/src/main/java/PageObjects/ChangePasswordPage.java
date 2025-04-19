package PageObjects;

import org.openqa.selenium.By;

public class ChangePasswordPage extends HomePage{

    private By currentPasswordInput = By.xpath("//input[@id='currentPassword']");
    private By newPasswordInput = By.xpath("//input[@id='newPassword']");
    private By confirmPasswordInput = By.xpath("//input[@id='confirmPassword']");
    private By btnChangePassword = By.xpath("//input[@title='Change password']");

    private By msgPassUpdated = By.xpath("//div[@id='content']//p[contains(text(), 'updated')]");

    public void changePassword (String currentPass, String newPass, String confirmPass) {
        set(currentPasswordInput, currentPass);
        set(newPasswordInput, newPass);
        set(confirmPasswordInput, confirmPass);

    }
    public LoginPage clickBtnRegister() {
        click(btnChangePassword);
        return new LoginPage();
    }

    public String getTextMsgPassUpdated() {
        return find(msgPassUpdated).getText();
    }

}
