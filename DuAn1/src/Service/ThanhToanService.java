
package Service;

import Repository.ThanhToanRepository;
import ViewModels.ThanhToan;
import java.util.ArrayList;

/**
 *
 * @author bach
 */
public class ThanhToanService {
        ThanhToanRepository thanhToanRepo;
    public ThanhToanService(){
    this.thanhToanRepo = new ThanhToanRepository();
    }
    public ArrayList<ThanhToan> getList(){
    return this.thanhToanRepo.all();
    }
}
