
package Repository;

import DomainModels.HoaDon;
import Untility.DBContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.* ;


public class HoaDonRepository {
    private DBContext connectionCuaVo;

    public HoaDonRepository() {
    connectionCuaVo=new DBContext();
    }
    public List<HoaDon> layHoaDon(){
        List<HoaDon> listHD = new ArrayList<>();
        String sql ="SELECT * FROM HOADON";
        ResultSet rs =connectionCuaVo.executeQuery(sql);
        try {
            while (rs.next()) {                
                String id =rs.getString("Id");
                String idKH=rs.getString("ID_KHACHHANG");
                String idNV =rs.getString("ID_NHANVIEN");
                String ma =rs.getString("MA");
                String ngayTao =rs.getString("NGAYTAO");
                String ngayThanhToan =rs.getString("NGAYTHANHTOAN");
                String tt =rs.getString("TINHTRANG");
                String diemKH =rs.getString("SODIEMKHACHHANG");
                String idKM =rs.getString("ID-KHUYEMMAI");
                HoaDon hd =new HoaDon(id, idKH, idNV, ma, ngayTao, ngayThanhToan, tt, idKM, idKM);
                listHD.add(hd);
                
            }
        } catch (Exception e) {
            System.out.println("Loi khi lay danh sach hoa don");
        }
        return listHD;
    }
}
