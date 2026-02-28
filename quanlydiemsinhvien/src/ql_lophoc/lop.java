package ql_lophoc;

public class lop {
    private int id;
    private String maLop;
    private String tenLop;
    private String khoaHoc;
    private String maChuyenNganh;
    private String gvcn;
    private String sdt;

    // Constructor mặc định
    public lop() {
    }
    // Constructor đầy đủ
    public lop(int id, String maLop, String tenLop, String khoaHoc, String maChuyenNganh, String gvcn, String sdt) {
        this.id = id;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoaHoc = khoaHoc;
        this.maChuyenNganh = maChuyenNganh;
        this.gvcn = gvcn;
        this.sdt = sdt;
    }

    //Getter và Setter 
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    
    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }

 
    public String getTenLop() { return tenLop; }
    public void setTenLop(String tenLop) { this.tenLop = tenLop; }

   
    public String getKhoaHoc() { return khoaHoc; }
    public void setKhoaHoc(String khoaHoc) { this.khoaHoc = khoaHoc; }

    
    public String getMaChuyenNganh() { return maChuyenNganh; }
    public void setMaChuyenNganh(String maChuyenNganh) { this.maChuyenNganh = maChuyenNganh; }

    
    public String getGVCN() { return gvcn; }
    public void setGVCN(String gvcn) { this.gvcn = gvcn; }

    
    public String getSDT() { return sdt; }
    public void setSDT(String sdt) { this.sdt = sdt; }

    @Override
    public String toString() {
        return tenLop;
    }
    
    
    public Object[] toArray() {
        return new Object[]{id, maLop, tenLop, khoaHoc, maChuyenNganh, gvcn, sdt};
    }
}