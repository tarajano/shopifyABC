package shopping;

public class ItemTaxRate {
	
	private Integer taxCode;
	private String name;
	private Float rate;
	
	public ItemTaxRate(Integer code, String name, Float rate) {
		this.taxCode = code;
		this.name = name;
		this.rate = rate;
	}
	
	// Getters
	public Integer getTaxCode() {
		return taxCode;
	}

	public String getName() {
		return name;
	}

	public Float getRate() {
		return rate;
	}
	
	// toString()
	public String toString() {
		String returnString;
		returnString =	"taxCode:" + this.taxCode + ", " + 
				 		"name:" + this.name + ", " +
				 		"rate:" + this.rate;
		return returnString;
	}

}
