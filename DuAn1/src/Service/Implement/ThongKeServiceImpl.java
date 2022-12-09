/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import ViewModels.ThongKeResponse;
import Repository.ThongKeRepository;
import Service.ThongKeService;
import ViewModels.ChartThongKe;
import ViewModels.DoanhThuThongKe;
import ViewModels.SanPhamHet;
import ViewModels.SoHoaDon;
import ViewModels.SoSanPhamTon;
import ViewModels.ThongKeSPResponse;
import java.util.List;

/**
 *
 * @author acer
 */
public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeRepository repo = new ThongKeRepository();

    @Override
    public List<ThongKeResponse> getAll() {
        return repo.getAll();
    }

    @Override
    public List<ThongKeSPResponse> getAllSP() {
        return repo.getAllThongKeSP();
    }

    @Override
    public List<DoanhThuThongKe> HienThiDoanhThu() {
        return repo.getDoanhThu();
    }

    @Override
    public List<SoHoaDon> HienThiSoHoaDon() {
        return repo.hienThiTongHoaDon();
    }

    @Override
    public List<SoSanPhamTon> HienThiSoLuongTon() {
        return repo.hienThiSoLuongTon();
    }

    @Override
    public List<SanPhamHet> HienThiSanPhamHet() {
        return repo.hienThiSoPhamHet();
    }

    @Override
    public List<ThongKeResponse> search(String dateBD, String dateKT) {
        return repo.search(dateBD, dateKT);
    }

    @Override
    public List<ThongKeResponse> getAllThang() {
        return repo.getAllThang();
    }

    @Override
    public List<ThongKeResponse> getAllNam() {
        return repo.getAllNam();
    }

    @Override
    public List<ThongKeSPResponse> getAllSPThang() {
        return repo.getAllThongKeSPThang();
    }

    @Override
    public List<ThongKeSPResponse> getAllSPNam() {
        return repo.getAllThongKeSPNam();
    }

    @Override
    public List<DoanhThuThongKe> getDoanhThu() {
        return repo.getDoanhThu();
    }

    @Override
    public List<ChartThongKe> chartThongKe() {
        return repo.ChartThongKe();
    }
}
