package vendingProduct;


public class VendingProduct {
	
	/**
	 * Empty constructor
	 */
	public VendingProduct(){
		
	}//end VendingProduct constructor

	/**
	 * Loaded Constructor
	 * @param price
	 * @param name
	 */
	public VendingProduct(float price, String name){
		this.price = price;
		this.name = name;
	}//end VendingProduct constructor
	
	/**
	 * 
	 * @return price
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * Manually set the products Price
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return Products Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Manually set the products Name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	float price;	
	String name;

	
}//end VendingProduct
