package entity;

public class Service_Th3_ProductManage {
    private String id;
    private String tourName;
    private String image;
    private String date;
    private double price;
    private String journeys;
    private int cateID;
    private int sellId; 
    private String categoryName;
    private String status;
    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getJourneys() {
        return journeys;
    }

    public void setJourneys(String journeys) {
        this.journeys = journeys;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getSellId() {
        return sellId;
    }

    public void setSellId(int sellId) {
        this.sellId = sellId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service_Th3_ProductManage{" +
               "id='" + id + '\'' +
               ", tourName='" + tourName + '\'' +
               ", image='" + image + '\'' +
               ", date='" + date + '\'' +
               ", price=" + price +
               ", journeys='" + journeys + '\'' +
               ", cateID=" + cateID +
               ", sellId=" + sellId +
               ", categoryName='" + categoryName + '\'' +
               ", status=" + status +
               '}';
    }
}
