package entity;

public class Admin_Quan_Help {
    private String idCauHoi;
    private String cauHoi;
    private String cauTraLoi;

    public Admin_Quan_Help(String idCauHoi, String cauHoi, String cauTraLoi) {
        this.idCauHoi = idCauHoi;
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
    }

    public String getIdCauHoi() {
        return idCauHoi;
    }

    public void setIdCauHoi(String idCauHoi) {
        this.idCauHoi = idCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    @Override
    public String toString() {
        return "ID câu hỏi: " + idCauHoi + ", Câu hỏi: " + cauHoi + ", Câu trả lời: " + cauTraLoi;
    }
}
