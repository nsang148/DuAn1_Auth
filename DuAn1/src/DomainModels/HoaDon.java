package DomainModels;

public class HoaDon {

    private String id, idKH, idNV, idVi, ma, ngayTao, ngayThanhToan, tienKhachDua, tongTien, sodiemKH;
    private int tinhTrang;

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String idVi, String ma, String ngayTao, String ngayThanhToan, String tienKhachDua, String tongTien, String sodiemKH, int tinhTrang) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idVi = idVi;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienKhachDua = tienKhachDua;
        this.tongTien = tongTien;
        this.sodiemKH = sodiemKH;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdVi() {
        return idVi;
    }

    public void setIdVi(String idVi) {
        this.idVi = idVi;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(String tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getSodiemKH() {
        return sodiemKH;
    }

    public void setSodiemKH(String sodiemKH) {
        this.sodiemKH = sodiemKH;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
