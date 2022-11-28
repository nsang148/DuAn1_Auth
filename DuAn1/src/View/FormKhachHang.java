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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author This PC
 */
public class FormKhachHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormThongKe
     */
    DefaultTableModel defaultTableModel;
    private DefaultTableModel model;
    KhachHangService khachHangService;
    List<KhachHangReponse> list;

    public FormKhachHang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        defaultTableModel = (DefaultTableModel) tbKh.getModel();
        String[] header = {"ID", "Mã KH", "Họ và tên", "Giới tính", "Ngày sinh", "SDT", "Email", "Tính trạng"};
        defaultTableModel.setColumnIdentifiers(header);
        khachHangService = new KhachHangIplement();
        fillToTable();
        btg();
    }

    private void btg() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdNam);
        buttonGroup.add(rdNu);

    }

    private void fillToTable() {
        defaultTableModel.setRowCount(0);
        list = khachHangService.getAll();
        System.out.println(list);
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String[] data = new String[8];
                data[0] = list.get(i).getId();
                data[1] = list.get(i).getMa();
                data[2] = list.get(i).getHoTen();
                data[3] = list.get(i).getGioiTinh();
                data[4] = list.get(i).getNgaySinh();
                data[5] = list.get(i).getSdt();
                data[6] = list.get(i).getEmail();
                if (list.get(i).getTinhTrang() == 1) {
                    data[7] = "KHTT";
                } else {
                    data[7] = "Không thân thiết";
                }

                defaultTableModel.addRow(data);
                System.out.println(list);
            }
            tbKh.setModel(defaultTableModel);
            defaultTableModel.fireTableDataChanged();
        }
    }

    private KhachHangModel getData() {
        KhachHangModel kh = new KhachHangModel();
        kh.setIdKH(lblID.getText());
        kh.setMaKH(txtMaKh.getText());
        kh.setTenKH(txtTen.getText());
        kh.setTenDem(txtTenDem.getText());
        kh.setHo(txtHo.getText());
        if (rdNam.isSelected()) {
            kh.setGioiTinh("Nam");
        } else {
            kh.setGioiTinh("Nữ");
        }
        kh.setNgaySinh(txtNgaySinh.getText());
        kh.setSdt(txtSoDienThoai.getText());
        kh.setEmail(txtEmail.getText());
        kh.setTinhTrang(Integer.parseInt(txtTt.getText()));
        return kh;
    }

    private void display() {
        int row = tbKh.getSelectedRow();
        String name = (String) tbKh.getValueAt(row, 2);
        lblID.setText(tbKh.getValueAt(row, 0).toString());
        txtMaKh.setText((String) tbKh.getValueAt(row, 1));
        txtTen.setText(name.split(" ")[2]);
        txtTenDem.setText(name.split(" ")[1].trim());
        txtHo.setText(name.split(" ")[0]);
        txtNgaySinh.setText(tbKh.getValueAt(row, 4).toString());
        if (tbKh.getValueAt(row, 3).equals("Nam")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        txtSoDienThoai.setText((String) tbKh.getValueAt(row, 5));
        txtEmail.setText((String) tbKh.getValueAt(row, 6));
        if (tbKh.getValueAt(row, 7).equals("KHTT")) {
            txtTt.setText("1");
        } else {
            txtTt.setText("0");
        }
    }

    private void clearFormData() {
        lblID.setText("");
        txtMaKh.setText("");
        txtTen.setText("");
        txtTenDem.setText("");
        txtHo.setText("");
        txtNgaySinh.setText("");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.clearSelection();
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txtTt.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        btnImportExcel = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTenDem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTt = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(930, 640));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTim.setText("Tim");

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
                .addGap(16, 16, 16)
                .addComponent(btnTim)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("ID");

        jLabel2.setText("Ten");

        jLabel3.setText("Ngay Sinh");

        jLabel4.setText("Gioi tinh");

        rdNam.setText("Nam");

        rdNu.setText("Nu");

        jLabel5.setText("SDT");

        jLabel6.setText("Email");

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

        btnImportExcel.setText("Import Excel");
        btnImportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportExcelActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã KH:");

        jLabel8.setText("Tên đêm:");

        jLabel9.setText("Họ:");

        jLabel10.setText("Tình Trạng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1))
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtMaKh, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(rdNam)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(rdNu))
                                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTt)))
                                        .addGap(0, 12, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtHo, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                            .addComponent(txtTenDem))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnImportExcel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuiMail)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua)
                        .addGap(42, 42, 42))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnGuiMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImportExcel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void btnImportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportExcelActionPerformed
        File excelFile;
        FileInputStream excelFis = null;
        BufferedInputStream excelBis = null;
        String defaultCurrentDirectoryPath = "C:\\Users\\sangh\\Documents";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFis = new FileInputStream(excelFile);
                excelBis = new BufferedInputStream(excelFis);

                XSSFWorkbook excelJtableImport = new XSSFWorkbook(excelBis);
                XSSFSheet excelSheet = excelJtableImport.getSheetAt(0);

                for (int row = 0; row < 10; row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    for (int column = 0; column < 10; column++) {

                        XSSFCell excelCell = excelRow.getCell(column);
                        System.out.println(excelCell.getStringCellValue());
                    }
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnImportExcelActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String mess = khachHangService.add(getData());
        JOptionPane.showMessageDialog(this, mess);
        fillToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (tbKh.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chua chon ban ghi");
            return;
        }
        int row = tbKh.getSelectedRow();
        String maKh = tbKh.getValueAt(row, 0).toString();
        String mess = khachHangService.delete(maKh);
        JOptionPane.showMessageDialog(this, mess);
        fillToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhMouseClicked
        // TODO add your handling code here:
        display();
    }//GEN-LAST:event_tbKhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (tbKh.getSelectedColumn() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên để sửa");
        } else {
            String mess = khachHangService.update(getData());
            JOptionPane.showMessageDialog(this, mess);
            clearFormData();
            fillToTable();
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiMail;
    private javax.swing.JButton btnImportExcel;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblID;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbKh;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTt;
    // End of variables declaration//GEN-END:variables

}
