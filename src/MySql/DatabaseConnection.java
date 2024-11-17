/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MySql;

/**
 *
 * @author vien1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    // Phương thức để tạo kết nối
    public static void connect() {
        String url = "jdbc:mysql://localhost:3306/qlnh"; // Thay 'qlnh' bằng tên database của bạn
        String user = "root"; // Thay bằng username của bạn
        String password = "123456"; // Thay bằng password của bạn

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để ngắt kết nối
    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Ngắt kết nối thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getter để lấy kết nối
    public static Connection getConnection() {
        return connection;
    }
}

