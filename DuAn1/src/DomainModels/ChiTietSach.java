/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author acer
 */
public class ChiTietSach {
    private String id;
    private String ma;
    private String ten;
    private int soLuongTon;
    private String moTa;
    private String id_TheLoai;
    private String id_NXB;
    private String id_TacGia;
    private int tt;
    private String anh;

    public ChiTietSach() {
    }

    public ChiTietSach(String id, String ma, String ten, int soLuongTon, String moTa, String id_TheLoai, String id_NXB, String id_TacGia, int tt, String anh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soLuongTon = soLuongTon;
        this.moTa = moTa;
        this.id_TheLoai = id_TheLoai;
        this.id_NXB = id_NXB;
        this.id_TacGia = id_TacGia;
        this.tt = tt;
        this.anh = anh;
    }

    public ChiTietSach(String id, String ma, String ten, int soLuongTon, String moTa, int tt, String anh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soLuongTon = soLuongTon;
        this.moTa = moTa;
        this.tt = tt;
        this.anh = anh;
    }
    
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

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getId_TheLoai() {
        return id_TheLoai;
    }

    public void setId_TheLoai(String id_TheLoai) {
        this.id_TheLoai = id_TheLoai;
    }

    public String getId_NXB() {
        return id_NXB;
    }

    public void setId_NXB(String id_NXB) {
        this.id_NXB = id_NXB;
    }

    public String getId_TacGia() {
        return id_TacGia;
    }

    public void setId_TacGia(String id_TacGia) {
        this.id_TacGia = id_TacGia;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTrangThai(){
        if (tt == 0) {
            return "Còn";
        } else {
            return "Hết";
        }
    }

    @Override
    public String toString() {
        return "ChiTietSach{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", soLuongTon=" + soLuongTon + ", moTa=" + moTa + ", id_TheLoai=" + id_TheLoai + ", id_NXB=" + id_NXB + ", id_TacGia=" + id_TacGia + ", tt=" + tt + ", anh=" + anh + '}';
    }
    
    public Object[] toRowdata(){
        return new Object[]{id,ma,ten,soLuongTon,moTa,getTrangThai(),anh};
    }

}
