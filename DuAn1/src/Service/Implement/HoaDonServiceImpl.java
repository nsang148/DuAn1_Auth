package Service.Implement;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT;
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

    @Override
    public List<HoaDonCT> layHoaDonCT(String id) {
        return hoaDonRepository.layHoaDonCT(id);
    }

}
