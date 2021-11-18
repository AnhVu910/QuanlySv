/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bangdiem;



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
public class CrudDiem {
    public static List<Diem> hienthi(){// lay toan bo danh sach diem
        List<Diem> listdiem= new ArrayList<>();
        Connection connect=null;
        Statement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "select * from monhoc";
            statement=connect.createStatement();
            ResultSet  resultset= statement.executeQuery(sql);//lay du lieu tra ve va bien resultset se la con tro tra ve cau truy van sql
            // doc du lieu tren tung ban ghi de dua ra listdiem
            while (resultset.next()){//.next() co tac dung cho phep chuyen tren tung ban ghi va con tro resultset se doc du lieu
                Diem diem= new Diem(resultset.getInt("id"), resultset.getString("MaSV"),resultset.getString("MaMH") ,resultset.getFloat("Diem")); // khoi tao mot doi tuong diem
                listdiem.add(diem); // add doi tuong vao list
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listdiem;
    }
    
    public static void add(Diem diem){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "insert into bangdiem(id,MaSV,MaMH,Diem) values(?,?,?,?)";
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
            statement.setInt(1, diem.getId());
            statement.setString(2, diem.getMamh());
            statement.setString(3, diem.getMasv());
            statement.setFloat(4, diem.getDiem());
            
            
            
                statement.execute(); // thuc hien qua trinh them du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Diem diem,int id){
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "update bangdiem set MaSV=? ,MaMH=?, Diem=? where id=?";
            
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
   
            statement.setString(1, diem.getMasv());
            statement.setString(2, diem.getMamh());
            statement.setFloat(3, diem.getDiem());
            statement.setInt(4, diem.getId());

            
                statement.execute(); // thuc hien qua trinh update du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql= "delete from bangdiem where id=?";
            
            statement = connect.prepareStatement(sql);
            //truyen du lieu vao cau truy van sql
            
            statement.setInt(1, id);

            
                statement.execute(); // thuc hien qua trinh update du lieu
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
     public static List<Diem> timDiem(String masv){
        List<Diem> listdiem= new ArrayList<>();
        Connection connect=null;
        PreparedStatement statement=null; // lay du lieu tư database
        try {
            
             connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?useTimezone=true&serverTimezone=UTC","root","");
            // tao truy van 
            String sql= "select * from bangdiem where MaSV like ?";
            statement=connect.prepareCall(sql);
            statement.setString(1,"%"+ masv+"%");
            ResultSet  resultset= statement.executeQuery();//lay du lieu tra ve va bien resultset se la con tro tra ve cau truy van sql
            // doc du lieu tren tung ban ghi de dua ra listdiem
            while (resultset.next()){//.next() co tac dung cho phep chuyen tren tung ban ghi va con tro resultset se doc du lieu
                Diem diem= new Diem(resultset.getInt("id"), resultset.getString("MaSV"),resultset.getString("MaMH") ,resultset.getFloat("Diem")); // khoi tao mot doi tuong diem
                listdiem.add(diem); // add doi tuong vao list
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connect!= null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrudDiem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listdiem;
    }
 
    
}
