package diem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ql_sv.SinhVien;

public class truyvandulieu_diem {

    // Khởi tạo đối tượng kết nối
    ketnoi_diem kn = new ketnoi_diem();

    /**
     * Lấy toàn bộ danh sách điểm kèm theo Tên SV, Mã Lớp và Tên Môn học
     */
    public List<Diem> getAll() {
        List<Diem> list = new ArrayList<>();
        // Query lấy dữ liệu từ bảng diem và JOIN với sinhvien, monhoc
        String sql = "SELECT d.MaSV, sv.HoTen, d.MaLop, d.MaMH, mh.TenMH, d.DiemTP1, d.DiemTP2, d.DiemCuoiKi, d.DiemTongKet " +
                     "FROM diem d " +
                     "JOIN sinhvien sv ON d.MaSV = sv.MaSV " +
                     "JOIN monhoc mh ON d.MaMH = mh.MaMH";

        try (Connection conn = kn.getInstan();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Diem d = new Diem(
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaLop"),
                    rs.getString("MaMH"),
                    rs.getString("TenMH"),
                    rs.getFloat("DiemTP1"),
                    rs.getFloat("DiemTP2"),
                    rs.getFloat("DiemCuoiKi"),
                    rs.getFloat("DiemTongKet")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    

    
    public List<Diem> getByMaSV(String maSV) {
        List<Diem> list = new ArrayList<>();
        String sql = "SELECT d.MaSV, sv.HoTen, d.MaLop, d.MaMH, mh.TenMH, d.DiemTP1, d.DiemTP2, d.DiemCuoiKi, d.DiemTongKet " +
                     "FROM diem d " +
                     "JOIN sinhvien sv ON d.MaSV = sv.MaSV " +
                     "JOIN monhoc mh ON d.MaMH = mh.MaMH " +
                     "WHERE d.MaSV = ?";

        try (Connection conn = kn.getInstan();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, maSV);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new Diem(
                        rs.getString("MaSV"), rs.getString("HoTen"), rs.getString("MaLop"),
                        rs.getString("MaMH"), rs.getString("TenMH"),
                        rs.getFloat("DiemTP1"), rs.getFloat("DiemTP2"),
                        rs.getFloat("DiemCuoiKi"), rs.getFloat("DiemTongKet")
                    ));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
 public boolean isExisted(String maSV, String maMH) {
    String sql = "SELECT COUNT(*) FROM diem WHERE MaSV = ? AND MaMH = ?";
    try (Connection conn = kn.getInstan();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, maSV);
        pst.setString(2, maMH);
        
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu count > 0 nghĩa là đã tồn tại
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    /**
     * MỚI: Tìm kiếm điểm theo Mã Lớp
     */
    public List<Diem> getByMaLop(String maLop) {
        List<Diem> list = new ArrayList<>();
        String sql = "SELECT d.MaSV, sv.HoTen, d.MaLop, d.MaMH, mh.TenMH, d.DiemTP1, d.DiemTP2, d.DiemCuoiKi, d.DiemTongKet " +
                     "FROM diem d " +
                     "JOIN sinhvien sv ON d.MaSV = sv.MaSV " +
                     "JOIN monhoc mh ON d.MaMH = mh.MaMH " +
                     "WHERE d.MaLop LIKE ?"; // Tìm kiếm gần đúng

        try (Connection conn = kn.getInstan();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + maLop + "%");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    list.add(new Diem(
                        rs.getString("MaSV"), rs.getString("HoTen"), rs.getString("MaLop"),
                        rs.getString("MaMH"), rs.getString("TenMH"),
                        rs.getFloat("DiemTP1"), rs.getFloat("DiemTP2"),
                        rs.getFloat("DiemCuoiKi"), rs.getFloat("DiemTongKet")
                    ));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    /**
     * Cập nhật hoặc Thêm mới điểm (Lưu)
     */
    public boolean update(Diem d) {
        // Câu lệnh này sẽ thử UPDATE, nếu không tìm thấy (row = 0) thì logic ở dưới sẽ INSERT
        String sqlUpdate = "UPDATE diem SET DiemTP1 = ?, DiemTP2 = ?, DiemCuoiKi = ?, DiemTongKet = ?, MaLop = ? " +
                           "WHERE MaSV = ? AND MaMH = ?";
        
        try (Connection conn = kn.getInstan();
             PreparedStatement pst = conn.prepareStatement(sqlUpdate)) {
            
            pst.setFloat(1, d.getDiemTP1());
            pst.setFloat(2, d.getDiemTP2());
            pst.setFloat(3, d.getDiemCuoiKi());
            pst.setFloat(4, d.getDiemTongKet());
            pst.setString(5, d.getMaLop());
            pst.setString(6, d.getMaSV());
            pst.setString(7, d.getMaMH());

            int rowAffected = pst.executeUpdate();

            // Nếu không cập nhật được dòng nào -> Thực hiện INSERT mới
            if (rowAffected == 0) {
                String sqlInsert = "INSERT INTO diem (MaSV, MaLop, MaMH, DiemTP1, DiemTP2, DiemCuoiKi, DiemTongKet) " +
                                   "VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstInsert = conn.prepareStatement(sqlInsert)) {
                    pstInsert.setString(1, d.getMaSV());
                    pstInsert.setString(2, d.getMaLop());
                    pstInsert.setString(3, d.getMaMH());
                    pstInsert.setFloat(4, d.getDiemTP1());
                    pstInsert.setFloat(5, d.getDiemTP2());
                    pstInsert.setFloat(6, d.getDiemCuoiKi());
                    pstInsert.setFloat(7, d.getDiemTongKet());
                    return pstInsert.executeUpdate() > 0;
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Xóa điểm
     */
    public boolean delete(String maSV, String maMH) {
        String sql = "DELETE FROM diem WHERE MaSV = ? AND MaMH = ?";
        try (Connection conn = kn.getInstan();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, maSV);
            pst.setString(2, maMH);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lấy danh sách mã SV để đổ vào ComboBox
     */
    public List<String> getListMaSV() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT MaSV FROM sinhvien";
        try (Connection conn = kn.getInstan();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(rs.getString("MaSV"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    /**
     * Lấy thông tin chi tiết của một sinh viên từ bảng sinhvien
     * Dùng để tự động lấy Mã Lớp và Họ Tên khi chọn ComboBox
     */
    public SinhVien getOne(String maSV) {
        String sql = "SELECT MaSV, HoTen, MaLop FROM sinhvien WHERE MaSV = ?";
        
        try (Connection conn = kn.getInstan(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, maSV);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMaSV(rs.getString("MaSV"));
                    sv.setHoTen(rs.getString("HoTen"));
                    sv.setMaLop(rs.getString("MaLop"));
                    return sv;
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn sinh viên (getOne): " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy sinh viên
    }
}