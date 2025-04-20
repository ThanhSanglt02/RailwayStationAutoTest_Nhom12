package Railway;

import Common.Constant.Constant;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketPageTest extends BaseTest {
    public LoginPage loginPage;
//    @BeforeMethod
//    public void setLogin() {
//        loginPage = homePage.gotoLoginPage();
//        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
//
//    }

    @Test
    public void TC04() {
        homePage.gotoBookTicketPage(); // vì chưa login nên khi từ HomePage muốn vào BookTicket phải thông qua login
        boolean actual = loginPage.isLoginPageDisplay();
        Assert.assertTrue(actual, "Login Page is not display when click tab BookTicket");
    }

    @Test
    public void TC14() {
        String departDate = "4/28/2025";
        String departFrom = "Huế";
        String arriveAt = "Đà Nẵng";
        String seatType = "Hard seat";
        String ticketAmount = "2";
        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        bookTicketPage.delay(3000);
//        bookTicketPage.bookTicketForm(departDate,departFrom,arriveAt,seatType,ticketAmount);
        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectDepartFrom(departFrom);
        bookTicketPage.selectArriveAt(arriveAt);
        bookTicketPage.selectSeatType(seatType);
        bookTicketPage.selectTicketAmount(ticketAmount);
        bookTicketPage.clickBtnBookTicket();

        String actualResult = bookTicketPage.getTitleBookTicketPageSuccess();
        Assert.assertEquals(actualResult,"Ticket booked successfully!", "The message of actual and expected is not match");
        boolean actualInfoTicketBooked = bookTicketPage.isInfoTableBookticketDisplay(departDate,departFrom,arriveAt,seatType,ticketAmount);
        Assert.assertTrue(actualInfoTicketBooked, "Information of ticket is not displayed");

    }

}
