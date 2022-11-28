/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Duc
 */
public class KhuyenMaiHD {
    private String id;
    private String ma;
    private String ten;
    private Float phanTramGiam;
    private String ngayApDung;
    private String ngayKetThuc;
    private int tinhTrang;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(Float phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public String getNgayApDung() {
        return ngayApDung;
    }

    public void setNgayApDung(String ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public KhuyenMaiHD() {
    }

    public KhuyenMaiHD(String id, String ma, String ten, Float phanTramGiam, String ngayApDung, String ngayKetThuc, int tinhTrang) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.phanTramGiam = phanTramGiam;
        this.ngayApDung = ngayApDung;
        this.ngayKetThuc = ngayKetThuc;
        this.tinhTrang = tinhTrang;
    }
}
