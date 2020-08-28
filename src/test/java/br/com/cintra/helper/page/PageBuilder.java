package br.com.cintra.helper.page;

import static br.com.cintra.helper.element.files.JsonFiles.getJsonIterator;
import static br.com.cintra.helper.page.PageHelper.getDriver;
import static br.com.cintra.helper.page.PageHelper.getFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.cintra.interfaces.annotation.aop.log.clazz.BuilderPage;
import br.com.cintra.interfaces.annotation.page.Page;


public abstract class PageBuilder {

	private String text;
	private HashMap<String, WebElement> mapOfElements = new HashMap<String, WebElement>();
	private List<WebElement> listElements;
	private String pageName;
	private Field field;


	@Override
	public String toString() {
		return text;
	}

	public PageBuilder click(WebElement element) {
		element.click();
		return this;
	}
	
	public PageBuilder click(String name) {
		try {
			mapOfElements.get(name).click();
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}

	public PageBuilder sendKeys(WebElement element, String txt) {
		element.sendKeys(txt);
		return this;
	}

	
	public PageBuilder sendKeys(String name, String txt) {
		try {
			mapOfElements.get(name).sendKeys(txt);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}

	public PageBuilder getText(WebElement element) {
		text = element.getText();
		return this;
	}
	
	public PageBuilder getText(String name) {
		try {
			text = mapOfElements.get(name).getText();
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}

	public PageBuilder getAtribute(String name, String attribute) {
		try {
			text = mapOfElements.get(name).getAttribute(attribute);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}
	
	public PageBuilder getAtribute(WebElement element, String attribute) {
		text = element.getAttribute(attribute);
		return this;
	}
	
	@BuilderPage
	public PageBuilder buildPage() {
		PageFactory.initElements(getDriver(), this);
		return this;
	}

	@BuilderPage
	public PageBuilder buildPage2() throws Exception {
		Page page = this.getClass().getAnnotation(Page.class);
		this.pageName = page.name();
		PageFactory.initElements(getFactory(), this);
		initElements();
		return this;
	}

	
	private void initElements() throws Exception {
		try {
			field = this.getClass().getDeclaredField("jsonElements");
			field.setAccessible(true);
			listElements = (List<WebElement>) field.get(this);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		if ((pageName != null) && (!pageName.equals(""))) {
			int count = 0;
			Iterator<JsonElement> iterator = getJsonIterator(pageName);
			while (iterator.hasNext()) {
				JsonObject object = iterator.next().getAsJsonObject();
				if (mapOfElements.get(object.get("name").getAsString()) == null) {
					mapOfElements.put(object.get("name").getAsString(), listElements.get(count));
					count++;
				} else {
					throw new Exception("Duplicate element in json file [ " + pageName + " ] with the name [ "
							+ object.get("name").getAsString() + " ]");
				}

			}
		}
	}
	
	public String getClassName() {
		return this.getClass().getName();
	}
}
