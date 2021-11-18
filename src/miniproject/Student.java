/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;


public class Student {
    int id;
    String name, gender, email, number,masv;

    

    public Student() {
    }

    public Student(int id, String name,String masv, String gender, String email, String number ) {
        this.id = id;
        this.name = name;
        this.masv = masv;
        this.gender = gender;
        this.email = email;
        this.number = number;
        
    }

 

    

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
   
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getMasv() {
        return masv;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    

    
    
   
   
}
