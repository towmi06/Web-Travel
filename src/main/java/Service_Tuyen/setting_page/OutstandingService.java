package Service_Tuyen.setting_page;

public class OutstandingService {
    private String ID;
    private float rate;
    private long sales;
    private String tourName;
    private String destination;
    private String departureDate;
    private int price;
    private String address;
    private String category;
    private boolean outstanding;

    // Constructor
    public OutstandingService() {
        this.ID = "";
        this.rate = (float) 0.0;
        this.sales = 0;
        this.tourName = "";
        this.destination = "";
        this.departureDate = "";
        this.price = 0;
        this.address = "";
        this.category = "";
        this.outstanding = false;
    }

    // Getters and setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        this.sales = sales;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public boolean getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(boolean outstanding) {
        this.outstanding = outstanding;
    }

    @Override
    public String toString() {
        return "OutstandingService{" +
                "ID='" + ID + '\'' +
                ", rate=" + rate +
                ", sales=" + sales +
                ", tourName='" + tourName + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", outstanding='" + outstanding + '\'' +
                '}';
    }
}
