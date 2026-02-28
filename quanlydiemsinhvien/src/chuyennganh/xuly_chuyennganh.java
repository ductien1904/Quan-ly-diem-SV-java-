/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chuyennganh;

import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class xuly_chuyennganh implements truyvandulieu_cn<chuyennganh>{
    
    khoa_ketnoi_cn myconec = new khoa_ketnoi_cn();
    final String TABLE_NAME = "ChuyenNganh";

    @Override
    public List<chuyennganh> getALL() {
        
        List<chuyennganh> list = new ArrayList<>();
        try {
            Connection conn = myconec.getInstan();
            String sql = "SELECT * FROM " + TABLE_NAME;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                chuyennganh cn = new chuyennganh(
                        rs.getInt("ID"), 
                        rs.getString("MaChuyenNganh"), 
                        rs.getString("TenChuyenNganh")
                );
                list.add(cn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<chuyennganh> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(chuyennganh t) {
        
        int id = 0;
        try {
            Connection conn = myconec.getInstan();
            
            String sql = "INSERT INTO " + TABLE_NAME + " (MaChuyenNganh, TenChuyenNganh) VALUES (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getMaChuyenNganh());
            ps.setString(2, t.getTenChuyenNganh());

            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    id = rs.getInt(1); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id; 
    }

    @Override
    public boolean update(chuyennganh t) {
        boolean ketqua = false;
        try {
            Connection conn = myconec.getInstan();
           
            String sql = "UPDATE " + TABLE_NAME + " SET MaChuyenNganh = ?, TenChuyenNganh = ? WHERE ID = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getMaChuyenNganh());
            ps.setString(2, t.getTenChuyenNganh());
            ps.setInt(3, t.getId()); 

            if (ps.executeUpdate() > 0) {
                ketqua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public boolean delete(chuyennganh t) {
        boolean ketqua = false;
        try {
            Connection conn = myconec.getInstan();
            
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getId());

            if (ps.executeUpdate() > 0) {
                ketqua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public boolean delete(int id) {
      
         boolean ketqua = false;
        try {
            Connection conn = myconec.getInstan();
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                ketqua = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;  
    }
    
    
    public static void main(String[] args) {
        xuly_chuyennganh xuly = new xuly_chuyennganh();
        
        System.out.println("--- DANH SÁCH CHUYÊN NGÀNH ---");
        List<chuyennganh> ds = xuly.getALL();
        for (chuyennganh cn : ds) {
            System.out.println(cn.toString());
        }
    
    }
}
