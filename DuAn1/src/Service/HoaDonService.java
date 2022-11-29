
package Service;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT;
import ViewModels.HoaDonChiTietReponse;
import ViewModels.HoaDonReponse;
import java.util.List;


public interface HoaDonService {
    public List<HoaDonReponse> layHoaDons();
    public List<HoaDonChiTietReponse> layHoaDonCT(String ma);
}
