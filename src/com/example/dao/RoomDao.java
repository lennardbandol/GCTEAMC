<<<<<<< HEAD
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
=======
package com.example.dao;

import com.example.business.Room;
import com.example.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDao extends Dao {

	public ArrayList<Room> searchRoom(String checkInDate, String checkOutDate, String roomType) throws DaoException{
		ArrayList<Room> roomList = new ArrayList<Room>();
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM room WHERE  = ?;";  //TODO: make search query for finding avalible rooms
            ps = con.prepareStatement(query);
            ps.setString(1, checkInDate);
            ps.setString(2, checkOutDate);
            ps.setString(3, roomType);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	//Add all room data to room object then add to array list.
            	String no = null;
            	String type = null;
            	String isSmoking = null;
            	
                no = rs.getString("roomId");				//TODO:
                type = rs.getString("type");				//Change according to
                isSmoking = rs.getString("isSmoking");	//database attributes
                
                Room room = new Room(no,type,isSmoking);
                roomList.add(room);
            }
        } 
        catch (SQLException e) {
            throw new DaoException("room search: " + e.getMessage());    
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
                throw new DaoException("room search: " + e.getMessage());
            }//end catch
        }//end finally
        return roomList;
	}
}
>>>>>>> 449c644f9b12a4add793758ff66233fd7fe24dcc
