/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ViDiem;
import Untility.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sangh
 */
public class ViDiemRepository {
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;

    public ViDiemRepository() {
    }
    
    public List<ViDiem> getKH() {
        String query = "SELECT Id, TongDiem, SoDiemDaDung, SoDiemDaCong, TinhTrang FROM ViDiem";
        List<ViDiem> vdm = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ViDiem vd = new ViDiem();
                vd.setId(rs.getString(1));
                vd.setSoDiemDaCong(rs.getInt(2));
                vd.setSoDiemDaDung(rs.getInt(3));
                vd.setTinhTrang(rs.getBoolean(4));
                vdm.add(vd);
            }
        } catch (Exception ex) {
        }
        return vdm;
    }
}
