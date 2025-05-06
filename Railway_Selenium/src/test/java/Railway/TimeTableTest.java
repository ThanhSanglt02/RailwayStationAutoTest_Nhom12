package Railway;

import Common.Constant.Constant;
import PageObjects.BookTicketPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TimeTablePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeTableTest extends BaseTest {
     @Test (description = "User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void TC15() {
         String departStation = "Huế";
         String arriveStation = "Sài Gòn";
         LoginPage loginPage = homePage.gotoLoginPage();
         loginPage.login(Constant.USERNAME,Constant.PASSWORD);
         TimeTablePage timeTablePage = homePage.gotoTimeTablePage();
         BookTicketPage bookTicketPage = timeTablePage.clickLinkBookTicket(departStation,arriveStation);

          // Tìm hiểu các lưu toàn bộ option vào list
         bookTicketPage.selectDepartFrom(departStation);
         bookTicketPage.selectArriveAt(arriveStation);
     }


}