package entity;

public class Service_Tuyen2_PageLayout {
    private String taiKhoan;
    private boolean sapXep;
    private boolean dichVuNoiBat;
    private boolean chuongTrinhKhuyenMai;
    private boolean hienThi;

    public Service_Tuyen2_PageLayout() {
    	this.taiKhoan = "";
        this.sapXep = false;
        this.dichVuNoiBat = false;
        this.chuongTrinhKhuyenMai = false;
        this.hienThi = false;
    }

    public Service_Tuyen2_PageLayout(String taiKhoan, boolean sapXep, boolean dichVuNoiBat, boolean chuongTrinhKhuyenMai, boolean hienThi) {
        this.taiKhoan = taiKhoan;
        this.sapXep = sapXep;
        this.dichVuNoiBat = dichVuNoiBat;
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
        this.hienThi = hienThi;
    }

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

    public boolean getHienThi() {
        return hienThi;
    }

    public void setHienThi(boolean hienThi) {
        this.hienThi = hienThi;
    }
}
