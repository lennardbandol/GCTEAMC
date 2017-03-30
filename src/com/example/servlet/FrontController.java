package com.example.servlet;

import com.example.service.MainUI;

@WebServlet(urlPatterns={"/FrontController"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainUI mainUi;
       
    public FrontController() {
    	this.mainUi = new MainUI();
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		processRequest (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}	
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;						
		String action;
		if((action = request.getParameter("action")) == null) {
			action = "";
		}
		
		switch (action) {
		case "/*whatever the case is gonna be*/":
			forwardToJsp = mainUi./*function in MainUI*/(request, response);
			break;
			
		case "/*whatever the case is gonna be*/":
			forwardToJsp = mainUi./*function in MainUI*/(request, response);
			break;
		
		default: 
			forwardToJsp = "/errorPage.jsp";
			break;
		}
		
		forwardToPage(request, response, forwardToJsp);
	}
	
	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page){
		
	}
}
