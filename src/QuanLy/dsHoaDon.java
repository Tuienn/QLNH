
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
    public void luuVaoFile(String duongDan) throws IOException
    {
        FileWriter fw = new FileWriter(duongDan);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(hoaDon m : dsHD)
        {
            bw.write(m.toStringFile());
            bw.newLine();
        }
        
        bw.close();
        fw.close();
    }
    
    public void docTuFile(String duongDan) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(duongDan);
        BufferedReader br = new BufferedReader(fr);
        
        String str = "";
        while((str=br.readLine())!=null)
        {
            String[] obj = str.split("\\$");
            
            String tenKH = obj[0];
            String thoiGian = obj[1];
            String dlBang = obj[2];
            
            themHoaDonMoi(tenKH, thoiGian, dlBang);
        }
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
