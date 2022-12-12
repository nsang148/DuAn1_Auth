/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.ChartThongKe;
import ViewModels.DoanhThuThongKe;
import ViewModels.SanPhamHet;
import ViewModels.SoHoaDon;
import ViewModels.SoSanPhamTon;
import ViewModels.ThongKeResponse;
import ViewModels.ThongKeSPResponse;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ThongKeService {
    List<ThongKeResponse> getAll();
    List<ThongKeSPResponse> getAllSP();
    List<ThongKeSPResponse> getAllSPThang();
    List<ThongKeSPResponse> getAllSPNam();
    List<DoanhThuThongKe> HienThiDoanhThu();
    List<SoHoaDon> HienThiSoHoaDon();
    List<SoSanPhamTon> HienThiSoLuongTon();
    List<SanPhamHet> HienThiSanPhamHet();
    List<ThongKeResponse> search(String dateBD, String dateKT);
    List<ThongKeResponse> getAllThang();
    List<ThongKeResponse> getAllNam();
    public List<DoanhThuThongKe> getDoanhThu();
    List<ChartThongKe> chartThongKe();
}
