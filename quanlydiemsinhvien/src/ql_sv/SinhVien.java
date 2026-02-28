/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ql_sv;

import java.util.Date;

public class SinhVien {
    private String maSV, hoTen, gioiTinh, sdt, diaChi, maLop;
    private Date ngaySinh;

    public SinhVien() {}

    public SinhVien(String maSV, String hoTen, String maLop, Date ngaySinh, String gioiTinh, String sdt, String diaChi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.maLop = maLop;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    //getter và setter
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    
    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }
    
    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }
    
    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
    
    public String getSDT() { return sdt; }
    public void setSDT(String sdt) { this.sdt = sdt; }
    
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
}