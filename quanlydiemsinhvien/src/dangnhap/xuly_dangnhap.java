/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangnhap;

import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class xuly_dangnhap implements truyvandulieu<dangnhap>{
        final String gv = "giangvien";
        final String sv = "sv";
        khoa_ketnoi_sql khoa = new khoa_ketnoi_sql();
    public boolean kiemtra(String user ,String pass)
    {
        boolean ketqua = false;///
        try {
            Connection conn = khoa.getInstan();
            
            String sql = "select * from " + gv + " where TenDangNhap = ? and MatKhau = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                ketqua = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    public boolean kiemtraSV(String user, String pass) {
        boolean ketqua = false;
        try {
            Connection conn = khoa.getInstan();
            // Truy vấn bảng SinhVien
            String sql = "select * from " + sv + " where TenDangNhap = ? and MatKhau = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ketqua = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    @Override
    public List<dangnhap> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<dangnhap> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(dangnhap t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(dangnhap t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(dangnhap t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean doiMatKhau(String user, String passMoi) {
        boolean ketqua = false;
        try {
            Connection conn = khoa.getInstan();
            
            String sql = "UPDATE GiangVien SET MatKhau = ? WHERE TenDangNhap = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, passMoi); // Tham số 1: Mật khẩu mới
            ps.setString(2, user);    // Tham số 2: Tên đăng nhập
            
           
            int row = ps.executeUpdate();
            if (row > 0) {
                ketqua = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    public boolean doiMatKhauSV(String user, String passMoi) {
        boolean ketqua = false;
        try {
            Connection conn = khoa.getInstan();
            
            
            String sql = "UPDATE SV SET MatKhau = ? WHERE TenDangNhap = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, passMoi); 
            ps.setString(2, user);    
            
            int row = ps.executeUpdate();
            if (row > 0) {
                ketqua = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    
    public static void main(String[] args) {
        xuly_dangnhap xuly = new xuly_dangnhap();
        boolean check = xuly.kiemtra("dungvt", "1234");
        if(check){
            System.out.println("Test thành công: Đăng nhập được!");
        } else {
            System.out.println("Test thất bại: Sai tên hoặc lỗi kết nối.");
        }
    }

    

}
