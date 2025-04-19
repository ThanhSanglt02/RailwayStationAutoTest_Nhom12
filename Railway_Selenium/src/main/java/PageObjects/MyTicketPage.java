package PageObjects;

import org.openqa.selenium.By;

import static Common.Common.HandleJS.clickJS;

public class MyTicketPage extends HomePage{

    private By getXpathbtnCancelId(String id) {
        return By.xpath("//input[@type='button' and @value='Cancel' and @onclick='DeleteTicket("+id+");']");
    }

    public void clickBtnCancelWithID(String id) {
        clickJS(getXpathbtnCancelId(id));
    }
}
