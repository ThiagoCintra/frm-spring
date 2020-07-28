package br.com.cintra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.Page;

@Page
public class HomePage extends PageBuilder{

	@FindBy(name ="q")
	private WebElement txtSearch;
	
	@FindBy(name ="q")
	private WebElement txtA;
	
	public void TesteComElementoFluenteEnivar() {
		super.sendKeys(txtSearch, "Teste com elemento fluente");
	}
	
	public void TesteComElementoFluentePegarTexto() {
		super.getText(txtSearch).toString();
	}
}
