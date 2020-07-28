package br.com.cintra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cintra.interfaces.annotation.Page;

@Page
public class HomePage {

	@FindBy(name ="q")
	private WebElement txtSearch;
	
	
	public void test() {
		txtSearch.sendKeys("Test");
	}
	
	public void test2() {
		txtSearch.sendKeys("Test2");
	}
}
