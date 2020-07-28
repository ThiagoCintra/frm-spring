package br.com.cintra.interfaces.helper;
import static br.com.cintra.helper.PageHelper.getDriver;

public interface ImplementElement <T>{

	default T getElementByXpath(String xpath) {
		return (T) getDriver().findElementByXPath(xpath);
	}
	
	default T getElementById(String id) {
		return (T) getDriver().findElementById(id);
	}
	
}
