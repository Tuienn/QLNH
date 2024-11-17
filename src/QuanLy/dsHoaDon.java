
package QuanLy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class dsHoaDon {
    public static ArrayList<hoaDon> dsHD = new ArrayList<>();
    
    public void themHoaDonMoi(String tenKH, String thoiGian, String dlBang)
    {
        hoaDon h = new hoaDon(tenKH, thoiGian, dlBang);
        dsHD.add(h);
    }
    
    //Thao tác với file
    public void luuVaoFile()
    {
        javaswingcnpm_vip.JavaSwingCNPM_VIP.dbhander.saveHoaDon(dsHD);
    }
    
    public void docTuFile()
    {
        javaswingcnpm_vip.JavaSwingCNPM_VIP.dbhander.getAllHoaDon(dsHD);
    }
    public void inDSHD()
    {
        for(hoaDon h : dsHD)
        {
            System.out.println(h.toStringFile());
            System.out.println(h.tinhThanhTienHD());
        }
    }
}
