
package LeTan;

import JavaPerson.DangNhap;
import JavaPerson.GiaoDienThongTin;
import java.awt.Color;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.login;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.HandleImage;
import util.ModelColor;

public class GiaoDienLeTan extends javax.swing.JFrame {
    
    private JPanel pChucNang;
    public GiaoDienLeTan(){
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
        mniDatMon = new javax.swing.JMenuItem();

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

        mniDatMon.setText("Đặt món");
        mniDatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDatMonActionPerformed(evt);
            }
        });
        mnChucNang.add(mniDatMon);

        jMenuBar1.add(mnChucNang);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pMain, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pMain, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniDatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDatMonActionPerformed
        pChucNang = new QLDatMon_LeTan();
        
        pMain.removeAll();
        pMain.add(pChucNang);
        pMain.validate();
    }//GEN-LAST:event_mniDatMonActionPerformed

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
            java.util.logging.Logger.getLogger(GiaoDienLeTan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienLeTan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienLeTan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienLeTan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienLeTan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnChucNang;
    private javax.swing.JMenu mnDangXuat;
    private javax.swing.JMenu mnThongTin;
    private javax.swing.JMenuItem mniDatMon;
    private javax.swing.JPanel pMain;
    // End of variables declaration//GEN-END:variables
}
