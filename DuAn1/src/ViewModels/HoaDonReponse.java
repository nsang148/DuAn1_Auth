/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author acer
 */
public class HoaDonReponse {
    private String ngayTao;
    private String ma;
    private Double tongTien;
    private String ten;
    private int tinhTrang;

    public HoaDonReponse() {
    }

    public HoaDonReponse(String ngayTao, String ma, Double tongTien, String ten, int tinhTrang) {
        this.ngayTao = ngayTao;
        this.ma = ma;
        this.tongTien = tongTien;
        this.ten = ten;
        this.tinhTrang = tinhTrang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}
