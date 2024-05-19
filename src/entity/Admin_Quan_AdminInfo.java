package entity;

public class Admin_Quan_AdminInfo {
    private String ID;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private String position;
    private String coverPhoto;
    private String avatar;
    private String facebook;
    private String twitter;
    private String instagram;
    private String tiktok;

    public Admin_Quan_AdminInfo(String ID, String name, String email, String phone, String gender, String address, String position, String coverPhoto, String avatar, String facebook, String twitter, String instagram, String tiktok) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.position = position;
        this.coverPhoto = coverPhoto;
        this.avatar = avatar;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.tiktok = tiktok;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTiktok() {
        return tiktok;
    }

    public void setTiktok(String tiktok) {
        this.tiktok = tiktok;
    }

    // toString method
    @Override
    public String toString() {
        return "AdminInfo{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", avatar='" + avatar + '\'' +
                ", facebook='" + facebook + '\'' +
                ", twitter='" + twitter + '\'' +
                ", instagram='" + instagram + '\'' +
                ", tiktok='" + tiktok + '\'' +
                '}';
    }
}
