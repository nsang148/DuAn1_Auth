
package Service.Implement;

import Repository.ThanhToanRepository;
import Service.ThanhToanService;
import ViewModels.ThanhToan;
import java.util.List;


public class ThanhToanServiceImpl implements ThanhToanService{
    private ThanhToanRepository ttRepo = new ThanhToanRepository();
    @Override
    public List<ThanhToan> all() {
        
        return this.ttRepo.all();
    }
    
}
