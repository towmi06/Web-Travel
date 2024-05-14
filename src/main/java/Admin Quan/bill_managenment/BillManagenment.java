package bill_managenment;

public class BillManagenment {
    private String ID;
    private String providerID;
    private String customerID;
    private String tourName;
    private String destination;
    private String departureDate;
    private int numberOfPeople;
    private long price;
    private String address;
    private String type;
    private String status;

    // Setter methods
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter methods
    public String getID() {
        return ID;
    }

    public String getProviderID() {
        return providerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getTourName() {
        return tourName;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public long getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    // toString method
    @Override
    public String toString() {
        return "BillManagenment{" +
                "ID='" + ID + '\'' +
                ", providerID='" + providerID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", tourName='" + tourName + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
