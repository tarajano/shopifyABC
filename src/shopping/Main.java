package shopping;

import java.util.List;

/*
 * Author: Manuel Alonso Tarajano (tarajano@gmail.com)
 */

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String pathToFile = null;
		
		// Preparing parser object
		JSONInputParser jsonParser = new JSONInputParser();

		// Loading Wish List
		pathToFile = "./data/inputEx2.json";
		List<WishListItem> wishList = jsonParser.loadWishList( pathToFile );

		// Loading Tax Rates
		pathToFile = "./data/taxrates.json";
		List<TaxRate> taxRates = jsonParser.loadTaxRates(pathToFile);
		
		// Loading Products
		pathToFile = "./data/products.json";		
		List<Product> productsList = jsonParser.loadProducts(pathToFile);
		
		
		//
		// TODO Commit first
		//
		
		
		
		
		
//		ShoppingCart shoppingCart = new ShoppingCart(wishList,productsList,taxRates);
//		shoppingCart.loadShoppingCart();
//		System.out.println(shoppingCart.toString());
//		System.out.println("done up to here!");

		for( WishListItem e : wishList) {
			System.out.println(e.toString());
		}
//		
//		for( Product e : productsList) {
//			System.out.println(e.toString(1));
//		}
		
	}

}
