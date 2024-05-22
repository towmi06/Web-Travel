package entity;

public class Service_Th1_OrderManager {
    private int id;
    private int customerId;
    private String tourId;
    private String imageTour;
    private String bookingDate;
    private String tourName;
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

    public Service_Th1_OrderManager(int id, String imageTour, String bookingDate, double totalPrice, String status, String createdAt ) {
        this.id = id;
        this.imageTour = imageTour;
        this.bookingDate = bookingDate;
        this.tourName = tourName;
        this.totalPrice = totalPrice; 
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getTourId() { return tourId; }
    public void setTourId(String tourId) { this.tourId = tourId; }
    public String getimageTour() { return imageTour; }
    public void setimageTour(String imageTour) { this.imageTour = imageTour; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
    
    public String getTourName() { return tourName; }
    public void setTourName(String tourName) { this.tourName = tourName; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

}
