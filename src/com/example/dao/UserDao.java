package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.exceptions.DaoException;


public class UserDao extends Dao {

    public boolean login(String uName, String pWord) throws DaoException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //by default success full login is set to false 
        boolean success = false;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM USERS";//change according to DB
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            if (rs.getString("PASSWORD")/* change according to DB*/ == pWord) {
            	//Password matches
            	success = true;
            }
        } 
        catch (SQLException e) {
            throw new DaoException("login " + e.getMessage());    
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
                throw new DaoException("login" + e.getMessage());
            }//end catch
        }//end finally
        return success;
    }
    
    public boolean register(String regUsername, String regPassword, String regConfirmPassword, String registerEmail, String regDOB, String regContactNumber) throws DaoException{
        Connection con = null;
        PreparedStatement ps = null;
        //by default success full login is set to false 
        boolean success = false;
        try {
            con = this.getConnection();
            
            String query = "INSERT INTO user (userId, password, name, birthday, gender, privilege) VALUES (?,?,?,?,'M','user');";
            ps = con.prepareStatement(query);
            ps.setString(1, regUsername);
            ps.setString(2, regPassword);
            ps.setString(3, regUsername);
            ps.setString(4, regPassword);
            
            ps.executeUpdate();

            	success = true;
        } 
        catch (SQLException e) {
            throw new DaoException("register " + e.getMessage());    
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
                throw new DaoException("register" + e.getMessage());
            }//end catch
        }//end finally
        return success;
    }
}//end UserDao
