package br.com.cintra.helper.element.files;

import static br.com.cintra.helper.element.files.JsonFiles.getFileInstantiete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


@Component
@PropertySource(value = "classpath:application.properties")
public class JsonFiles {

	private Map<String, String> files;
	private static Map<String, File> fileInstantiete = new HashMap<String, File>();
	private static Map<String, JsonElement> fileJsonParse = new HashMap<String, JsonElement>();

	
	public JsonFiles(@Value("#{${file.init.jsonfile-map}}")Map<String, String> files) {
		this.files = files;
		
		for(Map.Entry<String, String> entry : files.entrySet()) {
			fileInstantiete.put(entry.getKey(),new File(entry.getValue()));
			try {
				fileJsonParse.put(entry.getKey(), new JsonParser().parse(new FileReader(fileInstantiete.get(entry.getKey()))));
			} catch (JsonIOException e) {
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Map<String, File> getFileInstantiete() {
		return fileInstantiete;
	}
	
	public static Map<String, JsonElement> getFileJsonParse() {
		return fileJsonParse;
	}

	public static void setFileJsonParse(Map<String, JsonElement> fileJsonParse) {
		JsonFiles.fileJsonParse = fileJsonParse;
	}

}
