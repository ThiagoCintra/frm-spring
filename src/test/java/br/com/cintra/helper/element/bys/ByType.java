package br.com.cintra.helper.element.bys;

import static br.com.cintra.helper.element.files.ElementConstants.getMapBy;
import static br.com.cintra.helper.element.files.JsonFiles.getFileInstantiete;
import static br.com.cintra.helper.element.files.JsonFiles.getJsonArray;
import static br.com.cintra.helper.element.files.JsonFiles.getJsonIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.cintra.helper.aop.AspectAop;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;

public class ByType {

	Logger logger = LoggerFactory.getLogger(ByType.class);
	
	SearchWith search;
	SearchAll searchall;
	String pageName;

	public ByType(SearchWith search, String pageName) {
		this.search = search;
		this.pageName = pageName;
		logger.info("Search  ["+search+"]");
		logger.info("Page Name  ["+pageName+"]");
	}

	public ByType(SearchAll searchall, String pageName) {
		this.searchall = searchall;
		this.pageName = pageName;
		logger.info("Search  ["+searchall+"]");
		logger.info("Page Name  ["+pageName+"]");
	}

	public ByType(String pageName) {
		this.pageName = pageName;
		logger.info("Page Name  ["+pageName+"]");
	}

	public By by() {
		Preconditions.checkArgument(search != null, "Failed to locate the annotation @SearchWith");
		String elementName = search.name();
		String locatorsFile;
		logger.info("Element Name  ["+elementName+"]");
		if (search.locatorsFile().isEmpty()) {
			locatorsFile = pageName;
		} else {
			locatorsFile = search.locatorsFile();
		}
		
		logger.info("Locators File  ["+locatorsFile+"]");
		
		Preconditions.checkArgument(isNotNullAndEmpty(elementName), "Element name is not found.");
		Preconditions.checkArgument(isNotNullAndEmpty(locatorsFile), "Locators File name not provided");
		Preconditions.checkArgument(getFileInstantiete().get(locatorsFile).exists(),
				"Unable to locate " + locatorsFile);

		try {

			Iterator<JsonElement> iterator = getJsonIterator(locatorsFile);
			JsonObject foundObject = null;
			
			logger.info("Searching for object in json");
			
			while (iterator.hasNext()) {
				JsonObject object = iterator.next().getAsJsonObject();
				if (elementName.equalsIgnoreCase(object.get("name").getAsString())) {
					foundObject = object;
					logger.info("Found object ["+foundObject.get("name").getAsString()+"]");
					break;
				}
			}

			Preconditions.checkState(foundObject != null, "No entry found for the page [" + locatorsFile + "] in the "
					+ "locators file [" + locatorsFile + "]");
			String locateUsing = foundObject.get("locateUsing").getAsString();

			String type = getMapBy(locateUsing);

			if (type == null) {
				throw new UnsupportedOperationException("Currently " + locateUsing + " is NOT supported ");
			}

			String locator = foundObject.get("locator").getAsString();

			Preconditions.checkArgument(isNotNullAndEmpty(locator), "Locator cannot be null (or) empty.");
			
			logger.info("Object ["+foundObject.get("name").getAsString()+"] locator type ["+locator+"]");
			
			return type(type, locator);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public By[] allBys() {
		int i = 0;
		JsonObject object;
		List<String> ignores = Arrays.asList(searchall.ignore());
		int size = getJsonArray(pageName).size();
		
		if(!ignores.isEmpty() && (!ignores.contains(""))) {
			size-=ignores.size();
		}
		
		By[] bys = new By[size];
		
		try {

			Iterator<JsonElement> iterator = getJsonIterator(pageName);

			while (iterator.hasNext()) {

				object = iterator.next().getAsJsonObject();
				String name = object.get("name").getAsString();
				
				if (!ignores.contains(name)) {
					String type = getMapBy(object.get("locateUsing").getAsString());

					if (type == null) {
						throw new UnsupportedOperationException("Currently is NOT supported " + type);
					}

					String locator = object.get("locator").getAsString();
					bys[i] = type(type, locator);
					i++;
				}
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return bys;
	}

	private boolean isNotNullAndEmpty(String arg) {
		return ((arg != null) && (!arg.trim().isEmpty()));
	}

	public By type(String type, String locator) {
		if (type.equalsIgnoreCase("name")) {
			logger.info("Returning [By.ByName]");
			return new By.ByName(locator);

		} else if (type.equalsIgnoreCase("id")) {
			logger.info("Returning [By.ById]");
			return new By.ById(locator);

		} else if (type.equalsIgnoreCase("className")) {
			logger.info("Returning [By.ByClassName]");
			return new By.ByClassName(locator);

		}

		else if (type.equalsIgnoreCase("css")) {
			logger.info("Returning [By.ByCssSelector]");
			return new By.ByCssSelector(locator);
		}

		else {
			logger.info("Returning [By.ByXPath]");
			return new By.ByXPath(locator);
		}
	}
}
