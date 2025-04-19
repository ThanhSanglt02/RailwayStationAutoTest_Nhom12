package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Common.Common.HandleJS.clickJS;
import static Common.Common.Utilities.*;

public class BookTicketPage extends HomePage{
    // Locators
    private By departDateSelect = By.xpath("//select[@name='Date']");
    private By departFromSelect = By.xpath("//select[@name='DepartStation']");
    private By arriveAtSelect = By.xpath("//select[@name='ArriveStation']");
    private By seatTypeSelect = By.xpath("//select[@name='SeatType']");
    private By ticketAmountSelect = By.xpath("//select[@name='TicketAmount']");
    private By btnBookTicket = By.xpath("//input[@type='submit']");

    private By titleBookTicketSucces = By.xpath("//div[@id='content']//h1[text() ='Ticket booked successfully!']");
    private By titleBookTicketPage = By.xpath("//div[@id='content']//h1[text() ='Book ticket']");
    private String text;

    //Method
    public void bookTicketForm(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        selectOptionByVisibleText(departDateSelect, departDate);
        selectOptionByVisibleText(departFromSelect, departFrom);
        selectOptionByVisibleText(arriveAtSelect, arriveAt);
        selectOptionByVisibleText(seatTypeSelect, seatType);
        selectOptionByVisibleText(ticketAmountSelect, ticketAmount);
        click(btnBookTicket);
    }
    public void selectDepartDate(String departDate) {
        selectOptionByVisibleText(departDateSelect, departDate);
    }
    public void selectDepartFrom (String departFrom) {
        selectOptionByVisibleText(departFromSelect, departFrom);
    }
    public void selectArriveAt(String arriveAt) {
        selectOptionByVisibleText(arriveAtSelect, arriveAt);
    }
    public void selectSeatType(String seatType) {
        selectOptionByVisibleText(seatTypeSelect, seatType);
    }
    public void selectTicketAmount(String ticketAmount) {
        selectOptionByVisibleText(ticketAmountSelect, ticketAmount);
    }
    public BookTicketPage clickBtnBookTicket() {
        clickJS(btnBookTicket);
        return new BookTicketPage();
    }

    public String getIDBookTicketAfterBookSucess() {
        String url = driver.getCurrentUrl();
        return getIDUrlBySplit(url);
    }



    private By getXpathInfoDepartStation(String text) {
        return By.xpath("//td[text()='"+text+"']");
    }
    public String getInfoDepartStation(String departStation) {
        return find(getXpathInfoDepartStation(departStation)).getText();
    }
    private By getXpathInfoArriveStation(String text) {
        return By.xpath("//td[text()='"+text+"']");
    }
    public String getInfoArriveStation(String arrveStation) {
        return find(getXpathInfoArriveStation(arrveStation)).getText();
    }
    private String getInfoSeatType(String text) {
        return find(By.xpath("//td[text()='"+text+"']")).getText();
    }
    private String getInfoDepartDate(String text) {
        return find(By.xpath("//td[text()='"+text+"']")).getText();
    }
    private String getInfoAmountTicket(String text) {
        return find(By.xpath("//td[text()='"+text+"']")).getText();
    }

    public boolean isInfoTableBookticketDisplay(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        try {
            return getInfoDepartDate(departDate).equals(departDate)
                    && getInfoDepartStation(departFrom).equals(departFrom)
                    && getInfoArriveStation(arriveAt).equals(arriveAt)
                    && getInfoSeatType(seatType).equals(seatType)
                    && getInfoAmountTicket(ticketAmount).equals(ticketAmount);
        } catch (Exception e) {
            return false;
        }
    }

    public String getTitleBookTicketPage() {
        return find(titleBookTicketPage).getText();
    }
    public String getTitleBookTicketPageSuccess() {
        return find(titleBookTicketSucces).getText();
    }



}
