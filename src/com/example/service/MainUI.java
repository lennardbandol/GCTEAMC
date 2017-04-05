package com.example.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.example.command.Controller;

public class MainUI {
	public MainUI(){
	
	}
		
	public String login(HttpServletRequest request, HttpServletResponse repsonse){
		Controller controller = new Controller();
		String forwardToJsp = "";		
		String uName = request.getParameter("uName"); //change according to frontend
		String pWord = request.getParameter("pWord"); //change according to frontend
		
		controller.login(uName, pWord);
		
		forwardToJsp = login(request, repsonse);
		return forwardToJsp;
	}
}

