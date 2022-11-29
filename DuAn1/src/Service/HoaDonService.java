
package Service;

import DomainModels.HoaDon;
import ViewModels.HoaDonChiTietReponse;
import ViewModels.HoaDonReponse;
//import DomainModels.HoaDonCT;
import java.util.List;


public interface HoaDonService {
    public List<HoaDonReponse> layHoaDons();
    public List<HoaDonChiTietReponse> layHoaDonCT(String id);
}
