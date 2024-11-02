
package LeTan;
public class monAn {
    private String maMonAn;
    private String tenMonAn;
    private String maDanhMuc;
    private double gia;
    private String filePathImage;
    
    //Mã danh mục của món Việt-1, Hàn-2, Trung-3

    public monAn(String maMonAn, String tenMonAn, String maDanhMuc, double gia, String filePathImage) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.maDanhMuc = maDanhMuc;
        this.gia = gia;
        this.filePathImage = filePathImage;
    }

    public String getMaMonAn() {
        return maMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public double getGia() {
        return gia;
    }

    public String getFilePathImage() {
        return filePathImage;
    }
    
    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setFilePathImage(String filePathImage) {
        this.filePathImage = filePathImage;
    }

    @Override
    public String toString() {
        return "monAn{" + "maMonAn=" + maMonAn + ", tenMonAn=" + tenMonAn + ", maDanhMuc=" + maDanhMuc + ", gia=" + gia + ", filePathImage=" + filePathImage + '}';
    }
    
    public String toStringFile()
    {
        return maMonAn+"$"+tenMonAn+"$"+maDanhMuc+"$"+gia+"$"+filePathImage;
    }
}
