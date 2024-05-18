package entity;

import java.sql.Date;

public class Service_Tuyen4_Order {
    private String ID;
    private String sellID;
    private String customerID;
    private String tourID;
    private String bookingDate;
    private String tourName;
    private String date;
    private int numberOfPeople;
    private long price;
    private String type;
    private String status;

    // Constructors
    public Service_Tuyen4_Order() {
    }

    public Service_Tuyen4_Order(String ID, String sellID, String customerID, String tourID, String bookingDate, String tourName, String date, int numberOfPeople, long price, String type, String status) {
        this.ID = ID;
        this.sellID = sellID;
        this.customerID = customerID;
        this.tourID = tourID;
        this.bookingDate = bookingDate;
        this.tourName = tourName;
        this.date = date;
        this.numberOfPeople = numberOfPeople;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    // Getter and setter methods
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSellID() {
        return sellID;
    }

    public void setSellID(String sellID) {
        this.sellID = sellID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Service_Tuyen4_Order{" +
                "ID='" + ID + '\'' +
                ", sellID='" + sellID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", tourID='" + tourID + '\'' +
                ", bookingDate=" + bookingDate +
                ", tourName='" + tourName + '\'' +
                ", date='" + date + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
