INSERT INTO hoaDon (tenKH, thoiGian, dlBangThucDon) VALUES
('Nguyễn Văn Nam', '2022-04-04', 'Phở bò-1-2.5/Phở bò-1-2.5/'),
('Nguyễn Văn Hùng', '2022-04-03', 'Thịt nướng-1-5.5/KimChi cay-1-2.5/Thịt nướng-1-5.5/Phở bò-5-2.5/Cơm rang-1-2.5/'),
('Anh', '2019-04-04', 'Phở-1-2.5/Phở-1-2.5/KipBap-1-2.0/Đậu phụ-1-1.5/'),
('Nguyễn Văn Anh', '2018-04-04', 'KipBap-1-2.0/KimChi-1-2.5/Thịt BBQ-1-3.0/KipBap-1-2.0/KimChi-1-2.5/Thịt BBQ-1-3.0/KipBap-1-2.0/KimChi-1-2.5/Thịt BBQ-1-3.0/KimChi-1-2.5/KipBap-1-2.0/KimChi-1-2.5/KimChi-1-2.5/KimChi-1-2.5/KimChi-1-2.5/KimChi-1-2.5/KimChi-1-2.5/Thịt BBQ-1-3.0/Thịt BBQ-1-3.0/KimChi-1-2.5/KipBap-1-2.0/KimChi-1-2.5/Thịt BBQ-1-3.0/'),
('Nam Nguyễn', '2015-01-01', 'KimChi-1-2.5/Thịt BBQ-1-3.0/KimBap-1-2.0/Đậu phụ-1-1.5/Gà nướng-1-5.5/Lẩu cay-1-5.5/Gà nướng-1-5.5/Lẩu cay-1-5.5/'),
('Nguyễn Ngọc Tuyền', '2019-05-04', 'Súp nấm-1-2.5/Gà nướng-1-5.5/Lẩu cay-1-5.5/Đậu phụ-1-1.5/'),
('Viễn', '2015-01-01', 'Bánh mỳ-1-2.0/Nem rán-1-2.0/Thịt xiên-1-1.5/Súp nấm-1-2.5/Gà nướng-1-5.5/Lẩu cay-1-5.5/'),
('Quang', '2019-06-05', 'Thịt BBQ-1-3.0/KimChi-3-2.5/Súp nấm-1-2.5/Lẩu cay-1-5.5/Gà nướng-2-5.5/KimBap-1-2.0/Cơm rang-1-2.0/Bánh mỳ-1-2.0/'),
('Tú', '2015-01-01', 'Thịt BBQ-1-3.0/KimChi-1-2.5/');

INSERT INTO khachhang (taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT)
VALUES
('KH1', '123', 'Lê Công Bảo Ngọc', STR_TO_DATE('18/5/2003', '%d/%m/%Y'), 'Nữ', 'Thanh Hóa', '0382347582');

INSERT INTO nhanvien (taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT, chucVu, filePathImage) VALUES
('LT1', '123', 'Nguyễn Thị Hồng Ngân', '2003-04-01', 'Nữ', 'Quảng Ninh', '0382322519', 1, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\Ngann.jpg'),
('PV1', '123', 'Nguyễn Quang Anh', '2003-07-04', 'Nam', 'Nam Định', '01123455678', 0, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\QAnh.jpg'),
('PV2', '123', 'Cao Nhật Minh', '2002-05-04', 'Nam', 'Thái Bình', '0495828028', 0, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\CMinh.jpg'),
('TK1', '123', 'Nguyễn Văn Hiếu', '2003-05-01', 'Nam', 'Phú Thọ', '0968378924', 2, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\Hieu.jpg');

INSERT INTO monan (maMonAn, tenMonAn, maDanhMuc, gia, filePathImage) VALUES
('H1', 'KimBap', '1', 2.0, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\kimbap.png'),
('T1', 'Đậu phụ', '3', 1.5, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\stinky-tofu.png'),
('T2', 'Súp nấm', '3', 2.5, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\soup.png'),
('V2', 'Thịt xiên', '1', 1.5, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\skewer.png'),
('H2', 'KimChi', '2', 2.5, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\kimchi.png'),
('T3', 'Lẩu cay', '3', 5.5, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\hot-pot.png'),
('T4', 'Há cảo', '3', 1.0, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\gyoza.png'),
('V3', 'Nem rán', '3', 2.0, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\fried-spring-rolls.png'),
('V4', 'Cơm rang', '1', 2.5, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\fried-rice.png'),
('T5', 'Gà nướng', '3', 5.5, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\chicken.png'),
('V5', 'Bánh mỳ', '1', 2.0, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\bread.png'),
('H3', 'Thịt BBQ', '2', 3.0, 'C:\\Users\\vien1\\Downloads\\OceanTech\\monPTPMUngDung\\JavaSwingCNPM_VIP\\FileImage\\barbecue.png');
