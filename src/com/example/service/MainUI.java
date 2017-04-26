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
	
	public String logout(HttpServletRequest request, HttpServletResponse repsonse){
		Controller controller = new Controller();
		String forwardToJsp = "";		
		
		controller.logout();
		
		forwardToJsp = login(request, repsonse);
		return forwardToJsp;
	}
	public String getRooms(HttpServletRequest request, HttpServletResponse repsonse){
		Controller controller = new Controller();
		String forwardToJsp = "";		
		int number = Integer.parseInt(request.getParameter("number"));
		String type= request.getParameter("type");
		boolean smoking;
		if(request.getParameter("smoking")=="true")
		{
			smoking = true;
		}
		else
		{
			smoking = false;
		}
		
		float priceMin = Float.parseFloat(request.getParameter("priceMin"));
		float priceMax = Float.parseFloat(request.getParameter("priceMax"));
		int noOfPeople= Integer.parseInt(request.getParameter("noOfPeople"));
		
		controller.getRoom(type, smoking, priceMin, priceMax, noOfPeople);
		
		forwardToJsp =getRoom(request, repsonse);
		return forwardToJsp;
	}
}

