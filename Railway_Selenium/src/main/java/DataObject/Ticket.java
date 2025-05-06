package DataObject;

public class Ticket {
    private String departStation;
    private String arriveStation;
    private String departDate;
    private String bookDate;

    // khởi tạo constructor:
    public Ticket(String departStation, String arriveStation,
                  String departDate, String bookDate) {
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.departDate = departDate;
        this.bookDate = bookDate;
    }

    // Getter methods
    public String getDepartStation() { return departStation; }
    public String getArriveStation() { return arriveStation; }
    public String getDepartDate() { return departDate; }
    public String getBookDate() { return bookDate; }
}
