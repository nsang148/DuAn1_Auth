package Service.Implement;

import DomainModels.HoaDon;
import Repository.HoaDonRepository;
import Service.HoaDonService;
import java.util.List;

public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoaDonRepository;

    public HoaDonServiceImpl() {
        hoaDonRepository = new HoaDonRepository();

    }

    @Override
    public List<HoaDon> layHoaDons() {
        return hoaDonRepository.layHoaDon();
    }

}
