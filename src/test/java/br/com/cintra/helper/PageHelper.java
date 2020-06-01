package br.com.cintra.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageHelper {

	private static HashMap<Class, Object> pages = new HashMap<>();
	private static WebDriver thisDriver;
	
	public static void setPage(Class clazz, Object bean) {
		pages.put(clazz, bean);
	}

	public static Object getPage(Class name) {
		return pages.get(name);
	}
	
	public static void setDriverPage(WebDriver driver) {
		for(Map.Entry<Class, Object> page : pages.entrySet()) {
			try {
				page.setValue(PageFactory.initElements(driver, page.getKey()));	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static WebDriver getDriver() {
		return thisDriver;
	}
}
