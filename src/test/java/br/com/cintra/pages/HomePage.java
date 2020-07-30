package br.com.cintra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;

import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.Page;

@Page
@Scope("prototype")
public class HomePage extends PageBuilder{

	@FindBy(name ="q")
	private WebElement txtSearch;
	
	@FindBy(name ="q")
	private WebElement txtA;
	
	public void TesteComElementoFluenteEnivar() {
		super.buildPage().sendKeys(txtSearch, "Teste com elemento fluente").killPage();
	}
	
	public void TesteComElementoFluentePegarTexto() {
		super.buildPage().getText(txtSearch).killPage().toString();
	}
}
