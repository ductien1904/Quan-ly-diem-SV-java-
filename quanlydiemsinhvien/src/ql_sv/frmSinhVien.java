/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ql_sv;

import form_chinh.f_chinh_gv;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;
import ql_lophoc.lop;
import ql_lophoc.xuly_lop;
public class frmSinhVien extends javax.swing.JFrame {
    String MaSVCu="";
    xuly_sv xl = new xuly_sv();
    xuly_lop xlLop = new xuly_lop();

    DefaultTableModel model;
    int flag = 0; 

    ButtonGroup bgGioiTinh = new ButtonGroup();

    public frmSinhVien() {
           initComponents();
           this.setTitle("Hồ sơ Sinh viên");

        model = (DefaultTableModel) tblSinhVien.getModel();
        tblSinhVien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        bgGioiTinh.add(optNam);
        bgGioiTinh.add(optNu);

        loadComboBoxLop();
        loadTable();
        setControl(true);
    }
private void loadComboBoxLop() {
        cboLop.removeAllItems();
        cboLopChon.removeAllItems();

        cboLop.addItem("Tất cả");

        for (lop l : xlLop.getALL()) {
            cboLop.addItem(l.getMaLop());
            cboLopChon.addItem(l.getMaLop());
        }
    }

private void loadTable() {
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (SinhVien sv : xl.getALL()) {
            model.addRow(new Object[]{
                sv.getMaSV(),
                sv.getMaLop(),
                sv.getHoTen(),
                sdf.format(sv.getNgaySinh()),
                sv.getGioiTinh(),
                sv.getSDT(),
                sv.getDiaChi()
            });
        }
    }
  private void setControl(boolean b) {
        btnThem.setEnabled(b);
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);

        btnGhi.setEnabled(!b);
        btnKhong.setEnabled(!b);

        txtMaSV.setEditable(!b);
        txtHoTen.setEditable(!b);
        txtNgaySinh.setEditable(!b);
        txtSDT.setEditable(!b);
        txtDiaChi.setEditable(!b);
        cboLopChon.setEnabled(!b);
        optNam.setEnabled(!b);
        optNu.setEnabled(!b);
    }
 private void clearText() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        optNam.setSelected(true);
    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboLop = new javax.swing.JComboBox<>();
        btnToanBo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboLopChon = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        optNam = new javax.swing.JRadioButton();
        optNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnKhong = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Chọn lớp :");

        cboLop.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cboLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLopActionPerformed(evt);
            }
        });

        btnToanBo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnToanBo.setText("Toàn bộ");
        btnToanBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToanBoActionPerformed(evt);
            }
        });

        tblSinhVien.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Lớp", "Họ Tên", "Ngày Sinh", "Giới Tính", "SĐT", "Địa Chỉ"
            }
        ));
        tblSinhVien.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);
        if (tblSinhVien.getColumnModel().getColumnCount() > 0) {
            tblSinhVien.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblSinhVien.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblSinhVien.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblSinhVien.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblSinhVien.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Mã SV :");

        txtMaSV.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên :");

        txtHoTen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Lớp :");

        cboLopChon.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cboLopChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Ngày Sinh :");

        txtNgaySinh.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Giới Tính :");

        optNam.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        optNam.setText("Nam");

        optNu.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        optNu.setText("Nữ");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("SĐT :");

        txtSDT.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Địa Chỉ :");

        txtDiaChi.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        btnThem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnGhi.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnGhi.setText("Ghi");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnKhong.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnKhong.setText("Không");
        btnKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongActionPerformed(evt);
            }
        });

        btnXuatFile.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXuatFile.setText("Xuất File");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel9.setText("THÔNG TIN SINH VIÊN");

        btnQuayLai.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLop, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnToanBo)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLopChon, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(optNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(optNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnThem)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnSua))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnGhi)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnKhong)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnXuatFile)))))))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQuayLai)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuayLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToanBo)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboLopChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(optNam)
                            .addComponent(optNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGhi)
                            .addComponent(btnKhong)
                            .addComponent(btnXuatFile)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        // TODO add your handling code here:
        
    try (java.io.BufferedWriter bw = new java.io.BufferedWriter(
            new java.io.OutputStreamWriter(
                new java.io.FileOutputStream("danhsach_sinhvien.csv"), 
                java.nio.charset.StandardCharsets.UTF_8))) {
        
        bw.write("\uFEFF"); 
        
        // 2. Ghi tiêu đề cột
        bw.write("Ma SV,Lop,Ho Ten,Ngay Sinh,Gioi Tinh,SDT,Dia Chi");
        bw.newLine();
        
        // 3. Ghi dữ liệu từ bảng
        for (int i = 0; i < model.getRowCount(); i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < model.getColumnCount(); j++) {
                row.append(model.getValueAt(i, j).toString());
                if (j < model.getColumnCount() - 1) row.append(",");
            }
            bw.write(row.toString());
            bw.newLine();
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, "Đã xuất file danhsach_sinhvien.csv thành công!");
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Lỗi xuất file: " + e.getMessage());
    }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        
   try {
        //Lấy và chuẩn hóa dữ liệu đầu vào
        String maSV = txtMaSV.getText().trim();
        String hoTen = txtHoTen.getText().trim();
        String ngaySinhStr = txtNgaySinh.getText().trim();
        String sdt = txtSDT.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        

        //kt rỗng
        if (maSV.isEmpty() || hoTen.isEmpty() || ngaySinhStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống! ");
            return;
        }
       

        //kt trùng mã
        if (flag == 1) { 
            //nếu thêm
            if (xl.kiemTraTrungMa(maSV)) {
                JOptionPane.showMessageDialog(this, "Mã SV [" + maSV + "] đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtMaSV.requestFocus();
                return;
            }
        } else if (flag == 2) { 
            //nếu sửa
            if (xl.kiemTraTrungMaSua(MaSVCu, maSV)) {
                JOptionPane.showMessageDialog(this, "Mã SV mới [" + maSV + "] đã trùng với một sinh viên khác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtMaSV.requestFocus();
                return;
            }
        }
        if (hoTen.matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Tên không được chứa chữ số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        txtHoTen.requestFocus();
        return;
    }
        
        if (!sdt.matches("\\d+")) { 
         JOptionPane.showMessageDialog(this, "Số điện thoại chỉ được phép nhập số (0-9)!");
         txtSDT.requestFocus();
    return;
}

        // xử lí ngày sinh
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); //Chặn ngày ko hợp lệ
        java.util.Date ngaySinh = sdf.parse(ngaySinhStr);

        //đóng gói dữ liệu
        SinhVien sv = new SinhVien();
        sv.setMaSV(maSV);
        sv.setHoTen(hoTen);
        sv.setMaLop(cboLopChon.getSelectedItem().toString());
        sv.setNgaySinh(ngaySinh);
        sv.setGioiTinh(optNam.isSelected() ? "Nam" : "Nữ");
        sv.setSDT(sdt);
        sv.setDiaChi(diaChi);

        // lưu vào database
        if (flag == 1) {
            if (xl.insert(sv)) {
                JOptionPane.showMessageDialog(this, "Thêm sinh viên mới thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại. Vui lòng kiểm tra lại kết nối!");
                return;
            }
        } else if (flag == 2) {
            if (xl.update(sv)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                return;
            }
        }

        //reset trạng thái form
        flag = 0;
        MaSVCu="";
        setControl(true);
        clearText();
        loadTable();

    } catch (java.text.ParseException e) {
        JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng (d/m/y)!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        txtNgaySinh.requestFocus();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage(), "Lỗi hệ thống", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnToanBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToanBoActionPerformed
        // TODO add your handling code here:
        cboLop.setSelectedIndex(0);
        loadTable();
    }//GEN-LAST:event_btnToanBoActionPerformed

    private void cboLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLopActionPerformed
        // TODO add your handling code here:
          if (cboLop.getSelectedItem() == null) return;

        String lop = cboLop.getSelectedItem().toString();
        model.setRowCount(0);

        if (lop.equals("Tất cả")) {
            loadTable();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (SinhVien sv : xl.getByLop(lop)) {
                model.addRow(new Object[]{
                    sv.getMaSV(), sv.getMaLop(), sv.getHoTen(),
                    sdf.format(sv.getNgaySinh()), sv.getGioiTinh(),
                    sv.getSDT(), sv.getDiaChi()
                });
            }
        }
    }//GEN-LAST:event_cboLopActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
flag = 1;
        clearText();
        setControl(false);
        txtMaSV.requestFocus();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
if (tblSinhVien.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sinh viên cần sửa!");
            return;
        }
        flag = 2;
        setControl(false);
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
int row = tblSinhVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sinh viên cần xóa!");
            return;
        }

        String maSV = model.getValueAt(row, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this,
                "Xóa sinh viên " + maSV + " ?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            xl.delete(maSV);
            loadTable();
            clearText();
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
 int row = tblSinhVien.getSelectedRow();
    if (row >= 0) {
     // lấy mã sv cũ và lưu
         MaSVCu = model.getValueAt(row, 0).toString();
        
        //đẩy dữ liệu lên các ô nhập liệu
        txtMaSV.setText(MaSVCu);
        cboLopChon.setSelectedItem(model.getValueAt(row, 1).toString());
        txtHoTen.setText(model.getValueAt(row, 2).toString());
        txtNgaySinh.setText(model.getValueAt(row, 3).toString());

        String gt = model.getValueAt(row, 4).toString();
        if (gt.equals("Nam")) optNam.setSelected(true);
        else optNu.setSelected(true);

        txtSDT.setText(model.getValueAt(row, 5).toString());
        txtDiaChi.setText(model.getValueAt(row, 6).toString());
    }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongActionPerformed
        // TODO add your handling code here:
        flag = 0;
        setControl(true);
        clearText();
    }//GEN-LAST:event_btnKhongActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
         f_chinh_gv formChinh = new f_chinh_gv(); 
    
    //hiển thị lên form chính
    formChinh.setVisible(true);
    formChinh.setLocationRelativeTo(null);
       this.dispose();
        
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnKhong;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnToanBo;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cboLop;
    private javax.swing.JComboBox<String> cboLopChon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton optNam;
    private javax.swing.JRadioButton optNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
