
package QuanLy;

import static JavaPerson.DanhSachNhanVien.dsNV;
import JavaPerson.NhanVien;
import static QuanLy.quanLyNhanVien.dtm;
import static QuanLy.quanLyNhanVien.tbDSNV;
import static QuanLy.quanLyNhanVien.trs;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.HandleImage;
import util.ModelColor;

public class chiTietThongTinNV_QL extends javax.swing.JFrame {
    private boolean flag=false;//Dùng trong event upload. Nếu nhấn upload 
     //thì flag thành true. Khi này khi ta sửa nv mà ko đổi ảnh or xem 
    //nv thì lấy dữ liệu cũ, ngược lại lấy dl mới
    private String filePathImage="";
        //Color gradient backGround
    private Color color1 = new Color(0, 255, 204);
    //    private Color color2 = Color.GREEN;
    private Color color3 = new Color(204, 0, 204);
    public chiTietThongTinNV_QL() {
        initComponents();
        
        if(quanLyNhanVien.indexDong_click!=-1)
        {
            //Lấy dữ liệu
            String taiKhoan = dsNV.get(quanLyNhanVien.indexDong_click).getTaiKhoan();
            String matKhau = dsNV.get(quanLyNhanVien.indexDong_click).getMatKhau();
            String hoTen = dsNV.get(quanLyNhanVien.indexDong_click).getHoTen();
            String ngaySinh = dsNV.get(quanLyNhanVien.indexDong_click).getNgaySinh();
            String gioiTinh = dsNV.get(quanLyNhanVien.indexDong_click).getGioiTinh();
            String diaChi = dsNV.get(quanLyNhanVien.indexDong_click).getDiaChi();
            String SDT = dsNV.get(quanLyNhanVien.indexDong_click).getSDT();
            int chucVu = dsNV.get(quanLyNhanVien.indexDong_click).getChucVu();
            String filePathImage = dsNV.get(quanLyNhanVien.indexDong_click).getFilePathImage();
            
            txtTaiKhoan.setText(taiKhoan);
            txtMatKhau.setText(matKhau);
            txtHoTen.setText(hoTen);
        
            String[] date = ngaySinh.split("-");
            cbNgay.setSelectedItem(date[0]);
            cbThang.setSelectedItem(date[1]);
            cbNam.setSelectedItem(date[2]);
            if(gioiTinh.equals("Nam"))
                rbNam.setSelected(true);
            else
                rbNu.setSelected(true);
            
            txtDiaChi.setText(diaChi);
            txtSDT.setText(SDT);
            cbChucVu.setSelectedIndex(chucVu);
            addImage(filePathImage, 100, 100);
        }
        
        pMainTTNV.addColor(new ModelColor(color1,
                 0f),
                 new ModelColor(color3, 1f)); 
    }
    
    //Tạo hình cho button-Tái sử dụng
    public void addImage(String filePath, int width, int height) {
        try {
            BufferedImage bfImage = null;
            bfImage = ImageIO.read(new File(filePath));
            Image i = HandleImage.getScaledImage(bfImage, width, height);
            ImageIcon icon = new ImageIcon(i);
            bImage.setIcon(icon);
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        pMainTTNV = new util.PanelGradient();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        rbShow = new javax.swing.JRadioButton();
        bImage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        cbNgay = new javax.swing.JComboBox<>();
        cbThang = new javax.swing.JComboBox<>();
        cbNam = new javax.swing.JComboBox<>();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        cbChucVu = new javax.swing.JComboBox<>();
        bUpload = new javax.swing.JButton();
        bOK = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tài khoản");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mật khẩu");

        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        rbShow.setBackground(new java.awt.Color(255, 255, 255));
        rbShow.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        rbShow.setText("Show");
        rbShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbShow, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbShow))
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Họ tên");

        jLabel4.setText("Ngày sinh");

        jLabel5.setText("Giới tính");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("SDT");

        jLabel8.setText("Chức vụ");

        cbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005" }));

        rbNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbNam);
        rbNam.setSelected(true);
        rbNam.setText("Nam");

        rbNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rbNu);
        rbNu.setText("Nữ");

        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phục vụ", "Lễ tân", "Thủ kho" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(rbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbNam)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNam)
                    .addComponent(rbNu)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        bUpload.setText("Upload");
        bUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUploadActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout pMainTTNVLayout = new javax.swing.GroupLayout(pMainTTNV);
        pMainTTNV.setLayout(pMainTTNVLayout);
        pMainTTNVLayout.setHorizontalGroup(
            pMainTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainTTNVLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pMainTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pMainTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainTTNVLayout.createSequentialGroup()
                        .addComponent(bUpload)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainTTNVLayout.createSequentialGroup()
                        .addComponent(bImage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
            .addGroup(pMainTTNVLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(bOK)
                .addGap(78, 78, 78)
                .addComponent(bThoat)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pMainTTNVLayout.setVerticalGroup(
            pMainTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainTTNVLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pMainTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pMainTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bUpload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(pMainTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOK)
                    .addComponent(bThoat))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainTTNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pMainTTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbShowActionPerformed
        if(rbShow.isSelected())
            txtMatKhau.setEchoChar((char)0);
        else
            txtMatKhau.setEchoChar((char)'\u2022');
    }//GEN-LAST:event_rbShowActionPerformed

    private void bUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUploadActionPerformed
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP_git\\FileImage");
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("hinh anh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);
        
        int x = fileChooser.showDialog(this, "Chọn file");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f =fileChooser.getSelectedFile();
            
            filePathImage=f.getAbsolutePath();
        }
        addImage(filePathImage, 120, 120);
        flag=true;
    }//GEN-LAST:event_bUploadActionPerformed

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        quanLyNhanVien.indexDong_click=-1;
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        String taiKhoan = txtTaiKhoan.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        String hoTen = txtHoTen.getText();
        String ngaySinh=String.valueOf(cbNam.getSelectedItem())+"-"
                +String.valueOf(cbThang.getSelectedItem())+"-"
                +String.valueOf(cbNgay.getSelectedItem());
        String gioiTinh="";
        if(rbNam.isSelected())
            gioiTinh="Nam";
        else
            gioiTinh="Nữ";
        String diaChi=txtDiaChi.getText();
        String SDT = txtSDT.getText();
        int chucVu = cbChucVu.getSelectedIndex();
        
        if(quanLyNhanVien.indexDong_click==-1)//Tức nhân thêm món
        {
            NhanVien nv = new NhanVien(taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT, chucVu, filePathImage);
            JavaPerson.DanhSachNhanVien.dsNV.add(nv);
        }
        else//Tức xem, sửa nhân viên
        {
            dsNV.get(quanLyNhanVien.indexDong_click).setTaiKhoan(taiKhoan);
            dsNV.get(quanLyNhanVien.indexDong_click).setMatKhau(matKhau);
            dsNV.get(quanLyNhanVien.indexDong_click).setHoTen(hoTen);
            dsNV.get(quanLyNhanVien.indexDong_click).setNgaySinh(ngaySinh);
            dsNV.get(quanLyNhanVien.indexDong_click).setGioiTinh(gioiTinh);
            dsNV.get(quanLyNhanVien.indexDong_click).setDiaChi(diaChi);
            dsNV.get(quanLyNhanVien.indexDong_click).setSDT(SDT);
            dsNV.get(quanLyNhanVien.indexDong_click).setChucVu(chucVu);

            if(flag==true)//Tức có update ảnh
                dsNV.get(quanLyNhanVien.indexDong_click).setFilePathImage(filePathImage);
        }
        
        javaswingcnpm_vip.JavaSwingCNPM_VIP.dsNV.luuVaoFile();
        
        //Xóa toàn bộ thông tin trên table
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();
        
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
        tbDSNV.setModel(dtm);
        tbDSNV.setRowSorter(trs);
        
        quanLyNhanVien.indexDong_click=-1;//Trả về giá trị gốc
        setVisible(false);
    }//GEN-LAST:event_bOKActionPerformed

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
            java.util.logging.Logger.getLogger(chiTietThongTinNV_QL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chiTietThongTinNV_QL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chiTietThongTinNV_QL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chiTietThongTinNV_QL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chiTietThongTinNV_QL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bImage;
    private javax.swing.JButton bOK;
    private javax.swing.JButton bThoat;
    private javax.swing.JButton bUpload;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbChucVu;
    private javax.swing.JComboBox<String> cbNam;
    private javax.swing.JComboBox<String> cbNgay;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private util.PanelGradient pMainTTNV;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JRadioButton rbShow;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
