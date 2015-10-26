/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBInterface;

import EntityDB.Item;
import EntityDB.User;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author namal
 */
public class ItemControl extends DBControler{
    public boolean createItem(Item obj){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String quary = "INSERT INTO item VALUES (?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(quary);
            pst.setString(1, obj.getItemID());//add values to the sql quary
            pst.setString(2, obj.getRecoverCode());
            pst.setString(3, obj.getItemName());
            pst.setString(4, obj.getSubCategoryID());
            pst.setString(5, obj.getDescription());
            pst.setFloat(6, obj.getPrice());
            pst.setString(7, obj.getCompanyID());
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
    public Item getItem(String name){
        try{
        con= (Connection)DriverManager.getConnection(url, username, password);
            String quary="select * FROM item where itemName='"+name+"'";
            pst=(PreparedStatement)con.prepareStatement(quary);
            Item obj = new Item();
            rs=pst.executeQuery();
            
            while(rs.next()){
                obj.setItemID(rs.getString(1));
                obj.setRecoverCode(rs.getString(2));
                obj.setItemName(rs.getString(3));
                obj.setSubCategoryID(rs.getString(4));
                obj.setDescription(rs.getString(5));
                obj.setPrice(rs.getFloat(6));
                obj.setCompanyID(rs.getString(7));               
            }
            return obj;
            
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
    
    public boolean updateItem(Item obj){
        try {
            con= (Connection)DriverManager.getConnection(url, username, password);
            String quary="UPDATE item SET recoverCode='"+obj.getRecoverCode()+"',itemName='"+obj.getItemName()+"',subCategoryID='"+obj.getSubCategoryID()+"',description='"+obj.getDescription()+"',price="+obj.getPrice()+"companyID='"+obj.getCompanyID()+"'WHERE userID='"+obj.getItemID()+"'";
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
