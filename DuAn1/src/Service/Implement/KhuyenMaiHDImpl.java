/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.KhuyenMaiHD;
import Repository.KhuyenMaiHDRepository;
import Service.KhuyenMaiHDService;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public class KhuyenMaiHDImpl implements KhuyenMaiHDService {

    private KhuyenMaiHDRepository KMHDR = new KhuyenMaiHDRepository();

    @Override
    public ArrayList<KhuyenMaiHD> getList() {
        return (ArrayList<KhuyenMaiHD>) KMHDR.getAll();
    }

    @Override
    public String them(KhuyenMaiHD obj) {
        if (KMHDR.add(obj)) {
            KMHDR.getAll();
            return "Them thanh cong";
        }
        return "Them that bai";
    }

    @Override
    public String xoa(KhuyenMaiHD obj) {
        if (KMHDR.remove(obj)) {
            KMHDR.getAll();
            return "Xoa thanh cong";
        }
        return "Xoa that bai";
    }

    @Override
    public String sua(KhuyenMaiHD obj) {
        if (KMHDR.update(obj)) {
            KMHDR.getAll();
            return "Sua thanh cong";
        }
        return "Sua that bai";
    }

    @Override
    public KhuyenMaiHD getKMHDByID(String id) {
        for (KhuyenMaiHD item : KMHDR.getAll()) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String getTrangThai(int tt) {
        if (tt == 0) {
            return "Het Han";
        } else {
            return "Con Han";
        }
    }

    @Override
    public ArrayList<KhuyenMaiHD> searchKM(String tk) {
        ArrayList<KhuyenMaiHD> temp = new ArrayList<>();
        for (KhuyenMaiHD item : KMHDR.getAll()) {
            if (item.getMa().equals(tk)) {
                temp.add(item);
            }
        }
        return temp;
    }

}
