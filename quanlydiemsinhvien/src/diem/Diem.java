/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diem;


public class Diem {
    private String maSV;
    private String tenSV; 
    private String maLop; 
    private String maMH;
    private String tenMH; 
    private float diemTP1; 
    private float diemTP2; 
    private float diemCuoiKi;
    private float diemTongKet; 

    public Diem(){} 

    public Diem(String maSV, String tenSV, String maLop, String maMH, String tenMH, float diemTP1, float diemTP2, float diemCuoiKi, float diemTongKet) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.maLop = maLop;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.diemTP1 = diemTP1;
        this.diemTP2 = diemTP2;
        this.diemCuoiKi = diemCuoiKi;
        this.diemTongKet = diemTongKet;
    }

    // Các Getter và Setter
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getTenSV() { return tenSV; }
    public void setTenSV(String tenSV) { this.tenSV = tenSV; }
    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }
    public String getMaMH() { return maMH; }
    public void setMaMH(String maMH) { this.maMH = maMH; }
    public String getTenMH() { return tenMH; }
    public void setTenMH(String tenMH) { this.tenMH = tenMH; }
    public float getDiemTP1() { return diemTP1; }
    public void setDiemTP1(float diemTP1) { this.diemTP1 = diemTP1; }
    public float getDiemTP2() { return diemTP2; }
    public void setDiemTP2(float diemTP2) { this.diemTP2 = diemTP2; }
    public float getDiemCuoiKi() { return diemCuoiKi; }
    public void setDiemCuoiKi(float diemCuoiKi) { this.diemCuoiKi = diemCuoiKi; }
    public float getDiemTongKet() { return diemTongKet; }
    public void setDiemTongKet(float diemTongKet) { this.diemTongKet = diemTongKet; }
}

