package shopping;

import java.util.List;

public class Product {

	private Integer productId;
	private String name;
	List<ProductVariant> variantsList;
	
	// TODO sort on productId
	
	public Product(Integer code, String name, List<ProductVariant> pvList) {
		this.productId = code;
		this.name = name;
		this.variantsList = pvList;
	}
	
	// Getters	
	public Integer getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public List<ProductVariant> getVariantsList() {
		return variantsList;
	}
	
	// Helpers
	private String getVariantsAsString() {
		String returnString = "";
		for (ProductVariant variant: variantsList) {
			returnString = returnString + variant.toString(); 
		}
		return returnString;
	}
	
	// toString()
	public String toString() {
		return String.format("product:%d, name:%s",productId, name);
	}
	
	public String toString(Integer i) {
		// Use this method in case you want to print the variants from product.toString() 
		return String.format("productId:%d, name:%s, variants:%s",productId, name, getVariantsAsString() );
	}
	

}
