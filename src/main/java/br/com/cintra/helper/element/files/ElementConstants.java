package br.com.cintra.helper.element.files;

import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class ElementConstants {

	public static HashMap<String, String> by = new HashMap<String, String>();
	
	public ElementConstants() {
		by.put("name", "name");
		by.put("id", "id");
		by.put("className", "className");
		by.put("css", "css");
		by.put("xpath", "xpath");
	}
	
	public static String getMapBy(String By) {
		return by.get(By);
	}
}
