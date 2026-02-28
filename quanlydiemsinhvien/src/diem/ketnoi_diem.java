/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diem;

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ketnoi_diem {
    // Cấu hình thông số kết nối (Đảm bảo giống với MySQL của bạn)
    private final String user = "root";
    private final String password = "";
    private final String post = "3306";
    private final String host = "localhost";
    private final String database = "qlddh_vutiendung";
    private final String url = "jdbc:mysql://" + host + ":" + post + "/" + database + "?useUnicode=true&characterEncoding=UTF-8";
    
    private Connection conn = null;

    /**
     * Hàm lấy kết nối (Singleton pattern)
     * Đảm bảo luôn trả về một kết nối đang mở
     */
    public Connection getInstan() {
        try {
            // Nếu kết nối chưa tồn tại hoặc đã bị đóng, thì thực hiện mở mới
            if (conn == null || conn.isClosed()) {
                return open();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * Hàm thực hiện mở kết nối tới MySQL
     */
    public Connection open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Lỗi kết nối: " + ex.getMessage());
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * Hàm đóng kết nối khi không sử dụng
     */
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
            ketnoi_diem diem = new ketnoi_diem();
            Connection conn = diem.getInstan();
            if(conn != null )
            {
                System.out.println("Ket Noi Thanh Cong");
                diem.close();
            }else{
                System.out.println("Ket Noi Khong Thanh Cong");
            }
        }
}
