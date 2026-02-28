/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package monhoc;
import form_chinh.f_chinh_gv;
import monhoc.MonHoc;

import javax.swing.JOptionPane;

public class f_Quanlymonhoc extends javax.swing.JFrame {
    
String tenMonCu = "";
// Khai báo lớp xử lý dữ liệu    
monhoc.truyvandulieu_mh dao = new monhoc.truyvandulieu_mh();

// Hàm đổ dữ liệu vào bảng
public void loadTable() {
    java.util.List<monhoc.MonHoc> list = dao.getAll();
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblMonHoc.getModel();
    model.setRowCount(0);
    int stt = 1;
    for (monhoc.MonHoc mh : list) {
        model.addRow(new Object[]{stt++, mh.getMaMH(), mh.getTenMH(), mh.getSoTinChi()});
    }
}
    public f_Quanlymonhoc() {
    initComponents();
    this.setTitle("Quản lý Môn học");
    this.setLocationRelativeTo(null); // Cho form ra giữa màn hình
    loadTable();
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonHoc = new javax.swing.JTable();
        txtMaMH = new javax.swing.JTextField();
        txtTenMH = new javax.swing.JTextField();
        txtSoTinChi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMonHoc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tblMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Môn", "Tên Môn Học", "Số Tín Chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMonHoc.setGridColor(new java.awt.Color(255, 255, 255));
        tblMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMonHoc);
        if (tblMonHoc.getColumnModel().getColumnCount() > 0) {
            tblMonHoc.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblMonHoc.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblMonHoc.getColumnModel().getColumn(2).setPreferredWidth(250);
            tblMonHoc.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        txtMaMH.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txtTenMH.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtTenMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMHActionPerformed(evt);
            }
        });

        txtSoTinChi.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSoTinChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoTinChiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Mã Môn :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Tên Môn Học :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Số tín chỉ :");

        btnThem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quản lý môn học");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaMH)
                            .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLamMoi)
                                .addGap(30, 30, 30)
                                .addComponent(btnThoat))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
                        .addGap(113, 113, 113))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThoat))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMHActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        f_chinh_gv formChinh = new f_chinh_gv(); 
    
    // 2. Hiển thị form chính
    formChinh.setVisible(true);
    formChinh.setLocationRelativeTo(null);
       this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
// 1. Lấy dữ liệu 
    String ma = txtMaMH.getText().trim();
    String ten = txtTenMH.getText().trim();
    String stc = txtSoTinChi.getText().trim();
    // 2. Kiểm tra các ô nhập có bị trống không (Làm trước tiên)
    if (ma.isEmpty() || ten.isEmpty() || stc.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        return;
    }
    // Kiểm tra trùng tên trước
if (dao.isTenMonTonTai(ten)) {
    JOptionPane.showMessageDialog(this, "Tên môn học [" + ten + "] đã tồn tại!");
    txtTenMH.requestFocus();
    return;
}
    // 3. Kiểm tra định dạng và giá trị của Số tín chỉ
    int tc;
    try {
        tc = Integer.parseInt(stc); 
        if (tc <= 0) {
            JOptionPane.showMessageDialog(this, "Số tín chỉ phải là số nguyên dương (> 0)!");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Số tín chỉ phải là một con số hợp lệ!");
        return;
    }
    // 4. Gọi DAO để thực hiện lưu vào Database
    MonHoc mh = new MonHoc(ma, ten, tc);
    if (dao.insert(mh)) {
        JOptionPane.showMessageDialog(this, "Thêm môn học thành công!");
        loadTable(); // Cập nhật lại bảng hiển thị
        // Có thể thêm hàm xóa trắng các ô nhập ở đây (ví dụ: btnLamMoiActionPerformed(null);)
    } else {
        // Nếu insert trả về false, thường là do trùng khóa chính (MaMH)
        JOptionPane.showMessageDialog(this, "Thêm thất bại! Mã môn học này đã tồn tại trong hệ thống.");
    }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonHocMouseClicked
        // TODO add your handling code here:
    int row = tblMonHoc.getSelectedRow();
    if (row >= 0) {
        txtMaMH.setText(tblMonHoc.getValueAt(row, 1).toString());
        tenMonCu = tblMonHoc.getValueAt(row, 2).toString(); // Lưu lại tên cũ ở đây
        txtTenMH.setText(tenMonCu);
        txtSoTinChi.setText(tblMonHoc.getValueAt(row, 3).toString());
        
        txtMaMH.setEditable(false); // Khóa ô mã môn
    }
    txtMaMH.setEditable(false);
    }//GEN-LAST:event_tblMonHocMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    txtMaMH.setText("");
    txtTenMH.setText("");
    txtSoTinChi.setText("");
    txtMaMH.setEditable(true); // Mở lại ô mã
    txtMaMH.requestFocus();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtSoTinChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoTinChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoTinChiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
try {
        // 1. Lấy dữ liệu từ các ô nhập liệu
        String ma = txtMaMH.getText().trim();
        String ten = txtTenMH.getText().trim();
        String tinChiStr = txtSoTinChi.getText().trim();

        // 2. Kiểm tra trống (Phải làm đầu tiên)
        if (ma.isEmpty() || ten.isEmpty() || tinChiStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn môn học từ bảng để sửa!");
            return;
        }

        if (dao.isTenMonTonTaiSua(tenMonCu, ten)) {
            JOptionPane.showMessageDialog(this, "Tên môn học mới [" + ten + "] đã bị trùng với một môn học khác!");
            txtTenMH.requestFocus(); // Đưa con trỏ về ô tên để sửa lại
            return; // Dừng lại luôn, không chạy xuống phần hỏi xác nhận bên dưới
        }

        // 3. Xác nhận từ người dùng (Chỉ hiện khi tên KHÔNG bị trùng)
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc muốn cập nhật thông tin cho mã môn: " + ma + "?", 
                "Xác nhận", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            int tc = Integer.parseInt(tinChiStr);
            monhoc.MonHoc mh = new monhoc.MonHoc(ma, ten, tc);

            // 4. Gọi hàm update thực tế
            if (dao.update(mh)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadTable(); 
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Số tín chỉ phải là số nguyên!");
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma = txtMaMH.getText().trim();

    // 1. Kiểm tra xem người dùng đã chọn môn học chưa
    if (ma.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn môn học từ bảng để xóa!");
        return;
    }

    // 2. Hiện hộp thoại xác nhận (Cực kỳ quan trọng để bảo vệ dữ liệu)
    int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc chắn muốn xóa môn học: " + ma + "?\nHành động này không thể hoàn tác!", 
            "Cảnh báo xóa dữ liệu", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE);

    if (confirm == JOptionPane.YES_OPTION) {
        // 3. Gọi hàm xóa từ DAO
        if (dao.delete(ma)) {
            JOptionPane.showMessageDialog(this, "Đã xóa môn học thành công!");
            
            // 4. Cập nhật lại giao diện
            loadTable();      // Tải lại bảng
            btnLamMoiActionPerformed(null); // Xóa trắng các ô nhập liệu
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại! Có thể môn học đang được sử dụng ở bảng khác.");
        }
    }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(f_Quanlymonhoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(f_Quanlymonhoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(f_Quanlymonhoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(f_Quanlymonhoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f_Quanlymonhoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMonHoc;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtSoTinChi;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables


}

