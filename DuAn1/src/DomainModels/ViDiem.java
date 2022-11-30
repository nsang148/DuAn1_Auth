/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author sangh
 */
public class ViDiem {
    private String Id;
    private int tongDiem;
    private int soDiemDaDung;
    private int soDiemDaCong;
    private Boolean tinhTrang;

    public ViDiem() {
    }

    public ViDiem(String Id, int tongDiem, int soDiemDaDung, int soDiemDaCong, Boolean tinhTrang) {
        this.Id = Id;
        this.tongDiem = tongDiem;
        this.soDiemDaDung = soDiemDaDung;
        this.soDiemDaCong = soDiemDaCong;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(int tongDiem) {
        this.tongDiem = tongDiem;
    }

    public int getSoDiemDaDung() {
        return soDiemDaDung;
    }

    public void setSoDiemDaDung(int soDiemDaDung) {
        this.soDiemDaDung = soDiemDaDung;
    }

    public int getSoDiemDaCong() {
        return soDiemDaCong;
    }

    public void setSoDiemDaCong(int soDiemDaCong) {
        this.soDiemDaCong = soDiemDaCong;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
