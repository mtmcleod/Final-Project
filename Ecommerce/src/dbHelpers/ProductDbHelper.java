package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

/**
 * This refactor version moves the queries from their own objects
 * and organizes them as methods by model. 
 */

public class ProductDbHelper {
	private Connection connection;

	public ProductDbHelper() {
		connection = MyDbConnection.getConnection();
	}

	public void doAdd(Product product){
		String query = "INSERT INTO products (sku, productType , flavor, cost, price, quantity) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, product.getSku());
			ps.setString(2, product.getProductType());
			ps.setString(3, product.getName());
			ps.setDouble(4, product.getCost());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getQuantity());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block; add real error handling!
			e.printStackTrace();
		}
	}

	public void doDelete(String sku) {
		String query = "DELETE FROM products WHERE sku = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, sku);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block; add real error handling!
			e.printStackTrace();
		}
	}
	
	public void doUpdate(Product product){
		String query = "UPDATE products SET ProductType=?, Name=?, Cost=?, Price=?, Quantity=? WHERE sku=?";
		

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			
			ps.setString(1, product.getProductType());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getCost());
			ps.setDouble(4, product.getPrice());
			
			ps.setInt(5, product.getQuantity());
			ps.setString(6, product.getSku());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block; add real error handling!
			e.printStackTrace();
		}
	}

	/**
	 * doReadAll() is a refactor of the ReadQuery object's doRead() method
	 * in the previous version.
	 * 
	 * In this version, doReadAll() returns a result set rather than 
	 * storing it as a field of this helper object. The {@link #getHTMLTable()}
	 * helper is modified to accept the result set instead.
	 *  
	 * @return ResultSet
	 */
	public ResultSet doReadAll(){
		// Other methods will expect specific fields from this result set.
		// This is one reason why it's always good practice to SELECT specific fields
		// rather than using the wild card, SELECT *

		// String query = "SELECT * FROM books"; // <-- Not as good
		String query = "SELECT SKU, ProductType, Name, Cost, Price, Quantity FROM products"; // <-- Better

		ResultSet results = null;
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block; add real error handling!
			e.printStackTrace();
		}

		return results;
	}

	/**
	 * This version was refactored to accept a result set, rather than rely
	 * on a result set existing as a field of the instance.
	 * 
	 * This object could be further refactored to run without a result set. 
	 * One path  might be to create an overloaded version that takes no parameters.
	 * 
	 * @param results
	 * @return String
	 */
	public String getHTMLTable(ResultSet results){
		String table ="";
		table += "<table border=1>\n";
		//headers
		table +="<th>";
		table +="SKU";
		table +="</th>";
		/*
		table +="<th>";
		table +="Product Type";
		table +="</th>";
		*/
		table +="<th>";
		table +="Name";
		table +="</th>";
		
		/*
		table +="<th>";
		table +="Cost";
		table +="</th>";
		*/
		
		table +="<th>";
		table +="Price";
		table +="</th>";
		
		table +="<th>";
		table +="Number in Stock";
		table +="</th>";
		
		table +="<th>";
		table +="Actions";
		table +="</th>";

		try {
			while(results.next()) {

				// Consider: Why are we creating Book objects with these results, rather 
				// than just printing the results of the query directly?
				// (It helps us validate our data.)

				Product product = new Product(
						results.getString("sku"),
						results.getString("productType"),
						results.getString("name"),
						results.getDouble("cost"),
						results.getDouble("price"),
						results.getInt("quantity")
						);

				// Consider: Could this table row code be refactored to be part of Book?
				// Would that be a good idea or not?

				table +="<tr>";
				table +="<td>";
				table += product.getSku();
				table +="</td>";
				/*
				table +="<td>";
				table += product.getProductType();
				table +="</td>";
				*/
				table +="<td>";
				table += product.getName();
				table +="</td>";
				/*
				table +="<td>";
				table += product.getCost();
				table +="</td>";
				*/
				table +="<td>";
				table += product.getPrice();
				table +="</td>";
				table +="<td>";
				table += product.getQuantity();
				table +="</td>";
				
				table +="\n\t<td>";
				
				// We made changes to the Delete servlet, so that it can't be accessed via 'GET'
				// Thus, this HTML needs to change as well. 
				// We'll create a small form that POSTs instead.
				
			
				table += "<a href=update?sku=" + product.getSku() + " >Add to Cart</a><br>";
				/*
				table += "<input type=\"hidden\" name=\"sku\" value=\"" + product.getSku() + "\">"; //a hidden field? 
				table += "<input type=\"hidden\" name=\"productType\" value=\"" + product.getProductType() + "\">"; //a hidden field? 
				table += "<input type=\"hidden\" name=\"name\" value=\"" + product.getName() + "\">"; //a hidden field?
				table += "<input type=\"hidden\" name=\"cost\" value=\"" + product.getCost() + "\">"; //a hidden field? 
				table += "<input type='hidden' name='price' value=" + product.getPrice() + ">"; //a hidden field? 
				table += "<input type=\"hidden\" name=\"quantity\" value=\"" + product.getQuantity() + "\">"; //a hidden field? 
				
				table += "<form action=\"delete\" method=\"post\">";
				
				table += "<input type=\"submit\" value=\"Delete\"></form>";
				*/
				// Consider adding behavior that might make this more user friendly:
				// a) adding an "Are you sure?" Javascript popup.
				// b) adding a success message to the reloaded page.
				
				table +="</td>\n";
				
				table +="</tr>\n";

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table += "</table>";
		return table;
	}

	/**
	 * doReadOne() is a refactor of the ReadRecord object's doRead() method
	 * in the previous version.
	 * 
	 * In this version, doReadOne() accepts an integer rather than 
	 * storing it the id as a field of this helper object. It also returns a Book
	 * object, rather than storing it as a field.
	 * 
	 * One consequence of this change is that the calling code is now responsible 
	 * for keeping track of the resulting Book reference, rather than 
	 * the helper object.
	 * 
	 * @param int
	 * @return Book
	 **/
	
	
		
	
	public Product doReadOne(String sku) {
		String query = "SELECT * FROM products WHERE SKU = ?";

		Product product = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setString(1, sku);
			ResultSet results = ps.executeQuery();

			results.next();

			// What if book isn't found? Is an exception thrown?
			// Is it okay to return null from this refactored method?

			product = new Product(
					results.getString("SKU"),
					results.getString("ProductType"),
					results.getString("Name"),
					results.getDouble("Cost"),
					results.getDouble("Price"),
					results.getInt("Quantity")
					);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}
	
	
}
