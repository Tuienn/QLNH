
package JavaPerson;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DanhSachKhachHang {
    public static ArrayList<KhachHang> dsKH = new ArrayList<>();

    public static ArrayList<KhachHang> getDsKH() {
        return dsKH;
    }
    
    public boolean kiemTraTK_DaTonTai(String taiKhoan_Ktra)
    {
        for(KhachHang kh : dsKH)
        {
            if(kh.getTaiKhoan().equals(taiKhoan_Ktra))
                return true;
        }
        return false;
    }
    public KhachHang timKiemKhachHang_taiKhoan(String taiKhoan)
    {
        for(int i=0; i<dsKH.size(); i++)
        {
            if(dsKH.get(i).getTaiKhoan().equals(taiKhoan))
                return dsKH.get(i);
        }
        return null;
    }
    
    public boolean kiemTraTK_laDung(String taiKhoan, String matKhau)
    {
        for(KhachHang kh: dsKH)
        {
            if(kh.getTaiKhoan().equals(taiKhoan)&& kh.getMatKhau().equals(matKhau))
                    return true;
        }
        return false;
    }
    
    //Thao tác với file
    public void luuVaoFile()
    {
        javaswingcnpm_vip.JavaSwingCNPM_VIP.dbhander.saveKhachHang(dsKH);
    }
    
    public void docTuFile()
    {
        javaswingcnpm_vip.JavaSwingCNPM_VIP.dbhander.getAllKhachHang(dsKH);
    }
}