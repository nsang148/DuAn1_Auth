/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ChiTietSach;

import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public interface QLSachSevice {

    List<ChiTietSach> getAll();

    String add(ChiTietSach qls);

    String delete(String ma);

    String update(ChiTietSach qls, String ma);

    List<ChiTietSach> search(String ten);
}
