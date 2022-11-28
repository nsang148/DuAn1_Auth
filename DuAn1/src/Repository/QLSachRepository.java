/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

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

    public List<QLSach> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[MA]\n"
                + "      ,[TEN]\n"
                + "  FROM [dbo].[SACH]";
        List<QLSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLSach ql = new QLSach(rs.getString(1), rs.getString(2), rs.getString(3));
                lists.add(ql);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(QLSach ma) {
        int check = 0;
        String query = "INSERT INTO [dbo].[SACH]\n"
                + "           ([MA]\n"
                + "           ,[TEN])\n"
                + "     VALUES\n"
                + "           (?,?)";
        List<QLSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, ma.getMaSach());
            ps.setString(2, ma.getTenSach());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = "DELETE FROM [dbo].[SACH]\n"
                + "      WHERE MA like ?";
        List<QLSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public boolean update(QLSach sach, String ql) {
        int check = 0;
        String query = "UPDATE [dbo].[SACH]\n"
                + "   SET [MA] = ?\n"
                + "      ,[TEN] = ?\n"
                + " WHERE MA like ?";
        List<QLSach> lists = new ArrayList<>();
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, sach.getMaSach());
            ps.setString(2, sach.getTenSach());

            ps.setString(3, ql);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
//        List<QLSach> dd = new QLSachRepository().getAll();
//        System.out.println(dd);

//        QLSach hh = new QLSach("006", "demo" );
//        boolean add  = new QLSachRepository().add(hh);
//        System.out.println(add);
//        boolean hh = new QLSachRepository().delete("006");
//        System.out.println(hh);
        QLSach hh = new QLSach("001", "SGK");
        boolean add = new QLSachRepository().update(hh, "008");
        System.out.println(add);

    }
}
