/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSach;
import DomainModels.QLSach;
import Untility.DBContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nguyễn Hiếu
 */
public class QLSachRepository {

    public List<ChiTietSach> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[MA]\n"
                + "      ,[TEN]\n"
                + "      ,[SOLUONGTON]\n"
                + "      ,[MOTA]\n"
                + "      ,[ID_THELOAI]\n"
                + "      ,[ID_NXB]\n"
                + "      ,[ID_TACGIA]\n"
                + "      ,[TINHTRANG]\n"
                + "      ,[ANH]\n"
                + "  FROM [dbo].[SACH]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<ChiTietSach> lists = new ArrayList<>();
            while (rs.next()) {
                ChiTietSach ql = new ChiTietSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                lists.add(ql);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(ChiTietSach cts) {
        int check = 0;
        String query = "INSERT INTO [dbo].[SACH]\n"
                + "           ([MA]\n"
                + "           ,[TEN]\n"
                + "           ,[SOLUONGTON]\n"
                + "           ,[MOTA]\n"
                + "           ,[TINHTRANG]\n"
                + "           ,[ANH])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        List<ChiTietSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, cts.getMa());
            ps.setString(2, cts.getTen());
            ps.setInt(3, cts.getSoLuongTon());
            ps.setString(4, cts.getMoTa());
            ps.setInt(5, cts.getTt());
            ps.setString(6, cts.getAnh());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public boolean delete(String slt) {
        int check = 0;
        String query = "DELETE FROM [dbo].[SACH]\n"
                + "      WHERE MA like ?";
        List<ChiTietSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, slt);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean update(ChiTietSach cts, String id) {
        int check = 0;
        String query = "UPDATE [dbo].[SACH]\n"
                + "   SET[MA] = ?\n"
                + "      ,[TEN] = ?\n"
                + "      ,[SOLUONGTON] = ?\n"
                + "      ,[MOTA] = ?\n"
                + "      ,[TINHTRANG] = ?\n"
                + "      ,[ANH] = ?\n"
                + " WHERE Id like ?";
        List<ChiTietSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, cts.getMa());
            ps.setString(2, cts.getTen());
            ps.setInt(3, cts.getSoLuongTon());
            ps.setString(4, cts.getMoTa());
            ps.setInt(5, cts.getTt());
            ps.setString(6, cts.getAnh());
            ps.setString(7, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public List<ChiTietSach> search(String ten) {
        String query = "SELECT [Id]\n"
                + "      ,[MA]\n"
                + "      ,[TEN]\n"
                + "      ,[SOLUONGTON]\n"
                + "      ,[MOTA]\n"
                + "      ,[ID_THELOAI]\n"
                + "      ,[ID_NXB]\n"
                + "      ,[ID_TACGIA]\n"
                + "      ,[TINHTRANG]\n"
                + "      ,[ANH]\n"
                + "  FROM [dbo].[SACH] where TEN like ?";
        List<ChiTietSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSach ql = new ChiTietSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                lists.add(ql);
            }
            return lists;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        List<ChiTietSach> dd = new QLSachRepository().getAll();
//        System.out.println(dd);

//        ChiTietSach hh = new ChiTietSach("06", "sachHD", 312, "Binh thuong", 0, "");
//        boolean add = new QLSachRepository().add(hh);
//        System.out.println(add);
//        boolean hh = new QLSachRepository().delete("06");
//        System.out.println(hh);
//        ChiTietSach hh = new ChiTietSach("04", "Hóa", 423, "Bình Thường", 0, "NULL");
//        boolean add = new QLSachRepository().update(hh, "2c3c40d1-25c8-4c20-808e-4a28487dda21");
//        System.out.println(add);
        List<ChiTietSach> search = new QLSachRepository().search("Hóa");
        System.out.println(search);
    }
}
