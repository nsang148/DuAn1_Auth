/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import DomainModels.KhachHangModel;

import Service.Implement.KhachHangIplement;

import Service.KhachHangService;
import ViewModels.KhachHangReponse;
import java.io.BufferedInputStream;
import java.lang.Object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author This PC
 */
public class FormKhachHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormThongKe
     */
    DefaultTableModel defaultTableModel;
    KhachHangService khachHangService;
    List<KhachHangReponse> list;
    DefaultComboBoxModel defaultComboBoxModel;

    public FormKhachHang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        defaultTableModel = (DefaultTableModel) tbKh.getModel();
        String[] header = {"Mã KH", "Họ và tên", "Giới tính", "Ngày sinh", "Địa chỉ", "SDT", "Email", "Tình trạng"};
        defaultTableModel.setColumnIdentifiers(header);
        khachHangService = new KhachHangIplement();
        list = khachHangService.getAll();
        fillToTable(list);
//        loadCBNXB();
        btg();
    }

    private void btg() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdNam);
        buttonGroup.add(rdNu);

    }

    private void fillToTable(List<KhachHangReponse> list) {
        defaultTableModel.setRowCount(0);
//        list = khachHangService.getAll();
        System.out.println(list);
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Object[] data = new Object[8];
                data[0] = list.get(i).getMa();
                data[1] = list.get(i).getHoTen();
                data[2] = list.get(i).getGioiTinh();
                data[3] = list.get(i).getNgaySinh();
                data[4] = list.get(i).getDiaChi();
                data[5] = list.get(i).getSdt();
                data[6] = list.get(i).getEmail();
//                data[7] = list.get(i).getTongDiem();
//                data[8] = list.get(i).getSoDiemDaDung();
//                data[9] = list.get(i).getSoDiemDaCong();
                if (list.get(i).getTinhTrang().equals(1)) {
                    data[7] = "Khách hàng thân thiết";
                } else {
                    data[7] = "Khách hàng không thân thiết";
                }

                defaultTableModel.addRow(data);
                System.out.println(list);
            }
            tbKh.setModel(defaultTableModel);
//            defaultTableModel.fireTableDataChanged();
        }
    }

    private KhachHangModel getData() {
        SimpleDateFormat dinhDang = new SimpleDateFormat("yyyy-MM-dd");
        String ngay = dinhDang.format(jNgaySinh.getDate());

        KhachHangModel kh = new KhachHangModel();
        kh.setMaKH(txtMaKh.getText());
        kh.setTen(txtTen.getText());
        if (rdNam.isSelected()) {
            kh.setGioiTinh("Nam");
        } else {
            kh.setGioiTinh("Nữ");
        }
        kh.setNgaySinh(ngay);
        kh.setDiaChi(txtDiaChi.getText());
        kh.setSdt(txtSoDienThoai.getText());
        kh.setEmail(txtEmail.getText());
        if (cbTinhTrang.getSelectedItem().equals("Khách hàng thân thiết")) {
            kh.setTinhTrang(true);
        } else {
            kh.setTinhTrang(false);
        }
//        ViDiem vi= (ViDiem) cbViDiem.getSelectedItem();
//        String idVi = vi.getId();
//        kh.setIdViDiem(idVi);
        return kh;
    }

    private void display() {

        int row = tbKh.getSelectedRow();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) tbKh.getValueAt(row, 3));
            jNgaySinh.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(FormKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        String name = (String) tbKh.getValueAt(row, 1);
        txtMaKh.setText((String) tbKh.getValueAt(row, 0));
        txtTen.setText(name);
        if (tbKh.getValueAt(row, 2).equals("Nam")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        txtDiaChi.setText(tbKh.getValueAt(row, 4).toString());
        txtSoDienThoai.setText((String) tbKh.getValueAt(row, 5));
        txtEmail.setText((String) tbKh.getValueAt(row, 6));
        if (tbKh.getValueAt(row, 7).equals("Khách hàng thân thiết")) {
            cbTinhTrang.setSelectedIndex(0);
        } else {
            cbTinhTrang.setSelectedIndex(1);
        }
    }

    private void clearFormData() {
        txtMaKh.setText("");
        txtTen.setText("");
        jNgaySinh.setCalendar(null);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.clearSelection();
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        cbTinhTrang.setSelectedIndex(0);
    }

//    private void loadCBNXB() {
//        defaultComboBoxModel = (DefaultComboBoxModel) cbViDiem.getModel();
//        List<ViDiem> listVi = viDiemService.getAll();
//        for (ViDiem viDiem : listVi) {
//            defaultComboBoxModel.addElement(viDiem.getMa());
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGuiMail = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbTinhTrang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jNgaySinh = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1010, 640));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        tbKh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbKh);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Tên:");

        jLabel3.setText("Ngày sinh:");

        jLabel4.setText("Giới tính:");

        rdNam.setText("Nam");

        rdNu.setText("Nữ");

        jLabel5.setText("SDT:");

        jLabel6.setText("Email:");

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnGuiMail.setText("Gui Mail");
        btnGuiMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMailActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã KH:");

        jLabel10.setText("Tình Trạng:");

        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng thân thiết", "Khách hàng không thân thiết" }));

        jLabel8.setText("Địa chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jNgaySinh.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdNu))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnThem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSua))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(90, 90, 90)
                                .addComponent(btnGuiMail))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jButton1)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuiMail)
                    .addComponent(btnXoa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String mess = khachHangService.add(getData());
        JOptionPane.showMessageDialog(this, mess);
        List<KhachHangReponse> listAdd = khachHangService.getAll();
        fillToTable(listAdd);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (tbKh.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn bản ghi.");
            return;
        }
        int row = tbKh.getSelectedRow();
        String maKh = tbKh.getValueAt(row, 0).toString();
        String mess = khachHangService.delete(maKh);
        JOptionPane.showMessageDialog(this, mess);
        fillToTable(list);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhMouseClicked
        // TODO add your handling code here:
        display();
    }//GEN-LAST:event_tbKhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (tbKh.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để sửa");
        } else {
            String maKh = txtMaKh.getText();
            String mess = khachHangService.update(getData(), maKh);
            JOptionPane.showMessageDialog(this, mess);
            clearFormData();
            List<KhachHangReponse> listUp = khachHangService.getAll();
            fillToTable(listUp);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnGuiMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMailActionPerformed
        // TODO add your handling code here:
        GuiMail guiMail = new GuiMail();
        guiMail.setVisible(true);
    }//GEN-LAST:event_btnGuiMailActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        // TODO add your handling code here:
        list = khachHangService.search(txtTimKiem.getText());
        fillToTable(list);
        System.out.println(list);
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFormData();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiMail;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JDateChooser jNgaySinh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbKh;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
