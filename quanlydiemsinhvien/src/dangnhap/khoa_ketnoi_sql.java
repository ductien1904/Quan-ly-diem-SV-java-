    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package dangnhap;

    import java.sql.Connection;
    import java.sql.DriverManager;
    /**
     *
     * @author Admin
     */
    public class khoa_ketnoi_sql {
        private String user = "root";
        private String password = "";
        private String post = "3306";
        private String host = "localhost";
        private String database = "qlddh_vutiendung";
        private String url = "jdbc:mysql://" + host + ":" + post + "/" + database;
        Connection conn = null;
        public Connection getInstan(){
            if(conn != null)
            {
                return  conn;
            }
            return open();
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
            khoa_ketnoi_sql khoa = new khoa_ketnoi_sql();
            Connection conn = khoa.getInstan();
            if(khoa != null )
            {
                System.out.println("Ket Noi Thanh Cong");
                khoa.close();
            }else{
                System.out.println("Ket Noi Khong Thanh Cong");
            }
        }

    }
