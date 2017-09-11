package shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
	
	private List<TaxRate> taxRatesList;
	private List<Product> productsList;
	private List<WishListItem> wishesList;
	private List<String> billItemsList = new ArrayList<String>();
	private List<CartItem> cartItemsList = new ArrayList<CartItem>();
	
	private HashMap<Integer,Float> amountByTaxCode = new HashMap<Integer,Float>();
	
	Float billTotal = 0f;
	Float billSubTotal = 0f;
	
	public ShoppingCart(List<WishListItem> wishes, List<Product> products, List<TaxRate> taxes) {
		wishesList = wishes;
		taxRatesList = taxes;
		productsList = products;
	}
	
	// Helpers
	public void printBill() {
		
		String billLine;
		
		// Loading shopping cart from shopping/wish list
		loadShoppingCart();
		// Computing the bill
		computeBill();
		
		// Printing bill
		printHeader();
		// Print before taxes
		for(CartItem cartItem: cartItemsList) {
			
			Integer itemQuantity = cartItem.getQuantity();
			String itemName = cartItem.getProductObject().getName();
			Float itemPrice = cartItem.getVariantObject().getPrice();
			Float itemTaxRate = cartItem.getTaxRateObject().getRate();
			String itemVariant = cartItem.getVariantObject().getSize();
			Integer itemTaxCode = cartItem.getTaxRateObject().getTaxCode();			
			Float itemAmount = itemQuantity * itemPrice;
			
			billLine = String.format("%3d\t\t%s - %s \t %d \t %.2f",
											itemQuantity, itemName, itemVariant, itemTaxCode, itemAmount);
			System.out.println(billLine);
			
		}
		
		// Subtotal
		billLine = String.format("\n\t\tSUBTOTAL: $%.2f\n", billSubTotal);
		System.out.println(billLine);
		
		// After taxes
		printAmountByTaxCode();
		
		// Total
		billLine = String.format("\n\n\t\tTOTAL: $%.2f\n", billTotal);
		System.out.println(billLine);
		
	}

	private void printHeader() {
		System.out.println("==========================================================");
		System.out.println("\t\tCoding Challenge Store");
		System.out.println("==========================================================");
		System.out.println(String.join("\t", "Quantity", "Description", "       Tax Code", "    Amount"));
	}
	
	private void printAmountByTaxCode() {
		String billLine;
		
		for( Integer code : amountByTaxCode.keySet() ) {
			TaxRate taxRateItem = getTaxRateItemByCode(code);
		
			if (taxRateItem != null) {
				Float itemTaxRate =  taxRateItem.getRate();
				String itemTaxName = taxRateItem.getName();
				billLine = String.format("%d-%s\t\t%.0f%%\t%.2f", code, itemTaxName, (itemTaxRate * 100), amountByTaxCode.get(code) );
				System.out.println(billLine);
			} else {
				System.out.println("printAmountByTaxCode() taxCode not found.");
			}
			
		}
		
	} 
	
	private TaxRate getTaxRateItemByCode(Integer code) {
		for (TaxRate taxRateItem : taxRatesList) {
			if (taxRateItem.getTaxCode().equals(code)) {
				return taxRateItem;
			}
		}
		return null;
	}

	private void computeBill() {
		
		for(CartItem cartItem: cartItemsList) {
			Integer itemQuantity = cartItem.getQuantity();
			Float itemPrice = cartItem.getVariantObject().getPrice();
			Float itemTaxRate = cartItem.getTaxRateObject().getRate();
			Integer itemTaxCode = cartItem.getTaxRateObject().getTaxCode();
			
			Float itemAmount = itemQuantity * itemPrice;
			Float itemTaxableAmount = itemQuantity * itemPrice * itemTaxRate;
			
			billSubTotal += itemAmount;
			billTotal += itemAmount + itemTaxableAmount;
			recordAmountByTaxCode(itemTaxCode,itemTaxableAmount);
		}
					
	}
	
	private void recordAmountByTaxCode(Integer code, Float amount) {
		if ( amountByTaxCode.containsKey(code) ) {
			amountByTaxCode.put(code, amountByTaxCode.get(code) + amount); 
		} else {
			amountByTaxCode.put(code, amount);
		}
	}
	
	private TaxRate getTaxRateObject(Integer targetTaxCode) {
		for (TaxRate taxRateObject : taxRatesList) {
			Integer currentTaxCode = taxRateObject.getTaxCode();
			if( currentTaxCode.equals(targetTaxCode) ) {
				return taxRateObject;
			}
		}
		return null;
	}
	
	private Product getProductObject(Integer targetId) {	
		for (Product product : productsList) {
			Integer currentId = product.getProductId();
			if( currentId.equals(targetId) ) {
				return product;
			}
		}
		return null;
	}
	
	private ProductVariant getProductVariantObject(Integer wishProductId, Integer wishVariant) {	
		for (Product stockProduct : productsList) {
			Integer stockId = stockProduct.getProductId();
			if( stockId.equals(wishProductId) ) {
				List<ProductVariant> variantsList = stockProduct.getVariantsList();
				if ( wishVariant >= 0 & wishVariant <= (variantsList.size() - 1) ) {
					return variantsList.get(wishVariant);
				} else {
					return null;
				}
			}
		}
		System.out.printf("product %d NOT in stock\n", wishProductId);
		return null;
	}
	
	private void loadShoppingCart() {
		
		for(WishListItem wishItem : wishesList) {
			
			List<Object> quantProdVarTaxList = new ArrayList<Object>();
			Integer wishProductId = wishItem.getProductId();
			Integer wishVariant = wishItem.getVariant();
			Integer wishQuantity = wishItem.getQuantity();
			
			// Testing if wished Product and Variant exist ('in stock').
			ProductVariant variantObj = getProductVariantObject(wishProductId, wishVariant);
			if ( variantObj != null ) {
				// new CartItem(quantity, ProductObj, ProductVariantObj, ItemTaxRateObj);
				Product productObj = getProductObject(wishProductId);
				TaxRate taxRateObj = getTaxRateObject(variantObj.getTaxCode());
				// Keep quantProdVarTaxList.add in the order: quantity, product, variant, tax rate.
				quantProdVarTaxList.add(wishQuantity);
				quantProdVarTaxList.add(productObj);
				quantProdVarTaxList.add(variantObj);
				quantProdVarTaxList.add(taxRateObj);
				cartItemsList.add( new CartItem(quantProdVarTaxList) );
			}
			
		}
		
	}
	
	// toString
	public String toString() {
		String returnString = "Cart: \n";
		for ( CartItem cartItem : cartItemsList) {
			returnString = returnString + "\t" + cartItem.toString() + "\n";
		}
		return returnString;
	}
	
}
