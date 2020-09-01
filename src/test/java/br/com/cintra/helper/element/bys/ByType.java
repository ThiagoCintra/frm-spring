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

import com.google.common.base.Preconditions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;

public class ByType {

	SearchWith search;
	SearchAll searchall;
	String pageName;

	public ByType(SearchWith search, String pageName) {
		this.search = search;
		this.pageName = pageName;
	}

	public ByType(SearchAll searchall, String pageName) {
		this.searchall = searchall;
		this.pageName = pageName;
	}

	public ByType(String pageName) {
		this.pageName = pageName;
	}

	public By by() {
		Preconditions.checkArgument(search != null, "Failed to locate the annotation @SearchWith");
		String elementName = search.name();
		String locatorsFile;

		if (search.locatorsFile().isEmpty()) {
			locatorsFile = pageName;
		} else {
			locatorsFile = search.locatorsFile();
		}

		Preconditions.checkArgument(isNotNullAndEmpty(elementName), "Element name is not found.");
		Preconditions.checkArgument(isNotNullAndEmpty(locatorsFile), "Locators File name not provided");
		Preconditions.checkArgument(getFileInstantiete().get(locatorsFile).exists(),
				"Unable to locate " + locatorsFile);

		try {

			Iterator<JsonElement> iterator = getJsonIterator(locatorsFile);
			JsonObject foundObject = null;

			while (iterator.hasNext()) {
				JsonObject object = iterator.next().getAsJsonObject();
				if (elementName.equalsIgnoreCase(object.get("name").getAsString())) {
					foundObject = object;
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

			return type(type, locator);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public By[] allBys() {

		int size = getJsonArray(pageName).size();
		int i = 0;
		By[] bys = new By[size];
		JsonObject object;

		try {

			Iterator<JsonElement> iterator = getJsonIterator(pageName);

			while (iterator.hasNext()) {

				object = iterator.next().getAsJsonObject();

				String type = getMapBy(object.get("locateUsing").getAsString());

				if (type == null) {
					throw new UnsupportedOperationException("Currently is NOT supported " + type);
				}

				String locator = object.get("locator").getAsString();
				bys[i] = type(type, locator);
				i++;
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

			return new By.ByName(locator);

		} else if (type.equalsIgnoreCase("id")) {

			return new By.ById(locator);

		} else if (type.equalsIgnoreCase("className")) {

			return new By.ByClassName(locator);

		}

		else if (type.equalsIgnoreCase("css")) {
			return new By.ByCssSelector(locator);
		}

		else {
			return new By.ByXPath(locator);
		}
	}

//	public By[] allBys2() {
//
//		int size = getJsonArray(pageName).size();
//		int i = 0;
//		List<String> ignore = Arrays.asList(searchall.ignore());
//		By[] bys = new By[size];
//		JsonObject object;
//
//		try {
//
//			Iterator<JsonElement> iterator = getJsonIterator(pageName);
//
//			while (iterator.hasNext()) {
//
//				object = iterator.next().getAsJsonObject();
//
//				String type = getMapBy(object.get("locateUsing").getAsString());
//
//				if (type == null) {
//					throw new UnsupportedOperationException("Currently is NOT supported " + type);
//				}
//
//				String locator = object.get("locator").getAsString();
//				bys[i] = type(type, locator);
//				i++;
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		return bys;
//	}
}
