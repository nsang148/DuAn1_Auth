package View;

import javax.swing.JOptionPane;
import DomainModels.NhanVien;
import Service.Implement.NhanVienServiceimpl;
import java.awt.Image;
import java.io.File;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class NhanVienForm extends javax.swing.JFrame {

    private DefaultTableModel model;
    private NhanVienServiceimpl service;
    private String isClicked;

    public NhanVienForm() {
        initComponents();
        service = new NhanVienServiceimpl();
        // setExtendedState(MAXIMIZED_BOTH); 
        setLocationRelativeTo(this);
        setTitle("Phần mềm quản lý bán sách");
        this.loadTable();

    }

    private void loadTable() {
        model = (DefaultTableModel) this.tblNV.getModel();
        model.setRowCount(0);
        for (NhanVien item : this.service.getList()) {
            String ngaySinh = item.getNgaySinh();
            String ngay = "", thang = "", nam = "";
            String[] ngaySinhSplit = ngaySinh.split("-");
            ngay = ngaySinhSplit[0];
            thang = ngaySinhSplit[1];
            nam = ngaySinhSplit[2];
            model.addRow(new Object[]{
                item.getID(),
                item.getMaNV(),
                item.getHo() + " " + item.getTenDem() + " " + item.getTen(),
                item.getGioiTinh(),
                ngay + "-" + thang + "-" + nam,
                item.getSdt(),
                item.getDiaChi(),
                item.getMatKhau(),
                item.getVaiTro(),
                item.getTinhTrang() == 0 ? "Đang làm việc" : "Đã nghỉ việc"});
        }
    }

    private boolean checkData() {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (this.txtMa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống !");
            return false;
        } else if (this.txtDiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
            return false;
        } else if (this.txtHo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ không được để trống !");
            return false;
        } else if (this.txtMatKhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống !");
            return false;
        } else if (this.txtNam.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Năm không được để trống !");
            return false;
        } else if (this.txtNgay.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày không được để trống !");
            return false;
        } else if (this.txtSDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống !");
            return false;
        } else if (Pattern.matches("[0-9]", this.txtHo.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Họ không được có số !");
            return false;
        } else if (Pattern.matches("[0-9]", this.txtTen.getText())  == true) {
            JOptionPane.showMessageDialog(this, "Tên không được có số !");
            return false;
        } else if (Pattern.matches("[0-9]", this.txtTenDem.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Tên đệm không được có số !");
            return false;
        } else if (this.txtTenDem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên đệm không được để trống !");
            return false;
        } else if (Pattern.matches("[a-zA-Z]", this.txtThang.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Tháng không được có chữ !");
            return false;
        } else if (Pattern.matches("[a-zA-Z]", this.txtNgay.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Ngày không được có chữ !");
            return false;
        } else if (Pattern.matches("[a-zA-Z]", this.txtNam.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Năm không được có chữ !");
            return false;
        } else if (Pattern.matches("[a-zA-Z]", this.txtSDT.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được có chữ !");
            return false;
        } else if (this.txtThang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tháng không được để trống !");
            return false;
        } else if (this.txtSDT.getText().matches(reg) != true) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng !");
            return false;
        } else {
            try {
                int nam = 0, thang = 0, ngay = 0;
                nam = Integer.valueOf(this.txtNam.getText());
                thang = Integer.valueOf(this.txtThang.getText());
                ngay = Integer.valueOf(this.txtNgay.getText());
                if (nam < 0) {
                    JOptionPane.showMessageDialog(this, "Năm không được âm !");
                    return false;
                } else if (thang < 1 && thang > 12) {
                    JOptionPane.showMessageDialog(this, "Tháng không tồn tại !");
                    return false;
                } else if (ngay < 0) {
                    JOptionPane.showMessageDialog(this, "Ngày không không tồn tại !");
                    return false;
                } else {
                    if ((thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) && ngay > 31) {
                        JOptionPane.showMessageDialog(this, "Ngày không tồn tại !");
                        return false;
                    } else if ((thang == 4 || thang == 6 || thang == 11 || thang == 9) && ngay > 30) {
                        JOptionPane.showMessageDialog(this, "Ngày không tồn tại !");
                        return false;
                    } else if ((thang == 2) && ngay > 29) {
                        JOptionPane.showMessageDialog(this, "Ngày không tồn tại !");
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ngày tháng năm phải là số");
                return false;
            }
        }
    }

    private NhanVien getData() {
        return new NhanVien(null,
                this.txtMa.getText().trim().toUpperCase(),
                this.txtTen.getText().trim().toUpperCase(),
                this.txtTenDem.getText().trim().toUpperCase(),
                this.txtHo.getText().trim().toUpperCase(),
                this.rbNam.isSelected() ? "Nam" : "Nữ",
                this.txtNam.getText().trim().toUpperCase() + "-" + this.txtThang.getText().trim().toUpperCase() + "-" + this.txtNgay.getText().trim().toUpperCase(),
                this.txtSDT.getText().trim(),
                this.txtDiaChi.getText().trim().toUpperCase(),
                this.txtMatKhau.getText().trim(),
                Integer.parseInt(this.rbDLV.isSelected() ? "0" : "1"),
                this.cbbVaiTro.getSelectedItem().toString(),
                this.lblAnh.getName());
    }

    private void loadTableTK() {
        model = (DefaultTableModel) this.tblNV.getModel();
        model.setRowCount(0);
        for (NhanVien item : this.service.search(txtTimKiemTen.getText())) {
            String ngaySinh = item.getNgaySinh();
            String ngay = "", thang = "", nam = "";
            String[] ngaySinhSplit = ngaySinh.split("-");
            ngay = ngaySinhSplit[0];
            thang = ngaySinhSplit[1];
            nam = ngaySinhSplit[2];
            model.addRow(new Object[]{
                item.getID(),
                item.getMaNV(),
                item.getHo() + " " + item.getTenDem() + " " + item.getTen(),
                item.getGioiTinh(),
                ngay + "-" + thang + "-" + nam,
                item.getSdt(),
                item.getDiaChi(),
                item.getMatKhau(),
                item.getVaiTro(),
                item.getTinhTrang() == 0 ? "Đang làm việc" : "Đã nghỉ việc"});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTenDem = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        txtThang = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbbVaiTro = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        rbDLV = new javax.swing.JRadioButton();
        rbDNV = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        panel = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        txtTimKiemTen = new javax.swing.JTextField();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnSapXep1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        btnXoa2 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1425, 729));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản lý bán sách");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 63));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 130));

        jPanel6.setBackground(new java.awt.Color(64, 43, 100));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconhoadon.png"))); // NOI18N
        jLabel4.setText("Hóa Đơn");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, 50));

        jPanel7.setBackground(new java.awt.Color(64, 43, 100));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-nhanvien.png"))); // NOI18N
        jLabel5.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, 50));

        jPanel8.setBackground(new java.awt.Color(64, 43, 100));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-thongke.png"))); // NOI18N
        jLabel6.setText("Thống kê");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, -1, 50));

        jPanel9.setBackground(new java.awt.Color(64, 43, 100));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-sach.png"))); // NOI18N
        jLabel7.setText("Quản lý sách");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, 50));

        jPanel10.setBackground(new java.awt.Color(64, 43, 100));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-home.png"))); // NOI18N
        jLabel8.setText("Bán Hàng");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, 50));

        jPanel11.setBackground(new java.awt.Color(64, 43, 100));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-sale.png"))); // NOI18N
        jLabel9.setText("Khuyến Mãi");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, 50));

        jPanel12.setBackground(new java.awt.Color(64, 43, 100));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-khachhang.png"))); // NOI18N
        jLabel10.setText("Khách Hàng");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, 50));

        jPanel4.setBackground(new java.awt.Color(54, 33, 89));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-exit1.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, 40, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 730));

        jPanel13.setBackground(new java.awt.Color(116, 119, 189));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quản lý nhân viên");

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(975, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã nhân viên :");

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Họ :");

        txtHo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHo.setPreferredSize(new java.awt.Dimension(80, 31));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tên Đệm :");

        txtTenDem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenDem.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tên :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Giới tính :");

        rbNam.setText("Nam");

        rbNu.setText("Nữ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Ngày :");

        txtNgay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNgay.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtThang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtThang.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tháng :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Năm :");

        txtNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNam.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Số điện thoại :");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Mật khẩu :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Chức vụ :");

        cbbVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tình trạng :");

        buttonGroup1.add(rbDLV);
        rbDLV.setSelected(true);
        rbDLV.setText("Đang làm việc");

        buttonGroup1.add(rbDNV);
        rbDNV.setText("Đã nghỉ việc");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Địa chỉ :");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiaChi.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Ảnh :");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(rbNam)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(rbNu)
                                    .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addComponent(jLabel3)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 84, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(txtNgay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNam)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbVaiTro, 0, 180, Short.MAX_VALUE)
                    .addComponent(txtSDT)
                    .addComponent(txtDiaChi)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21)
                    .addComponent(txtMatKhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel22))
                    .addComponent(rbDLV, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(rbDNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(rbDLV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel23)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel19))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel21)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbbVaiTro))
                            .addComponent(rbDNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTimKiemTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiemTen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimKiemTen.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemTenCaretUpdate(evt);
            }
        });
        txtTimKiemTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTimKiemTenMouseExited(evt);
            }
        });
        txtTimKiemTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemTenActionPerformed(evt);
            }
        });

        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_add.png"))); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_update.png"))); // NOI18N
        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_delete.png"))); // NOI18N
        btnXoa1.setText("Xoá");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnSapXep1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_sapxep.png"))); // NOI18N
        btnSapXep1.setText("Sắp xếp");
        btnSapXep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXep1ActionPerformed(evt);
            }
        });

        jLabel25.setText("Nhập thông tin bất kỳ để tìm kiếm :");

        btnXoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_loading.png"))); // NOI18N
        btnXoa2.setText("Reset");
        btnXoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTimKiemTen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSapXep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem1)
                    .addComponent(btnSapXep1))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua1)
                    .addComponent(btnXoa1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa2)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã nhân viên", "Họ và Tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Mật khẩu", "Chức vụ", "Tình trạng"
            }
        ));
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNV);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1160, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        TrangChuForm trangchu = new TrangChuForm();
        trangchu.setVisible(true);
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        HoaDonForm hd = new HoaDonForm();
        hd.setVisible(true);

    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        NhanVienForm nhanvien = new NhanVienForm();
        nhanvien.setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        ThongKeForm thongke = new ThongKeForm();
        thongke.setVisible(true);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        QLSachForm sach = new QLSachForm();
        sach.setVisible(true);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        KhuyenMaiForm km = new KhuyenMaiForm();
        km.setVisible(true);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        KhachHangForm kh = new KhachHangForm();
        kh.setVisible(true);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon("src\\icon\\icon_sad.png");
        int click = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát à?", "Thoát khỏi đây", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
        if (click == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            int imgW = this.lblAnh.getWidth();
            int imgH = this.lblAnh.getHeight();
            ImageIcon icon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage().getScaledInstance(imgW, imgH, Image.SCALE_DEFAULT));
            this.lblAnh.setName(selectedFile.getAbsolutePath());
            this.lblAnh.setIcon(icon);
            this.lblAnh.setHorizontalAlignment(JLabel.CENTER);
            this.lblAnh.setVerticalAlignment(JLabel.CENTER);
        }
    }//GEN-LAST:event_lblAnhMouseClicked

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked

    }//GEN-LAST:event_panelMouseClicked

    private void txtTimKiemTenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemTenCaretUpdate
        // TODO add your handling code here:
        this.loadTableTK();
    }//GEN-LAST:event_txtTimKiemTenCaretUpdate

    private void txtTimKiemTenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemTenMouseExited
        // TODO add your handling code here:
        this.loadTable();
    }//GEN-LAST:event_txtTimKiemTenMouseExited

    private void txtTimKiemTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemTenActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm nhân viên này ?", "Thông báo", 0);
        if (confirm == 0) {
            if (this.checkData() == false) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin chính xác", "Cảnh báo", 2);
            } else {
                this.service.insert(this.getData());
                this.loadTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã huỷ yêu cầu.");
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa nhân viên này ?", "Thông báo", 0);
        NhanVien obj = this.getData();
        obj.setID(isClicked);
        if (confirm == 0) {
            this.service.update(obj);
            this.loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Đã huỷ yêu cầu.");
        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá nhân viên này ?", "Thông báo", 0);
        if (confirm == 0) {
            this.service.delete(isClicked);
            this.loadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Đã huỷ yêu cầu.");
        }
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnSapXep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXep1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sắp xếp nhân viên này ?", "Thông báo", 0);
        if (confirm == 0) {
            model = (DefaultTableModel) this.tblNV.getModel();
            model.setRowCount(0);
            for (NhanVien item : this.service.sortListNhanVien()) {
                model.addRow(new Object[]{
                    item.getID(),
                    item.getMaNV(),
                    item.getHo() + " " + item.getTenDem() + " " + item.getTen(),
                    item.getGioiTinh(),
                    item.getNgaySinh(),
                    item.getSdt(),
                    item.getDiaChi(),
                    item.getMatKhau(),
                    item.getVaiTro(),
                    item.getTinhTrang() == 0 ? "Đang làm việc" : "Đã nghỉ việc"});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đã huỷ yêu cầu.");
        }
    }//GEN-LAST:event_btnSapXep1ActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        int row = this.tblNV.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn không chọn dòng !");
        } else {
            isClicked = this.tblNV.getModel().getValueAt(row, 0).toString();
            this.txtMa.setText(this.tblNV.getModel().getValueAt(row, 1).toString());
            String hoVaTen = this.tblNV.getModel().getValueAt(row, 2).toString();
            String ho = "", tenDem = "", ten = "";
            String[] hoVaTenSplit = hoVaTen.split(" ");
            ho = hoVaTenSplit[0];
            ten = hoVaTenSplit[hoVaTenSplit.length - 1];
            for (int i = 0; i < hoVaTenSplit.length; i++) {
                if (i > 0 && i < hoVaTenSplit.length - 1) {
                    tenDem += hoVaTenSplit[i] + " ";
                }
            }
            this.txtHo.setText(ho);
            this.txtTenDem.setText(tenDem);
            this.txtTen.setText(ten);
            if (this.tblNV.getModel().getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
                this.rbNam.setSelected(true);
            } else {
                this.rbNu.setSelected(true);
            }
            String ngaySinh = this.tblNV.getModel().getValueAt(row, 4).toString();
            String ngay = "", thang = "", nam = "";
            String[] ngaySinhSplit = ngaySinh.split("-");
            ngay = ngaySinhSplit[0];
            thang = ngaySinhSplit[1];
            nam = ngaySinhSplit[2];
            this.txtNgay.setText(nam);
            this.txtThang.setText(thang);
            this.txtNam.setText(ngay);
            this.txtSDT.setText(this.tblNV.getModel().getValueAt(row, 5).toString());
            this.txtDiaChi.setText(this.tblNV.getModel().getValueAt(row, 6).toString());
            this.txtMatKhau.setText(this.tblNV.getModel().getValueAt(row, 7).toString());
            this.cbbVaiTro.setSelectedItem(this.tblNV.getModel().getValueAt(row, 8).toString());
            System.out.println(this.tblNV.getModel().getValueAt(row, 8).toString());
            if (this.tblNV.getModel().getValueAt(row, 9).toString().equalsIgnoreCase("Đang làm việc")) {
                this.rbDLV.setSelected(true);
            } else {
                this.rbDNV.setSelected(true);
            }
            ImageIcon anh = new ImageIcon(this.service.getNVByID(isClicked).getAnh());
            int wid = this.lblAnh.getWidth();
            int hei = this.lblAnh.getHeight();
            this.lblAnh.setIcon(anh);
        }
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnXoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa2ActionPerformed
        this.txtNgay.setText("");
        this.txtThang.setText("");
        this.txtNam.setText("");
        this.txtSDT.setText("");
        this.txtDiaChi.setText("");
        this.txtMatKhau.setText("");
        this.cbbVaiTro.setSelectedItem(0);
        this.rbDLV.setSelected(true);
        txtMa.setText("");
        txtHo.setText("");
        txtTenDem.setText("");
        txtTen.setText("");


    }//GEN-LAST:event_btnXoa2ActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSapXep1;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXoa2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbVaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton rbDLV;
    private javax.swing.JRadioButton rbDNV;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    private javax.swing.JTextField txtThang;
    private javax.swing.JTextField txtTimKiemTen;
    // End of variables declaration//GEN-END:variables
}
