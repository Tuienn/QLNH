/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MySql;

import JavaPerson.KhachHang;
import JavaPerson.NhanVien;
import LeTan.monAn;
import QuanLy.hoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseHandler {

    private Connection connection;

    // Constructor nhận kết nối từ DatabaseConnection
    public DatabaseHandler() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Phương thức để lưu dữ liệu hóa đơn
    public boolean saveHoaDon(ArrayList<hoaDon> dsHD) {
        String deleteSql = "DELETE FROM hoaDon";
        String insertSql = "INSERT INTO hoaDon (tenKH, thoiGian, dlBangThucDon) VALUES (?, ?, ?)";

        try {
            // Tắt chế độ tự động commit để quản lý giao dịch
            connection.setAutoCommit(false);

            // Bước 1: Xóa tất cả các bản ghi trong bảng
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
                deleteStmt.executeUpdate();
            }

            // Bước 2: Thêm lại các bản ghi từ danh sách
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                for (hoaDon hoaDon : dsHD) {
                    insertStmt.setString(1, hoaDon.getTenKH());
                    insertStmt.setString(2, hoaDon.getThoiGian());
                    insertStmt.setString(3, hoaDon.getDlBangThucDon());

                    // Thêm vào batch
                    insertStmt.addBatch();
                }

                // Thực thi batch
                insertStmt.executeBatch();
            }

            // Commit giao dịch
            connection.commit();
            return true; // Trả về true nếu lưu thành công

        } catch (SQLException e) {
            System.err.println("Lỗi khi lưu hoaDon: " + e.getMessage());
            try {
                connection.rollback(); // Rollback nếu có lỗi
            } catch (SQLException rollbackEx) {
                System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
            }
            return false; // Trả về false nếu có lỗi

        } finally {
            try {
                connection.setAutoCommit(true); // Bật lại chế độ tự động commit
            } catch (SQLException ex) {
                System.err.println("Lỗi khi bật lại auto-commit: " + ex.getMessage());
            }
        }
    }

    // Phương thức để lấy tất cả hóa đơn từ cơ sở dữ liệu
    public void getAllHoaDon(ArrayList<hoaDon> dsHD) {
        String sql = "SELECT * FROM hoaDon"; // Truy vấn tất cả hóa đơn từ bảng hoaDon
        try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            dsHD.clear();
            while (rs.next()) {
                String tenKH = rs.getString("tenKH");
                String thoiGian = rs.getString("thoiGian");
                String dlBangThucDon = rs.getString("dlBangThucDon");
                hoaDon hoaDonItem = new hoaDon(tenKH, thoiGian, dlBangThucDon);
                // In ra các thông tin hóa đơn
                System.out.println(hoaDonItem.toString());
                dsHD.add(hoaDonItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để lưu khách hàng vào cơ sở dữ liệu
    public boolean saveKhachHang(ArrayList<KhachHang> dsKH) {
        String deleteSql = "DELETE FROM khachhang";
        String insertSql = "INSERT INTO khachhang (taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            // Tắt chế độ tự động commit để quản lý giao dịch
            connection.setAutoCommit(false);

            // Bước 1: Xóa tất cả các bản ghi trong bảng
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
                deleteStmt.executeUpdate();
            }

            // Bước 2: Thêm lại các bản ghi từ danh sách
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                for (KhachHang khachHang : dsKH) {
                    insertStmt.setString(1, khachHang.getTaiKhoan());
                    insertStmt.setString(2, khachHang.getMatKhau());
                    insertStmt.setString(3, khachHang.getHoTen());
                    insertStmt.setString(4, khachHang.getNgaySinh());
                    insertStmt.setString(5, khachHang.getGioiTinh());
                    insertStmt.setString(6, khachHang.getDiaChi());
                    insertStmt.setString(7, khachHang.getSDT());

                    // Thêm vào batch
                    insertStmt.addBatch();
                }

                // Thực thi batch
                insertStmt.executeBatch();
            }

            // Commit giao dịch
            connection.commit();
            return true; // Trả về true nếu lưu thành công

        } catch (SQLException e) {
            System.err.println("Lỗi khi lưu khachHang: " + e.getMessage());
            try {
                connection.rollback(); // Rollback nếu có lỗi
            } catch (SQLException rollbackEx) {
                System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
            }
            return false; // Trả về false nếu có lỗi

        } finally {
            try {
                connection.setAutoCommit(true); // Bật lại chế độ tự động commit
            } catch (SQLException ex) {
                System.err.println("Lỗi khi bật lại auto-commit: " + ex.getMessage());
            }
        }
    }

    // Phương thức lấy tất cả khách hàng
    public void getAllKhachHang(ArrayList<KhachHang> dsKH) {
        String sql = "SELECT * FROM khachhang";

        try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            dsKH.clear();
            while (rs.next()) {
                String taiKhoan = rs.getString("taiKhoan");
                String matKhau = rs.getString("matKhau");
                String hoTen = rs.getString("hoTen");
                String ngaySinh = rs.getString("ngaySinh");
                String gioiTinh = rs.getString("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String SDT = rs.getString("SDT");

                // Tạo đối tượng KhachHang từ dữ liệu truy vấn
                KhachHang khachHang = new KhachHang(taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT);
                System.out.println(khachHang.toString());
                dsKH.add(khachHang);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để lưu nhân viên vào cơ sở dữ liệu
    public boolean saveNhanVien(ArrayList<NhanVien> dsNV) {
        String deleteSql = "DELETE FROM nhanvien";
        String insertSql = "INSERT INTO nhanvien (taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT, chucVu, filePathImage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Tắt chế độ tự động commit để quản lý giao dịch
            connection.setAutoCommit(false);

            // Bước 1: Xóa tất cả các bản ghi trong bảng
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
                deleteStmt.executeUpdate();
            }

            // Bước 2: Thêm lại các bản ghi từ danh sách
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                for (NhanVien nhanVien : dsNV) {
                    insertStmt.setString(1, nhanVien.getTaiKhoan());
                    insertStmt.setString(2, nhanVien.getMatKhau());
                    insertStmt.setString(3, nhanVien.getHoTen());
                    insertStmt.setString(4, nhanVien.getNgaySinh());
                    insertStmt.setString(5, nhanVien.getGioiTinh());
                    insertStmt.setString(6, nhanVien.getDiaChi());
                    insertStmt.setString(7, nhanVien.getSDT());
                    insertStmt.setInt(8, nhanVien.getChucVu());
                    insertStmt.setString(9, nhanVien.getFilePathImage());

                    // Thêm vào batch
                    insertStmt.addBatch();
                }

                // Thực thi batch
                insertStmt.executeBatch();
            }

            // Commit giao dịch
            connection.commit();
            return true; // Trả về true nếu lưu thành công

        } catch (SQLException e) {
            System.err.println("Lỗi khi lưu nhanVien: " + e.getMessage());
            try {
                connection.rollback(); // Rollback nếu có lỗi
            } catch (SQLException rollbackEx) {
                System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
            }
            return false; // Trả về false nếu có lỗi

        } finally {
            try {
                connection.setAutoCommit(true); // Bật lại chế độ tự động commit
            } catch (SQLException ex) {
                System.err.println("Lỗi khi bật lại auto-commit: " + ex.getMessage());
            }
        }
    }

    // Phương thức để lấy tất cả nhân viên
    public void getAllNhanVien(ArrayList<NhanVien> dsNV) {
        String sql = "SELECT * FROM nhanvien";
        try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            dsNV.clear();
            while (rs.next()) {
                String taiKhoan = rs.getString("taiKhoan");
                String matKhau = rs.getString("matKhau");
                String hoTen = rs.getString("hoTen");
                String ngaySinh = rs.getString("ngaySinh");
                String gioiTinh = rs.getString("gioiTinh");
                String diaChi = rs.getString("diaChi");
                String SDT = rs.getString("SDT");
                int chucVu = rs.getInt("chucVu");
                String filePathImage = rs.getString("filePathImage");

                // Tạo đối tượng NhanVien từ dữ liệu truy vấn
                NhanVien nhanVien = new NhanVien(taiKhoan, matKhau, hoTen, ngaySinh, gioiTinh, diaChi, SDT, chucVu, filePathImage);

                // In thông tin nhân viên ra màn hình (hoặc xử lý khác nếu cần)
                System.out.println(nhanVien.toString());
                dsNV.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //lưu món ăn
    public boolean luuMonAn(ArrayList<monAn> dsMon) {
        String deleteSql = "DELETE FROM monan";
        String insertSql = "INSERT INTO monan (maMonAn, tenMonAn, maDanhMuc, gia, filePathImage) VALUES (?, ?, ?, ?, ?)";

        try {
            // Tắt chế độ tự động commit để quản lý giao dịch
            connection.setAutoCommit(false);

            // Bước 1: Xóa tất cả các bản ghi trong bảng
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {
                deleteStmt.executeUpdate();
            }

            // Bước 2: Thêm lại các bản ghi từ danh sách
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                for (monAn monAn : dsMon) {
                    insertStmt.setString(1, monAn.getMaMonAn());
                    insertStmt.setString(2, monAn.getTenMonAn());
                    insertStmt.setString(3, monAn.getMaDanhMuc());
                    insertStmt.setDouble(4, monAn.getGia());
                    insertStmt.setString(5, monAn.getFilePathImage());

                    // Thêm vào batch
                    insertStmt.addBatch();
                }

                // Thực thi batch
                insertStmt.executeBatch();
            }

            // Commit giao dịch
            connection.commit();
            return true; // Trả về true nếu lưu thành công

        } catch (SQLException e) {
            System.err.println("Lỗi khi lưu món ăn: " + e.getMessage());
            try {
                connection.rollback(); // Rollback nếu có lỗi
            } catch (SQLException rollbackEx) {
                System.err.println("Lỗi khi rollback: " + rollbackEx.getMessage());
            }
            return false; // Trả về false nếu có lỗi

        } finally {
            try {
                connection.setAutoCommit(true); // Bật lại chế độ tự động commit
            } catch (SQLException ex) {
                System.err.println("Lỗi khi bật lại auto-commit: " + ex.getMessage());
            }
        }
    }

    // lấy tất cả món ăn
    public void getAllMonAn(ArrayList<monAn> dsMon) {
        String sql = "SELECT * FROM monan";
        try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            dsMon.clear();
            while (rs.next()) {
                String maMonAn = rs.getString("maMonAn");
                String tenMonAn = rs.getString("tenMonAn");
                String maDanhMuc = rs.getString("maDanhMuc");
                double gia = rs.getDouble("gia");
                String filePathImage = rs.getString("filePathImage");

                // Tạo đối tượng monAn từ dữ liệu truy vấn
                monAn monAnItem = new monAn(maMonAn, tenMonAn, maDanhMuc, gia, filePathImage);

                // In thông tin món ăn ra màn hình (hoặc xử lý khác nếu cần)
                System.out.println(monAnItem.toString());
                dsMon.add(monAnItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
