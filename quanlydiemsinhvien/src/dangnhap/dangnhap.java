/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangnhap;

/**
 *
 * @author Admin
 */
public class dangnhap {
    private int id;
    private String tenDangNhap;
    private String matKhau;
   

    public dangnhap() {
    }

    public dangnhap(int id, String tenDangNhap, String matKhau) {
        this.id = id;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "dangnhap{" + "id=" + id + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + '}';
    }
    
    
}
