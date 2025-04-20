package Railway;

import Common.Constant.Constant;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.Common.HandleAlertSwitchTo.*;

public class MyTicketTest extends BaseTest{
    @Test (description =  "User can cancel a ticket")
    public void cancelTicketTest() {
        String departDate = "4/28/2025";
        String departFrom = "Quảng Ngãi";
        String arriveAt = "Nha Trang";
        String seatType = "Hard seat";
        String ticketAmount = "2";

        String expectedAlertText = "Are you sure?";

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        bookTicketPage.delay(3000);
//        bookTicketPage.bookTicketForm(departDate,departFrom,arriveAt,seatType,ticketAmount);
        bookTicketPage.selectDepartDate(departDate);
        bookTicketPage.selectDepartFrom(departFrom);
        bookTicketPage.selectArriveAt(arriveAt);
        bookTicketPage.selectSeatType(seatType);
        bookTicketPage.selectTicketAmount(ticketAmount);
        bookTicketPage.clickBtnBookTicket();
        String idTicketAfterBookingSuccess = bookTicketPage.getIDBookTicketAfterBookSucess();
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.clickBtnCancelWithID(idTicketAfterBookingSuccess);

        Assert.assertEquals(getAlertText(), expectedAlertText, "\n Actual and Expected are not match \n");
        acceptAlert();
    }
}
