package br.com.cintra.helper.page;

import org.openqa.selenium.WebElement;

public abstract class PageBuilder {

	private String text;
	
	@Override
	public String toString() {
		return text;
	}
	
	protected PageBuilder click(WebElement element) {
		element.click();
		return this;
	}
	
	protected PageBuilder sendKeys(WebElement element,String txt) {
		element.sendKeys(txt);
		return this;
	}
	
	protected PageBuilder getText(WebElement element) {
		text = element.getText();
		return this;
	}
}
