/**
 * 
 */
package model;

/**
 * @author JSBickerstaff
 * @version 04.07.18
 *
 */
public class Product {
	
	private String sku;
	private String productType;
	private String name;
	private double cost;
	private double price;
	private int quantity;
	
	
	/**
	 * default constructor
	 */
	public Product() {
		this.sku = "NON000";
		this.productType = "No product type";
		this.name = "No name";
		this.cost = 0.00;
		this.price = 0.00;
		this.quantity = 0;
	}
	
	/**
	 * @param sku
	 * @param productType
	 * @param flavor
	 * @param cost
	 * @param price
	 * @param quantity
	 */
	public Product(String sku, String productType, String name, double cost, double price, int quantity) {
		this.sku = sku;
		this.productType = productType;
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {	
		return sku;
	}
	
	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the flavor
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param flavor the flavor to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return String.format("Product [SKU: " + sku + " Name: " + name + " Cost: " + cost +
				" Price: " + price + " Quantity: " + quantity + "]");
	}

}
