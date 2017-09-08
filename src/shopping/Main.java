package shopping;

/*
 * Author: Manuel Alonso Tarajano (tarajano@gmail.com)
 */

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pathToWishListFile = "/Users/tarajano/eclipse-workspace/shopifyABC/data/inputEx1.json";
		
		System.out.println("here we are");
		JSONInputParser jp = new JSONInputParser();
		jp.loadWishList( pathToWishListFile );
		
	}

}
