package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

// Vì sao không xử lý đối tượng Select ở GeneralPage hay HomePage mà nên để ở Utilities?
// --> Vì HomePgae kế thừa GenealPage và HomePage chỉ thực hiện được các hành vi trong GeneralPage có và hầu như ở mọi Page đều có các hành vi như vậy
// --> Nếu xử lý Select ở GeneralPage thì sẽ không hợp lý vì HomePage hiện tại không có xuất hiện dropdown Select và các này cũng chi xuất hiện ở 1 vài Page chứ không phải hầu hết

public class GeneralPage {

    public static WebDriver driver;
    //Locators

    public void setUpDriver(WebDriver driver) {
        GeneralPage.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public boolean isTabDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void click(By locator) {
        find(locator).click();
    }

    public String getTextSuscess(By locator) {
        return find(locator).getText();
    }
    public String getTextError(By locator) {
        return find(locator).getText();
    }

    public void delay(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
