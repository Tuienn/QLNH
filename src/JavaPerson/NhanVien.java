
package JavaPerson;

public class NhanVien extends Person{
    
    private int chucVu;//0-Phục vụ, 1-Lễ tân, 2-Thủ kho
    private String filePathImage;
    
    public NhanVien() {
    }

    public NhanVien(String taiKhoan, String matKhau, String hoTen, String ngaySinh, String gioiTinh, String diaChi, String SDT, int chucVu, String filePathImage) {
        super(taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT);
        this.chucVu = chucVu;
        this.filePathImage = filePathImage;
    }

    public int getChucVu() {
        return chucVu;
    }

    public String getFilePathImage() {
        return filePathImage;
    }
    
    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public void setFilePathImage(String filePathImage) {
        this.filePathImage = filePathImage;
    }
    
    @Override
    public String toStringFile()
    {
        return super.toStringFile()+"$"+chucVu+"$"+filePathImage;
    }
}

