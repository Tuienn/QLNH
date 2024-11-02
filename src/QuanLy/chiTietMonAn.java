
package QuanLy;

import LeTan.danhSachMonAn;
import LeTan.monAn;
import static QuanLy.quanLyMonAn.dtm;
import static QuanLy.quanLyMonAn.tbMonAn;
import static QuanLy.quanLyMonAn.trs;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.HandleImage;
import util.ModelColor;


public class chiTietMonAn extends javax.swing.JFrame {
    private boolean flag=false;//Dùng trong event OK vs initComponent
    private boolean flag2=false;//Dùng trong event upload. Nếu nhấn upload 
     //thì flag2 thành true. Khi này khi ta sửa món mà ko đổi ảnh or xem 
    //món thì lấy dữ liệu cũ, ngược lại lấy dl mới
    
    //Color gradient backGround
    private Color color1 = new Color(0, 255, 204);
//    private Color color2 = Color.GREEN;
    private Color color3 = new Color(204, 0, 204);
    private String filePathImage="";
    public chiTietMonAn() {
        initComponents();
        
        pMainMon.addColor(new ModelColor(color1,
                 0f),
                 new ModelColor(color3, 1f));
        if(quanLyMonAn.indexDongClick!=-1)
        {
            //Lấy dữ liệu
            String maMon = danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).getMaMonAn();
            String tenMon = danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).getTenMonAn();
            String maDanhMuc = danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).getMaDanhMuc();
            double gia = danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).getGia();
            String filePathImage = danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).getFilePathImage();
            
            //Gán dữ liệu
            txtMaMon.setText(maMon);
            txtTenMon.setText(tenMon);
            cbDanhMuc.setSelectedIndex(Integer.parseInt(maDanhMuc)-1);
            txtGia.setText(String.valueOf(gia));
            addImage(bImage, filePathImage, 85, 85);
        }
    }
    //Tạo hình cho button-Tái sử dụng
    public void addImage(JButton bBan, String filePath, int width, int height) {
        try {
            BufferedImage bfImage = null;
            bfImage = ImageIO.read(new File(filePath));
            Image i = HandleImage.getScaledImage(bfImage, width, height);
            ImageIcon icon = new ImageIcon(i);
            bBan.setIcon(icon);
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMainMon = new util.PanelGradient();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        cbDanhMuc = new javax.swing.JComboBox<>();
        bImage = new javax.swing.JButton();
        bOK = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();
        bUpload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết món ăn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã món");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên món");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh mục");

        txtMaMon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giá($)");

        txtTenMon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Món Việt", "Món Hàn", "Món Trung" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        bOK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        bThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        bUpload.setText("Upload");
        bUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pMainMonLayout = new javax.swing.GroupLayout(pMainMon);
        pMainMon.setLayout(pMainMonLayout);
        pMainMonLayout.setHorizontalGroup(
            pMainMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainMonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pMainMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainMonLayout.createSequentialGroup()
                        .addComponent(bUpload)
                        .addGap(12, 12, 12)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainMonLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(bOK)
                .addGap(71, 71, 71)
                .addComponent(bThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pMainMonLayout.setVerticalGroup(
            pMainMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainMonLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pMainMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainMonLayout.createSequentialGroup()
                        .addComponent(bImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bUpload))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pMainMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOK)
                    .addComponent(bThoat))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pMainMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUploadActionPerformed
        
        JFileChooser fileChooser = new JFileChooser("D:\\Code\\java-netbean projects\\JavaSwingCNPM_VIP\\FileImage");
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("hinh anh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);
        
        int x = fileChooser.showDialog(this, "Chọn file");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f =fileChooser.getSelectedFile();
            
            filePathImage=f.getAbsolutePath();
        }
        addImage(bImage, filePathImage, 85, 85);
        flag2=true;
    }//GEN-LAST:event_bUploadActionPerformed

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        String maMon=txtMaMon.getText();
        String tenMon=txtTenMon.getText();
        String maDanhMuc=String.valueOf(cbDanhMuc.getSelectedIndex()+1);
        String gia = txtGia.getText();
        
        if(quanLyMonAn.indexDongClick==-1)//Nhấn nút thêm món
        {
            monAn m = new monAn(maMon, tenMon, maDanhMuc, Double.parseDouble(gia), filePathImage);
            danhSachMonAn.dsMon.add(m);
        }
        else//Tức sửa món-xem món
        {
            danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).setMaMonAn(maMon);
            danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).setTenMonAn(tenMon);
            danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).setMaDanhMuc(maDanhMuc);
            danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).setGia(Double.parseDouble(gia));
            
            if(flag2==true)//Tức có sửa ảnh
                danhSachMonAn.dsMon.get(quanLyMonAn.indexDongClick).setFilePathImage(filePathImage);    
        }
        try {
            dsMon.luuVaoFile(javaswingcnpm_vip.JavaSwingCNPM_VIP.duongDanDSMon);
        } catch (IOException ex) {
            Logger.getLogger(chiTietMonAn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Xóa toàn bộ thông tin trên table
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();
        
        //Nút ok này dùng cho cả thêm và xóa nên phải làm vậy
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
        
        tbMonAn.setModel(dtm);
        tbMonAn.setRowSorter(trs);
        
//Cái này sinh ra bug:)). Mệt vch 2h sáng rồi muốn ngủ.        
//        //Chỉnh sửa phông chữ và độ rộng cột  
//        tbMonAn.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 14));
//        tbMonAn.setFont(new Font("Tahoma", 0, 12));
//        
//        tbMonAn.getColumnModel().getColumn(0).setPreferredWidth(10);
//        tbMonAn.getColumnModel().getColumn(2).setPreferredWidth(120);

        quanLyMonAn.indexDongClick=-1;//Trả về giá trị gốc
        setVisible(false);
    }//GEN-LAST:event_bOKActionPerformed

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        quanLyMonAn.indexDongClick=-1;
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chiTietMonAn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bImage;
    private javax.swing.JButton bOK;
    private javax.swing.JButton bThoat;
    private javax.swing.JButton bUpload;
    private javax.swing.JComboBox<String> cbDanhMuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private util.PanelGradient pMainMon;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
