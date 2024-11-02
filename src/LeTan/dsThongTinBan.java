
package LeTan;

import java.util.ArrayList;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsMon;

public class dsThongTinBan {
     public static thongTinBan[] dsBan = new thongTinBan[12];

    public static thongTinBan[] getDsBan() {
        return dsBan;
    }
    public void taoDSThongTinBan()
    {
        for(int i=0; i<12; i++)
            dsBan[i] = new thongTinBan(String.valueOf(i+1), 0, null, "1/1/2015", null);
    }
    
    public void themThongTinBan_maBan(int maBan, thongTinBan ttb)
    {
        dsBan[maBan-1] = ttb;
    }
    //C2
    public void themTTBan_maBan(int maBan, int trangThaiBan, String tenKH, String thoiGian, String dlBang)
    {
        dsBan[maBan-1].setMaBan(String.valueOf(maBan));
        dsBan[maBan-1].setTrangThaiBan(trangThaiBan);
        dsBan[maBan-1].setTenKH(tenKH);
        dsBan[maBan-1].setThoiGian(thoiGian);
        dsBan[maBan-1].setDuLieuBang_theoBan(dlBang);
    }

    public void doiCho2Ban(int maBanCu, int maBanMoi)//Bàn mới phải trống mới chuyển được
    {     
        //Đổi chỗ dl 2 bàn(cả mã bàn)
        dsBan[maBanMoi-1] = dsBan[maBanCu-1];
        dsBan[maBanMoi-1].setMaBan(String.valueOf(maBanMoi));
        //Đổi lại dữ liệu của 2 mã bàn cho nhau
        dsBan[maBanCu-1]=new thongTinBan(String.valueOf(maBanCu), 0, null, "1/1/2015", null);
    }
    public void hienThiDSBan()
    {
        for(thongTinBan y : dsBan)
        {
            System.out.println(y.toString());
        }
    }
    public boolean kiemTraBan_isCoNguoi(int maBan)
    {
        if(dsBan[maBan-1].getTrangThaiBan()==1)
            return true;
        return false;
    }
}
