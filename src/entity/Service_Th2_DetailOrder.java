package entity;

import java.util.Date;

public class Service_Th2_DetailOrder {
    private int id;
    private int customerId;
    private String tourId;
    private Date bookingDate;
    private double totalPrice;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private int sellId;
    private String image;
    private int numberOrders;

    private String paymentMethod;
    private Date paymentDate;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;

    // Getters and Setters for all fields
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getTourId() {
        return tourId;
    }
    public void setTourId(String tourId) {
        this.tourId = tourId;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public int getSellId() {
        return sellId;
    }
    public void setSellId(int sellId) {
        this.sellId = sellId;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getNumberOrders() {
        return numberOrders;
    }
    public void setNumberOrders(int numberOrders) {
        this.numberOrders = numberOrders;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Service_Th2_DetailOrder{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", tourId='" + tourId + '\'' +
                ", bookingDate=" + bookingDate +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", sellId=" + sellId +
                ", image='" + image + '\'' +
                ", numberOrders=" + numberOrders +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
