
package JavaPerson;

import KhachHang.GiaoDienKhachHang;
import LeTan.GiaoDienLeTan;
import PhucVu.GiaoDienPhucVu;
import QuanLy.GiaoDienQuanLy;
import ThuKho.GiaoDienThuKho;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsKH;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsNV;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.HandleImage;
import util.ModelColor;

/**
 *
 * @author DELL
 */
public class DangNhap extends javax.swing.JFrame {
    public static int indexNV=-1;
    public static boolean indexKH=false;
    //Color gradient backGround
    private Color color1 = new Color(0, 255, 204);
//    private Color color2 = Color.GREEN;
    private Color color3 = new Color(204, 0, 204);
    
    public DangNhap() {
        initComponents();
        panelGradient1.addColor(new ModelColor(color1, 0f),
                new ModelColor(color3, 1f));
        addImage(ImageTK, javaswingcnpm_vip.JavaSwingCNPM_VIP.fileImageTK, 30, 30);
        addImage(ImageMK, javaswingcnpm_vip.JavaSwingCNPM_VIP.fileImageMK, 30, 30);
        addImage(ImagePL, javaswingcnpm_vip.JavaSwingCNPM_VIP.fileImagePL, 30, 30);
        addImage(lbLogo, javaswingcnpm_vip.JavaSwingCNPM_VIP.fileLogo, 250, 250);
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
    
    private void refreshText()
    {
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
        cbHienMK.setSelected(false);
        cbPhanLoai.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new util.PanelGradient();
        jPanel1 = new javax.swing.JPanel();
        bDangNhap = new util.ButtonGradient();
        jLabel1 = new javax.swing.JLabel();
        lbTaiKhoan = new javax.swing.JLabel();
        lbMatKhau = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        ImageTK = new javax.swing.JLabel();
        ImageMK = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        cbHienMK = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cbPhanLoai = new javax.swing.JComboBox<>();
        ImagePL = new javax.swing.JLabel();
        erTaiKhoan = new javax.swing.JLabel();
        erMatKhau = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bDangNhap.setText("Đăng nhập");
        bDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDangNhapActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(255, 102, 0), new java.awt.Color(255, 102, 0)));

        lbTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTaiKhoan.setText("Tài khoản");

        lbMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbMatKhau.setText("Mật khẩu");

        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTaiKhoan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(153, 153, 153)));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMatKhau.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(153, 153, 153)));

        cbHienMK.setBackground(new java.awt.Color(255, 255, 255));
        cbHienMK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbHienMK.setText("Hiện mật khẩu");
        cbHienMK.setBorder(null);
        cbHienMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHienMKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Phân loại");

        cbPhanLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbPhanLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Khách hàng" }));

        ImagePL.setBackground(new java.awt.Color(255, 255, 255));

        erTaiKhoan.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        erTaiKhoan.setForeground(new java.awt.Color(255, 51, 0));

        erMatKhau.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        erMatKhau.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ImageTK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(8, Short.MAX_VALUE)
                                .addComponent(ImageMK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ImagePL, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTaiKhoan)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(cbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(erMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbHienMK)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTaiKhoan)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ImageTK, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(erTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMatKhau)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImageMK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHienMK)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagePL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addComponent(bDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        lbLogo.setPreferredSize(new java.awt.Dimension(270, 270));

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbHienMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHienMKActionPerformed
        if(cbHienMK.isSelected())
            txtMatKhau.setEchoChar((char)0);
        else
            txtMatKhau.setEchoChar((char)'\u2022');
    }//GEN-LAST:event_cbHienMKActionPerformed

    private void bDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDangNhapActionPerformed
        erTaiKhoan.setText("");
        erMatKhau.setText("");
        
        String taiKhoan = txtTaiKhoan.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        
        Person p = new Person();
        
        if(p.kiemTraTaiKhoanHopLe(taiKhoan)!=0||p.kiemTraMatKhauHopLe(matKhau)!=0)
        {
            //Kiểm tra tài khoản hợp lệ
            if(p.kiemTraTaiKhoanHopLe(taiKhoan)==1)
                erTaiKhoan.setText("(*)Không chứa dấu cách");
            else if(p.kiemTraTaiKhoanHopLe(taiKhoan)==2)
                erTaiKhoan.setText("(*)Hãy nhập tài khoản");  
            //Kiểm tra mật khẩu hợp lệ
            if(p.kiemTraMatKhauHopLe(matKhau)==1)
                erMatKhau.setText("(*)Không chứa dấu cách");
            else if(p.kiemTraMatKhauHopLe(taiKhoan)==2)
                erMatKhau.setText("(*)Hãy nhập mật khẩu"); 
        }
        
        else
        {
            if(cbPhanLoai.getSelectedIndex()==0)
            {
                if(dsNV.kiemTraTK_laDung(txtTaiKhoan.getText(), matKhau))
                {
                    int chucVu = dsNV.chucVuNV_DangNhap(taiKhoan, matKhau);
                    if(chucVu==-1)
                    {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công\nChào quản lý Nguyễn Ngọc Tuyền");
                        setVisible(false);

                        indexNV=-2;
                        GiaoDienQuanLy UI_QL = new GiaoDienQuanLy();

                        UI_QL.setLocationRelativeTo(null);
                        UI_QL.setVisible(true);
                    }
                    else if(chucVu==0)//Phục vụ
                    {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công\nChào phục vụ " + 
                                dsNV.timKiemNhanVien_TK(taiKhoan).getHoTen());

                        indexNV=dsNV.timKiemNhanVien_taiKhoan(taiKhoan);
                        setVisible(false);
                        GiaoDienPhucVu UI_PV = new GiaoDienPhucVu();

                        UI_PV.setLocationRelativeTo(null);
                        UI_PV.setVisible(true);
                    }

                    else if(chucVu==1)//Lễ tân
                    {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công\nChào lễ tân " + 
                                dsNV.timKiemNhanVien_TK(taiKhoan).getHoTen());
                        setVisible(false);

                        indexNV=dsNV.timKiemNhanVien_taiKhoan(taiKhoan);
                        GiaoDienLeTan UI_LT = new GiaoDienLeTan();
                        UI_LT.setLocationRelativeTo(null);
                        UI_LT.setVisible(true);
                    }

                    else if(chucVu==2)//Thủ kho
                    {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công\nChào thủ kho " + 
                                dsNV.timKiemNhanVien_TK(taiKhoan).getHoTen());
                        indexNV=dsNV.timKiemNhanVien_taiKhoan(taiKhoan);
                        setVisible(false);

                        GiaoDienThuKho UI_TK = new GiaoDienThuKho();

                        UI_TK.setLocationRelativeTo(null);
                        UI_TK.setVisible(true);
                        
                        refreshText();
                    }
                }
                else
                {
                    erTaiKhoan.setText("(*)Tài khoản sai");
                    erMatKhau.setText("(*)Mật khẩu sai");
                }
            }
            else
            {
                if(dsKH.kiemTraTK_laDung(taiKhoan, matKhau))
                {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công\nChào khách hàng " + 
                                dsKH.timKiemKhachHang_taiKhoan(taiKhoan).getHoTen());
                    indexKH=true;
                    setVisible(false);

                    GiaoDienKhachHang UI_KH = new GiaoDienKhachHang();

                    UI_KH.setLocationRelativeTo(null);
                    UI_KH.setVisible(true);
                        
                    refreshText();
                }
                else
                {
                    erTaiKhoan.setText("(*)Tài khoản sai");
                    erMatKhau.setText("(*)Mật khẩu sai");
                }
            }
            
        }
    }//GEN-LAST:event_bDangNhapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageMK;
    private javax.swing.JLabel ImagePL;
    private javax.swing.JLabel ImageTK;
    private util.ButtonGradient bDangNhap;
    private javax.swing.JCheckBox cbHienMK;
    private javax.swing.JComboBox<String> cbPhanLoai;
    private javax.swing.JLabel erMatKhau;
    private javax.swing.JLabel erTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbTaiKhoan;
    private util.PanelGradient panelGradient1;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
