
package monhoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author admin
 */
public class ketnoi_monhoc {
        private String user = "root";
        private String password = "";
        private String post = "3306";
        private String host = "localhost";
        private String database = "qlddh_vutiendung";
        private String url = "jdbc:mysql://" + host + ":" + post + "/" + database;
        Connection conn = null;
        
        public Connection getInstan() {
    try {
        // Nếu conn đã đóng hoặc chưa khởi tạo, thì mở mới
        if (conn == null || conn.isClosed()) {
            return open();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return conn;
}
        public Connection open()
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return conn;
        }
        public void close(){
            try {
                if(conn != null)
                {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public static void main(String[] args) {
            ketnoi_monhoc mh = new ketnoi_monhoc();
            Connection conn = mh.getInstan();
            if(conn != null )
            {
                System.out.println("Ket Noi Thanh Cong");
                mh.close();
            }else{
                System.out.println("Ket Noi Khong Thanh Cong");
            }
        }

    }
