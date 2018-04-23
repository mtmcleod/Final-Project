package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Product;
import dbHelpers.ProductDbHelper;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updateProduct" })
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBookServlet() {
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
		// get the form data and set up a Book object
	    String sku = request.getParameter("sku");
	    String productType = request.getParameter("productType");
	    String name = request.getParameter("name");
	    double cost = Double.parseDouble(request.getParameter("cost"));
	    double price = Double.parseDouble(request.getParameter("price"));
	    
	    //how many did you originally have?
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    
	    //how many did they order?
		
		int amount = Integer.parseInt(request.getParameter("amount"));


	    Product product = new Product();
	    product.setSku(sku);
	    product.setProductType(productType);
	    product.setName(name);
	    product.setCost(cost);
	    product.setPrice(price);
	    
	    
	 
	    
	    String tooMuch ="";
	    
	    if (amount - quantity < 0) {
	    	tooMuch = "not enough in stock - resetting order";
	    	product.setQuantity(quantity);
	    } else {
	    	product.setQuantity(amount - quantity);
	    }
	    
	    
		// create an dbHelper object and use it to update the book
		ProductDbHelper bdb = new ProductDbHelper();
		bdb.doUpdate(product);

		// pass control on to the ReadServlet
		String url = "/read";
		request.setAttribute("tooMuch",tooMuch);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}