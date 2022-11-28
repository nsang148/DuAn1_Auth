
package ViewModels;


public class QLHoaDon {
    private String ma ,ngayTao ,ngayThanhToan ,tinhTrang ;

    public QLHoaDon() {
    }

    public QLHoaDon(String ma, String ngayTao, String ngayThanhToan, String tinhTrang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
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

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "QLHoaDon{" + "ma=" + ma + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tinhTrang=" + tinhTrang + '}';
    }
    
}
