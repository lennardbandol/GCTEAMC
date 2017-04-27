
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

=======
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		controller.login(username, password);
		forwardToJsp = "/homepage.html";
		return forwardToJsp;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse repsonse){
		Controller controller = new Controller();
		String forwardToJsp = "";		
		controller.logout();
		forwardToJsp = "/homepage.html";
		return forwardToJsp;
	}
	
	public String register(HttpServletRequest request, HttpServletResponse repsonse){
		Controller controller = new Controller();
		String forwardToJsp = "";	
		String regUsername = request.getParameter("regUsername");
		String regPassword = request.getParameter("regPassword");
		String regConfirmPassword = request.getParameter("regConfirmPassword");
		String registerEmail = request.getParameter("registerEmail");
		String regDOB = request.getParameter("regDOB");
		String regContactNumber = request.getParameter("regContactNumber");
		System.out.printf("regDOB: %s",regDOB);
		controller.register(regUsername, regPassword, regConfirmPassword, registerEmail, regDOB, regContactNumber);
		forwardToJsp = "/homepage.html";
		return forwardToJsp;
	}
	
}