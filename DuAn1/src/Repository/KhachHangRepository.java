/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhachHangModel;
import Untility.DBContext;
import ViewModels.KhachHangReponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sangh
 */
public class KhachHangRepository {

    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;

    public KhachHangRepository() {
    }

    public List<KhachHangReponse> getKH() {
        String query = "SELECT Id, MAKH, HO +' '+TenDem+' '+Ten,GioiTinh,NgaySinh,Sdt,Email,ViDiem.TongDiem,ViDiem.SoDiemDaDung,ViDiem.SoDiemDaCong,TinhTrang FROM KhachHang join ViDiem on KhachHang.IdViDiem = ViDiem.Id";
        List<KhachHangReponse> kvr = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                KhachHangReponse kh = new KhachHangReponse();
                kh.setId(rs.getString(1));
                kh.setMa(rs.getString(2));
                kh.setHoTen(rs.getString(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setNgaySinh(rs.getString(5));
                kh.setSdt(rs.getString(6));
                kh.setEmail(rs.getString(7));
                kh.setTongDiem(rs.getInt(8));
                kh.setSoDiemDaDung(rs.getInt(9));
                kh.setSoDiemDaCong(rs.getInt(10));
                kh.setTinhTrang(rs.getBoolean(11));
                kvr.add(kh);
            }
        } catch (Exception ex) {
        }
        return kvr;
    }

    public String insert(KhachHangModel kh) {
        String insert = "Insert into KHACHHANG(MAKH,TEN,TENDEM,HO,GIOITINH,NGAYSINH,SDT,EMAIL,TINHTRANG) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            psm = DBContext.getConnection().prepareStatement(insert);

            psm.setObject(1, kh.getMaKH());
            psm.setObject(2, kh.getTenKH());
            psm.setObject(3, kh.getTenDem());
            psm.setObject(4, kh.getHo());
            psm.setObject(5, kh.getGioiTinh());
            psm.setObject(6, kh.getNgaySinh());
            psm.setString(7, kh.getSdt());
            psm.setObject(8, kh.getEmail());
            psm.setObject(9, kh.getTinhTrang());
            psm.executeUpdate();
            return "Thêm thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm không thành công";
        }
    }

    public String update(KhachHangModel kh) {
        String update = "UPDATE  KhachHang SET  MaKh= ?, Ten = ?, Tendem = ?, Ho = ?, GioiTinh = ?, NgaySinh = ?, Sdt = ?, Email = ?, TinhTrang = ? WHERE id = ?";
        try {
            psm = DBContext.getConnection().prepareStatement(update);
            psm.setObject(1, kh.getMaKH());
            psm.setObject(2, kh.getTenKH());
            psm.setObject(3, kh.getTenDem());
            psm.setObject(4, kh.getHo());
            psm.setObject(5, kh.getGioiTinh());
            psm.setString(6, kh.getNgaySinh());
            psm.setObject(7, kh.getSdt());
            psm.setObject(8, kh.getEmail());
            psm.setObject(9, kh.getTinhTrang());
            psm.setObject(10, kh.getIdKH());

            psm.executeUpdate();
            return "Sửa thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sửa không thành công";
        }
    }

    public String delete(String id) {
        String delete = "DELETE FROM  KhachHang WHERE Id = ?";
        try {
            psm = DBContext.getConnection().prepareStatement(delete);
            psm.setObject(1, id);

            psm.executeUpdate();
            return "Xóa thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xóa không thành công";
        }
    }
}
