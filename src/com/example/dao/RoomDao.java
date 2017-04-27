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
