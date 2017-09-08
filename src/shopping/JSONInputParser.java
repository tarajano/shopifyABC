package shopping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JSONInputParser {
	
	private JSONParser parserJSON;
	
	public JSONInputParser() {
		parserJSON = new JSONParser();
	}
	
	// Reads a JSON array file into an List<Item> 
	public void loadWishList(String pathToJSON) {
		
		Integer productId;
		Integer variant;
		Integer quantity;
		
		try {
			
			String jsonString = fileToString(pathToJSON);
			
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(jsonString);
			
			for (int i = 0; i < jsonArray.size(); i++) {
			    JSONObject jsonObjetc = (JSONObject) jsonArray.get(i);
			    //System.out.println(jsonObjetc);
//			    (Integer) jsonObjetc.get("productId");
//			    (Integer) jsonObjetc.get("quantity");
//			    (Integer) jsonObjetc.get("variant");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Concatenates a file content to a String.
	private String fileToString(String pathToFile) throws IOException {
		String fileContent = "";
		try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	fileContent = fileContent + " " + line;
		    }
		}
		return fileContent;
	}

}
