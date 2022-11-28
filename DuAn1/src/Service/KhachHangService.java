/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhachHangModel;
import ViewModels.KhachHangReponse;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface KhachHangService {
     List<KhachHangReponse> getAll();

    String add(KhachHangModel khachHang);

    String update(KhachHangModel khachHang);

    String delete(String id);
}
