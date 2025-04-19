package Common.Common;

import org.openqa.selenium.WebDriver;

public class HandleAlertSwitchTo extends Utilities{
    private static WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }
    public static String getAlertText() {
       return switchTo().alert().getText();
    }
    public static void acceptAlert() {
        switchTo().alert().accept();  //alert sẽ tự động click button Ok để accept
    }
}
