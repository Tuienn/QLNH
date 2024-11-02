
package LeTan;

import JavaPerson.DangNhap;
import static LeTan.QLDatMon_LeTan.dtm;
import static LeTan.QLDatMon_LeTan.tbThucDon;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsBan;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsMon;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import util.HandleImage;


public class thucDon extends javax.swing.JPanel {

    public thucDon() {
        initComponents();
    }
    //Quản lý nút
    public JButton traVeNutTheoMaNut(int maNut)
    {
        if(maNut==1)
            return bMon1;
        else if(maNut==2)
            return bMon2;
        else if(maNut==3)
            return bMon3;
        else if(maNut==4)
            return bMon4;
        else if(maNut==5)
            return bMon5;
        else if(maNut==6)
            return bMon6;
        else if(maNut==7)
            return bMon7;
        else if(maNut==8)
            return bMon8;
        return bMon9;
    }
    
    private int traVeMaNutTuNut(JButton bMon)
    {
        if(bMon==bMon1)
            return 1;
        else if(bMon==bMon2)
            return 2;
        else if(bMon==bMon3)
            return 3;
        else if(bMon==bMon4)
            return 4;
        else if(bMon==bMon5)
            return 5;
        else if(bMon==bMon6)
            return 6;
        else if(bMon==bMon7)
            return 7;
        else if(bMon==bMon8)
            return 8;
        return 9;
    }
    //Quản lý JLabel tên món
    private JLabel traVeLabelTheoMaNut(int maNut)
    {
        if(maNut==1)
            return txtMon1;
        else if(maNut==2)
            return txtMon2;
        else if(maNut==3)
            return txtMon3;
        else if(maNut==4)
            return txtMon4;
        else if(maNut==5)
            return txtMon5;
        else if(maNut==6)
            return txtMon6;
        else if(maNut==7)
            return txtMon7;
        else if(maNut==8)
            return txtMon8;
        return txtMon9;
    }
    private void ganTenMonTheoMaNut(int maNut, String tenMon)
    {
        traVeLabelTheoMaNut(maNut).setText(tenMon+"-"+dsMon.timGiaMon_tenMon(tenMon));
    }
    //Tạo hình ảnh cho nút món
    public void addImage(JButton bMon, String filePath, int width, int height) {
        try {
            BufferedImage bfImage = null;
            bfImage = ImageIO.read(new File(filePath));
            Image i = HandleImage.getScaledImage(bfImage, width, height);
            ImageIcon icon = new ImageIcon(i);
            bMon.setIcon(icon);
        } catch (Exception e) {
        }
    }
    //Xóa toán bộ thông tin hiển thị thực đơn
    public void refeshDisplay()
    {
        for(int i=0; i<9; i++)
        {
            traVeNutTheoMaNut(i+1).setIcon(null);
            traVeLabelTheoMaNut(i+1).setText("Trống");
        }
    }
    private void them1MonVaoBang_theoMaNutMon(int maNut)
    {
        String[] tt = traVeLabelTheoMaNut(maNut).getText().split("-");
        int indexMon = dsMon.timIndexMon_tenMon(tt[0]);
        
        if(indexMon!=-1)
        {
            //Tạo dữ liệu món(dùng cho bảng tbThucDon)
            String dlMon = LeTan.danhSachMonAn.dsMon.get(indexMon).getTenMonAn()
                    +"-"+"1"+"-"+LeTan.danhSachMonAn.dsMon.get(indexMon).getGia(); 

            int stt=dtm.getRowCount()+1;

            String[] data = dlMon.split("-");//Chưa có stt

                String[] dataRow = new String[4];
                dataRow[0] = (stt++)+"";
                dataRow[1] = data[0];
                dataRow[2] = data[1];
                dataRow[3] = data[2];

            //dtm phải ở dạng public static
            //tbThucDon cx vậy nhưng phải sửa ở nagivator chỗ customize code
            QLDatMon_LeTan.dtm.addRow(dataRow);
            QLDatMon_LeTan.tbThucDon.setModel(dtm);
            
            //Set cho tên món được dài hơn
            QLDatMon_LeTan.tbThucDon.getColumnModel().getColumn(0).setPreferredWidth(50);
            QLDatMon_LeTan.tbThucDon.getColumnModel().getColumn(1).setPreferredWidth(120);
            QLDatMon_LeTan.tbThucDon.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 14));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Món chưa có!!", "Lỗi thêm món", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        cbDanhMuc = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        bHienMon = new javax.swing.JButton();
        bMon1 = new javax.swing.JButton();
        bMon2 = new javax.swing.JButton();
        bMon3 = new javax.swing.JButton();
        bMon4 = new javax.swing.JButton();
        bMon5 = new javax.swing.JButton();
        bMon6 = new javax.swing.JButton();
        bMon7 = new javax.swing.JButton();
        bMon8 = new javax.swing.JButton();
        bMon9 = new javax.swing.JButton();
        txtMon1 = new javax.swing.JLabel();
        txtMon2 = new javax.swing.JLabel();
        txtMon3 = new javax.swing.JLabel();
        txtMon4 = new javax.swing.JLabel();
        txtMon5 = new javax.swing.JLabel();
        txtMon6 = new javax.swing.JLabel();
        txtMon7 = new javax.swing.JLabel();
        txtMon8 = new javax.swing.JLabel();
        txtMon9 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Món Việt", "Món Hàn", "Món Trung" }));

        jLabel16.setText("Danh mục");

        bHienMon.setText("Hiện món");
        bHienMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHienMonActionPerformed(evt);
            }
        });

        bMon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon1ActionPerformed(evt);
            }
        });

        bMon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon2ActionPerformed(evt);
            }
        });

        bMon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon3ActionPerformed(evt);
            }
        });

        bMon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon4ActionPerformed(evt);
            }
        });

        bMon5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon5ActionPerformed(evt);
            }
        });

        bMon6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon6ActionPerformed(evt);
            }
        });

        bMon7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon7ActionPerformed(evt);
            }
        });

        bMon8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon8ActionPerformed(evt);
            }
        });

        bMon9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMon9ActionPerformed(evt);
            }
        });

        txtMon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon1.setText("Trống");

        txtMon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon2.setText("Trống");

        txtMon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon3.setText("Trống");

        txtMon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon4.setText("Trống");

        txtMon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon5.setText("Trống");

        txtMon6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon6.setText("Trống");

        txtMon7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon7.setText("Trống");

        txtMon8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon8.setText("Trống");

        txtMon9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMon9.setText("Trống");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMon1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(txtMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMon3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bMon1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(bMon4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(bMon7, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(bMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bMon3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bMon5, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(bMon8, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                        .addGap(60, 60, 60)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bMon9, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(bMon6, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(txtMon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMon7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(txtMon8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(txtMon9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(bHienMon)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHienMon))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMon1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMon3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMon1)
                    .addComponent(txtMon2)
                    .addComponent(txtMon3))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMon5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMon6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMon4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMon4)
                    .addComponent(txtMon5)
                    .addComponent(txtMon6))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bMon7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bMon8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bMon9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMon7)
                    .addComponent(txtMon8)
                    .addComponent(txtMon9))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bHienMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHienMonActionPerformed
        //Danh sách tên món
        String[] dsTenMonViet = dsMon.dsTenMonViet();
        String[] dsTenMonHan = dsMon.dsTenMonHan();
        String[] dsTenMonTrung = dsMon.dsTenMonTrung();
        //Danh sách đường dẫn ảnh
        String[] dsFilePathImageMonViet= dsMon.dsFilePathImageMonViet();
        String[] dsFilePathImageMonHan = dsMon.dsFilePathImageMonHan();
        String[] dsFilePathImageMonTrung = dsMon.dsFilePathImageMonTrung();
        //Xử lý món ăn
        if(cbDanhMuc.getSelectedIndex()==1)//Món Việt
        {
            refeshDisplay();
            for(int i=0; i<dsTenMonViet.length; i++)
            {
                //Gán tên món
                ganTenMonTheoMaNut(i+1, dsTenMonViet[i]);
                //Gán hình ảnh
                addImage(traVeNutTheoMaNut(i+1), dsFilePathImageMonViet[i], 40, 40);
            }
        }
        else if(cbDanhMuc.getSelectedIndex()==2)//Món Hàn
        {
            refeshDisplay();
            for(int i=0; i<dsTenMonHan.length; i++)
            {
                //Gán tên món
                ganTenMonTheoMaNut(i+1, dsTenMonHan[i]);
                //Gán hình ảnh
                addImage(traVeNutTheoMaNut(i+1), dsFilePathImageMonHan[i], 40, 40);
            }
        }
        else if(cbDanhMuc.getSelectedIndex()==3)//Món Trung
        {
            refeshDisplay();
            for(int i=0; i<dsTenMonTrung.length; i++)
            {
                //Gán tên món
                ganTenMonTheoMaNut(i+1, dsTenMonTrung[i]);
                //Gán hình ảnh
                addImage(traVeNutTheoMaNut(i+1), dsFilePathImageMonTrung[i], 40, 40);
            }
        }
        else
            refeshDisplay();
    }//GEN-LAST:event_bHienMonActionPerformed

    private void bMon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon1ActionPerformed
        if(DangNhap.indexKH==false)//Là khách hàng thì ko chạy lệnh này
            them1MonVaoBang_theoMaNutMon(1);
    }//GEN-LAST:event_bMon1ActionPerformed

    private void bMon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon2ActionPerformed
        if(DangNhap.indexKH==false)
            them1MonVaoBang_theoMaNutMon(2);
    }//GEN-LAST:event_bMon2ActionPerformed

    private void bMon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon3ActionPerformed
        if(DangNhap.indexKH==false)
            them1MonVaoBang_theoMaNutMon(3);
    }//GEN-LAST:event_bMon3ActionPerformed
        
    private void bMon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon4ActionPerformed
        if(DangNhap.indexKH==false)
            them1MonVaoBang_theoMaNutMon(4);
    }//GEN-LAST:event_bMon4ActionPerformed

    private void bMon5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon5ActionPerformed
        if(DangNhap.indexKH==false)    
            them1MonVaoBang_theoMaNutMon(5);
    }//GEN-LAST:event_bMon5ActionPerformed

    private void bMon6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon6ActionPerformed
        
        if(DangNhap.indexKH==false)
            them1MonVaoBang_theoMaNutMon(6);
    }//GEN-LAST:event_bMon6ActionPerformed

    private void bMon7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon7ActionPerformed
        them1MonVaoBang_theoMaNutMon(7);
    }//GEN-LAST:event_bMon7ActionPerformed

    private void bMon8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon8ActionPerformed
        if(DangNhap.indexKH==false)
            them1MonVaoBang_theoMaNutMon(8);
    }//GEN-LAST:event_bMon8ActionPerformed

    private void bMon9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMon9ActionPerformed
        if(DangNhap.indexKH==false)
            them1MonVaoBang_theoMaNutMon(9);
    }//GEN-LAST:event_bMon9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHienMon;
    public static javax.swing.JButton bMon1;
    public static javax.swing.JButton bMon2;
    public static javax.swing.JButton bMon3;
    public static javax.swing.JButton bMon4;
    public static javax.swing.JButton bMon5;
    public static javax.swing.JButton bMon6;
    public static javax.swing.JButton bMon7;
    public static javax.swing.JButton bMon8;
    public static javax.swing.JButton bMon9;
    public static javax.swing.JComboBox<String> cbDanhMuc;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel txtMon1;
    public static javax.swing.JLabel txtMon2;
    public static javax.swing.JLabel txtMon3;
    public static javax.swing.JLabel txtMon4;
    public static javax.swing.JLabel txtMon5;
    public static javax.swing.JLabel txtMon6;
    public static javax.swing.JLabel txtMon7;
    public static javax.swing.JLabel txtMon8;
    public static javax.swing.JLabel txtMon9;
    // End of variables declaration//GEN-END:variables
}
