CREATE TABLE hoaDon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tenKH VARCHAR(255) NOT NULL,
    thoiGian DATE NOT NULL,
    dlBangThucDon TEXT NOT NULL
);

CREATE TABLE khachhang (
    taiKhoan VARCHAR(50) PRIMARY KEY,
    matKhau VARCHAR(100),
    hoTen VARCHAR(100),
    ngaySinh DATE,
    gioiTinh VARCHAR(10),
    diaChi VARCHAR(255),
    SDT VARCHAR(20)
);

CREATE TABLE nhanvien (
    taiKhoan VARCHAR(50) PRIMARY KEY,
    matKhau VARCHAR(50),
    hoTen VARCHAR(100),
    ngaySinh DATE,
    gioiTinh VARCHAR(10),
    diaChi VARCHAR(100),
    SDT VARCHAR(15),
    chucVu INT,
    filePathImage VARCHAR(255)
);

CREATE TABLE monan (
    maMonAn VARCHAR(10) PRIMARY KEY,
    tenMonAn VARCHAR(100) NOT NULL,
    maDanhMuc VARCHAR(10) NOT NULL,
    gia DOUBLE NOT NULL,
    filePathImage VARCHAR(255)
);
