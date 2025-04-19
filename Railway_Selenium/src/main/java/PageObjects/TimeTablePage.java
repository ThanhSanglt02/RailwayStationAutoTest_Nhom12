package PageObjects;

import org.openqa.selenium.By;

import static Common.Common.HandleJS.clickJS;

public class TimeTablePage extends HomePage{
    private By getXpathLinkBookTicket(String departStation, String arriveStation) {
        return By.xpath("//td[text()='"+departStation+"']/following-sibling::td[text() = '"+arriveStation+"']/..//a[text()='book ticket']");
    }
    public BookTicketPage clickLinkBookTicket(String departStation, String arriveStation) {
        clickJS(getXpathLinkBookTicket(departStation,arriveStation));
        return new BookTicketPage();
    }
}
