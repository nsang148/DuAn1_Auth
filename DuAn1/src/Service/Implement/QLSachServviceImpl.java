/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.ChiTietSach;
import Repository.QLSachRepository;
import Service.QLSachSevice;
import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public class QLSachServviceImpl implements QLSachSevice{
    private QLSachRepository hh = new QLSachRepository();

    @Override
    public List<ChiTietSach> getAll() {
        return hh.getAll();
    }

    @Override
    public String add(ChiTietSach qls) {
        boolean add= hh.add(qls);
        if (add) {
            return "Thành Công";
        } else {
            return "Thất Bại";
        } 
    }

    @Override
    public String delete(String ma) {
        boolean delete= hh.delete(ma);
        if (delete) {
            return "Thành Công";
        } else {
            return "Thất Bại";
        }
    }

    @Override
    public String update(ChiTietSach qls, String ma) {
        boolean update= hh.update(qls, ma);
        if (update) {
            return "Thành Công";
        } else {
            return "Thất Bại";
        }
    }

    @Override
    public List<ChiTietSach> search(String ten) {
        return hh.search(ten);
    }

   
   
}
