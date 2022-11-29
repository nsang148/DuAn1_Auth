
package DomainModels;

public class HoaDonCT {
//    Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
//	ID_SACH UNIQUEIDENTIFIER,
//	ID_HOADON UNIQUEIDENTIFIER,
//	SOLUONG INT,
//	DONGIA MONEY,
//	TIENTHUA MONEY,
//	TIENGIAMGIA MONEY,
//	TINHTRANG BIT,
    private String id,idSach,idHD,donGia,tienThua,TienGiamGia;
    private int soLuong ,tinhTrang;

    public HoaDonCT() {
    }

    public HoaDonCT(String id, String idSach, String idHD, String donGia, String tienThua, String TienGiamGia, int soLuong, int tinhTrang) {
        this.id = id;
        this.idSach = idSach;
        this.idHD = idHD;
        this.donGia = donGia;
        this.tienThua = tienThua;
        this.TienGiamGia = TienGiamGia;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getTienThua() {
        return tienThua;
    }

    public void setTienThua(String tienThua) {
        this.tienThua = tienThua;
    }

    public String getTienGiamGia() {
        return TienGiamGia;
    }

    public void setTienGiamGia(String TienGiamGia) {
        this.TienGiamGia = TienGiamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

 
    
}
