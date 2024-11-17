
package JavaPerson;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DanhSachNhanVien {
    public static ArrayList<NhanVien> dsNV = new ArrayList<>();

    public static ArrayList<NhanVien> getDsNV() {
        return dsNV;
    }
    //Thao tác khi đăng nhập
    //1
    public boolean kiemTraTK_DaTonTai(String taiKhoan)
    {
        for(NhanVien nv : dsNV)
        {
            if(nv.getTaiKhoan().equals(taiKhoan))
                return true;
        }
        return false;
    }
    
    //2
    public boolean kiemTraTK_laDung(String taiKhoan, String matKhau)
    {
        if(taiKhoan.equals("admin")&&matKhau.equals("admin"))
            return true;
        for(NhanVien nv : dsNV)
        {
            if(nv.getTaiKhoan().equals(taiKhoan)&& nv.getMatKhau().equals(matKhau))
                    return true;
        }
        return false;
    }
    //3
    public int chucVuNV_DangNhap(String taiKhoan, String matKhau)
    {
        if(taiKhoan.equals("admin")&&matKhau.equals("admin"))
            return -1;//Quản lý
        else if(taiKhoan.contains("PV"))
            return 0;//Phục vụ
        else if(taiKhoan.contains("LT"))
            return 1;//Lễ tân
        else if(taiKhoan.contains("TK"))
            return 2;//Thủ kho
        return -2; 
    }
    
    
    public int timKiemNhanVien_taiKhoan(String taiKhoan)
    {
        for(int i=0; i<dsNV.size(); i++)
        {
            if(dsNV.get(i).getTaiKhoan().equals(taiKhoan))
                return i;
        }
        return -1;
    }
    
    public NhanVien timKiemNhanVien_TK(String taiKhoan)
    {
        for(int i=0; i<dsNV.size(); i++)
        {
            if(dsNV.get(i).getTaiKhoan().equals(taiKhoan))
                return dsNV.get(i);
        }
        return null;
    }
    //Thao tác với file
    public void luuVaoFile()
    {
        javaswingcnpm_vip.JavaSwingCNPM_VIP.dbhander.saveNhanVien(dsNV);
    }
    
    public void docTuFile()
    {
        javaswingcnpm_vip.JavaSwingCNPM_VIP.dbhander.getAllNhanVien(dsNV);
    }  
    public void inDSNV()
    {
        for(NhanVien nv : dsNV)
        {
            System.out.println(nv.toStringFile());
        }
    }
}
