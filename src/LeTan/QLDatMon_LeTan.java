package LeTan;

import static LeTan.danhSachMonAn.dsMon;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import util.ModelColor;
import util.HandleImage;
import util.ButtonGradient;

import LeTan.thucDon;
import QuanLy.ChiTietHD;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingcnpm_vip.JavaSwingCNPM_VIP;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsBan;
import static javaswingcnpm_vip.JavaSwingCNPM_VIP.dsHD;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class QLDatMon_LeTan extends javax.swing.JPanel {
    //Color gradient backGround
    private Color color1 = new Color(0, 255, 204);
//    private Color color2 = Color.GREEN;
    private Color color3 = new Color(204, 0, 204);
    
    //Color màu bàn
    private Color color_dangChon = new Color(255, 255, 204);
    private Color color_trong = new Color(204, 255, 204);
    private Color color_coNguoi = new Color(255, 204, 204);
    
    //Lưu vị trí nút vừa nhấn để làm nút đang chọn
    private int maBan_historyClick=-1;
    
    //Tạo bảng mẫu
    public static DefaultTableModel dtm = new DefaultTableModel();
    
    public QLDatMon_LeTan() {
        initComponents();
        //Set backGround
        pMainBan.addColor(new ModelColor(color1,
                 0f),
                 new ModelColor(color3, 1f));
     
        pMainThucDon.addColor(new ModelColor(color1,
                 0f),
                 new ModelColor(color3, 1f));
        //Set icon bBan
        for(int i=1; i<=12; i++)
        {
            addImage(traVeNutTheoMaBan(i), JavaSwingCNPM_VIP.fileImageTable, 75, 75);
        }
        
        //Liên kết panel ThucDon với pThucDon
        pThucDon.add(new thucDon());
        pThucDon.validate();
        //Set phông bảng
        setPhongBang_choDep();
        
        //Set màu nút cho các bàn hiện tại-Khi đặt món chuyển sang tác vụ thông tin chẳng hạn
        for(int i=1; i<=12; i++)
        {
            setMauNut_maBan(i);
        }
    }
    private void setPhongBang_choDep()
    {
        //Set cho tên món được dài hơn
        tbThucDon.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbThucDon.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbThucDon.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 14));
    }
    //Quản lý nút
    private JButton traVeNutTheoMaBan(int maBan) {
        if (maBan == 1) {
            return bBan1;
        } else if (maBan == 2) {
            return bBan2;
        } else if (maBan == 3) {
            return bBan3;
        } else if (maBan == 4) {
            return bBan4;
        } else if (maBan == 5) {
            return bBan5;
        } else if (maBan == 6) {
            return bBan6;
        } else if (maBan == 7) {
            return bBan7;
        } else if (maBan == 8) {
            return bBan8;
        } else if (maBan == 9) {
            return bBan9;
        } else if (maBan == 10) {
            return bBan10;
        } else if (maBan == 11) {
            return bBan11;
        }
        return bBan12;
    }

    private int traVeMaBanTuNut(JButton bBan) {
        if (bBan == bBan1) {
            return 1;
        } else if (bBan == bBan2) {
            return 2;
        } else if (bBan == bBan3) {
            return 3;
        } else if (bBan == bBan4) {
            return 4;
        } else if (bBan == bBan5) {
            return 5;
        } else if (bBan == bBan6) {
            return 6;
        } else if (bBan == bBan7) {
            return 7;
        } else if (bBan == bBan8) {
            return 8;
        } else if (bBan == bBan9) {
            return 9;
        } else if (bBan == bBan10) {
            return 10;
        } else if (bBan == bBan11) {
            return 11;
        }
        return 12;
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
    //Quản lý màu
    private void setMauNut_maBan(int maBan)
    {
        JButton bBan = traVeNutTheoMaBan(maBan);
        
        if(!dsBan.kiemTraBan_isCoNguoi(maBan))//Bàn trống
            bBan.setBackground(color_trong);
        else if(dsBan.kiemTraBan_isCoNguoi(maBan))//Có người
            bBan.setBackground(color_coNguoi);
    }
    private void doiMauNutDangChon(JButton bBan)
    {
        //Đổi màu nút đang chọn
        bBan.setBackground(color_dangChon);
        //Trả về màu nút vừa click
        if(maBan_historyClick!=-1&&maBan_historyClick!=traVeMaBanTuNut(bBan))
        {
            setMauNut_maBan(maBan_historyClick);
        }
        
        maBan_historyClick=traVeMaBanTuNut(bBan);
    }    
    
    //Làm mới hoàn toàn bảng
    private void refreshTable()
    {
        //Xóa toàn bộ thông tin trên table
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
    }
    //Làm mới bảng vài tải lại thông ti bảng
    public void reloadTable_theoMaBan(int maBan_int)
    {
        refreshTable();
        setPhongBang_choDep();
        layDuLieuTuDsBan(maBan_int);
    }
    //Xóa toàn bộ dữ liệu hiển thị
    private void refreshJPanelThucDon()
    {
        thucDon.bMon1.setIcon(null);
        thucDon.bMon2.setIcon(null);
        thucDon.bMon3.setIcon(null);
        thucDon.bMon4.setIcon(null);
        thucDon.bMon5.setIcon(null);
        thucDon.bMon6.setIcon(null);
        thucDon.bMon7.setIcon(null);
        thucDon.bMon8.setIcon(null);
        thucDon.bMon9.setIcon(null);
        
        thucDon.txtMon1.setText("Trống");
        thucDon.txtMon2.setText("Trống");
        thucDon.txtMon3.setText("Trống");
        thucDon.txtMon4.setText("Trống");
        thucDon.txtMon5.setText("Trống");
        thucDon.txtMon6.setText("Trống");
        thucDon.txtMon7.setText("Trống");
        thucDon.txtMon8.setText("Trống");
        thucDon.txtMon9.setText("Trống");
    }
    private void lamMoiData()
    {
        refreshJPanelThucDon();
        
        refreshTable();
        
        cbNgay.setSelectedIndex(0);
        cbThang.setSelectedIndex(0);
        cbNam.setSelectedIndex(0);
        
        txtTenHD.setText("THÔNG TIN HÓA ĐƠN");
        txtTenKH.setText("");
    }
    //Xử lý thông tin cho bảng
    
        //Lưu dữ liệu bảng vào dsBan
    private String layDuLieuBang()
    {
        String dlBang="";
        
        for(int i=0; i<dtm.getRowCount(); i++)
        {
            //Không lưu stt
            String tenMon = String.valueOf(dtm.getValueAt(i, 1));
            String soLuong = String.valueOf(dtm.getValueAt(i, 2));
            String donGia = String.valueOf(dtm.getValueAt(i, 3));
            
            String dl1Hang = tenMon+"-"+soLuong+"-"+donGia+"/";
            dlBang+=dl1Hang;
            //Lưu theo c1d1-c2d1-c3d1-c4d1/c1d2-c2d2-c3d2-c4d2/...
        }
        return dlBang;
    }
        //Lấy dữ liệu dsBan để insert vào bảng
    private void layDuLieuTuDsBan(int maBan_int)
    {
        //Mã bàn là maBan_int
        
        //Tên KH
        String tenKH = dsThongTinBan.dsBan[maBan_int-1].getTenKH();
        
        txtTenKH.setText(tenKH);
        //Thời gian
        String thoiGian = dsThongTinBan.dsBan[maBan_int-1].getThoiGian();
        String[] tg = thoiGian.split("/");
        
        cbNgay.setSelectedItem(tg[0]);
        cbThang.setSelectedItem(tg[1]);
        cbNam.setSelectedItem(tg[2]);
        //Dữ liệu món ăn trong bảng
        refreshTable();
        //Xử lý dữ liệu bảng món gọi    
        String dlBangMon = dsThongTinBan.dsBan[maBan_int-1].getDuLieuBang_theoBan();
        String[] dlBang_Hang = dlBangMon.split("/");
        
        int stt=1;
        for(String dlMon : dlBang_Hang)
        {
            String[] data = dlMon.split("-");//Chưa có stt
            
            String[] dataRow = new String[4];
            dataRow[0] = (stt++)+"";
            dataRow[1] = data[0];
            dataRow[2] = data[1];
            dataRow[3] = data[2];
            dtm.addRow(dataRow);
            tbThucDon.setModel(dtm);
        }
    }
    private void clickButton(JButton bBan)
    {
        int maBan = traVeMaBanTuNut(bBan);
        lamMoiData();
        if(dsBan.kiemTraBan_isCoNguoi(maBan))
        {
            layDuLieuTuDsBan(maBan);
        }
    }
    private double tinhTotal()
    {
        double total=0;
        
        for(int i=0; i<dtm.getRowCount(); i++)
        {
            int sl = Integer.parseInt(String.valueOf(dtm.getValueAt(i, 2)));
            double donGia = Double.parseDouble(String.valueOf(dtm.getValueAt(i, 3)));
            total+=sl*donGia;
        }
        return total;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabDatMon = new javax.swing.JTabbedPane();
        tabBan = new javax.swing.JPanel();
        pMainBan = new util.PanelGradient();
        jPanel1 = new javax.swing.JPanel();
        bBan1 = new javax.swing.JButton();
        bBan2 = new javax.swing.JButton();
        bBan7 = new javax.swing.JButton();
        bBan3 = new javax.swing.JButton();
        bBan5 = new javax.swing.JButton();
        bBan6 = new javax.swing.JButton();
        bBan9 = new javax.swing.JButton();
        bBan4 = new javax.swing.JButton();
        bBan8 = new javax.swing.JButton();
        bBan11 = new javax.swing.JButton();
        bBan10 = new javax.swing.JButton();
        bBan12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bChonMon = new util.ButtonGradient();
        bHuyBan = new util.ButtonGradient();
        bDoiBan = new util.ButtonGradient();
        tabThucDon = new javax.swing.JPanel();
        pMainThucDon = new util.PanelGradient();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtTenHD = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        cbNgay = new javax.swing.JComboBox<>();
        cbThang = new javax.swing.JComboBox<>();
        cbNam = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThucDon = new javax.swing.JTable();
        //Bảng thực đơn chỉ đc đọc 1 lần
        if (javaswingcnpm_vip.JavaSwingCNPM_VIP.flag == true) {
            dtm.addColumn("STT");
            dtm.addColumn("Tên món");
            dtm.addColumn("SL");
            dtm.addColumn("Đơn giá($)");
            javaswingcnpm_vip.JavaSwingCNPM_VIP.flag = false;
        }
        bTaoBan = new util.ButtonGradient();
        bThanhToan = new util.ButtonGradient();
        pThucDon = new javax.swing.JPanel();

        pMainBan.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bBan1.setBackground(new java.awt.Color(204, 255, 204));
        bBan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan1MouseEntered(evt);
            }
        });
        bBan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan1ActionPerformed(evt);
            }
        });

        bBan2.setBackground(new java.awt.Color(204, 255, 204));
        bBan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan2MouseEntered(evt);
            }
        });
        bBan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan2ActionPerformed(evt);
            }
        });

        bBan7.setBackground(new java.awt.Color(204, 255, 204));
        bBan7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan7MouseEntered(evt);
            }
        });
        bBan7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan7ActionPerformed(evt);
            }
        });

        bBan3.setBackground(new java.awt.Color(204, 255, 204));
        bBan3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan3MouseEntered(evt);
            }
        });
        bBan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan3ActionPerformed(evt);
            }
        });

        bBan5.setBackground(new java.awt.Color(204, 255, 204));
        bBan5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan5MouseEntered(evt);
            }
        });
        bBan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan5ActionPerformed(evt);
            }
        });

        bBan6.setBackground(new java.awt.Color(204, 255, 204));
        bBan6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan6MouseEntered(evt);
            }
        });
        bBan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan6ActionPerformed(evt);
            }
        });

        bBan9.setBackground(new java.awt.Color(204, 255, 204));
        bBan9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan9MouseEntered(evt);
            }
        });
        bBan9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan9ActionPerformed(evt);
            }
        });

        bBan4.setBackground(new java.awt.Color(204, 255, 204));
        bBan4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBan4MouseClicked(evt);
            }
        });
        bBan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan4ActionPerformed(evt);
            }
        });

        bBan8.setBackground(new java.awt.Color(204, 255, 204));
        bBan8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan8MouseEntered(evt);
            }
        });
        bBan8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan8ActionPerformed(evt);
            }
        });

        bBan11.setBackground(new java.awt.Color(204, 255, 204));
        bBan11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan11MouseEntered(evt);
            }
        });
        bBan11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan11ActionPerformed(evt);
            }
        });

        bBan10.setBackground(new java.awt.Color(204, 255, 204));
        bBan10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan10MouseEntered(evt);
            }
        });
        bBan10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan10ActionPerformed(evt);
            }
        });

        bBan12.setBackground(new java.awt.Color(204, 255, 204));
        bBan12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bBan12MouseEntered(evt);
            }
        });
        bBan12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBan12ActionPerformed(evt);
            }
        });

        jLabel1.setText("Bàn 2");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bàn 1");

        jLabel3.setText("Bàn 3");

        jLabel4.setText("Bàn 4");

        jLabel5.setText("Bàn 5");

        jLabel6.setText("Bàn 6");

        jLabel7.setText("Bàn 7");

        jLabel8.setText("Bàn 8");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Bàn 12");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Bàn 11");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Bàn 10");

        jLabel12.setText("Bàn 9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(95, 95, 95)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addGap(97, 97, 97)
                .addComponent(jLabel6)
                .addGap(94, 94, 94)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(bBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bBan5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bBan9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bBan6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bBan10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bBan7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bBan4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBan12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBan8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBan6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBan9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBan12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(9, 9, 9))
        );

        bChonMon.setText("Chọn món");
        bChonMon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bChonMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChonMonActionPerformed(evt);
            }
        });

        bHuyBan.setBackground(new java.awt.Color(0, 0, 0));
        bHuyBan.setText("Hủy bàn");
        bHuyBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bHuyBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHuyBanActionPerformed(evt);
            }
        });

        bDoiBan.setText("Đổi bàn");
        bDoiBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bDoiBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDoiBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pMainBanLayout = new javax.swing.GroupLayout(pMainBan);
        pMainBan.setLayout(pMainBanLayout);
        pMainBanLayout.setHorizontalGroup(
            pMainBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainBanLayout.createSequentialGroup()
                .addGroup(pMainBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMainBanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pMainBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pMainBanLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(bChonMon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pMainBanLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(bDoiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainBanLayout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(bHuyBan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 88, Short.MAX_VALUE))
        );
        pMainBanLayout.setVerticalGroup(
            pMainBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainBanLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(bChonMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(bHuyBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(bDoiBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainBanLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout tabBanLayout = new javax.swing.GroupLayout(tabBan);
        tabBan.setLayout(tabBanLayout);
        tabBanLayout.setHorizontalGroup(
            tabBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabBanLayout.setVerticalGroup(
            tabBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabBanLayout.createSequentialGroup()
                .addComponent(pMainBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabDatMon.addTab("Bàn", tabBan);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtTenHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenHD.setText("THÔNG TIN HÓA ĐƠN");

        txtThoiGian.setText("Thời gian");

        jLabel14.setText("Tên KH");

        cbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbNgay.setToolTipText("Ngày");

        cbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbThang.setToolTipText("Tháng");

        cbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
        cbNam.setToolTipText("Năm");

        tbThucDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên món", "SL", "Đơn giá($)"
            }
        ));
        tbThucDon.setGridColor(new java.awt.Color(204, 204, 204));
        tbThucDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThucDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbThucDon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(27, 27, 27)
                        .addComponent(txtTenKH)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtThoiGian)
                                .addGap(18, 18, 18)
                                .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTenHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThoiGian)
                    .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        bTaoBan.setText("Tạo bàn");
        bTaoBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bTaoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTaoBanActionPerformed(evt);
            }
        });

        bThanhToan.setText("Thanh toán");
        bThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(bTaoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(bThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTaoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pThucDon.setBackground(new java.awt.Color(255, 255, 255));
        pThucDon.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pMainThucDonLayout = new javax.swing.GroupLayout(pMainThucDon);
        pMainThucDon.setLayout(pMainThucDonLayout);
        pMainThucDonLayout.setHorizontalGroup(
            pMainThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMainThucDonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pMainThucDonLayout.setVerticalGroup(
            pMainThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainThucDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMainThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabThucDonLayout = new javax.swing.GroupLayout(tabThucDon);
        tabThucDon.setLayout(tabThucDonLayout);
        tabThucDonLayout.setHorizontalGroup(
            tabThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabThucDonLayout.setVerticalGroup(
            tabThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMainThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabDatMon.addTab("Thực đơn", tabThucDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bBan1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan1MouseEntered
        
    }//GEN-LAST:event_bBan1MouseEntered

    private void bBan2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan2MouseEntered
        
    }//GEN-LAST:event_bBan2MouseEntered

    private void bBan3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan3MouseEntered
        
    }//GEN-LAST:event_bBan3MouseEntered

    private void bBan4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan4MouseClicked
        
    }//GEN-LAST:event_bBan4MouseClicked

    private void bBan5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan5MouseEntered
        
    }//GEN-LAST:event_bBan5MouseEntered

    private void bBan6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan6MouseEntered
        
    }//GEN-LAST:event_bBan6MouseEntered

    private void bBan7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan7MouseEntered
        
    }//GEN-LAST:event_bBan7MouseEntered

    private void bBan8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan8MouseEntered
        
    }//GEN-LAST:event_bBan8MouseEntered

    private void bBan9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan9MouseEntered
        
    }//GEN-LAST:event_bBan9MouseEntered

    private void bBan10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan10MouseEntered
        
    }//GEN-LAST:event_bBan10MouseEntered

    private void bBan11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan11MouseEntered
        
    }//GEN-LAST:event_bBan11MouseEntered

    private void bBan12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBan12MouseEntered
        
    }//GEN-LAST:event_bBan12MouseEntered

    private void bBan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan1ActionPerformed
        doiMauNutDangChon(bBan1);
        clickButton(bBan1);
    }//GEN-LAST:event_bBan1ActionPerformed

    private void bBan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan2ActionPerformed
        doiMauNutDangChon(bBan2);
        clickButton(bBan2);
    }//GEN-LAST:event_bBan2ActionPerformed

    private void bBan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan3ActionPerformed
        doiMauNutDangChon(bBan3);
        clickButton(bBan3);
    }//GEN-LAST:event_bBan3ActionPerformed

    private void bBan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan4ActionPerformed
        doiMauNutDangChon(bBan4);
        clickButton(bBan4);
    }//GEN-LAST:event_bBan4ActionPerformed

    private void bBan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan5ActionPerformed
        doiMauNutDangChon(bBan5);
        clickButton(bBan5);
    }//GEN-LAST:event_bBan5ActionPerformed

    private void bBan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan6ActionPerformed
        doiMauNutDangChon(bBan6);
        clickButton(bBan6);
    }//GEN-LAST:event_bBan6ActionPerformed

    private void bBan7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan7ActionPerformed
        doiMauNutDangChon(bBan7);
        clickButton(bBan7);
    }//GEN-LAST:event_bBan7ActionPerformed

    private void bBan8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan8ActionPerformed
        doiMauNutDangChon(bBan8);
        clickButton(bBan8);
    }//GEN-LAST:event_bBan8ActionPerformed

    private void bBan9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan9ActionPerformed
        doiMauNutDangChon(bBan9);
        clickButton(bBan9);
    }//GEN-LAST:event_bBan9ActionPerformed

    private void bBan10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan10ActionPerformed
        doiMauNutDangChon(bBan10);
        clickButton(bBan10);
    }//GEN-LAST:event_bBan10ActionPerformed

    private void bBan11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan11ActionPerformed
        doiMauNutDangChon(bBan11);
        clickButton(bBan11);
    }//GEN-LAST:event_bBan11ActionPerformed

    private void bBan12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBan12ActionPerformed
        doiMauNutDangChon(bBan12);
        clickButton(bBan12);
    }//GEN-LAST:event_bBan12ActionPerformed

    private void bChonMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChonMonActionPerformed
        if(maBan_historyClick!=-1)
        {
            tabDatMon.setSelectedIndex(1);
  //        lamMoiData();
            txtTenHD.setText("THÔNG TIN HÓA ĐƠN BÀN "+maBan_historyClick);
        }
        else
            JOptionPane.showMessageDialog(null, "Chưa chọn bàn nào!!", "Lỗi chọn món", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_bChonMonActionPerformed

    private void bTaoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTaoBanActionPerformed
        //Tức đã chọn bàn, do người code quyết định
        if (txtTenHD.getText().contains("BÀN")) {
                
            if (tbThucDon.getRowCount()!=0) {
                JOptionPane.showMessageDialog(null, "Tạo thành công bàn " + maBan_historyClick, "Successful", JOptionPane.DEFAULT_OPTION);

                dsThongTinBan.dsBan[maBan_historyClick-1].setTrangThaiBan(1);

                String tenKH = txtTenKH.getText();

                String thoiGian = String.valueOf(cbNgay.getSelectedItem())
                        + "/" + String.valueOf(cbThang.getSelectedItem())
                        + "/" + String.valueOf(cbNam.getSelectedItem());

                String dlBangHoaDon = layDuLieuBang();
                //Lưu thông tin bàn theo vị trí tương ứng trong thongTinBan[] dsBan
                //C1
                //        thongTinBan ttb = new thongTinBan(maBan, trangThaiBan_int, thanhTien, tenKH, thoiGian, dlBangHoaDon);
                //        dsBan.themThongTinBan_maBan(maBan_int, ttb);
                //C2
                dsBan.themTTBan_maBan(maBan_historyClick, 1, tenKH, thoiGian, dlBangHoaDon);
            } else {
                JOptionPane.showMessageDialog(null, "Bàn " + maBan_historyClick + " chưa có món!!", "Lỗi tạo bàn", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn bàn nào!!", "Lỗi tạo bàn", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bTaoBanActionPerformed

    private void bHuyBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHuyBanActionPerformed
        //Đã click chọn bàn
        if(maBan_historyClick!=-1)
        {
            if(dsBan.kiemTraBan_isCoNguoi(maBan_historyClick))//Có người mới thanh toán được
            {
                if(JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy bàn?", "Hủy bàn", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE )==0)
                {
                    dsThongTinBan.dsBan[maBan_historyClick-1]=new thongTinBan(String.valueOf(maBan_historyClick), 0, null, "1/1/2015", null);

                    lamMoiData();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Bàn "+maBan_historyClick+" chưa được tạo!!", "Lỗi hủy bàn", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Chưa chọn bàn nào!!",  "Lỗi hủy bàn", JOptionPane.ERROR_MESSAGE);               
    }//GEN-LAST:event_bHuyBanActionPerformed

    private void bDoiBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDoiBanActionPerformed
        //Đổi phải từ bàn có người sang bàn không người
        if (maBan_historyClick != -1) {
            if (dsBan.kiemTraBan_isCoNguoi(maBan_historyClick)) {
                int maBanCu = maBan_historyClick;
                String maBanMoi_string = JOptionPane.showInputDialog(this, "Nhập mã bàn mới(khác mã bàn " + maBanCu + " hiện tại)", "Đổi bàn", JOptionPane.DEFAULT_OPTION);
                int maBanMoi = Integer.parseInt(maBanMoi_string);

                if (maBanMoi == maBanCu) {
                    JOptionPane.showMessageDialog(null, "Mã bàn mới phải khác mã bàn cũ!!", "Lỗi đổi bàn", JOptionPane.ERROR_MESSAGE);
                } else if (maBanMoi > 12 || maBanMoi <= 0) {
                    JOptionPane.showMessageDialog(null, "Mã bàn mới không hợp lệ!!", "Lỗi đổi bàn", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (dsBan.kiemTraBan_isCoNguoi(maBanMoi))//Bàn muốn đổi sang có người
                    {
                        JOptionPane.showMessageDialog(null, "Bàn " + maBanMoi + " đã có người. Chọn bàn khác!!", "Lỗi đổi bàn", JOptionPane.ERROR_MESSAGE);
                    } else {
                        dsBan.doiCho2Ban(maBanCu, maBanMoi);
                        //Con trỏ đang trỏ vào bàn cũ, bàn cũ cam- có người thành màu xanh - trống

                        lamMoiData();

                        setMauNut_maBan(maBanMoi);

                        JOptionPane.showMessageDialog(null, "Đổi thành công bàn " + maBanCu + " sang bàn " + maBanMoi, "Successfull", JOptionPane.DEFAULT_OPTION);
                    }
                }
            } else 
                    JOptionPane.showMessageDialog(null, "Bàn " + maBan_historyClick + " chưa được tạo!!", "Lỗi đổi bàn", JOptionPane.ERROR_MESSAGE);

        } else
            JOptionPane.showMessageDialog(null, "Chưa chọn bàn nào!!", "Lỗi đổi bàn", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_bDoiBanActionPerformed

    private void tbThucDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThucDonMouseClicked
        int index = tbThucDon.getSelectedRow();
        
        String slMoi = JOptionPane.showInputDialog(this, "Nhập số lượng mới", "Đổi số lượng", JOptionPane.DEFAULT_OPTION);
        if(slMoi!=null)
        {
            int slMoi_int = Integer.parseInt(slMoi);
            if(slMoi_int>1)
            {
                dtm.setValueAt(slMoi, index, 2);
            }
            else if(slMoi_int==0)
            {
                dtm.removeRow(index);
                tbThucDon.setModel(dtm);
//                layDuLieuTuDsBan(maBan_historyClick);
            }
            else if(slMoi.contains("-"))
            {
                dtm.removeRow(index);
                tbThucDon.setModel(dtm);
            }
        }
    }//GEN-LAST:event_tbThucDonMouseClicked

    private void bThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThanhToanActionPerformed
        if(maBan_historyClick==-1)
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn bàn nào!!", "Lỗi thanh toán", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(dsBan.kiemTraBan_isCoNguoi(maBan_historyClick))
            {
                //Thanh toán-> Lưu hd vào dsHD-> đọc từ file dsHD để lấy UI_HD       
                String tenKH = dsThongTinBan.dsBan[maBan_historyClick-1].getTenKH();
                String thoiGian = dsThongTinBan.dsBan[maBan_historyClick-1].getThoiGian();
                String dlBang = dsThongTinBan.dsBan[maBan_historyClick-1].getDuLieuBang_theoBan();
                dsHD.themHoaDonMoi(tenKH, thoiGian, dlBang);
                
                try {
                    //Lưu vào file
                    dsHD.luuVaoFile(JavaSwingCNPM_VIP.duongDanDSHD);
                } catch (IOException ex) {
                    Logger.getLogger(QLDatMon_LeTan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Thông báo xem hóa đơn
                String strThanhToan = "Tên khách hàng: "+txtTenKH.getText()+"\nChi phí hóa đơn: "+tinhTotal()+"\nXem chi tiết hóa đơn?";
        
                if(JOptionPane.showConfirmDialog(this,strThanhToan , "Thanh toán thành công", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE )==0)
                {
                    //Giao diện hóa đơn
                    ChiTietHD UI_HD = new ChiTietHD();
                    //Chỉ có thể thao tác trên hóa đơn
                    UI_HD.setLocationRelativeTo(this);

                    UI_HD.setVisible(true);
                }
                 //Thanh toán thì bàn thành trống
                    dsThongTinBan.dsBan[maBan_historyClick-1]=new thongTinBan(String.valueOf(maBan_historyClick), 0, null, "1/1/2015", null);   
                    lamMoiData();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Bàn "+maBan_historyClick+" chưa được tạo!!", "Lỗi thanh toán", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_bThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBan1;
    private javax.swing.JButton bBan10;
    private javax.swing.JButton bBan11;
    private javax.swing.JButton bBan12;
    private javax.swing.JButton bBan2;
    private javax.swing.JButton bBan3;
    private javax.swing.JButton bBan4;
    private javax.swing.JButton bBan5;
    private javax.swing.JButton bBan6;
    private javax.swing.JButton bBan7;
    private javax.swing.JButton bBan8;
    private javax.swing.JButton bBan9;
    private util.ButtonGradient bChonMon;
    private util.ButtonGradient bDoiBan;
    private util.ButtonGradient bHuyBan;
    private util.ButtonGradient bTaoBan;
    private util.ButtonGradient bThanhToan;
    private javax.swing.JComboBox<String> cbNam;
    private javax.swing.JComboBox<String> cbNgay;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    private util.PanelGradient pMainBan;
    private util.PanelGradient pMainThucDon;
    private javax.swing.JPanel pThucDon;
    private javax.swing.JPanel tabBan;
    private javax.swing.JTabbedPane tabDatMon;
    private javax.swing.JPanel tabThucDon;
    public static javax.swing.JTable tbThucDon;
    private javax.swing.JLabel txtTenHD;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JLabel txtThoiGian;
    // End of variables declaration//GEN-END:variables
}
