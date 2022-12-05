/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.Sach;
import ViewModels.LayIDSach;
import ViewModels.QLSach;
import java.util.List;

/**
 *
 * @author acer
 */
public interface SachService {
    List<QLSach> getAll();
    List<LayIDSach> getIDSach();
    public int createSach(Sach s);
    public int updateSach(Sach s, String ma);
    public int deleteSach(String ma);
    List<QLSach> search(String ma);
}
