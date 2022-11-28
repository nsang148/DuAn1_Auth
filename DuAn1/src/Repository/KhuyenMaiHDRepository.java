/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuyenMaiHD;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc
 */
public class KhuyenMaiHDRepository {

    public KhuyenMaiHDRepository() {
    }

    public List<KhuyenMaiHD> getAll() {
        List<KhuyenMaiHD> lstKMHD = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "SELECT * FROM KHUYENMAIHOADON";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                lstKMHD.add(new KhuyenMaiHD(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return lstKMHD;
    }

    public boolean add(KhuyenMaiHD obj) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String INSERT_KHUYENMAIHOADON = "INSERT INTO KHUYENMAIHOADON (MA, TEN, PHANTRAMGIAM, NGAYAPDUNG, NGAYKETTHUC, TINHTRANG) VALUES('" + obj.getMa() + "','" + obj.getTen() + "','" + obj.getPhanTramGiam() + "','" + obj.getNgayApDung() + "','" + obj.getNgayKetThuc() + "','" + obj.getTinhTrang() + "')";
            st.executeUpdate(INSERT_KHUYENMAIHOADON);
            System.out.println(INSERT_KHUYENMAIHOADON);
            st.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Loi tai add()");
            return false;
        }
    }

    public boolean remove(KhuyenMaiHD obj) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String REMOVE_KhuyenMaiHD = "DELETE FROM KHUYENMAIHOADON WHERE ID = '" + obj.getId() + "'";
            st.executeUpdate(REMOVE_KhuyenMaiHD);
            st.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Loi tai remove()");
            return false;
        }
    }

    public boolean update(KhuyenMaiHD obj) {
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            String UPDATE_KhuyenMaiHD = "UPDATE KHUYENMAIHOADON SET MA = '" + obj.getMa() + "',Ten = '" + obj.getTen() + "',PHANTRAMGIAM = '" + obj.getPhanTramGiam() + "',NGAYAPDUNG = '" + obj.getNgayApDung() + "',NGAYKETTHUC = '" + obj.getNgayKetThuc() + "',TINHTRANG = " + obj.getTinhTrang() + " WHERE ID = '" + obj.getId() + "'";
            st.executeUpdate(UPDATE_KhuyenMaiHD);
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi không thể kết nối vào CSDL tại update()");
            return false;
        }
    }
}
