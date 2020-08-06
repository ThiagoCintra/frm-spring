package br.com.cintra.helper.element.custom_annotation;

import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.cintra.interfaces.annotation.element.SearchWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;

import static br.com.cintra.helper.element.files.ElementConstants.getMapBy;
import static br.com.cintra.helper.element.files.JsonFiles.getFileInstantiete;
import static br.com.cintra.helper.element.files.JsonFiles.getFileJsonParse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Iterator;

public class CustomAnnotations extends AbstractAnnotations {

	private final Field field;

	public CustomAnnotations(Field field) {
		this.field = field;
	}

	@Override
	public By buildBy() {
		SearchWith search = field.getAnnotation(SearchWith.class);
		Preconditions.checkArgument(search != null, "Failed to locate the annotation @SearchWith");
		String elementName = search.name();
		String locatorsFile = search.locatorsFile();
		Preconditions.checkArgument(isNotNullAndEmpty(elementName), "Element name is not found.");
		Preconditions.checkArgument(isNotNullAndEmpty(locatorsFile), "Locators File name not provided");
		Preconditions.checkArgument(getFileInstantiete().get(locatorsFile).exists(), "Unable to locate " + locatorsFile);

		try {

			JsonArray array = getFileJsonParse().get(locatorsFile).getAsJsonArray();
			Iterator<JsonElement> iterator = array.iterator();
			JsonObject foundObject = null;

			while (iterator.hasNext()) {
				JsonObject object = iterator.next().getAsJsonObject();
				if (elementName.equalsIgnoreCase(object.get("name").getAsString())) {
					foundObject = object;
					break;
				}
			}

			Preconditions.checkState(foundObject != null,
					"No entry found for the page [" + locatorsFile + "] in the " + "locators file [" + locatorsFile + "]");
			String locateUsing = foundObject.get("locateUsing").getAsString();

			String type = getMapBy(locateUsing);

			if (type == null) {

				throw new UnsupportedOperationException(
						"Currently " + locateUsing + " is NOT supported. Only xPaths " + "are supported");

			}

			String locator = foundObject.get("locator").getAsString();
			Preconditions.checkArgument(isNotNullAndEmpty(locator), "Locator cannot be null (or) empty.");

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

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean isLookupCached() {
		return (field.getAnnotation(CacheLookup.class) != null);
	}

	private boolean isNotNullAndEmpty(String arg) {
		return ((arg != null) && (!arg.trim().isEmpty()));
	}

}
