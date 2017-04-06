package com.example.command;

import com.example.dao.UserDao;
import com.example.exceptions.DaoException;
public class Controller {
	
	UserDao userdao = new UserDao();
	
	
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
}
