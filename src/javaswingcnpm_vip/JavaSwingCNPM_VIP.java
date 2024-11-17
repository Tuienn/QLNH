
package javaswingcnpm_vip;

import JavaPerson.DangNhap;
import JavaPerson.DanhSachKhachHang;
import JavaPerson.DanhSachNhanVien;
import LeTan.GiaoDienLeTan;
import LeTan.danhSachMonAn;
import LeTan.dsThongTinBan;
import MySql.DatabaseConnection;
import MySql.DatabaseHandler;
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
    public static String fileImageTK="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\user.png";
    public static String fileImageMK="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\lock.png";
    public static String fileImagePL="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\settings.png";
    public static String fileLogo="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\logo2.png";
    
     //package LeTan/QLDatMon_LeTan
    public static String fileImageTable="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\table.png";
    //package QuanLy/quanLyHoaDon
    public static String fileImageBill="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\bill.png";
    //package QuanLy/quanLyHoaDon
    public static String fileImageTeam="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\team.png";
    //package QuanLy/quanLyHoaDon
    public static String fileImageMenu="C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage\\menu.png";
    
    public static DatabaseHandler dbhander;
            
    public static void main(String[] args) throws IOException {
        DatabaseConnection.connect();
        dbhander = new DatabaseHandler();
        dsMon.docTuFile();
        dsHD.docTuFile();
        dsKH.docTuFile();
        dsNV.docTuFile();
        dsBan.taoDSThongTinBan();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }   
}
