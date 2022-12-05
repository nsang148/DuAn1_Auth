/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import Repository.SachRepository;
import DomainModels.Sach;
import Service.SachService;
import ViewModels.LayIDSach;
import ViewModels.QLSach;
import java.util.List;

/**
 *
 * @author acer
 */
    
public class SachServiceImpl implements SachService{
    private SachRepository repo = new SachRepository();
    
    @Override
    public List<QLSach> getAll() {
        return repo.getAll();
    }

    @Override
    public int createSach(Sach s) {
        return repo.createSachRepository(s);
    }

    @Override
    public int updateSach(Sach s, String ma) {
        return repo.updateSachRepository(s, ma);
    }

    @Override
    public int deleteSach(String ma) {
        return repo.deleteSachRepository(ma);
    }

    @Override
    public List<QLSach> search(String ma) {
        return repo.search(ma);
    }

    @Override
    public List<LayIDSach> getIDSach() {
        return repo.getIDHD();
    }
}
