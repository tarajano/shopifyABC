package shopping;

import java.util.List;

public class Product {

	private Integer productId;
	private String name;
	List<ProductVariant> variantsList;
	
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
	
	// toString()
	public String toString() {
		String returnString;
		returnString =	"productId:" + this.productId + ", " + 
				 		"name:" + this.name + ", " +
				 		"variants:" + this.variantsList.toString();
		return returnString;
	}

}
