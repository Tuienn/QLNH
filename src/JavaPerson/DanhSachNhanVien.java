
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
    public void luuVaoFile(String duongDan) throws IOException
    {
        FileWriter fw = new FileWriter(duongDan);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(NhanVien nv : dsNV)
        {
            bw.write(nv.toStringFile());
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
            int chucVu = Integer.parseInt(obj[7]);
            String filePathImage=obj[8];
            
            NhanVien nv = new NhanVien(taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT, chucVu, filePathImage);
            dsNV.add(nv);
        }
        
        br.close();
        fr.close();
    }  
    public void inDSNV()
    {
        for(NhanVien nv : dsNV)
        {
            System.out.println(nv.toStringFile());
        }
    }
}
