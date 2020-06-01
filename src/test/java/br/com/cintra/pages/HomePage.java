package br.com.cintra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactoryFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import static br.com.cintra.helper.PageHelper.getDriver;
import br.com.cintra.interfaces.Page;

@Page
public class HomePage {

	@FindBy(name ="q")
	private WebElement txtSearch;
	
	public void test() {
		txtSearch.sendKeys("Test");
	}
}
