
package ViewModels;

/**
 *
 * @author bach
 */
public class ThanhToan {
    private String tenSach;
    private String tacGia;    
    private String theLoai;
    private String NXB;
    private int soLuongTon ;
    private int donGia;
    private String idSach;
    private String idTheLoai;
    private String idNXB;


    private String idTacGia;


    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public ThanhToan() {
    }

    public ThanhToan(String tenSach, String tacGia, String theLoai, String NXB, int soLuongTon, int donGia) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.NXB = NXB;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }




    
}
