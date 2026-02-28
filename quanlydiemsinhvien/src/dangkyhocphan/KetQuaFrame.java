package dangkyhocphan;

import form_chinh.f_sv;
import java.sql.Connection; // Phải là java.sql
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

public class KetQuaFrame extends javax.swing.JFrame {

   
   public KetQuaFrame() {
    initComponents();
    setLocationRelativeTo(null);
    loadData(); // Tự động load khi mở trang
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKetQua = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuBack = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KẾT QUẢ ĐĂNG KÝ");

        jButton1.setText("Xem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblKetQua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã học phần", "Tên học phần", "Tín chỉ", "Ngày học", "Ca học"
            }
        ));
        jScrollPane1.setViewportView(tblKetQua);

        jButton2.setText("Xác nhận");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jMenuBar1.add(jMenu2);

        menuBack.setText("← Quay lại");
        menuBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBackMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuBack);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnXoa)
                        .addGap(55, 55, 55)
                        .addComponent(jButton2)
                        .addGap(75, 75, 75)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBackMouseClicked
         new f_sv().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_menuBackMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       loadData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(this, "Xác nhận đăng ký học phần thành công!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
 int row = tblKetQua.getSelectedRow();

    // Chưa chọn dòng
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn học phần cần xóa!");
        return;
    }

    // Hỏi xác nhận
    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Bạn có chắc chắn muốn xóa học phần này?",
        "Xác nhận xóa",
        JOptionPane.YES_NO_OPTION
    );
    if (confirm != JOptionPane.YES_OPTION) return;

    // LẤY MÃ HỌC PHẦN (CỘT 0)
    String maHP = tblKetQua.getValueAt(row, 0).toString();

    try {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM KetQuaDangKy WHERE maHP = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, maHP);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            ((DefaultTableModel) tblKetQua.getModel()).removeRow(row);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu để xóa!");
        }

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa dữ liệu!");
    }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(KetQuaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KetQuaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KetQuaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KetQuaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KetQuaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuBack;
    private javax.swing.JTable tblKetQua;
    // End of variables declaration//GEN-END:variables

   public void loadData() {
    // Lấy model của bảng, hãy chắc chắn tên biến là tblKetQua
    DefaultTableModel model = (DefaultTableModel) tblKetQua.getModel();
    model.setRowCount(0); // Xóa trắng bảng trước khi nạp dữ liệu mới

    try {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            String sql = "SELECT * FROM KetQuaDangKy";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("maHP"),
                    rs.getString("tenHP"),
                    rs.getInt("tinChi"),
                    rs.getString("ngayHoc"),
                    rs.getString("caHoc")
                });
            }
            conn.close();
        }
    } catch (Exception e) {
        System.out.println("Lỗi khi tải kết quả: " + e.getMessage());
    }
}
}
