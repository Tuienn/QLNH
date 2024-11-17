
package QuanLy;

import LeTan.danhSachMonAn;
import LeTan.monAn;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsMon;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import util.HandleImage;
import util.ModelColor;

public class quanLyMonAn extends javax.swing.JPanel {
    public static int indexDongClick=-1;//Dùng cho event clickTable
    //Nếu click dòng thì index này thành số dòng
    //Khi này gọi ra chiTietHD. Và index này lại chuyển về -1

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
    public quanLyMonAn() {
        initComponents();
        
        pMainQLMon.addColor(new ModelColor(color1,
                 0f),
                 new ModelColor(color3, 1f));
        reloadTable();
        addImage(imageMon, javaswingcnpm_vip.JavaSwingCNPM_VIP.fileImageMenu, 200, 200);
        
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
    public void reloadTable()
    {
        //Xóa toàn bộ thông tin trên table
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();
        //Tải lại thông tin table
        loadDataTable();
    }
    public void chinhBang_choDep()
    {
        //Chỉnh sửa phông chữ và độ rộng cột  
        tbMonAn.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 14));
        tbMonAn.setFont(new Font("Tahoma", 0, 12));
        
        tbMonAn.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbMonAn.getColumnModel().getColumn(2).setPreferredWidth(120);
    }
    public void loadDataTable()
    {            
        //Chỉnh sửa dữ liệu cho cột, hàng
        //Các cột được thêm vào trực tiếp trên design
        //Thêm dl hàng
        int stt=1;
        for(monAn u : danhSachMonAn.dsMon)
        {
            String[] data = new String[5];
            
            data[0] = (stt++)+"";
            data[1] = u.getMaMonAn();
            data[2] = u.getTenMonAn();
            String maDM = u.getMaDanhMuc();
            
            if(maDM.equals("1"))
                data[3]="Món Việt";
            else if(maDM.equals("2"))
                data[3]="Món Hàn";
            else if(maDM.equals("3"))
                data[3]="Món Trung";
            
            data[4] = String.valueOf(u.getGia());
            
            dtm.addRow(data);
        } 
        
        //Áp dụng vào table trên
        tbMonAn.setModel(dtm);
        //*** Có cái này mới chạy được sort và nó ở sau cái setModel
        tbMonAn.setRowSorter(trs);
        chinhBang_choDep();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMainQLMon = new util.PanelGradient();
        bThemMon = new util.ButtonGradient();
        bXoaMon = new util.ButtonGradient();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        if (javaswingcnpm_vip.JavaSwingCNPM_VIP.flag2 == true)
        {
            dtm.addColumn("STT");
            dtm.addColumn("Mã món");
            dtm.addColumn("Tên món");
            dtm.addColumn("Danh mục");
            dtm.addColumn("Đơn giá");

            javaswingcnpm_vip.JavaSwingCNPM_VIP.flag2=false;
        }
        jLabel1 = new javax.swing.JLabel();
        txtTimMon = new javax.swing.JTextField();
        imageMon = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 480));

        bThemMon.setText("Thêm món");
        bThemMon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemMonActionPerformed(evt);
            }
        });

        bXoaMon.setText("Xóa món");
        bXoaMon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaMonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên món", "Tên món", "Danh mục", "Đơn giá"
            }
        ));
        tbMonAn.setGridColor(new java.awt.Color(204, 204, 204));
        tbMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMonAn);

        jLabel1.setText("Tìm tên món");

        txtTimMon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimMonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimMon, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout pMainQLMonLayout = new javax.swing.GroupLayout(pMainQLMon);
        pMainQLMon.setLayout(pMainQLMonLayout);
        pMainQLMonLayout.setHorizontalGroup(
            pMainQLMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainQLMonLayout.createSequentialGroup()
                .addGroup(pMainQLMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainQLMonLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(bThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(bXoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pMainQLMonLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(imageMon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pMainQLMonLayout.setVerticalGroup(
            pMainQLMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainQLMonLayout.createSequentialGroup()
                .addGroup(pMainQLMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainQLMonLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pMainQLMonLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(imageMon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(pMainQLMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bXoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pMainQLMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pMainQLMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimMonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimMonKeyReleased
        trs.setRowFilter(new myRowFilter(txtTimMon.getText()));
    }//GEN-LAST:event_txtTimMonKeyReleased

    private void bXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaMonActionPerformed
        //Xóa món thì xóa trên trong dsMon, rồi đọc dữ liệu 
        //từ dsMon đó. Lưu dữ liệu dsMon vào filr
        String inputText = JOptionPane.showInputDialog(this, "Nhập mã món ăn", "Xóa món", JOptionPane.DEFAULT_OPTION);
        int index = dsMon.timIndexMon_maMon(inputText);
        if(index!=-1)
        {
            JOptionPane.showMessageDialog(null, 
                    "Xóa món "+danhSachMonAn.dsMon.get(index).getTenMonAn()+" thành công");
            danhSachMonAn.dsMon.remove(index);
            
            dsMon.luuVaoFile();//Lưu bảng sau khi thêm món vào file
            
            reloadTable();
        }
        else if(index==-1 && inputText!=null)
            JOptionPane.showMessageDialog(null, "Món có mã " + inputText+" không tồn tại!!", "Xóa món", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_bXoaMonActionPerformed

    private void bThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemMonActionPerformed
        chiTietMonAn CTMon = new chiTietMonAn();
        
        CTMon.setLocationRelativeTo(null);
        CTMon.setVisible(true);
    }//GEN-LAST:event_bThemMonActionPerformed

    private void tbMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonAnMouseClicked
        indexDongClick=tbMonAn.getSelectedRow();
        
        chiTietMonAn CTMon = new chiTietMonAn();
        
        CTMon.setLocationRelativeTo(null);
        CTMon.setVisible(true);
    }//GEN-LAST:event_tbMonAnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient bThemMon;
    private util.ButtonGradient bXoaMon;
    private javax.swing.JLabel imageMon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private util.PanelGradient pMainQLMon;
    public static javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtTimMon;
    // End of variables declaration//GEN-END:variables
}
