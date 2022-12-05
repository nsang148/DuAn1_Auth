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
    List<LayIDHD> getIDHD();
    public int createHDCho(HoaDon hd);
    public int updateHD(HoaDon hd);
    public int createHDCT(HoaDonCT hd);
}
