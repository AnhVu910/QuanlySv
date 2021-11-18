/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monhoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Anh
 */
public class CrudSubject {
     public static List<Subjects> hienthi(){// lay toan bo danh sach monhoc
        List<Subjects> listmh= new ArrayList<>();
        Connection connect=null;
        Statement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "select * from monhoc";
            statement=connect.createStatement();
            ResultSet  resultset= statement.executeQuery(sql);//lay du lieu tra ve va bien resultset se la con tro tra ve cau truy van sql
            // doc du lieu tren tung ban ghi de dua ra listmh
            while (resultset.next()){//.next() co tac dung cho phep chuyen tren tung ban ghi va con tro resultset se doc du lieu
                Subjects mh= new Subjects(resultset.getInt("id"), resultset.getString("MaMH"),resultset.getString("TenMH") ,resultset.getInt("SoTC")); // khoi tao mot doi tuong mh
                listmh.add(mh); // add doi tuong vao list
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listmh;
    }
     
     public static void add(Subjects mh){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "insert into monhoc(id,MaMH,TenMH,SoTC) values(?,?,?,?)";
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
            statement.setInt(1, mh.getId());
            statement.setString(2, mh.getMamh());
            statement.setString(3, mh.getName());
            statement.setInt(4, mh.getSotc());
            
            
            
                statement.execute(); // thuc hien qua trinh them du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     
     public static void update(Subjects mh,int id){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "update monhoc set MaMH=? ,TenMH=?, SoTC=? where id=?";
            
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
   
            statement.setString(1, mh.getMamh());
            statement.setString(2, mh.getName());
            statement.setInt(3, mh.getSotc());
            statement.setInt(4, mh.getId());

            
                statement.execute(); // thuc hien qua trinh update du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     
     public static void delete(int id){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "delete from monhoc where id=?";
            
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
            
            statement.setInt(1, id);

            
                statement.execute(); // thuc hien qua trinh update du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     
     public static List<Subjects> timMH(String name){
        List<Subjects> listmh= new ArrayList<>();
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "select * from monhoc where TenMH like ?";
            statement=connect.prepareCall(sql);
            statement.setString(1,"%"+ name+"%");
            ResultSet  resultset= statement.executeQuery();//lay du lieu tra ve va bien resultset se la con tro tra ve cau truy van sql
            // doc du lieu tren tung ban ghi de dua ra listmh
            while (resultset.next()){//.next() co tac dung cho phep chuyen tren tung ban ghi va con tro resultset se doc du lieu
                Subjects mh= new Subjects(resultset.getInt("id"), resultset.getString("MaMH"),resultset.getString("TenMH") ,resultset.getInt("SoTC")); // khoi tao mot doi tuong mh
                listmh.add(mh); // add doi tuong vao list
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listmh;
    }
 
    
}
