/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chuyennganh;

/**
 *
 * @author Admin
 */
public class chuyennganh {
    private int id;
    private String MaChuyenNganh;
    private String TenChuyenNganh;

    public chuyennganh() {
    }

    public chuyennganh(int id, String MaChuyenNganh, String TenChuyenNganh) {
        this.id = id;
        this.MaChuyenNganh = MaChuyenNganh;
        this.TenChuyenNganh = TenChuyenNganh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaChuyenNganh() {
        return MaChuyenNganh;
    }

    public void setMaChuyenNganh(String MaChuyenNganh) {
        this.MaChuyenNganh = MaChuyenNganh;
    }

    public String getTenChuyenNganh() {
        return TenChuyenNganh;
    }

    public void setTenChuyenNganh(String TenChuyenNganh) {
        this.TenChuyenNganh = TenChuyenNganh;
    }

    @Override
    public String toString() {
        return "chuyennganh{" + "id=" + id + ", MaChuyenNganh=" + MaChuyenNganh + ", TenChuyenNganh=" + TenChuyenNganh + '}';
    }
    
    
    
}
