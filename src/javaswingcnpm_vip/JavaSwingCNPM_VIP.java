
package javaswingcnpm_vip;

import JavaPerson.DangNhap;
import JavaPerson.DanhSachKhachHang;
import JavaPerson.DanhSachNhanVien;
import LeTan.GiaoDienLeTan;
import LeTan.danhSachMonAn;
import LeTan.dsThongTinBan;
import QuanLy.ChiTietHD;
import QuanLy.GiaoDienQuanLy;
import QuanLy.chiTietMonAn;
import QuanLy.dsHoaDon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaSwingCNPM_VIP {
    private static boolean checkFileIsNull(String filePath) throws FileNotFoundException, IOException
    {
        File f = new File(filePath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
   
        if((br.readLine())==null)//(br.readLine())!=null -> sai
        {
            br.close();
            fr.close();
            return true;
        }    
        br.close();
        fr.close();  
        return false;
    }
    //Biến toàn cục để sau khi nhấn phím chức năng thì hàm thêm cột ko đc chạy lại
    public static boolean flag=true;//Dùng cho tb gọi món
    public static boolean flag2=true;//Dùng cho tb dsMon
    public static boolean flag3=true;//Dùng cho tb dsHD
    public static boolean flag4=true;//Dùn cho tbDSNV
    //Đường dẫn
    public static String duongDanDSKH = "khachHang.txt";//Lưu tt khách hàng
    public static String duongDanDSNV = "nhanVien.txt";//Lưu tt nhân viên-Không có quản lý
    public static String duongDanDSMon = "monAn.txt";//Lưu tt món ăn
    public static String duongDanDSHD = "hoaDon.txt";//Lưu tt hóa đơn
    //Đăng nhập
    public static DangNhap login = new DangNhap();

    
    //Danh sách lưu đối tượng    
    public static dsThongTinBan dsBan = new dsThongTinBan();
    public static danhSachMonAn dsMon = new danhSachMonAn();
    public static dsHoaDon dsHD = new dsHoaDon();
    public static DanhSachNhanVien dsNV = new DanhSachNhanVien();
    public static DanhSachKhachHang dsKH = new DanhSachKhachHang();
    //Tổng hợp đườn dẫn file ảnh
    //package JavaPerson/DangNhap
    public static String fileImageTK="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\user.png";
    public static String fileImageMK="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\lock.png";
    public static String fileImagePL="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\settings.png";
    public static String fileLogo="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\logo2.png";
    
     //package LeTan/QLDatMon_LeTan
    public static String fileImageTable="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\table.png";
    //package QuanLy/quanLyHoaDon
    public static String fileImageBill="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\bill.png";
    //package QuanLy/quanLyHoaDon
    public static String fileImageTeam="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\team.png";
    //package QuanLy/quanLyHoaDon
    public static String fileImageMenu="D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage\\menu.png";
    
    public static void main(String[] args) throws IOException {
        if(!checkFileIsNull(duongDanDSMon))
            dsMon.docTuFile(duongDanDSMon);
        if(!checkFileIsNull(duongDanDSHD))
            dsHD.docTuFile(duongDanDSHD);
        if(!checkFileIsNull(duongDanDSKH))
            dsKH.docTuFile(duongDanDSKH);        
        if(!checkFileIsNull(duongDanDSNV))
            dsNV.docTuFile(duongDanDSNV);
        
        dsBan.taoDSThongTinBan();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }   
}
