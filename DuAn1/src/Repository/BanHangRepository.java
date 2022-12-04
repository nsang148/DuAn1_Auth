/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Untility.DBContext;
import ViewModels.SanPhamThanhToan;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author acer
 */
public class BanHangRepository {
     public List<SanPhamThanhToan> getALLSP() {
        List<SanPhamThanhToan> listHD = new ArrayList<>();
        String sql = "select S.TEN, S.Ma ,tl.TEN, tg.TEN, nxb.TEN, s.SOLUONGTON, s.Gia from SACH s join THELOAI tl on s.ID_THELOAI = tl.Id join TACGIA tg on s.ID_TACGIA = tg.Id join NXB nxb on s.ID_NXB = nxb.Id";

        try {
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listHD.add(new SanPhamThanhToan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7)));
            }
        } catch (Exception e) {
            System.out.println("Loi khi lay danh sach hoa don");
        }
        return listHD;
    }
}
