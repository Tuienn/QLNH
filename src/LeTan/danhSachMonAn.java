
package LeTan;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class danhSachMonAn {
    public static ArrayList<monAn> dsMon = new ArrayList<>();

    public static ArrayList<monAn> getDsMon() {
        return dsMon;
    }
    
    public int timIndexMon_maMon(String maMon)
    {
        for(int i=0; i<dsMon.size(); i++)
        {
            if(dsMon.get(i).getMaMonAn().equals(maMon))
                return i;
        }
        return -1;
    }
    
    public int timIndexMon_tenMon(String tenMon)
    {
        for(int i=0; i<dsMon.size(); i++)
        {
            if(dsMon.get(i).getTenMonAn().equals(tenMon))
                return i;
        }
        return -1;
    }
    public double timGiaMon_tenMon(String tenMon)
    {
        for(int i=0; i<dsMon.size(); i++)
        {
            if(dsMon.get(i).getTenMonAn().equals(tenMon))
                return dsMon.get(i).getGia();
        }
        return -1;
    }
    //Thao tác với file
    public void luuVaoFile(String duongDan) throws IOException
    {
        FileWriter fw = new FileWriter(duongDan);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(monAn m : dsMon)
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
            
            String maMonAn = obj[0];
            String tenMonAn = obj[1];
            String maDanhMuc = obj[2];
            double gia = Double.parseDouble(obj[3]);
            String filePathImage = obj[4];
            
            monAn m = new monAn(maMonAn, tenMonAn, maDanhMuc, gia,filePathImage);
            dsMon.add(m);
        }
    }
    
    //Tách danh sách theo loại món ăn
    private int demSLMonViet()
    {
        int tongSLMonViet=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("1"))//Món Việt
            {
                tongSLMonViet++;
            }
        }
        return tongSLMonViet;
    }
    private int demSLMonHan()
    {
        int tongSLMonHan=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("2"))//Món Hàn
            {
                tongSLMonHan++;
            }
        }
        return tongSLMonHan;
    }
    private int demSLMonTrung()
    {
        int tongSLMonTrung=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("3"))//Món Trung
            {
                tongSLMonTrung++;
            }
        }
        return tongSLMonTrung;
    }
    public String[] dsTenMonViet()
    {
        String[] ds = new String[demSLMonViet()];
        int index=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("1"))//Món Việt
            {
                ds[index]=m.getTenMonAn();
                index++;
            }
        }
        return ds;
    }
    
    public String[] dsTenMonHan()
    {
        String[] ds = new String[demSLMonHan()];
        int index=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("2"))//Món Hàn
            {
                ds[index]=m.getTenMonAn();
                index++;
            }
        }
        return ds;
    }
    
    public String[] dsTenMonTrung()
    {
        String[] ds = new String[demSLMonTrung()];
        int index=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("3"))//Món Trung
            {
                ds[index]=m.getTenMonAn();
                index++;
            }
        }
        return ds;
    }
    public String[] dsFilePathImageMonViet()
    {
        String[] ds = new String[demSLMonViet()];
        int index=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("1"))//Món Việt
            {
                ds[index]=m.getFilePathImage();
                index++;
            }
        }
        return ds;
    }
    
    public String[] dsFilePathImageMonHan()
    {
        String[] ds = new String[demSLMonHan()];
        int index=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("2"))//Món Hàn
            {
                ds[index]=m.getFilePathImage();
                index++;
            }
        }
        return ds;
    }
    
    public String[] dsFilePathImageMonTrung()
    {
        String[] ds = new String[demSLMonTrung()];
        int index=0;
        for(monAn m : dsMon)
        {
            if(m.getMaDanhMuc().equals("3"))//Món Trung
            {
                ds[index]=m.getFilePathImage();
                index++;
            }
        }
        return ds;
    }
    
    public void inDSMon()
    {
        for(monAn m : dsMon)
        {
            System.out.println(m.toStringFile());
        }
    }
}

