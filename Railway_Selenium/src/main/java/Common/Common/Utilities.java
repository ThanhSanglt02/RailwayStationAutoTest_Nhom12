package Common.Common;

import PageObjects.GeneralPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static Common.Common.HandleJS.scrollIntoViewJS;

public class Utilities<IJavaScriptExecutor> {
    public static WebDriver driver;

    public static void setUpDriverUtilities() {
        driver = GeneralPage.driver;
    }

    private static Select findDropDown(By locator) {
        scrollIntoViewJS(locator);
        return new Select(driver.findElement(locator));
    }

    // perform select option
    public static void selectOptionByVisibleText(By locator,String text) {
        findDropDown(locator).selectByVisibleText(text);
    }
    public static void selectOptionByValue(By locator,String value) {
        findDropDown(locator).selectByValue(value);
    }
    public static void selectOptionByIndex(By locator,int index) {
        findDropDown(locator).selectByIndex(index);
    }
    public static void deselectOptionByVisibleText(By locator,String text) {
        findDropDown(locator).deselectByVisibleText(text);
    }
    // get text of option
    public static void getTextofSelectOption(By locator) {
        findDropDown(locator).getOptions();
    }

    public static String getPseudoBeforeJS(By locator) {
        WebElement webElement = driver.findElement(locator);
        String script = "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String beforeContent = (String) js.executeScript(script, webElement);
        return beforeContent;
    }

    public static String getIDUrlBySplit(String url) {
        return url.split("id=")[1];
    }
}
