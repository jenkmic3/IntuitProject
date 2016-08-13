import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import vendingMachine.VendingBox;

public class VendingApp {

	public static void main(String[] args) {
		
		VendingBox vendingBox = new VendingBox();		
		
		//load the products
		vendingBox.loadProducts();
		
		
			while (true){
				//scan for input
				Scanner input = new Scanner(System.in);
				try {
				//Display menu
				System.out.println("Menu: \nPurchase Product(1)\tDisplay Products(2)\tQuit(3)");
				int i = input.nextInt();
				//quit
				if (i==3){
					System.out.println("Thanks for your business!");
					break;
				}
				//Display products
				if (i==2){
					vendingBox.displayProducts();
				}//end if
				//purchase product
				if (i==1){
					System.out.println("Enter Location");
					String locationInput = input.next();
					float productPrice = vendingBox.getPrice(locationInput);
					//if slot is not empty
					if (productPrice!=0){
						System.out.println("Please Input $" + productPrice);
						float customerMoney = input.nextFloat();
						float customerChange = vendingBox.getChange(locationInput,customerMoney);
						String customerProduct = vendingBox.purchaseProduct(locationInput,customerMoney);						
							//if slot is not empty
							if (customerProduct==null){
								System.out.println("Slot is Empty.  Please try another slot.");
							}//end if
							else if (customerProduct=="1"){
								System.out.println("Not enough money entered ");
							}
							else {
								System.out.println("Enjoy your Snack.  Your change is: " + customerChange);
							}//end else
					}//end if productPrice!=0
					else {
						System.out.println("Slot is Empty.  Please try another slot.");
					}//end if
				}//end if					
				} catch (InputMismatchException e) {
					System.out.println("Wrong Input");
				}	
				catch (NullPointerException e) {
					System.out.println("Product does not exist");
				}	
				System.out.println("\n");
			}//end while
	}//end main

}//end VendingApp
