package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.business.Room;
import com.example.exceptions.DaoException;


public class RoomDao extends Dao {

    public ArrayList<Room> getRoom(String type,boolean smoking, float priceMin,float priceMax, int noOfPeople) throws DaoException
    {
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Room> Rooms =new ArrayList();
        
        boolean success = false;
        try {
            con = this.getConnection();
            String query;
            if(smoking==true)
            	query = "SELECT * FROM room WHERE bedType ='"+type+"' And smoking ='Y'";//change according to DB
            else
            	query = "SELECT * FROM room WHERE bedType ='"+type+"' And smoking ='N'";//change according to DB
                
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            
           
            do
            {
            	float tempPrice=Float.parseFloat(rs.getString("price"));
            	if (tempPrice<=priceMax&&tempPrice>=priceMin) {
            	
            		Room temp=new Room(Integer.valueOf(rs.getString("roomNo")),type,noOfPeople,smoking,"",tempPrice);
            		Rooms.add(temp);
            	}
            }while(rs.next());
            	
        } 
        catch (SQLException e) {
            throw new DaoException("getRoom " + e.getMessage());    
        } 
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            }//end try 
            catch (SQLException e) {
                throw new DaoException("getRoom" + e.getMessage());
            }//end catch
        }//end finally
        return Rooms;
    }
    
}
