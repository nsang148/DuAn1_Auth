/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhanVien;
import Untility.DBContext;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tran Tuan Cuong
 */
public class NhanVienRepository {

    public NhanVienRepository() {
    }

    public List<NhanVien> all() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        String SELECT_NHANVIEN = "SELECT * FROM KHUYENMAIHOADON";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_NHANVIEN);
            while (rs.next()) {
                listNhanVien.add(new NhanVien(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13)));
            }
        } catch (SQLException ex) {
            System.out.println("Loi tai getAll()");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return listNhanVien;
    }

    public boolean insert(NhanVien obj) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String INSERT_NHANVIEN = "INSERT INTO dbo.NHANVIEN(MANV,TEN,TENDEM,HO,GIOITINH,NGAYSINH,SDT,DIACHI,MATKHAU,TINHTRANG,VAITRO,ANH) VALUES (" + obj.getMaNV() + ","
                    + "" + obj.getTen() + ","
                    + "" + obj.getTenDem() + ","
                    + "" + obj.getHo() + ","
                    + "" + obj.getGioiTinh() + ","
                    + "" + obj.getNgaySinh() + ","
                    + "" + obj.getSdt() + ","
                    + "" + obj.getDiaChi() + ","
                    + "" + obj.getMatKhau() + ","
                    + "" + obj.getTinhTrang() + ","
                    + "" + obj.getVaiTro() + ","
                    + "" + obj.getAnh() + ")";
            st.executeUpdate(INSERT_NHANVIEN);
            st.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi tai add()");
            return false;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String ID) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String REMOVE_NHANVIEN = "DELETE FROM NHANVIEN WHERE ID = '" + ID + "'";
            st.executeUpdate(REMOVE_NHANVIEN);
            st.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Loi tai remove()");
            return false;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(NhanVien obj) {
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            String UPDATE_NHANVIEN = "UPDATE NHANVIEN SET MANV = '" + obj.getMaNV()
                    + "',TEN = '" + obj.getTen()
                    + "',TENDEM = '" + obj.getTenDem()
                    + "',HO = '" + obj.getHo()
                    + "',GIOITINH = '" + obj.getGioiTinh()
                    + "',NGAYSINH = " + obj.getNgaySinh()
                    + "',SDT = " + obj.getSdt()
                    + "',DIACHI = " + obj.getDiaChi()
                    + "',MATKHAU = " + obj.getMatKhau()
                    + "',TINHTRANG = " + obj.getTinhTrang()
                    + "',VAITRO = " + obj.getVaiTro()
                    + "',ANH = " + obj.getAnh()
                    + " WHERE ID = '" + obj.getID() + "'";
            st.executeUpdate(UPDATE_NHANVIEN);
            st.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Lỗi không thể kết nối vào CSDL tại update()");
            return false;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    public NhanVien search(String ID) {
        NhanVien obj = new NhanVien();
        String SEARCH_NHANVIEN = "SELECT * FROM NHANVIEN WHERE ID = " + ID + "";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SEARCH_NHANVIEN);
            while (rs.next()) {
                obj.setID(rs.getString(1));
                obj.setMaNV(rs.getString(2));
                obj.setTen(rs.getString(3));
                obj.setTenDem(rs.getString(4));
                obj.setHo(rs.getString(5));
                obj.setGioiTinh(rs.getString(6));
                obj.setNgaySinh(rs.getString(7));
                obj.setSdt(rs.getString(8));
                obj.setDiaChi(rs.getString(9));
                obj.setMatKhau(rs.getString(10));
                obj.setTinhTrang(rs.getInt(11));
                obj.setVaiTro(rs.getString(12));
                obj.setAnh(rs.getString(13));
            }
        } catch (SQLException ex) {
            System.out.println("Loi tai getAll()");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return obj;
    }
}
