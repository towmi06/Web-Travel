package entity;

public class Service_Th1_OrderManager {
    private int id;
    private int customerId;
    private String tourId;
    private String bookingDate;
    private double totalPrice;
    private String status;
    private String createdAt;
    private String updatedAt;
    private int sellId;
    private String customerName;
    private String phoneNumber;
    private String address;
    
    public Service_Th1_OrderManager() {
    	
    }

    public Service_Th1_OrderManager(int id, int customerId, String tourId, String bookingDate, double totalPrice, String status, String createdAt, String updatedAt, int sellId, String customerName, String phoneNumber, String address) {
        this.id = id;
        this.customerId = customerId;
        this.tourId = tourId;
        this.bookingDate = bookingDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sellId = sellId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getTourId() { return tourId; }
    public void setTourId(String tourId) { this.tourId = tourId; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public int getSellId() { return sellId; }
    public void setSellId(int sellId) { this.sellId = sellId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
