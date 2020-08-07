package br.com.cintra.test_pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;

import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import br.com.cintra.interfaces.annotation.page.Page;

@Page(name = "googlePage")
@Scope("prototype")
public class GooglePage extends PageBuilder{

	private WebElement txtSearch;
	
	public void enviar_texto() {
		super.buildPage2().sendKeys(txtSearch, "Teste com elemento fluente").sendKeys(txtSearch, "reteste");
	}
	
}
