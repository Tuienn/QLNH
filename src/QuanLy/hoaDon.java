
package QuanLy;

public class hoaDon {
    private String tenKH;
    private String thoiGian;
    private String dlBangThucDon;

    public hoaDon() {
    }

    public hoaDon(String tenKH, String thoiGian, String dlBangThucDon) {
        this.tenKH = tenKH;
        this.thoiGian = thoiGian;
        this.dlBangThucDon = dlBangThucDon;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public String getDlBangThucDon() {
        return dlBangThucDon;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setDlBangThucDon(String dlBangThucDon) {
        this.dlBangThucDon = dlBangThucDon;
    }
    public double tinhThanhTienHD()
    {
        double thanhTienHD=0;
        
        String[] dl1Hang = dlBangThucDon.split("/");
        for(String dl : dl1Hang)
        {
            String[] CtDL = dl.split("-");
            thanhTienHD+=Integer.parseInt(CtDL[1])*Double.parseDouble(CtDL[2]);
        }
        return thanhTienHD;
    }
    public String toStringFile()
    {
        return tenKH+"$"+thoiGian+"$"+dlBangThucDon;
    }
}
