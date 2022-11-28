package Repository;

import DomainModels.HoaDon;
import Untility.DBContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class HoaDonRepository {

    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;

    private DBContext conn;

    public HoaDonRepository() {
        conn = new DBContext();
    }

    public List<HoaDon> layHoaDon() {
        List<HoaDon> listHD = new ArrayList<>();
        String sql = "SELECT * FROM HOADON";

        try {
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("Id");
                String idKH = rs.getString("ID_KHACHHANG");
                String idNV = rs.getString("ID_NHANVIEN");
                String idVi = rs.getString("ID_VIDIEM");
                String ma = rs.getString("MA");
                String ngayTao = rs.getString("NGAYTAO");
                String ngayThanhToan = rs.getString("NGAYTHANHTOAN");
                String tienKhachDua = rs.getString("TIENKHACHDUA");
                String tongTien = rs.getString("TONGTIEN");
                int tt = rs.getInt("TINHTRANG");
                String diemKH = rs.getString("SODIEMKHACHHANG");
                HoaDon hd = new HoaDon(id, idKH, idNV, idVi, ma, ngayTao, ngayThanhToan, tienKhachDua, tongTien, diemKH, tt);
                listHD.add(hd);

            }
        } catch (Exception e) {
            System.out.println("Loi khi lay danh sach hoa don");
        }
        return listHD;
    }
}
