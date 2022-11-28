/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhuyenMaiHD;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public interface KhuyenMaiHDService {
    ArrayList<KhuyenMaiHD> getList();
    String them(KhuyenMaiHD obj);
    String xoa(KhuyenMaiHD obj);
    String sua(KhuyenMaiHD obj);
    KhuyenMaiHD getKMHDByID(String id);
    String getTrangThai(int tt);
    ArrayList<KhuyenMaiHD> searchKM(String tk);
}
