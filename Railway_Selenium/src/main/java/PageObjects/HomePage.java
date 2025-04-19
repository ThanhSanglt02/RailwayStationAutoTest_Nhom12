package PageObjects;

import org.openqa.selenium.By;

public class HomePage extends GeneralPage {
    //Locator
    public By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    public By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    public By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    public By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    public By tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    public By tabLogout = By.xpath("//a[@href='/Account/Logout']");
    public By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");

    public By titleMessageHomePage = By.xpath("//div[@id='content']//h1[contains(text(),'Welcome')]");

    public LoginPage gotoLoginPage() {
        find(tabLogin).click();
        return new LoginPage();
    }
    // from HomePage navigate to BookTicketPage
    public BookTicketPage gotoBookTicketPage() {
        find(tabBookTicket).click();
        return new BookTicketPage();
    }
    public RegisterPage gotoRegisterPage() {
        find(tabRegister).click();
        return new RegisterPage();
    }
    public ChangePasswordPage gotoChangePasswordPage() {
        click(tabChangePassword);
        return new ChangePasswordPage();
    }
    public TimeTablePage gotoTimeTablePage() {
        click(tabTimeTable);
        return new TimeTablePage();
    }
    public MyTicketPage gotoMyTicketPage() {
        click(tabMyTicket);
        return new MyTicketPage();
    }

    public boolean isLoginSuccessful() {
        try {
            return isTabDisplayed(tabMyTicket) && isTabDisplayed(tabChangePassword)
                    && isTabDisplayed(tabLogout);
        } catch (Exception e) {
            return  false;
        }
    }

    public String msgWelcomHomePage() {
        return find(titleMessageHomePage).getText();
    }



}
