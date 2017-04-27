
package com.example.command;

import java.util.ArrayList;

import com.example.business.Room;
import com.example.dao.RoomDao;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;

public class Controller {
	
	UserDao userdao = new UserDao();
	RoomDao roomdao = new RoomDao();
	
	public boolean login(String username, String password){
		try {			
			userdao.login(username, password);
			return true;
		} 
		catch (DaoException e) {
			e.printStackTrace();
			return false;
		}
	}//End login
	
	public boolean logout(){
		return true;
	}//End logout
	
	public boolean register(String regUsername, String regPassword, String regConfirmPassword, String registerEmail, String regDOB, String regContactNumber){
		try {			
			userdao.register(regUsername, regPassword, regConfirmPassword, registerEmail, regDOB, regContactNumber);
			return true;
		} 
		catch (DaoException e) {
			e.printStackTrace();
			return false;
		}
	}//End register
	
	 public ArrayList<Room> getRoom(String type,boolean smoking, float priceMin,float priceMax, int noOfPeople)
     {
		 try {			
				return roomdao.getRoom(type,smoking,priceMin,priceMax,noOfPeople);
			} 
			catch (DaoException e) {
				e.printStackTrace();
				return null;
			}
     }//End getRoom
	 
	 public boolean addRoom(int number,String type,int noOfPeople,boolean smoking,String details,float price)
	 {
		 try {			
				return roomdao.addRoom(number,type,noOfPeople,smoking,details,price);
			} 
			catch (DaoException e) {
				e.printStackTrace();
				return false;
			}
	 }//End addRoom
	 
	 public boolean removeRoom(int number)
	 {
		 try {			
				return roomdao.removeRoom(number);
			} 
			catch (DaoException e) {
				e.printStackTrace();
				return false;
			}
	 }//End removeRoom
	 
	 public boolean ammendRoom(int number,String type,int noOfPeople,boolean smoking,String details,float price)
	 {
		 try 
		 {			
			return roomdao.ammendRoom(number,type,noOfPeople,smoking,details,price);
		 } 
		 catch (DaoException e) {
		 	e.printStackTrace();
			return false;
		 }
	 }//End ammendRoom
	 
}