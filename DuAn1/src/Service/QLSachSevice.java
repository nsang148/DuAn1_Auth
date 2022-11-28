/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.QLSach;
import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public interface QLSachSevice {
    List<QLSach> getAll();
    String add(QLSach qls);
    String delete(String ma);
    String update(QLSach qls,String ma);
}
