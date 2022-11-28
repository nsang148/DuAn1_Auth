package Service.Implement;

import DomainModels.HoaDon;
import Repository.HoaDonRepository;
import Service.HoaDonService;
import ViewModels.QLHoaDon;
import java.util.ArrayList;
import java.util.List;

public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoaDonRepository;

    public HoaDonServiceImpl() {
        hoaDonRepository = new HoaDonRepository();

    }

    @Override
    public List<QLHoaDon> layHoaDons() {
        List<QLHoaDon> list = new ArrayList<>();
        List<HoaDon> ds = hoaDonRepository.layHoaDon();
        for (HoaDon d : ds) {
            list.add(new QLHoaDon(d.getMa(), d.getNgayTao(), d.getNgayThanhToan(), d.getTinhTrang()));
        }
        return list;
    }

}
