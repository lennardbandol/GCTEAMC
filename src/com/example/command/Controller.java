<<<<<<< HEAD
package com.example.command;

import java.util.ArrayList;

import com.example.business.Room;
import com.example.dao.RoomDao;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;
public class Controller {
	
	UserDao userdao = new UserDao();
	RoomDao roomdao = new RoomDao();
	
	public boolean login(String uName, String pWord){
		try {			
			System.out.println("Try login");
			userdao.login(uName, pWord);
			return true;
		} 
		catch (DaoException e) {
			System.out.println("fails login");
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
		try{
			System.out.println("Try Search");
			return roomdao.getRoom(type,smoking,priceMin,priceMax,noOfPeople);
		}
		catch(DaoException e)
		{
			System.out.println("Fail to search");
			e.printStackTrace();
			return null;
		}
	}
}
=======
package com.example.command;

import com.example.dao.UserDao;
import com.example.exceptions.DaoException;
import com.example.business.Room;
import java.util.ArrayList;

public class Controller {
	
	UserDao userdao = new UserDao();
	
	
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
	}//End login
	
	public ArrayList<Room> searchRoom(String checkInDate, String checkOutDate, String roomType){
		ArrayList<Room> listRooms = null;
		try {			
			listRooms = roomDao.searchRoom(String checkInDate, String checkOutDate, String roomType)
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		return listRooms;
	}
}
>>>>>>> branch 'master' of https://github.com/AndrewKLeech/GCTEAMC
