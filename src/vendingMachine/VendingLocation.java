package vendingMachine;


import java.util.Stack;
import vendingProduct.VendingProduct;

public class VendingLocation {
	
	/**
	 * Constructor.
	 * Starts with a quantity of zero.
	 */
	public VendingLocation(){
		quantity=0;
	}//end VendingLocation
	
	/**
	 * Add a product to the slot	
	 * @param location
	 * @param name
	 * @param price
	 */
	public void addProduct(String location, String name, float price){		
		VendingProduct currentProduct = new VendingProduct(price,name);
		stackOfProducts.push(currentProduct);		
	}//end addProduct

	/**
	 * Increases quantity by one.  Used when loading products in the box
	 */
	public void increaseQuantityByOne() {
		quantity++;		
	}//end setQuantityByOne
	
	/**
	 * 
	 * @return Products name
	 */
	public String getProductName(){
		return stackOfProducts.peek().getName();
	}
	
	/**
	 * 
	 * @return Products price
	 */
	public float getProductPrice(){
		if (quantity==0){
			return 0;
		}
		return stackOfProducts.peek().getPrice();
	}

	/**
	 * 
	 * @return the product
	 */
	public VendingProduct getProduct() {
		quantity--;
		return stackOfProducts.pop();		
	}

	/**
	 * 
	 * @return quantity
	 */
	protected int getQuantity() {
		return quantity;
	}
	
	/**
	 * Manually set the slots quantity
	 * @param quantity
	 */
	private void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	int quantity;
	Stack <VendingProduct> stackOfProducts = new Stack<VendingProduct>();
}//end VendingLocation
