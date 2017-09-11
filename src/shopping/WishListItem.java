package shopping;

public class WishListItem {

	private Integer productId;
	private Integer variant;
	private Integer quantity;
	
	public WishListItem(Integer id, Integer var, Integer quant) {
		this.productId = id;
		this.variant = var;
		this.quantity = quant;
	}
	
	// Getters
	public Integer getProductId() {
		return this.productId;
	}

	public Integer getVariant() {
		return this.variant;
	}

	public Integer getQuantity() {
		return this.quantity;
	}
	
	// toString()
	public String toString() {
		return String.format("product:%d, variant:%d, rate:%d", productId, variant, quantity);
	}

}
