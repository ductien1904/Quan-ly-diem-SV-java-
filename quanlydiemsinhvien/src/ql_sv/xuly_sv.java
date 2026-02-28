/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ql_sv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class xuly_sv {
    khoa_ketnoi_sv db = new khoa_ketnoi_sv();

    public List<SinhVien> getALL() {
        List<SinhVien> ds = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try (Connection conn = db.open(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                ds.add(new SinhVien(rs.getString("MaSV"), rs.getString("HoTen"), rs.getString("MaLop"),
                        rs.getDate("NgaySinh"), rs.getString("GioiTinh"), rs.getString("SDT"), rs.getString("DiaChi")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ds;
    }

    public List<SinhVien> getByLop(String maLop) {
        List<SinhVien> ds = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien WHERE MaLop = ?";
        try (Connection conn = db.open(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new SinhVien(rs.getString("MaSV"), rs.getString("HoTen"), rs.getString("MaLop"),
                        rs.getDate("NgaySinh"), rs.getString("GioiTinh"), rs.getString("SDT"), rs.getString("DiaChi")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ds;
    }

    public boolean insert(SinhVien sv) {
        String sql = "INSERT INTO sinhvien VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.open(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setDate(3, new java.sql.Date(sv.getNgaySinh().getTime()));
            ps.setString(4, sv.getGioiTinh());
            ps.setString(5, sv.getSDT());
            ps.setString(6, sv.getDiaChi());
            ps.setString(7, sv.getMaLop());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { return false; }
    }
    
    public boolean delete(String maSV) {
        try (Connection conn = db.open(); PreparedStatement ps = conn.prepareStatement("DELETE FROM sinhvien WHERE MaSV=?")) {
            ps.setString(1, maSV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { return false; }
    }

  

    public boolean update(SinhVien sv) {
    String sql = "UPDATE sinhvien SET HoTen=?, NgaySinh=?, GioiTinh=?, SDT=?, DiaChi=?, MaLop=? WHERE MaSV=?";
    
    try (Connection conn = db.open(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        // truyền các giá trị vào dấu ? theothứ tự
        ps.setString(1, sv.getHoTen());
        ps.setDate(2, new java.sql.Date(sv.getNgaySinh().getTime())); // sang java.sql.Date
        ps.setString(3, sv.getGioiTinh());
        ps.setString(4, sv.getSDT());
        ps.setString(5, sv.getDiaChi());
        ps.setString(6, sv.getMaLop());
        ps.setString(7, sv.getMaSV());
        
        return ps.executeUpdate() > 0; // Trả về true nếu cập nhật thành công
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
   

public boolean kiemTraTrungMa(String maSV) {
    String sql = "SELECT COUNT(*) FROM sinhvien WHERE MaSV = ?";
    
    try (Connection conn = db.open(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, maSV);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu tìm thấy mã trùng
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
public boolean kiemTraTrungMaSua(String maCu, String maMoi) {
    String sql = "SELECT COUNT(*) FROM sinhvien WHERE MaSV = ? AND MaSV <> ?";
    try (Connection conn = db.open();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, maMoi);
        ps.setString(2, maCu);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getInt(1) > 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}



}