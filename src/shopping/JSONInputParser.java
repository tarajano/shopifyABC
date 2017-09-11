package shopping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JSONInputParser {
	
	public JSONInputParser() {}
	

	// Reads a JSON array file into an List<TaxRate> 
	public List<Product> loadProducts(String pathToJSON) {
		
		List<Product> returnProductsList = new ArrayList<Product>(); 
		
		try {
			String jsonString = fileToString(pathToJSON);
			
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(jsonString);

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonOuterObjetc = (JSONObject) jsonArray.get(i);
				String name = jsonOuterObjetc.get("name").toString();
				Integer productId = Integer.valueOf( jsonOuterObjetc.get("id").toString() );
				// Fetching the variants
				JSONArray variantsArray = (JSONArray) jsonOuterObjetc.get("variants");
				List<ProductVariant> variantsList = loadProductVariants(variantsArray);
				returnProductsList.add( new Product(productId, name, variantsList) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnProductsList;
	}
	
	// Reads a JSON array into an List<ProductVariant>
	private List<ProductVariant> loadProductVariants ( JSONArray variantsArray ) {
		List<ProductVariant> returnVariants  = new ArrayList<ProductVariant>();

		try {
			for (int i = 0; i < variantsArray.size(); i++) {
				JSONObject jsonVariantObject = (JSONObject) variantsArray.get(i);
				String size = jsonVariantObject.get("size").toString();
				Float price = Float.valueOf( jsonVariantObject.get("price").toString() );
				Integer code = Integer.valueOf( jsonVariantObject.get("tax_code").toString() );
				returnVariants.add( new ProductVariant(size, price, code) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnVariants;
	} 
	
	
	// Reads a JSON array file into an List<TaxRate> 
	public List<TaxRate> loadTaxRates(String pathToJSON) {
		
		List<TaxRate> returnTaxesRatesList = new ArrayList<TaxRate>(); 
		
		try {
			String jsonString = fileToString(pathToJSON);
			
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(jsonString);

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObjetc = (JSONObject) jsonArray.get(i);				 
				Integer code = Integer.valueOf( jsonObjetc.get("code").toString() );
				String name = jsonObjetc.get("name").toString();
				Float rate = Float.valueOf( jsonObjetc.get("rate").toString() );
				returnTaxesRatesList.add( new TaxRate(code, name, rate) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnTaxesRatesList;
	}	
	
	
	// Reads a JSON array file into an List<WishListItem> 
	public List<WishListItem> loadWishList(String pathToJSON) {
		
		List<WishListItem> returnWishList = new ArrayList<WishListItem>(); 
		
		try {
			String jsonString = fileToString(pathToJSON);
			
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(jsonString);

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObjetc = (JSONObject) jsonArray.get(i);				 
				Integer id = Integer.valueOf( jsonObjetc.get("product").toString() );
				Integer quantity = Integer.valueOf( jsonObjetc.get("quantity").toString() );
				Integer variant = Integer.valueOf( jsonObjetc.get("variant").toString() );
			    returnWishList.add( new WishListItem(id, variant, quantity) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnWishList;
	}
	
	// Concatenates a file content to a String.
	private String fileToString(String pathToFile) throws IOException {
		String fileContent = "";
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	fileContent = fileContent + " " + line;
		    }
		}
		return fileContent;
	}

}
