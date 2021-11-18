/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bangdiem;

/**
 *
 * @author Anh
 */
public class Diem {
    int id;
    String  masv, mamh;
    float diem;

    public Diem() {
    }

    public Diem(int id, String masv, String mamh, float diem) {
        this.id = id;
        this.masv = masv;
        this.mamh = mamh;
        this.diem = diem;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
}
