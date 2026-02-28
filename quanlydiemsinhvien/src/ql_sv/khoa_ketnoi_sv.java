/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ql_sv;

import java.sql.Connection;
import java.sql.DriverManager;

public class khoa_ketnoi_sv {

    private String url = "jdbc:mysql://localhost:3306/qlddh_vutiendung";
    private String user = "root"; 
    private String pass = ""; 

    public Connection open() {
        try {
            // Nạp Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Mở kết nối
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
            return null;
        }
    }
}