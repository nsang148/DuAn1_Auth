package Repository;

import Untility.DBContext;
import ViewModels.ThanhToan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author bach
 */
public class ThanhToanRepository {

    public ArrayList<ThanhToan> all() {
        ArrayList<ThanhToan> listTT = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            String sql = "SELECT A.Ten,B.Ten,C.Ten,D.Ten,E.GIA,E.SOLUONGTON from CHITIETSACH E inner join SACH A on A.Id = E.ID_SACH inner join THELOAI B on E.ID_THELOAI = B.Id inner join TACGIA C on C.Id = E.ID_TACGIA inner join NXB D on D.Id = E.ID_NXB ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String tenSach = rs.getString("A.TEN");
                String tacGia = rs.getString("B.TEN");
                String theLoai = rs.getString("C.TEN");
                String NXB = rs.getString("D.TEN");
                int slTon = rs.getInt("E.SOLUONGTON");
                int gia = rs.getInt("E.GIA");
                ThanhToan tt = new ThanhToan(tenSach,tacGia, theLoai, NXB, slTon, gia);
                listTT.add(tt);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listTT;
    }
}
