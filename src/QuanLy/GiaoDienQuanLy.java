
package QuanLy;

import JavaPerson.GiaoDienThongTin;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.login;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GiaoDienQuanLy extends javax.swing.JFrame {
    
    private JPanel pChucNang;
    
    public GiaoDienQuanLy() {
        initComponents();
        
        GiaoDienThongTin tt = new GiaoDienThongTin();

        pChucNang = tt;
        
        pMain.removeAll();
        pMain.add(pChucNang);
        pMain.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnDangXuat = new javax.swing.JMenu();
        mnThongTin = new javax.swing.JMenu();
        mnChucNang = new javax.swing.JMenu();
        mniQLMon = new javax.swing.JMenuItem();
        mniQLHD = new javax.swing.JMenuItem();
        mniQLNV = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pMain.setLayout(new java.awt.BorderLayout());

        mnDangXuat.setText("Đăng xuất");
        mnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnDangXuatMouseClicked(evt);
            }
        });
        mnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDangXuatActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnDangXuat);

        mnThongTin.setText("Thông tin");
        mnThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnThongTinMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnThongTin);

        mnChucNang.setText("Chức năng");

        mniQLMon.setText("Quản lý món ăn");
        mniQLMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLMonActionPerformed(evt);
            }
        });
        mnChucNang.add(mniQLMon);

        mniQLHD.setText("Quản lý hóa đơn");
        mniQLHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLHDActionPerformed(evt);
            }
        });
        mnChucNang.add(mniQLHD);

        mniQLNV.setText("Quản lý nhân viên");
        mniQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLNVActionPerformed(evt);
            }
        });
        mnChucNang.add(mniQLNV);

        jMenuBar1.add(mnChucNang);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMain, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMain, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLNVActionPerformed
        quanLyNhanVien qlNV = new quanLyNhanVien();

        pChucNang = qlNV;
        
        pMain.removeAll();
        pMain.add(pChucNang);
        pMain.validate();   
    }//GEN-LAST:event_mniQLNVActionPerformed

    private void mniQLMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLMonActionPerformed
        quanLyMonAn qlMon = new quanLyMonAn();
        
        pChucNang = qlMon;
        
        pMain.removeAll();
        pMain.add(pChucNang);
        pMain.validate();   
    }//GEN-LAST:event_mniQLMonActionPerformed

    private void mniQLHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLHDActionPerformed
        quanLyHoaDon qlHD = new quanLyHoaDon();
        
        pChucNang = qlHD;
        
        pMain.removeAll();
        pMain.add(pChucNang);
        pMain.validate();
    }//GEN-LAST:event_mniQLHDActionPerformed

    private void mnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDangXuatActionPerformed
         
    }//GEN-LAST:event_mnDangXuatActionPerformed

    private void mnDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnDangXuatMouseClicked
        if(JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE )==0)
        {
            setVisible(false);
            
            login.setLocationRelativeTo(null);
            login.setVisible(true);
            JavaPerson.DangNhap.indexNV=-1;
        }   
        
    }//GEN-LAST:event_mnDangXuatMouseClicked

    private void mnThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnThongTinMouseClicked
        GiaoDienThongTin tt = new GiaoDienThongTin();

        pChucNang = tt;
        
        pMain.removeAll();
        pMain.add(pChucNang);
        pMain.validate();
    }//GEN-LAST:event_mnThongTinMouseClicked

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
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienQuanLy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnChucNang;
    private javax.swing.JMenu mnDangXuat;
    private javax.swing.JMenu mnThongTin;
    private javax.swing.JMenuItem mniQLHD;
    private javax.swing.JMenuItem mniQLMon;
    private javax.swing.JMenuItem mniQLNV;
    private javax.swing.JPanel pMain;
    // End of variables declaration//GEN-END:variables
}
