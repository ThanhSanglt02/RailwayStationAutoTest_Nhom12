package PageObjects;

import DataObject.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Common.Common.HandleJS.clickJS;

public class MyTicketPage extends HomePage{


    private By allTicketsExisted = By.xpath("//table[@class='MyTable']//tr[contains(@class, 'OddRow') or contains(@class, 'EvenRow')]");

    private By getXpathbtnCancelId(String id) {
        return By.xpath("//input[@type='button' and @value='Cancel' and @onclick='DeleteTicket("+id+");']");
    }
    private By btnCancelOrDeleteDetail(String departStation, String arriveStation, String departDate) {
        return By.xpath("//td[text()='"+departStation+"']/following-sibling::td[text() = '"+arriveStation+"']/following-sibling::td[text() = '"+departDate+"']/..//input[@type='button']");
    }

    public void clickBtnCancelWithID(String id) {
        clickJS(getXpathbtnCancelId(id));
    }

    public void clickBtnCancelWithRowDetail(String departStation, String arriveStation, String departDate) {
        clickJS(btnCancelOrDeleteDetail(departStation,arriveStation,departDate));
    }

    // Lấy toàn bộ ticket đã book trong MyTicket Page
    public List<Ticket> getAllTicketRows() {
        List<Ticket> tickets = new ArrayList<>();
        List<WebElement> rows = driver.findElements(allTicketsExisted);

        for (WebElement row : rows) {
            // Lấy toàn bộ thông tin của từng ô của dòng <-> lấy tất cả td có trong dòng (row) đó
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String departStation = cells.get(1).getText();
            String arriveStation = cells.get(2).getText();
            String departDate = cells.get(4).getText();
            String bookDate = cells.get(5).getText();

            Ticket ticket = new Ticket(departStation, arriveStation, departDate, bookDate);
            tickets.add(ticket);
        }
        return tickets;
    }

    public List<Ticket> getAllTicketRowsAfter() {
        List<Ticket> tickets = new ArrayList<>();
        List<WebElement> rows = driver.findElements(allTicketsExisted);

        for (WebElement row : rows) {
            // Lấy toàn bộ thông tin của từng ô của dòng <-> lấy tất cả td có trong dòng (row) đó
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String departStation = cells.get(1).getText();
            String arriveStation = cells.get(2).getText();
            String departDate = cells.get(4).getText();
            String bookDate = cells.get(5).getText();

            Ticket ticket = new Ticket(departStation, arriveStation, departDate, bookDate);
            tickets.add(ticket);
        }
        return tickets;
    }

    // Kiểm tra xem ticket còn tồn tại sau khi đã cancel hoặc xóa hay không
    boolean isTicketExistAfterCancelOrDelete = false;
    public boolean isTicketExistAfterCancelOrDelete(List<Ticket> ticketRows, String departStation, String arriveStation,
                                                    String departDate, String bookDate) {
        for (Ticket ticketRow : ticketRows) {
            if (ticketRow.getDepartStation().equals(departStation) && ticketRow.getArriveStation().equals(arriveStation)
                    && ticketRow.getDepartDate().equals(departDate) && ticketRow.getBookDate().equals(bookDate)) {
                isTicketExistAfterCancelOrDelete = true;
                break;
            }
        }
        return isTicketExistAfterCancelOrDelete;
    }


}
