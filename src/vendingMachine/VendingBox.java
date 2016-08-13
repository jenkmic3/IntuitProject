package vendingMachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import vendingProduct.VendingProduct;

public class VendingBox {

	/**
	 * Constructor.  Starts with no money.
	 */
	public VendingBox(){
		totalMoney=0;
		
	}//end VendingMachine constructor
	/**
	 * 	Return the money in the box
	 * @return totalMoney
	 */
	private float getTotalMoney() {
		return totalMoney;
	}
	/**
	 * Set the amount of oney in the box
	 * @param totalMoney
	 */
	private void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}//end add setTotalMoney
	
	/**
	 * Add a product to the box
	 * @param location
	 * @param name
	 * @param price
	 */
	public void addProduct(String location, String name, float price){		
		
		if (this.locationHashMap.get(location)==null){
			VendingLocation newLocation = new VendingLocation();
			this.locationHashMap.put(location, newLocation);
		}//end if
		VendingLocation currentLocation = this.locationHashMap.get(location);
		currentLocation.addProduct(location, name, price);
		currentLocation.increaseQuantityByOne();
				
	}//end addProduct
	
	/**
	 * Return the price of the product or zero dollars if the slot is empty
	 * @param location
	 * @return price of the product or 0 if slot is empty
	 */
	public float getPrice(String location){
		if (this.locationHashMap.get(location)!=null){
			VendingLocation currentLocation = this.locationHashMap.get(location);
			return currentLocation.getProductPrice();
		}
		return 0;
		
	}//end getPrice
	
	/**
	 * Load the products in the box
	 */
	public void loadProducts(){
		try {
			BufferedReader br = new BufferedReader(new FileReader("products.txt"));
			String line;
			
			try {
				while ((line = br.readLine()) != null){
					String[]splitLine = line.split("\\s+");
					if (!line.isEmpty() && splitLine.length==3){
						String location = splitLine[0];
						String name = splitLine[1];
						float price = Float.valueOf(splitLine[2]);
						addProduct(location, name, price);
					}//end if
				}//end while
			} catch (IOException e) {
				System.out.println("Error Reading File: " + e);
			}//end catch
		} catch (FileNotFoundException e) {
			System.out.println("Please create \"products.txt\" file: " + e);
		}//end catch
	}//loadProducts	
	
	/**
	 * Display the menu to the user
	 */
	public void displayProducts() {
		SortedSet<String> keys = new TreeSet<String>(locationHashMap.keySet());
		
		//sort hash map
		for (String key: keys){
			if (locationHashMap.get(key).getQuantity()>0){
				String product = locationHashMap.get(key).getProductName();
				float price = locationHashMap.get(key).getProductPrice();
				System.out.println("Location: " + key + " " + product + " Price: " + price);
			}//end if
		}//end for
		
	}//end displayMenu
	
	/**
	 * Purchase a product for the box
	 * @param locationInput
	 * @param customerMoney
	 * @return the products name
	 */
	public String purchaseProduct(String locationInput, float customerMoney) {		
		if (this.locationHashMap.get(locationInput)!=null){
			VendingLocation currentLocation = this.locationHashMap.get(locationInput);
			if (currentLocation.getQuantity()>0){
				if (customerMoney >= currentLocation.getProductPrice()){
					totalMoney+=currentLocation.getProductPrice();
					return currentLocation.getProduct().getName();
				}//end if
				else return "1";
			}//end if
		}//end if		
		return null;
		
	}//end locationInput
	
	/**
	 * Return the change to the user
	 * @param locationInput
	 * @param customerMoney
	 * @return users change
	 */
	public float getChange(String locationInput, float customerMoney) {
		VendingLocation currentLocation = this.locationHashMap.get(locationInput);
		float change = customerMoney - currentLocation.getProductPrice();
		return change;
	}
	
	//variables
	float totalMoney;
	HashMap<String,VendingLocation> locationHashMap = new HashMap<String, VendingLocation>();
		
	
}//end VendingBox
	
