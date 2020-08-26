package br.com.cintra.helper.element.custom_annotation;

import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.ByAll;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.cintra.helper.element.bys.ByType;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;

import static br.com.cintra.helper.element.files.ElementConstants.getMapBy;
import static br.com.cintra.helper.element.files.JsonFiles.getFileInstantiete;
import static br.com.cintra.helper.element.files.JsonFiles.getFileJsonParse;
import static br.com.cintra.helper.element.files.JsonFiles.getJsonArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Iterator;

public class CustomAnnotations extends AbstractAnnotations {

	private final Field field;
	private final String pageName;

	public CustomAnnotations(Field field, String pageName) {
		this.field = field;
		this.pageName = pageName;
	}

	@Override
	public By buildBy() {

		SearchWith search = field.getAnnotation(SearchWith.class);
		SearchAll all = field.getAnnotation(SearchAll.class);

		if (search != null) {
			ByType type = new ByType(search, pageName);
			return type.by();

		} else {
			ByType type = new ByType(pageName);
			return new ByAll(type.allBys());
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
