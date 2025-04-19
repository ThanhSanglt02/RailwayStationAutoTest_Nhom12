package PageObjects;

import org.openqa.selenium.By;

public class ForgetPasswordPage extends LoginPage{
    private By emailInput = By.xpath("//input[@id='email']");
    private By btnSendInstructions = By.xpath("//input[@type='submit']");

}
