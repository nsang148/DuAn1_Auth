package Repository;

import Untility.DBContext;
import ViewModels.ThanhToan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author bach
 */
public class ThanhToanRepository {

    public List<ThanhToan> all() {
        List<ThanhToan> listTT = new ArrayList<>();
        String sql = "SELECT A.TEN,B.TEN,C.TEN,D.TEN,A.SOLUONGTON,A.DONGIA from SACH A \n"
                + "                         inner join THELOAI B on A.ID_THELOAI = B.Id\n"
                + "                         inner join TACGIA C on A.ID_TACGIA = C.Id\n"
                + "                         inner join NXB D on A.ID_NXB = D.Id";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                ThanhToan tt = new ThanhToan();
                tt.setTenSach(rs.getString(1));
                tt.setTacGia(rs.getString(2));
                tt.setTheLoai(rs.getString(3));
                tt.setNXB(rs.getString(4));
                tt.setSoLuongTon(rs.getInt(5));
                tt.setDonGia(rs.getInt(6));
//                ThanhToan tt = new ThanhToan(tenSach, tacGia, theLoai, NXB, slTon, gia);
                listTT.add(tt);
            }
        } catch (Exception ex) {
        }

        return listTT;
    }
}
