/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.ChiTietSach;
import DomainModels.KhuyenMai;
import DomainModels.KhuyenMaiSach;
import Service.Implement.KhuyenMaiSachImpl;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc
 */
public class FormKhuyenMaiSach extends javax.swing.JPanel {

    /**
     * Creates new form FormKhuyenMaiSach
     */
    private DefaultTableModel model;
    private KhuyenMaiSachImpl service;
    private String isClicked;
    ArrayList<ChiTietSach> listAllSach = service.getALLSach();
    ArrayList<KhuyenMai> listAllKM = service.getALLKM();

    public FormKhuyenMaiSach() {
        initComponents();
        rdoHetHan.setSelected(true);
        service = new KhuyenMaiSachImpl();
        loadTable();
        for (ChiTietSach item : listAllSach) {
            cboSach.addItem(item.getMa());
        }
        for (KhuyenMai item : listAllKM) {
            cboKM.addItem(item.getMa());
        }
    }

    public void loadTable() {
        model = (DefaultTableModel) tblKMHD.getModel();
        model.setRowCount(0);
        for (KhuyenMaiSach item : service.getList()) {
            model.addRow(new Object[]{
                item.getId(), item.getIdSach(), item.getIdKM(), item.getDonGia(), item.getSoTienConLai(), service.getTrangThai(item.getTinhTrang())
            });
        }
    }

    public void loadTableTK() {
        model = (DefaultTableModel) tblKMHD.getModel();
        model.setRowCount(0);
        for (KhuyenMaiSach item : service.searchKM(Float.parseFloat(txtTK.getText()))) {
            model.addRow(new Object[]{
                item.getId(), item.getIdSach(), item.getIdKM(), item.getDonGia(), item.getSoTienConLai(), service.getTrangThai(item.getTinhTrang())
            });
        }
    }

    public KhuyenMaiSach getAllFromGUI() {
        String tt;
        if (rdoHetHan.isSelected()) {
            tt = "0";
        } else {
            tt = "1";
        }
        return new KhuyenMaiSach(null, service.getIdSachByMa(cboSach.getSelectedItem().toString()), service.getIdKhuyenMaiByMa(cboKM.getSelectedItem().toString()), Float.parseFloat(txtDonGia.getText()), Float.parseFloat(txtSTCL.getText()), tt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        rdoConHan = new javax.swing.JRadioButton();
        btnSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboSach = new javax.swing.JComboBox<>();
        btnXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboKM = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSTCL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKMHD = new javax.swing.JTable();
        rdoHetHan = new javax.swing.JRadioButton();

        rdoConHan.setText("Con Han");

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Khuyen Mai Hoa Don");

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ma Sach:");

        jLabel5.setText("So Tien Con Lai:");

        txtTK.setText("Tim Kiemmm...");
        txtTK.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTKCaretUpdate(evt);
            }
        });
        txtTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTKMouseExited(evt);
            }
        });

        jLabel3.setText("Ma Khuyen Mai:");

        jLabel4.setText("Don Gia:");

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel7.setText("Trang Thai:");

        tblKMHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID Sach", "Ma Khuyen Mai", "Don Gia", "So Tien Con Lai", "Trang Thai"
            }
        ));
        tblKMHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKMHDMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKMHD);

        rdoHetHan.setText("Het Han");

        jDesktopPane1.setLayer(rdoConHan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnSua, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cboSach, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnXoa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cboKM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtTK, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtSTCL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtDonGia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnThem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(rdoHetHan, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboSach, 0, 114, Short.MAX_VALUE)
                                    .addComponent(cboKM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(179, 179, 179)
                                        .addComponent(jLabel7))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(btnThem)))
                                .addGap(28, 28, 28)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdoConHan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoHetHan)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(btnXoa)))))
                        .addContainerGap(84, Short.MAX_VALUE))))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtSTCL, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSTCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoConHan)
                            .addComponent(rdoHetHan)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        var temp = getAllFromGUI();
        temp.setId(isClicked);
        int confirm = JOptionPane.showConfirmDialog(this, "Xac Nhan");
        if (confirm == 0) {
            JOptionPane.showMessageDialog(this, service.sua(temp));
            loadTable();
        } else if (confirm == 1) {
            JOptionPane.showMessageDialog(this, "Da Huy");
        } else {
            JOptionPane.showMessageDialog(this, "Da Huy");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        KhuyenMaiSach temp = new KhuyenMaiSach();
        temp.setId(isClicked);
        int confirm = JOptionPane.showConfirmDialog(this, "Xac Nhan");
        if (confirm == 0) {
            JOptionPane.showMessageDialog(this, service.xoa(temp));
            loadTable();
        } else if (confirm == 1) {
            JOptionPane.showMessageDialog(this, "Da Huy");
        } else {
            JOptionPane.showMessageDialog(this, "Da Huy");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblKMHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKMHDMouseClicked
        // TODO add your handling code here:
        int row = tblKMHD.getSelectedRow();
        if (row == -1) {
            return;
        }
        isClicked = tblKMHD.getModel().getValueAt(row, 0).toString();
        var temp = service.getKMSachByID(isClicked);
        cboSach.setSelectedItem(service.getMaSachByID(temp.getIdSach()));
        cboKM.setSelectedItem(service.getMaKMByID(temp.getIdKM()));
        txtDonGia.setText(temp.getDonGia().toString());
        txtSTCL.setText(temp.getSoTienConLai().toString());
        if (temp.getTinhTrang().equals("0")) {
            rdoHetHan.setSelected(true);
        } else {
            rdoConHan.setSelected(true);
        }
    }//GEN-LAST:event_tblKMHDMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Xac Nhan");
        if (confirm == 0) {
            JOptionPane.showMessageDialog(this, service.them(getAllFromGUI()));
            loadTable();
        } else if (confirm == 1) {
            JOptionPane.showMessageDialog(this, "Da Huy");
        } else {
            JOptionPane.showMessageDialog(this, "Da Huy");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTKCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTKCaretUpdate
        // TODO add your handling code here:
        loadTableTK();
    }//GEN-LAST:event_txtTKCaretUpdate

    private void txtTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTKMouseExited
        // TODO add your handling code here:
        txtTK.setText("Tim Kiemmmm ...");
        loadTable();
    }//GEN-LAST:event_txtTKMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboKM;
    private javax.swing.JComboBox<String> cboSach;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoConHan;
    private javax.swing.JRadioButton rdoHetHan;
    private javax.swing.JTable tblKMHD;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtSTCL;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}