package Railway;

import Common.Constant.Constant;
import DataObject.Ticket;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static Common.Common.HandleAlertSwitchTo.*;

public class MyTicketTest extends BaseTest{
    @Test (description =  "TC16: User can cancel a ticket")
    public void cancelTicketWithIDTest() {
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


    @Test (description =  "TC16 - continue: User can cancel a ticket with detail row")
    public void cancelTicketWithRowDetailTest() {
        String departFrom = "Huế";
        String arriveAt = "Nha Trang";
        String departDate = "4/21/2025";
        String bookDate = "4/18/2025";


        String expectedAlertText = "Are you sure?";

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        List<Ticket> ticketList = myTicketPage.getAllTicketRows();

        myTicketPage.clickBtnCancelWithRowDetail(departFrom, arriveAt, departDate);
        Assert.assertEquals(getAlertText(), expectedAlertText, "\n Actual and Expected are not match \n");
        acceptAlert();

        List<Ticket> ticketListAfter = myTicketPage.getAllTicketRowsAfter();

        if (ticketListAfter.size() == ticketList.size() - 1) {
            Boolean actual = myTicketPage.isTicketExistAfterCancelOrDelete(ticketList, departFrom, arriveAt, departDate, bookDate);
            Assert.assertFalse(actual, "The ticket does not exist on my ticket after cancel or delete");
            System.out.println("The ticket does not exist on my ticket after cancel or delete");
        }
        else {
            Boolean actual = myTicketPage.isTicketExistAfterCancelOrDelete(ticketList, departFrom, arriveAt, departDate, bookDate);
            Assert.assertTrue(actual, "The ticket is still exist on my ticket after cancel or delete");
            System.out.println("The ticket is still exist on my ticket after cancel or delete");
        }
    }
}
