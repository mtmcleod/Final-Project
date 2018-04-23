package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.RegisterUser;
import model.User;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new book to the database", urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// NEVER make database changes via a GET request.
		// You don't want a web crawler accidentally modifying your data!
		throw new RuntimeException();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the data
		// TODO: Add error checking!
	    String username = request.getParameter("userName");
	    String firstname = request.getParameter("firstName");
	    String lastname = request.getParameter("lastName");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	
		// set up a user object
	    User user = new User();
	    user.setUsername(username);
	    user.setFirstname(firstname);
	    user.setLastname(lastname);
	    user.setEmail(email);
	    user.setPassword(password);
	    
	    
		// set up an dbHelper object
	    RegisterUser bdb = new RegisterUser();
	    
		// pass the book to addQuery to add to the database
	    bdb.doAdd(user);
	    
		// pass execution control to login
	    String url = "/login.jsp";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
