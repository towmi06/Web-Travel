package table_data;

public class tour {
    private int id;
    private String tourName;
    private String image;
    private String date;
    private double price;
    private String journeys;
    private String description1;
    private String imageKS;
    private String description2;
    private int cateID;
    private int sell_ID;
    
    public tour() {
    }

    public tour(int id, String tourName, String image, String date, double price, String journeys, String description1,
    		String imageKS, String description2, int cateID, int sell_ID) {
        this.id = id;
        this.tourName = tourName;
        this.image = image;
        this.date = date;
        this.price = price;
        this.journeys = journeys;
        this.description1 = description1;
        this.imageKS = imageKS;
        this.description2 = description2;
        this.cateID = cateID;
        this.sell_ID = sell_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getImageKS() {
        return imageKS;
    }

    public void setImageKS(String imageKS) {
        this.imageKS = imageKS;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getSellID() {
        return sell_ID;
    }

    public void setSellID(int sellID) {
        this.sell_ID = sellID;
    }
    @Override
    public String toString() {
        return "tour{" +
                "id=" + id +
                ", tourName='" + tourName + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", journeys='" + journeys + '\'' +
                ", description1='" + description1 + '\'' +
                ", imageKS='" + imageKS + '\'' +
                ", description2='" + description2 + '\'' +
                ", cateID=" + cateID +
                ", sell_ID=" + sell_ID +
                '}';
    }

}
