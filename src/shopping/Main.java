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
		pathToFile = "./data/inputEx1.json";
		List<WishListItem> wishList = jsonParser.loadWishList( pathToFile );

		// Loading Tax Rates
		pathToFile = "./data/taxrates.json";
		List<ItemTaxRate> taxRates = jsonParser.loadTaxRates(pathToFile);
		
		// Loading Products
		pathToFile = "./data/products.json";		
		List<Product> productsList = jsonParser.loadProducts(pathToFile);
		

		for( Product e : productsList) {
			System.out.println(e.toString());
		}
		
	}

}
