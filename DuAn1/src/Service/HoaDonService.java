
package Service;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT;
import java.util.List;


public interface HoaDonService {
    public List<HoaDon> layHoaDons();
    public List<HoaDonCT> layHoaDonCT(String id);
}
