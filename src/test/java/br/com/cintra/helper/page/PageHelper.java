package br.com.cintra.helper.page;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.springframework.beans.factory.config.SetFactoryBean;

public abstract class PageHelper {

	private static HashMap<Class, Object> pages = new HashMap<Class,Object>();
	private static RemoteWebDriver driver;
	private static ElementLocatorFactory factory;
	
	public static void setPage(Class clazz, Object bean) {
		pages.put(clazz, bean);
	}

	public static Object getPage(Class name) {
		try {
			Object page = pages.get(name);
			return page;
		}catch(Exception e) {
			System.out.println("ainda nao instanciou");
		}
		return name;
	}
	
	public static void setDriver(RemoteWebDriver remoteDriver) {
		driver = remoteDriver;
	}
	
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	
	public static void setFactory(ElementLocatorFactory f) {
		factory = f;
	}
	
	public static ElementLocatorFactory getFactory() {
		return factory;
	}
}
