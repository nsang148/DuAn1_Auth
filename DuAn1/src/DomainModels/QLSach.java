/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Nguyễn Hiếu
 */
public class QLSach {
    private String  ID;
    private String maSach;
    private String  tenSach;

    public QLSach(String ID, String maSach, String tenSach) {
        this.ID = ID;
        this.maSach = maSach;
        this.tenSach = tenSach;
    }

    public QLSach(String maSach, String tenSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
    }

    public QLSach() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    
    
    public Object[] toRowData(){
        return new Object[]{ID,maSach,tenSach};
    }
    
}
