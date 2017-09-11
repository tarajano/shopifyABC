package shopping;

import java.util.List;

/*
 * Author: Manuel Alonso Tarajano (tarajano@gmail.com)
 */

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		String pathToFile = null;
		
		// General description. 
		// 	The program uses several classes to organize and modularize the data. These are:
		// 		WishListIte: items to be purchased.
		//		Product: items from the store.
		//  	ProductVariant: variants for each product (will be assigned as a List to a Product object).
		//  	TaxRate: The different tax rates to be applied to purchased items. 
		//  	CartItem: compiles the WishListItems that where found among Products and ProductVariant
		//  	ShoppingCart: composed of CartItems. Has methods to compute the bill and print it out.
		
		// GitHub: https://github.com/tarajano/shopifyABC
		
		// Preparing parser object
		JSONInputParser jsonParser = new JSONInputParser();

		// Loading Tax Rates
		pathToFile = "./data/taxrates.json";
		List<TaxRate> taxRates = jsonParser.loadTaxRates(pathToFile);
		
		// Loading Products
		pathToFile = "./data/products.json";		
		List<Product> productsList = jsonParser.loadProducts(pathToFile);
		
		// Loading Wish List
		pathToFile = "./data/inputTest2.json";
		List<WishListItem> wishList = jsonParser.loadWishList( pathToFile );
		
		ShoppingCart shoppingCart = new ShoppingCart(wishList,productsList,taxRates);
		shoppingCart.printBill();
	}

}
