/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT;
import Repository.BanHangRepository;
import Service.BanHangService;
import ViewModels.HoaDonThanhToan;
import ViewModels.LayIDHD;
import ViewModels.SanPhamThanhToan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class BanHangServiceImpl implements BanHangService{

    private BanHangRepository repo = new BanHangRepository();
    @Override
    public List<SanPhamThanhToan> getAll() {
        return repo.getALLSP();
    }

    @Override
    public int createHDCho(HoaDon hd) {
        return repo.createHDChoRepository(hd);
    }

    @Override
    public List<HoaDonThanhToan> getAllHD() {
        return repo.getAllHD();
    }

    @Override
    public List<LayIDHD> getIDHD() {
        return repo.getIDHD();
    }

    @Override
    public int createHDCT(HoaDonCT hd) {
        return repo.createHDCTRepository(hd);
    }

    @Override
    public int updateHD(HoaDon hd) {
        return repo.updateHDRepository(hd);
    }

    @Override
    public boolean isExists(String maHD) {
        return repo.isExists(maHD);
    }

    @Override
    public int updateSLSach(int i, String ma) {
        return repo.updateSLSach(i, ma);
    }

    @Override
    public List<SanPhamThanhToan> search(String ma) {
        List<SanPhamThanhToan> list = new ArrayList<>();
        for (SanPhamThanhToan sp : repo.getALLSP()) {
            if(sp.getMa().equals(ma)) {
                list.add(sp);
            }
        }
        return list;
    }
    
}
