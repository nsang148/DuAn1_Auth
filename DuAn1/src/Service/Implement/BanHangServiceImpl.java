/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import Repository.BanHangRepository;
import Service.BanHangService;
import ViewModels.SanPhamThanhToan;
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
    
}
