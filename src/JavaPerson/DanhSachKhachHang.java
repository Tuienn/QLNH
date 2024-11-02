
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
    public void luuVaoFile(String duongDan) throws IOException
    {
        FileWriter fw = new FileWriter(duongDan);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(KhachHang kh : dsKH)
        {
            bw.write(kh.toStringFile());
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
            
            String taiKhoan = obj[0];
            String matKhau = obj[1];
            String hoTen = obj[2];
            String ngaySinh = obj[3];
            String gioiTinh = obj[4];
            String diaChi = obj[5];
            String SDT = obj[6];
            
            KhachHang kh = new KhachHang(taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT);
            dsKH.add(kh);
        }
        
        br.close();
        fr.close();
    }
}