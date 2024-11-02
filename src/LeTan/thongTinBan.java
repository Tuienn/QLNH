
package LeTan;

public class thongTinBan {
    //dữ liệu của thông tin bàn chỉ là dũ liệu tạm-> Lưu vào file để lấy dl cho hóa đơn(dùng sau)
    private String maBan;
    private int trangThaiBan;//Trống - 0, Có người - 1
    private String tenKH;
    private String thoiGian;
    private String duLieuBang_theoBan;//Lưu dữ liệu theo: c1d1-c2d1-c3d1-c4d1/c1d2-c2d2-c3d2-c4d2

    public thongTinBan() {
    }

    public thongTinBan(String maBan, int trangThaiBan, String tenKH, String thoiGian, String duLieuBang_theoBan) {
        this.maBan = maBan;
        this.trangThaiBan = trangThaiBan;
        this.tenKH = tenKH;
        this.thoiGian = thoiGian;
        this.duLieuBang_theoBan = duLieuBang_theoBan;
    }
    
    public String getMaBan() {
        return maBan;
    }

    public int getTrangThaiBan() {
        return trangThaiBan;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public String getDuLieuBang_theoBan() {
        return duLieuBang_theoBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public void setTrangThaiBan(int trangThaiBan) {
        this.trangThaiBan = trangThaiBan;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setDuLieuBang_theoBan(String duLieuBang_theoBan) {
        this.duLieuBang_theoBan = duLieuBang_theoBan;
    }

    @Override
    public String toString() {
        return "thongTinBan{" + "maBan=" + maBan + ", trangThaiBan=" + trangThaiBan +", tenKH=" + tenKH + ", thoiGian=" + thoiGian + ", duLieuBang_theoBan=" + duLieuBang_theoBan + '}';
    }
    
}
