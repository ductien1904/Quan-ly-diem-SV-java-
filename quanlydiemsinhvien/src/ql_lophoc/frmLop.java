/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java 
 */
package ql_lophoc;

import form_chinh.f_chinh_gv;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
public class frmLop extends javax.swing.JFrame {
    String maLopCu = ""; 

    xuly_lop xl = new xuly_lop(); 
    int flag = 0; // 1: Thêm, 2: Sửa
    DefaultTableModel model;
    
    public frmLop() {
        initComponents();
        this.setTitle("Quản lý Lớp");
    model = (DefaultTableModel) tblLop.getModel();
    
    //hàm nạp toàn bộ dữ liệu cho các ComboBox
    setupAllComboBoxes(); 
    
    loadTable();
    setControl(true);
    }
    private void setupAllComboBoxes() {
    // 1. Nạp dữ liệu tìm kiếm (Khoa)
    cboKhoaTim.removeAllItems();
    cboKhoaTim.addItem("Tất cả");
    List<String> dsKhoa = xl.getDanhSachKhoa();
    for (String k : dsKhoa) {
        cboKhoaTim.addItem(k);
    }

    // 2. Nạp dữ liệu nhập liệu (Khoa)
    cboKhoa.removeAllItems();
    for (String k : dsKhoa) {
        cboKhoa.addItem(k);
    }

    // 3. Nạp dữ liệu Ngành
    cboNganh.removeAllItems();
    List<String> dsNganh = xl.getDanhSachNganh();
    for (String nganh : dsNganh) {
        cboNganh.addItem(nganh);
    }
}

    private void loadTable() {
        model.setRowCount(0);
        List<lop> ds = xl.getALL(); 
        for (lop l : ds) {
            model.addRow(new Object[]{
                l.getMaLop(), l.getTenLop(), l.getKhoaHoc(), 
                l.getMaChuyenNganh(), l.getGVCN(), l.getSDT()
            });
        }
    }
    private void setControl(boolean b) {
        btnThem.setEnabled(b); // Sửa từ btnThem thành btnThemm
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);
        btnGhi.setEnabled(!b);
        btnKhong.setEnabled(!b);

        txtMaLop.setEditable(!b);
        txtTenLop.setEditable(!b);
        txtGVCN.setEditable(!b);
        txtSDT.setEditable(!b);
        cboKhoa.setEnabled(!b); 
        cboNganh.setEnabled(!b); 
        
    }
    private void clearText() {
        txtMaLop.setText("");
        txtTenLop.setText("");
        txtGVCN.setText("");
        txtSDT.setText("");
    }
    // Trong frmLop.java

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboKhoaTim = new javax.swing.JComboBox<>();
        btnToanBo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLop = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenLop = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboKhoa = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboNganh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtGVCN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnKhong = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Chọn khóa :");

        cboKhoaTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKhoaTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhoaTimActionPerformed(evt);
            }
        });

        btnToanBo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnToanBo.setText("Toàn bộ");
        btnToanBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToanBoActionPerformed(evt);
            }
        });

        tblLop.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tblLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã lớp", "Tên lớp", "Khóa", "Ngành", "GVCN", "SĐT"
            }
        ));
        tblLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLop);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Mã Lớp :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Tên lớp :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Khóa Học :");

        cboKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Ngành :");

        cboNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("GVCN :");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("SĐT :");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel8.setText("QUẢN LÝ DANH MỤC LỚP");

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSua)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGhi))
                                    .addComponent(cboKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(35, 35, 35))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGVCN, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(txtSDT)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnKhong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnQuayLai)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboKhoaTim, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnToanBo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cboKhoaTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnToanBo))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtGVCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnGhi)
                        .addComponent(btnKhong))
                    .addComponent(btnQuayLai))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        flag = 1; 
        clearText();
        setControl(false);
        txtMaLop.requestFocus();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tblLop.getSelectedRow();
        if (row >= 0) {
            flag = 2; 
            setControl(false);
            txtMaLop.setEditable(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblLop.getSelectedRow();
        if (row >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                List<lop> ds = xl.getALL();
                int idXoa = ds.get(row).getId();
                if (xl.delete(idXoa)) {
                    loadTable();
                    clearText();
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
     String maMoi = txtMaLop.getText().trim();
     String sdt = txtSDT.getText().trim(); 
     String gvcn = txtGVCN.getText().trim();
     
     
    if (maMoi.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã Lớp!");
        txtMaLop.requestFocus();
        return;
    }
    
// "\\d+": toàn bộ phải là chữ số. 
    if (!sdt.matches("\\d+")) { 
        JOptionPane.showMessageDialog(this, "Số điện thoại chỉ được phép nhập số (0-9)!");
        txtSDT.requestFocus();
    return;
    }
    if (gvcn.matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Tên GVCN không được chứa chữ số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        txtGVCN.requestFocus();
        return;
    }

    // --- kt trùng mã ---
    if (flag == 1) { 
        if (xl.kiemTraTrungMa(maMoi)) {
            JOptionPane.showMessageDialog(this, "Mã lớp [" + maMoi + "] đã tồn tại!");
            txtMaLop.requestFocus();
            return;
        }
    } else if (flag == 2) { 
        // sử dụng hàm kiemTraTrungMaSua 
        if (xl.kiemTraTrungMaSua(maLopCu, maMoi)) {
            JOptionPane.showMessageDialog(this, "Mã lớp mới [" + maMoi + "] đã trùng với lớp khác!");
            txtMaLop.requestFocus();
            return;
        }
    }

    // --- lưu dữ liệu ---
    lop l = new lop();
    l.setMaLop(maMoi);
    l.setTenLop(txtTenLop.getText());
    l.setKhoaHoc(cboKhoa.getSelectedItem().toString());
    l.setMaChuyenNganh(cboNganh.getSelectedItem().toString());
    l.setGVCN(txtGVCN.getText());
    l.setSDT(txtSDT.getText());

    if (flag == 1) {
        xl.insert(l);
        JOptionPane.showMessageDialog(this, "Thêm thành công!");
    } else if (flag == 2) {
        int row = tblLop.getSelectedRow();
        // Lấy đúng ID từ database để sửa
        l.setId(xl.getALL().get(row).getId()); 
        xl.update(l);
        JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
    }
    
    flag = 0;
    maLopCu = "";
    setControl(true);
    loadTable();
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongActionPerformed
        // TODO add your handling code here:
        flag = 0;
        setControl(true);
        clearText();
    }//GEN-LAST:event_btnKhongActionPerformed

    private void btnToanBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToanBoActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnToanBoActionPerformed

    private void cboKhoaTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhoaTimActionPerformed
        // TODO add your handling code here:
    Object selectedItem = cboKhoaTim.getSelectedItem();
    if (selectedItem == null) return;
    
    String khoaChon = selectedItem.toString();
    
    if (khoaChon.equals("Tất cả")) {
        loadTable(); // Hiện lại toàn bộ nếu chọn "Tất cả"
    } else {
        model.setRowCount(0);
        List<lop> dsFiltered = xl.getByKhoa(khoaChon);
        for (lop l : dsFiltered) {
            model.addRow(new Object[]{
                l.getMaLop(), l.getTenLop(), l.getKhoaHoc(), 
                l.getMaChuyenNganh(), l.getGVCN(), l.getSDT()
            });
        }
    }
    }//GEN-LAST:event_cboKhoaTimActionPerformed

    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopMouseClicked
        // TODO add your handling code here:
      int row = tblLop.getSelectedRow();
    if (row >= 0) {
        //lưu mã lopcu
        maLopCu = model.getValueAt(row, 0).toString(); 
        
        // đẩy dữ liệu lên ô nhập
        txtMaLop.setText(maLopCu);
        txtTenLop.setText(model.getValueAt(row, 1).toString());
        cboKhoa.setSelectedItem(model.getValueAt(row, 2).toString());
        cboNganh.setSelectedItem(model.getValueAt(row, 3).toString());
        txtGVCN.setText(model.getValueAt(row, 4).toString());
        txtSDT.setText(model.getValueAt(row, 5).toString());
    }
    }//GEN-LAST:event_tblLopMouseClicked

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        f_chinh_gv formChinh = new f_chinh_gv();

        // 2. Hiển thị form chính
        formChinh.setVisible(true);
        formChinh.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_btnQuayLaiActionPerformed

   
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
            java.util.logging.Logger.getLogger(frmLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLop().setVisible(true);
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
    private javax.swing.JComboBox<String> cboKhoa;
    private javax.swing.JComboBox<String> cboKhoaTim;
    private javax.swing.JComboBox<String> cboNganh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLop;
    private javax.swing.JTextField txtGVCN;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenLop;
    // End of variables declaration//GEN-END:variables
}
