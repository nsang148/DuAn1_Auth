/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.KhachHangModel;
import Repository.KhachHangRepository;
import Service.KhachHangService;
import ViewModels.KhachHangReponse;
import java.util.List;

/**
 *
 * @author sangh
 */
public class KhachHangIplement implements KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHangReponse> getAll() {
        return khachHangRepository.getKH();
    }

    @Override
    public String add(KhachHangModel khachHang) {
        return khachHangRepository.insert(khachHang);
    }

    @Override
    public String update(KhachHangModel khachHang) {
        return khachHangRepository.update(khachHang);
    }

    @Override
    public String delete(String id) {
        return khachHangRepository.delete(id);
    }

}
