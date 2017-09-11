package shopping;

public class TaxRate {
	
	private Integer taxCode;
	private String name;
	private Float rate;
	
	// TODO sort on taxCode 
	
	public TaxRate(Integer code, String name, Float rate) {
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
		return String.format("taxCode:%d, name:%s, rate:%.2f", taxCode, name, rate);
	}

}
