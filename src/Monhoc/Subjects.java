/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monhoc;

/**
 *
 * @author Anh
 */
public class Subjects {
    int id, sotc;
    String  mamh, name;

    public Subjects() {
    }

    public Subjects(int id, String mamh, String name,  int sotc) {
        this.id = id;
        this.mamh = mamh;
        this.name = name;
        this.sotc = sotc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSotc() {
        return sotc;
    }

    public void setSotc(int sotc) {
        this.sotc = sotc;
    }
}
