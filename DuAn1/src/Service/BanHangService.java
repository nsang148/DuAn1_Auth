/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT;
import ViewModels.HoaDonThanhToan;
import ViewModels.LayIDHD;
import ViewModels.SanPhamThanhToan;
import java.util.List;

/**
 *
 * @author acer
 */
public interface BanHangService {
    List<SanPhamThanhToan> getAll();
    List<HoaDonThanhToan> getAllHD();
    boolean isExists(String maHD);
    public int updateSLSach(int i, String ma);
    List<LayIDHD> getIDHD();
    List<SanPhamThanhToan> search(String ma);
    public int createHDCho(HoaDon hd);
    public int updateHD(HoaDon hd);
    public int createHDCT(HoaDonCT hd);
    public int updateSLSach(int i, String ma);
    public List<SanPhamThanhToan> search(String ma);
}
