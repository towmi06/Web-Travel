package entity;

public class Service_Tuyen2_PageLayout {
    private String taiKhoan;
    private boolean sapXep;
    private boolean dichVuNoiBat;
    private boolean chuongTrinhKhuyenMai;
    private boolean hienThi;

    // Constructors
    public Service_Tuyen2_PageLayout() {
    }

    public Service_Tuyen2_PageLayout(String taiKhoan, boolean sapXep, boolean dichVuNoiBat, boolean chuongTrinhKhuyenMai, boolean hienThi) {
        this.taiKhoan = taiKhoan;
        this.sapXep = sapXep;
        this.dichVuNoiBat = dichVuNoiBat;
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
        this.hienThi = hienThi;
    }

    // Getter and setter methods
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public boolean getSapXep() {
        return sapXep;
    }

    public void setSapXep(boolean sapXep) {
        this.sapXep = sapXep;
    }

    public boolean getDichVuNoiBat() {
        return dichVuNoiBat;
    }

    public void setDichVuNoiBat(boolean dichVuNoiBat) {
        this.dichVuNoiBat = dichVuNoiBat;
    }

    public boolean getChuongTrinhKhuyenMai() {
        return chuongTrinhKhuyenMai;
    }

    public void setChuongTrinhKhuyenMai(boolean chuongTrinhKhuyenMai) {
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
    }

    public boolean geHhienThi() {
        return hienThi;
    }

    public void setHienThi(boolean hienThi) {
        this.hienThi = hienThi;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "PageLayout{" +
                "taiKhoan='" + taiKhoan + '\'' +
                ", sapXep=" + sapXep +
                ", dichVuNoiBat=" + dichVuNoiBat +
                ", chuongTrinhKhuyenMai=" + chuongTrinhKhuyenMai +
                ", hienThi=" + hienThi +
                '}';
    }
}
