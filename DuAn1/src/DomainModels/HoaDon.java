
package DomainModels;

public class HoaDon {
    private String id ,idKH ,idNV ,ma ,ngayTao ,ngayThanhToan ,tinhTrang ,sodiem,idKM;

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String ma, String ngayTao, String ngayThanhToan, String tinhTrang, String sodiem, String idKM) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.sodiem = sodiem;
        this.idKM = idKM;
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

    public String getSodiem() {
        return sodiem;
    }

    public void setSodiem(String sodiem) {
        this.sodiem = sodiem;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "id=" + id + ", idKH=" + idKH + ", idNV=" + idNV + ", ma=" + ma + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tinhTrang=" + tinhTrang + ", sodiem=" + sodiem + ", idKM=" + idKM + '}';
    }
    
}
