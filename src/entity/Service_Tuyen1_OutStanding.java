package entity;

public class Service_Tuyen1_OutStanding {
    private String id;
    private int sell_ID;
    private String cateID;
    private float rate;
    private long sales;
    private String tourName;
    private String image;
    private String journeys;
    private String date;
    private int price;
    private boolean outstanding;

    public Service_Tuyen1_OutStanding() {
        this.id = "";
        this.sell_ID = 0;
        this.cateID = "";
        this.rate = 0.0f;
        this.sales = 0;
        this.tourName = "";
        this.journeys = "";
        this.date = "";
        this.price = 0;
        this.outstanding = false;
    }
    
    public Service_Tuyen1_OutStanding(String id, int sell_ID, String cateID, float rate, long sales, String tourName, String image, String journeys, String date, int price, boolean outstanding) {
        this.id = id;
        this.sell_ID = sell_ID;
        this.cateID = cateID;
        this.rate = rate;
        this.sales = sales;
        this.tourName = tourName;
        this.image = image;
        this.journeys = journeys;
        this.date = date;
        this.price = price;
        this.outstanding = outstanding;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSell_ID() {
        return sell_ID;
    }

    public void setSell_ID(int sell_ID) {
        this.sell_ID = sell_ID;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
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
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJourneys() {
        return journeys;
    }

    public void setJourneys(String journeys) {
        this.journeys = journeys;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(boolean outstanding) {
        this.outstanding = outstanding;
    }
}