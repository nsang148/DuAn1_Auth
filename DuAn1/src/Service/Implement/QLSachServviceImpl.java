/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.QLSach;
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
    public List<QLSach> getAll() {
        return hh.getAll();
    }

    @Override
    public String add(QLSach qls) {
        boolean add = hh.add(qls);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean add = hh.delete(ma);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public String update(QLSach qls, String ma) {
        boolean add = hh.update(qls, ma);
        if (add) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }
    
}
