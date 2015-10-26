/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBInterface;

import EntityDB.User;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author namal
 */
public class UserControl extends DBControler{
    public boolean createUser(User usr){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String quary = "INSERT INTO user VALUES (?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(quary);
            pst.setString(1, usr.getUserID());//add values to the sql quary
            pst.setString(2, usr.getUserName());
            pst.setString(3, usr.getAddress());
            pst.setInt(4, usr.getTel());
            pst.setString(5, usr.getPassword());
            pst.setString(6, usr.getUserCategory());
            pst.executeUpdate();//execute the sql quary and insert the values to the values table
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
        }
    }
    public User getUser(String name){
        try{
        con= (Connection)DriverManager.getConnection(url, username, password);
            String quary="select * FROM user where userName='"+name+"'";
            pst=(PreparedStatement)con.prepareStatement(quary);
            User usr = new User();
            rs=pst.executeQuery();
            
            while(rs.next()){
                usr.setUserID(rs.getString(1));
                usr.setUserName(rs.getString(2));
                usr.setAddress(rs.getString(3));
                usr.setTel(rs.getInt(4));
                usr.setPassword(rs.getString(5));
                usr.setUserCategory(rs.getString(6));
                //System.out.println(usr.getUserID().toString()+usr.getUserName().toString());
            }
            return usr;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;        
        }
        finally{
            try{
                if(con!=null){
                    con.close();
                }
                if(pst!=null){
                    pst.close();
                }
            }catch(Exception e){
                
            }
        }
    }
    
    public boolean updateUser(User usr){
        try {
            con= (Connection)DriverManager.getConnection(url, username, password);
            String quary="UPDATE user SET userName='"+usr.getUserName()+"',address='"+usr.getAddress()+"',tel="+usr.getTel()+",password='"+usr.getPassword()+"',userCategory='"+usr.getUserCategory()+"'WHERE userID='"+usr.getUserID()+"'";
            pst=(PreparedStatement)con.prepareStatement(quary);
            pst.executeUpdate();//execute the sql quary and insert the values to the values table
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        finally{
            try{
                if(con!=null){
                    con.close();
                }
                if(pst!=null){
                    pst.close();
                }
            }catch(Exception e){
                
            }
        }
    }
}
