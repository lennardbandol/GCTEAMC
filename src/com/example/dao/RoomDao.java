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
        
        try {
            con = this.getConnection();
            String query;
            if(smoking==true)
            	query = "SELECT * FROM room WHERE bedType ='"+type+"' And smoking ='Y';";//change according to DB
            else
            	query = "SELECT * FROM room WHERE bedType ='"+type+"' And smoking ='N';";//change according to DB
                
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
    
    public boolean addRoom(int number,String type,int noOfPeople,boolean smoking,String details,float price) throws DaoException
    {
    	Connection con = null;
        PreparedStatement ps = null;
        boolean success = false;
        try {
            con = this.getConnection();
            String query;
            if(smoking==true)
            	query = "INCERT INTO ROOM (roomNo, bedType,smoking,price) VALUES ('"+number+"','"+type+"','Y','"+price+"');";
            else
            	query = "INCERT INTO ROOM (roomNo, bedType,smoking,price) VALUES ('"+number+"','"+type+"','N','"+price+"');";
                    
            ps = con.prepareStatement(query);
            ps.executeUpdate();
            success=true;
        } 
        catch (SQLException e) {
            throw new DaoException("addRoom " + e.getMessage());    
        } 
        finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            }//end try 
            catch (SQLException e) {
                throw new DaoException("addRoom" + e.getMessage());
            }//end catch
        }//end finally
        return success;    	
    }
    
    public boolean removeRoom(int number) throws DaoException
    {
    	Connection con = null;
        PreparedStatement ps = null;
        boolean success = false;
        try {
            con = this.getConnection();
            String query="DELETE FROM ROOM WHERE roomNo='"+number+"';";
            ps = con.prepareStatement(query);
            ps.executeUpdate();
            
            success=true;
        } 
        catch (SQLException e) {
            throw new DaoException("removeRoom " + e.getMessage());    
        } 
        finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            }//end try 
            catch (SQLException e) {
                throw new DaoException("removeRoom" + e.getMessage());
            }//end catch
        }//end finally
        return success;    	
    } 
    public boolean ammendRoom(int number,String type,int noOfPeople,boolean smoking,String details,float price) throws DaoException
    {
    	Connection con = null;
        PreparedStatement ps = null;
        boolean success = false;
        try {
            con = this.getConnection();
            String query;
           	query="UPDATE ROOM SET bedType = ? , smoking = ? price = ? WHERE roomNo= ?;";    
            ps = con.prepareStatement(query);
            ps.setString(1, type);
            if (smoking==true)
            	ps.setString(2,"Y");
            else
            	ps.setString(2, "N");
            ps.setString(3, String.format("%d", price));
            ps.setString(4, String.format("%d", number));
            

            ps.executeUpdate();
            success=true;
        } 
        catch (SQLException e) {
            throw new DaoException("addRoom " + e.getMessage());    
        } 
        finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            }//end try 
            catch (SQLException e) {
                throw new DaoException("addRoom" + e.getMessage());
            }//end catch
        }//end finally
        return success;    	
    }
    
    
}
