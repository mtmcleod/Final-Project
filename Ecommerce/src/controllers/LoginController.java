package controllers;

import dbHelpers.RegisterUser;
import dbHelpers.UserHelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;


/**
 * Servlet implementation class LoginController
 * A controller for handling user authentication and login
 */
@WebServlet(description = "A controller for handling user logins", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HttpSession session; 
	private String url;


	/**
	 * Servlet constructor
	 */
	public LoginController() {
		super();
	}

	/**
	 * Process GET requests/responses (logout)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * Process POST requests/responses (login)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get our current session
		session = request.getSession();
	    String username = request.getParameter("userName");
	    String password = request.getParameter("password");
	    
	    User user = new User();
	    user.setUsername(username);
	    user.setPassword(password);
	    
	 // set up an dbHelper object
	    UserHelper bdb = new UserHelper();
	    
		// pass the book to addQuery to add to the database
	    bdb.authenticateUser(user);
	    
		// pass execution control to login (/read) or invalid 
	     String url = "";
	     String incorrect = "";
	     if(user != null){
	    	 url = "/read";
	     } else {
	    	 url = "login.jsp";
	    	 incorrect = "invalid login, please try again";
	     }
	     
	     session.setAttribute(incorrect, "incorrect");
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

		
	}
}
