package br.com.cintra.helper.page;

import static br.com.cintra.helper.element.files.JsonFiles.getJsonIterator;
import static br.com.cintra.helper.test.TestHelper.getDriver;
import static br.com.cintra.helper.test.TestHelper.getFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.cintra.helper.screenshot.TakeScreenshot;
import br.com.cintra.interfaces.annotation.aop.log.clazz.PageAop;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.page.Page;

public abstract class PageBuilder {

	private String text;
	private HashMap<String, WebElement> mapOfElements = new HashMap<String, WebElement>();
	private List<WebElement> listElements;
	private String pageName;
	private Field field;
	private WebDriverWait wait;

	@Autowired
	private TakeScreenshot screenshot;

	@Override
	public String toString() {
		return text;
	}

	@PageAop
	public PageBuilder click(WebElement element) {
		element.click();
		return this;
	}

	@PageAop
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

	@PageAop
	public PageBuilder sendKeys(WebElement element, String txt) {
		element.sendKeys(txt);
		return this;
	}

	@PageAop
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

	@PageAop
	public PageBuilder getText(WebElement element) {
		text = element.getText();
		return this;
	}

	@PageAop
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

	@PageAop
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

	@PageAop
	public WebElement getElementInList(String nameOfList, String attribte,String value) {
		try {
			Field list = this.getClass().getDeclaredField(nameOfList);
			list.setAccessible(true);
			
			@SuppressWarnings("unchecked")
			List<WebElement> sameType = (List<WebElement>) field.get(this);

			for (WebElement element : sameType) {
				if(element.getAttribute(attribte).equals(value)) {
					return element;
				}
			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PageAop
	public WebElement getElementInList(String nameOfList, String text) {
		try {
			Field list = this.getClass().getDeclaredField(nameOfList);
			list.setAccessible(true);
			
			@SuppressWarnings("unchecked")
			List<WebElement> sameType = (List<WebElement>) field.get(this);

			for (WebElement element : sameType) {
				if(element.getText().equals(text)) {
					return element;
				}
			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PageAop
	public PageBuilder getAtribute(WebElement element, String attribute) {
		text = element.getAttribute(attribute);
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsVisible(WebElement element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(element));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsVisible(String element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(mapOfElements.get(element)));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsNotVisible(WebElement element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.invisibilityOf(element));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsNotVisible(String element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.invisibilityOf(mapOfElements.get(element)));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementToBeClickble(WebElement element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.invisibilityOf(element));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementToBeClickble(String element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.invisibilityOf(mapOfElements.get(element)));
		return this;
	}

	@PageAop
	public PageBuilder buildPage() {
		PageFactory.initElements(getDriver(), this);
		return this;
	}

	@PageAop
	public PageBuilder buildPageFactory() throws Exception {
		Page page = this.getClass().getAnnotation(Page.class);
		this.pageName = page.name();
		PageFactory.initElements(getFactory(), this);
		initElements();
		return this;
	}

	@SuppressWarnings("unchecked")
	@PageAop
	private void initElements() throws Exception {

		Field[] fields = this.getClass().getDeclaredFields();
		SearchAll searchAll = null;

		for (Field field : fields) {
			if (searchAll == null) {
				searchAll = field.getAnnotation(SearchAll.class);
				this.field = field;
			}
		}

		if (searchAll != null) {
			try {
				field.setAccessible(true);
				listElements = (List<WebElement>) field.get(this);
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
	}

	@PageAop
	public PageBuilder takeScreenshot(String screenshotName) {
		screenshot.takeScreenshot(screenshotName);
		return this;
	}

	public String getClassName() {
		return this.getClass().getName();
	}
}
