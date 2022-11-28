/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author Tran Tuan Cuong
 */
public class NhanVien {
    private String ID;
    private String maNV;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String diaChi;
    private String matKhau;
    private Integer tinhTrang;
    private String vaiTro;
    private String anh;

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public NhanVien() {
    }

    public NhanVien(String ID, String maNV, String ten, String tenDem, String ho, String gioiTinh, String ngaySinh, String sdt, String diaChi, String matKhau, Integer tinhTrang, String vaiTro, String anh) {
        this.ID = ID;
        this.maNV = maNV;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.tinhTrang = tinhTrang;
        this.vaiTro = vaiTro;
        this.anh = anh;
    }
    
    public String getTrangThai() {
        if (this.tinhTrang == 0) {
            return "Đang làm việc";
        } else {
            return "Đã nghỉ việc";
        }
    }
}
