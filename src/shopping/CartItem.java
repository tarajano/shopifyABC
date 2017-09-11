package shopping;

import java.util.List;

public class CartItem {
	
	// Getters
	public Integer getQuantity() {
		return quantity;
	}

	public Product getProductObject() {
		return productObject;
	}

	public TaxRate getTaxRateObject() {
		return taxRateObject;
	}

	public ProductVariant getVariantObject() {
		return variantObject;
	}

	private Integer quantity;
	private Product productObject; 
	private TaxRate taxRateObject;
	private ProductVariant variantObject;
	
	public CartItem(List<Object> list) {
		quantity = (Integer) list.get(0);
		productObject = (Product) list.get(1);
		variantObject = (ProductVariant) list.get(2);
		taxRateObject = (TaxRate) list.get(3);
	}
	
	// toString()
	public String toString() {
		return String.format(	"> quantity:%d || product:%s || variant:%s || taxrate:%s",
								quantity, productObject.toString(), variantObject.toString(), taxRateObject.toString());
	}
}
