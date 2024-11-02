
package QuanLy;

import java.awt.Color;
import java.awt.Font;

import util.ModelColor;


public class ChiTietHD extends javax.swing.JFrame {
    //Đọc từ dsHD theo maHD - STT khi tạo HD-bắt đầu từ 1
    private String layTenKH_maHD(int maHD)
    {
        return dsHoaDon.dsHD.get(maHD-1).getTenKH();
    }
    private String layThoiGianHD_maHD(int maHD)
    {
        return dsHoaDon.dsHD.get(maHD-1).getThoiGian();
    }
    private String layDLBang_maHD(int maHD)
    {
        return dsHoaDon.dsHD.get(maHD-1).getDlBangThucDon();
    }
    private String layTenKH_maHD_moiTao()
    {
        return dsHoaDon.dsHD.get(dsHoaDon.dsHD.size()-1).getTenKH();
    }
    private String layThoiGianHD_maHD_moiTao()
    {
        return dsHoaDon.dsHD.get(dsHoaDon.dsHD.size()-1).getThoiGian();
    }
    private String layDLBang_maHD_moiTao()
    {
        return dsHoaDon.dsHD.get(dsHoaDon.dsHD.size()-1).getDlBangThucDon();
    }
    
    private String tenKH="";
    private String thoiGian="";
    private String dlBang="";
    private double totalMoney=0;
    
    public ChiTietHD() {
        initComponents();
        
        if(dsHoaDon.dsHD.size()!=0)
        {
            tenKH=layTenKH_maHD_moiTao();
            thoiGian=layThoiGianHD_maHD_moiTao();
            dlBang=layDLBang_maHD_moiTao();
        }
        if(quanLyHoaDon.indexDong!=-1)
        {
            tenKH=layTenKH_maHD(quanLyHoaDon.indexDong);
            thoiGian=layThoiGianHD_maHD(quanLyHoaDon.indexDong);
            dlBang=layDLBang_maHD(quanLyHoaDon.indexDong);
            //Trả lại dl để tạo vòng lặp
            quanLyHoaDon.indexDong=-1;
        }
        txtThongTinHD.setText("  ==========================================  ");

        txtThongTinHD.append("\n               NHÀ HÀNG THÁI BÌNH");
        txtThongTinHD.append("\n  Địa chỉ: Cạnh Học Viện Kỹ thuật Mật Mã");
        txtThongTinHD.append("\n  SDT    : 0854422289");
        addTenKH_ThoiGian();
        txtThongTinHD.append("\n  ==========================================  ");
        txtThongTinHD.append("\n\t\tCHI TIẾT HÓA ĐƠN");
        txtThongTinHD.append("\n           ************************  ");
        txtThongTinHD.append("\n  Tên món        SL   Đơn giá    Thành tiền\n");
        addAllInfo();
        addTotal();
    }
    
    private void addTenKH_ThoiGian()
    {
        String tenKhachHang = String.format("\n\n  Tên KH    : %s", this.tenKH);
        txtThongTinHD.append(tenKhachHang);
        String tg = String.format("\n  Thời gian : %s", this.thoiGian);
        txtThongTinHD.append(tg);
    }
    private void add1Info(String tenMon, int soLuong, double donGia)
    {
        double thanhTien=soLuong*donGia;
        String line = String.format("  %-15s%-5d%-11.2f%-10.2f\n", tenMon, soLuong, donGia, thanhTien);
        txtThongTinHD.append(line);
        totalMoney+=thanhTien;
    }
    private void addAllInfo()
    {
        String[] dlBang_Hang = dlBang.split("/");
        
        for(String dlMon : dlBang_Hang)
        {
            String[] data = dlMon.split("-");//Chưa có stt
            
            String[] dataRow = new String[4];

            dataRow[1] = data[0];
            dataRow[2] = data[1];
            dataRow[3] = data[2];
            
            add1Info(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]));
        }
    }
    private void addTotal()
    {
        txtThongTinHD.append("              ------------------  \n");
        String total = String.format("%31s  "
                + "%.2f", "TOTAL", totalMoney);
        txtThongTinHD.append(total);
        txtThongTinHD.append("\n           ************************  ");
        txtThongTinHD.append("\n            Xin chân thành cảm ơn!");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtThongTinHD = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtThongTinHD.setEditable(false);
        txtThongTinHD.setColumns(20);
        txtThongTinHD.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtThongTinHD.setRows(5);
        jScrollPane1.setViewportView(txtThongTinHD);

        jButton1.setText("In hóa đơn");

        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1)
                        .addGap(55, 55, 55)
                        .addComponent(bThoat))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(bThoat))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        //Xóa dữ liệu của bill
        
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietHD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bThoat;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtThongTinHD;
    // End of variables declaration//GEN-END:variables
}
