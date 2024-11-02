
package QuanLy;

import JavaPerson.DanhSachKhachHang;
import static JavaPerson.DanhSachNhanVien.dsNV;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingcnpm_vip.JavaSwingCNPM_VIP;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.HandleImage;
import util.ModelColor;


public class quanLyNhanVien extends javax.swing.JPanel {
    public static int indexDong_click=-1;
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
            return entry.getStringValue(2).indexOf(searchText)>=0;
        }  
    }
    public quanLyNhanVien() {
        initComponents();
        
        pMainQLNV.addColor(new ModelColor(color1,
                 0f),
                 new ModelColor(color3, 1f));
        reloadTable();
        addImage(imageUser, JavaSwingCNPM_VIP.fileImageTeam, 200, 200);
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
    public void chinhBang_choDep()
    {
        //Chỉnh sửa phông chữ và độ rộng cột  
        tbDSNV.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 14));
        tbDSNV.setFont(new Font("Tahoma", 0, 12));
        
        tbDSNV.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbDSNV.getColumnModel().getColumn(2).setPreferredWidth(120);
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
        //Chỉnh sửa dữ liệu cho cột, hàng
        //Các cột được thêm vào trực tiếp trên design
        //Thêm dl hàng
        int stt=1;
        for(JavaPerson.NhanVien u : JavaPerson.DanhSachNhanVien.dsNV)
        {
            String[] data = new String[4];
            
            data[0] = (stt++)+"";
            data[1] = u.getTaiKhoan();
            data[2] = u.getHoTen();
          
            if(u.getChucVu()==0)
                data[3]="Phục vụ";
            else if(u.getChucVu()==1)
                data[3]="Lễ tân";
            else if(u.getChucVu()==2)
                data[3]="Thủ kho";
            
            dtm.addRow(data);
        } 
        
        //Áp dụng vào table trên
        tbDSNV.setModel(dtm);
        //*** Có cái này mới chạy được sort và nó ở sau cái setModel
        tbDSNV.setRowSorter(trs);
        chinhBang_choDep();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMainQLNV = new util.PanelGradient();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDSNV = new javax.swing.JTable();
        if (javaswingcnpm_vip.JavaSwingCNPM_VIP.flag4 == true)
        {
            dtm.addColumn("STT");
            dtm.addColumn("Tài khoản");
            dtm.addColumn("Họ tên");
            dtm.addColumn("Chức vụ");

            javaswingcnpm_vip.JavaSwingCNPM_VIP.flag4=false;
        }
        jLabel1 = new javax.swing.JLabel();
        txtTimTenNV = new javax.swing.JTextField();
        bThemNV = new util.ButtonGradient();
        bXoaNV = new util.ButtonGradient();
        imageUser = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tài khoản", "Họ tên", "Chức vụ"
            }
        ));
        tbDSNV.setGridColor(new java.awt.Color(204, 204, 204));
        tbDSNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDSNV);

        jLabel1.setText("Tìm tên NV");

        txtTimTenNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimTenNVKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bThemNV.setText("Thêm NV");
        bThemNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemNVActionPerformed(evt);
            }
        });

        bXoaNV.setText("Xóa NV");
        bXoaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pMainQLNVLayout = new javax.swing.GroupLayout(pMainQLNV);
        pMainQLNV.setLayout(pMainQLNVLayout);
        pMainQLNVLayout.setHorizontalGroup(
            pMainQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainQLNVLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(bThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(bXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
            .addGroup(pMainQLNVLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        pMainQLNVLayout.setVerticalGroup(
            pMainQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainQLNVLayout.createSequentialGroup()
                .addGroup(pMainQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainQLNVLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pMainQLNVLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(imageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(pMainQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimTenNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimTenNVKeyReleased
        trs.setRowFilter(new myRowFilter(txtTimTenNV.getText()));
    }//GEN-LAST:event_txtTimTenNVKeyReleased

    private void bXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaNVActionPerformed
        //Xóa món thì xóa trên trong dsMon, rồi đọc dữ liệu 
        //từ dsMon đó. Lưu dữ liệu dsMon vào filr
        String inputText = JOptionPane.showInputDialog(this, "Nhập mã nhân viên", "Xóa nhân viên", JOptionPane.DEFAULT_OPTION);
        int index = JavaSwingCNPM_VIP.dsNV.timKiemNhanVien_taiKhoan(inputText);
        if(index!=-1)
        {
            JOptionPane.showMessageDialog(null, 
                    "Xóa nhân viên "+dsNV.get(index).getHoTen()+" thành công");
            dsNV.remove(index);
            
            try {
                JavaSwingCNPM_VIP.dsNV.luuVaoFile(JavaSwingCNPM_VIP.duongDanDSNV);//Lưu bảng sau khi thêm món vào file
            } catch (IOException ex) {
                Logger.getLogger(quanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            reloadTable();
        }
        else if(index==-1 && inputText!=null)
            JOptionPane.showMessageDialog(null, "Nhân viên có mã " + inputText+" không tồn tại!!", "Xóa nhân viên", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_bXoaNVActionPerformed

    private void tbDSNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSNVMouseClicked
        indexDong_click = tbDSNV.getSelectedRow();
        
        chiTietThongTinNV_QL CtTT = new chiTietThongTinNV_QL();
        
        CtTT.setLocationRelativeTo(null);
        CtTT.setVisible(true);
    }//GEN-LAST:event_tbDSNVMouseClicked

    private void bThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemNVActionPerformed
        chiTietThongTinNV_QL CtTT = new chiTietThongTinNV_QL();
        
        CtTT.setLocationRelativeTo(null);
        CtTT.setVisible(true);
    }//GEN-LAST:event_bThemNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient bThemNV;
    private util.ButtonGradient bXoaNV;
    private javax.swing.JLabel imageUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private util.PanelGradient pMainQLNV;
    public static javax.swing.JTable tbDSNV;
    private javax.swing.JTextField txtTimTenNV;
    // End of variables declaration//GEN-END:variables
}
