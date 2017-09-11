package shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<WishListItem> wishesList;
	private List<TaxRate> taxRatesList;
	private List<Product> productsList;
	private List<CartItem> cartItemsList = new ArrayList<CartItem>();
	
	public ShoppingCart(List<WishListItem> wishes, List<Product> products, List<TaxRate> taxes) {
		taxRatesList = taxes;
		wishesList = wishes;
		productsList = products;
	}
	
	// Helpers
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
	
	public void loadShoppingCart() {
		
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
	
	// Getters
	
	
	// toString
	public String toString() {
		String returnString = "Cart: \n";
		for ( CartItem cartItem : cartItemsList) {
			returnString = returnString + "\t" + cartItem.toString() + "\n";
		}
		return returnString;
	}
	
}
