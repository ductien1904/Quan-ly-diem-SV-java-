package monhoc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import monhoc.MonHoc; // Import model

public class truyvandulieu_mh {
    private final ketnoi_monhoc db = new ketnoi_monhoc();

    /**
     * Lấy toàn bộ danh sách môn học từ Database
     * @return 
     */
    public List<MonHoc> getAll() {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM monhoc";
        try (Connection conn = db.getInstan();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                list.add(new MonHoc(
                    rs.getString("MaMH"),
                    rs.getString("TenMH"),
                    rs.getInt("SoTinChi")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi lấy danh sách: " + e.getMessage());
        }
        return list;
    }

    /**
     * Thêm mới môn học bằng đối tượng
     */
    public boolean insert(MonHoc mh) {
        String sql = "INSERT INTO monhoc (MaMH, TenMH, SoTinChi) VALUES (?, ?, ?)";
        return executeUpdate(sql, mh.getMaMH(), mh.getTenMH(), mh.getSoTinChi());
    }

    public boolean update(MonHoc mh) {
        String sql = "UPDATE monhoc SET TenMH = ?, SoTinChi = ? WHERE MaMH = ?";
        return executeUpdate(sql, mh.getTenMH(), mh.getSoTinChi(), mh.getMaMH());
    }

    public boolean delete(String maMH) {
        String sql = "DELETE FROM monhoc WHERE MaMH = ?";
        return executeUpdate(sql, maMH);
    }

    /**
     * Hàm dùng chung để tối ưu hóa việc thực thi (Refactoring)
     */
    private boolean executeUpdate(String sql, Object... params) {
    // Luôn lấy kết nối mới từ hàm getInstan()
    try (Connection conn = db.getInstan(); 
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }
        
        return pst.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    // Kết nối sẽ tự động đóng an toàn khi kết thúc khối try này
}
    // 1. Kiểm tra trùng tên khi THÊM MỚI
public boolean isTenMonTonTai(String tenMH) {
    String sql = "SELECT TenMH FROM monhoc WHERE TenMH = ?";
    try (Connection conn = db.getInstan(); 
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, tenMH);
        try (ResultSet rs = pst.executeQuery()) {
            return rs.next(); // Trả về true nếu đã có tên này trong kho
        }
    } catch (SQLException e) { return false; }
}

// 2. Kiểm tra trùng tên khi SỬA (phải khác tên hiện tại của chính nó)
public boolean isTenMonTonTaiSua(String tenCu, String tenMoi) {
    String sql = "SELECT TenMH FROM monhoc WHERE TenMH = ? AND TenMH <> ?";
    try (Connection conn = db.getInstan(); 
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, tenMoi);
        pst.setString(2, tenCu);
        try (ResultSet rs = pst.executeQuery()) {
            return rs.next(); // Trả về true nếu trùng với môn KHÁC
        }
    } catch (SQLException e) { return false; }
}
public boolean isMaMonTonTai(String maMH) {
    String sql = "SELECT MaMH FROM monhoc WHERE MaMH = ?";
    try (Connection conn = db.getInstan(); 
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, maMH);
        try (ResultSet rs = pst.executeQuery()) {
            return rs.next(); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    
}

}