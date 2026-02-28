package ql_lophoc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class xuly_lop implements truyvandulieu_lop<lop> {

    private final khoa_ketnoi_lop db = new khoa_ketnoi_lop(); //

    @Override
    public List<lop> getALL() {
        List<lop> dsLop = new ArrayList<>();
        String sql = "SELECT * FROM lop"; //
        
        try (Connection conn = db.open(); 
             Statement st = conn.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                lop l = new lop();
                l.setId(rs.getInt("id")); 
                l.setMaLop(rs.getString("MaLop")); 
                l.setTenLop(rs.getString("TenLop")); 
                l.setKhoaHoc(rs.getString("KhoaHoc")); 
                l.setMaChuyenNganh(rs.getString("MaChuyenNganh")); 
                l.setGVCN(rs.getString("GVCN")); 
                l.setSDT(rs.getString("SDT")); 
                dsLop.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLop;
    }

    @Override
    public Optional<lop> get(int id) {
        String sql = "SELECT * FROM lop WHERE id = ?"; 
        
        try (Connection conn = db.open(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    lop l = new lop();
                    l.setId(rs.getInt("id"));
                    l.setMaLop(rs.getString("MaLop"));
                    l.setTenLop(rs.getString("TenLop"));
                    l.setKhoaHoc(rs.getString("KhoaHoc"));
                    l.setMaChuyenNganh(rs.getString("MaChuyenNganh"));
                    l.setGVCN(rs.getString("GVCN"));
                    l.setSDT(rs.getString("SDT"));
                    return Optional.of(l);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
 
public List<String> getDanhSachKhoa() {//để nạp vào combobox
    List<String> dsKhoa = new ArrayList<>();
    //distinct để lấy giá trị duy nhất
    String sql = "SELECT DISTINCT KhoaHoc FROM lop"; 
    
    try (Connection conn = db.open(); 
         Statement st = conn.createStatement(); 
         ResultSet rs = st.executeQuery(sql)) {
        
        while (rs.next()) {
            dsKhoa.add(rs.getString("KhoaHoc"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dsKhoa;
}

public List<lop> getByKhoa(String khoaHoc) {
    List<lop> dsLop = new ArrayList<>();
    
    String sql = "SELECT * FROM lop WHERE KhoaHoc = ?"; 
    
    try (Connection conn = db.open(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, khoaHoc);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lop l = new lop();
                l.setId(rs.getInt("id"));
                l.setMaLop(rs.getString("MaLop"));
                l.setTenLop(rs.getString("TenLop"));
                l.setKhoaHoc(rs.getString("KhoaHoc"));
                l.setMaChuyenNganh(rs.getString("MaChuyenNganh"));
                l.setGVCN(rs.getString("GVCN"));
                l.setSDT(rs.getString("SDT"));
                dsLop.add(l);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dsLop;
}

    @Override
    public int insert(lop t) {
        
        String sql = "INSERT INTO lop (MaLop, TenLop, KhoaHoc, MaChuyenNganh, GVCN, SDT) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = db.open(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, t.getMaLop());
            ps.setString(2, t.getTenLop());
            ps.setString(3, t.getKhoaHoc());
            ps.setString(4, t.getMaChuyenNganh());
            ps.setString(5, t.getGVCN());
            ps.setString(6, t.getSDT());
            
            return ps.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean update(lop t) {
        
        String sql = "UPDATE lop SET MaLop = ?, TenLop = ?, KhoaHoc = ?, MaChuyenNganh = ?, GVCN = ?, SDT = ? WHERE id = ?";
        
        try (Connection conn = db.open(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, t.getMaLop());
            ps.setString(2, t.getTenLop());
            ps.setString(3, t.getKhoaHoc());
            ps.setString(4, t.getMaChuyenNganh());
            ps.setString(5, t.getGVCN());
            ps.setString(6, t.getSDT());
            ps.setInt(7, t.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(lop t) {
        return delete(t.getId()); 
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM lop WHERE id = ?"; //
        
        try (Connection conn = db.open(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
public java.util.List<String> getUniqueKhoa() {
    java.util.List<String> dsKhoa = new java.util.ArrayList<>();
    // distinct: tránh trùng lặp
    String sql = "SELECT DISTINCT KhoaHoc FROM lop"; 
    
    try (java.sql.Connection conn = db.open(); 
         java.sql.Statement st = conn.createStatement(); 
         java.sql.ResultSet rs = st.executeQuery(sql)) {
        
        while (rs.next()) {
            dsKhoa.add(rs.getString("KhoaHoc")); 
        }
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
    }
    return dsKhoa;
}

public List<String> getTenNganh() {
    List<String> ds = new ArrayList<>();
 
    String sql = "SELECT TenChuyenNganh FROM chuyennganh"; 
    khoa_ketnoi_lop ketNoi = new khoa_ketnoi_lop(); 
    
    try (Connection conn = ketNoi.open(); 
         Statement st = conn.createStatement(); 
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            ds.add(rs.getString("TenChuyenNganh"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ds;
}
// Trong xuly_lop.java
public List<String> getDanhSachNganh() {
    List<String> ds = new ArrayList<>();
    
    String sql = "SELECT MaChuyenNganh FROM chuyennganh"; 
    try (Connection conn = db.open(); 
         Statement st = conn.createStatement(); 
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            ds.add(rs.getString("MaChuyenNganh"));
        }
    } catch (SQLException e) { e.printStackTrace(); }
    return ds;
}

public boolean kiemTraTrungMa(String maLop) {
   
    String sql = "SELECT COUNT(*) FROM lop WHERE MaLop = ?";
    
    try (Connection conn = db.open(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, maLop);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
               
                return rs.getInt(1) > 0;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
} 
public boolean kiemTraTrungMaSua(String maCu, String maMoi) {
    // Đếm xem có bao nhiêu lớp có mã là maMoi nhưng phải khác maCu
    String sql = "SELECT COUNT(*) FROM lop WHERE MaLop = ? AND MaLop <> ?";
    try (Connection conn = db.open(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, maMoi);
        ps.setString(2, maCu);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // trả về true nếu tìm thấy mã trùng ở lớp khác
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}