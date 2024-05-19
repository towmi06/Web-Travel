package entity;

public class Admin_Quan_Cooperate {
    private String tenNCC;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private String ngayGui;
    private String noiDungHopTac;

    public Admin_Quan_Cooperate(String tenNCC, String email, String soDienThoai, String diaChi, String ngayGui, String noiDungHopTac) {
        this.tenNCC = tenNCC;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngayGui = ngayGui;
        this.noiDungHopTac = noiDungHopTac;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getNoiDungHopTac() {
        return noiDungHopTac;
    }

    public void setNoiDungHopTac(String noiDungHopTac) {
        this.noiDungHopTac = noiDungHopTac;
    }

    // toString method
    @Override
    public String toString() {
        return "Cooperate{" +
                "tenNCC='" + tenNCC + '\'' +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngayGui='" + ngayGui + '\'' +
                ", noiDungHopTac='" + noiDungHopTac + '\'' +
                '}';
    }
}
