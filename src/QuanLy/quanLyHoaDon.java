
package QuanLy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.HandleImage;
import util.ModelColor;


public class quanLyHoaDon extends javax.swing.JPanel {
    public static int indexDong=-1;//Dùng liên kết với ChiTietHD
    //Color gradient backGround
    private Color color1 = new Color(0, 255, 204);
//    private Color color2 = Color.GREEN;
    private Color color3 = new Color(204, 0, 204);
    //Tạo bảng khuôn mẫu
    public static DefaultTableModel dtm = new DefaultTableModel();
    //Tạo table có khả năng sort. Hà này để ở ngoài vì còn vướng tìm món
    public static TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
    public class myRowFilter extends RowFilter{
        private String searchText;
        public myRowFilter(String searchText)
        {
            this.searchText = searchText;
        }
        @Override
        public boolean include(RowFilter.Entry entry) {
            //getStringValue(2)là tìm theo tên món(cột 3)
            return entry.getStringValue(1).indexOf(searchText)>=0;
        }  
    }
     
    public quanLyHoaDon() {
        initComponents();
        pMainQLHD.addColor(new ModelColor(color1,
                 0f),
                 new ModelColor(color3, 1f));
        reloadTable();
        addImage(imageBill, javaswingcnpm_vip.JavaSwingCNPM_VIP.fileImageBill, 180, 180);
    }
    public void addImage(JLabel txt, String filePath, int width, int height) {
        try {
            BufferedImage bfImage = null;
            bfImage = ImageIO.read(new File(filePath));
            Image i = HandleImage.getScaledImage(bfImage, width, height);
            ImageIcon icon = new ImageIcon(i);
            txt.setIcon(icon);
        } catch (Exception e) {
        }
    }
    private void chinhBang_choDep()
    {
        //Chỉnh sửa phông chữ và độ rộng cột  
        tbDSHD.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 14));
        tbDSHD.setFont(new Font("Tahoma", 0, 12));
        
        tbDSHD.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbDSHD.getColumnModel().getColumn(1).setPreferredWidth(100);
    }
    public void reloadTable()
    {   
    //Xóa toàn bộ thông tin trên table
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();
        //Tải lại thông tin table
        loadDataTable();
    }
    public void loadDataTable()
    {            
        double tongDoanhThu=0;
        //Chỉnh sửa dữ liệu cho cột, hàng
        //Các cột được thêm vào trực tiếp trên design
        //Thêm dl hàng
        int maHD=1;
        for(hoaDon u : dsHoaDon.dsHD)
        {
            String[] data = new String[4];
            
            data[0] = (maHD++)+"";//Tương đương stt
            data[1] = u.getTenKH();
            data[2] = u.getThoiGian();
            //Thành tiền
            tongDoanhThu+=u.tinhThanhTienHD();
            data[3] = String.valueOf(u.tinhThanhTienHD());
            dtm.addRow(data);
        } 
        
        //Áp dụng vào table trên
        tbDSHD.setModel(dtm);
        //*** Có cái này mới chạy được sort và nó ở sau cái setModel
        tbDSHD.setRowSorter(trs);
        //Set dữ liệu cho doanh thu
        txtDoanhThu.setText(String.valueOf(tongDoanhThu)+"$");
        chinhBang_choDep();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMainQLHD = new util.PanelGradient();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDSHD = new javax.swing.JTable();
        if (javaswingcnpm_vip.JavaSwingCNPM_VIP.flag3 == true)
        {
            dtm.addColumn("MaHD");
            dtm.addColumn("Tên KH");
            dtm.addColumn("Ngày lập");
            dtm.addColumn("Thành tiền");

            javaswingcnpm_vip.JavaSwingCNPM_VIP.flag3=false;
        }
        jLabel1 = new javax.swing.JLabel();
        txtTimTenKH = new javax.swing.JTextField();
        bInThongKe = new util.ButtonGradient();
        jLabel2 = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JTextField();
        imageBill = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 480));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "Tên KH", "Ngày lập", "Thành tiền"
            }
        ));
        tbDSHD.setGridColor(new java.awt.Color(204, 204, 204));
        tbDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDSHD);

        jLabel1.setText("Tìm tên KH");

        txtTimTenKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimTenKHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bInThongKe.setBackground(new java.awt.Color(102, 102, 102));
        bInThongKe.setText("In bảng thống kê");
        bInThongKe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tổng doanh thu");

        txtDoanhThu.setEditable(false);
        txtDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDoanhThu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pMainQLHDLayout = new javax.swing.GroupLayout(pMainQLHD);
        pMainQLHD.setLayout(pMainQLHDLayout);
        pMainQLHDLayout.setHorizontalGroup(
            pMainQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainQLHDLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pMainQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pMainQLHDLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bInThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(imageBill, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        pMainQLHDLayout.setVerticalGroup(
            pMainQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainQLHDLayout.createSequentialGroup()
                .addGroup(pMainQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainQLHDLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pMainQLHDLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(imageBill, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(pMainQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bInThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pMainQLHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimTenKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimTenKHKeyReleased
        trs.setRowFilter(new myRowFilter(txtTimTenKH.getText()));
    }//GEN-LAST:event_txtTimTenKHKeyReleased

    private void tbDSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSHDMouseClicked
        indexDong = tbDSHD.getSelectedRow()+1;
        ChiTietHD h = new ChiTietHD();
        
        h.setLocationRelativeTo(this);
        h.setVisible(true);
    }//GEN-LAST:event_tbDSHDMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient bInThongKe;
    private javax.swing.JLabel imageBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private util.PanelGradient pMainQLHD;
    private javax.swing.JTable tbDSHD;
    private javax.swing.JTextField txtDoanhThu;
    private javax.swing.JTextField txtTimTenKH;
    // End of variables declaration//GEN-END:variables
}
