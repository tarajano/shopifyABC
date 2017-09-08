package shopping;

public class ProductVariant {

	private String size;
	private Float price;
	private Integer taxCode;
	
	public ProductVariant(String size, Float price, Integer code) {
		this.size = size;
		this.price = price;
		this.taxCode = code;
	}
	
	// Getters
	public String getSize() {
		return this.size;
	}

	public Float getPrice() {
		return this.price;
	}

	public Integer getTaxCode() {
		return this.taxCode;
	}	
	
	// toString()
	public String toString() {
		String returnString;
		returnString =	"taxCode:" + this.taxCode + ", " + 
				 		"size:" + this.size + ", " +
				 		"price:" + this.price;
		return returnString;
	}

}
