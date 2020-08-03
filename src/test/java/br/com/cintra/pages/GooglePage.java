package br.com.cintra.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;

import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import br.com.cintra.interfaces.annotation.page.Page;

@Page
@Scope("prototype")
public class GooglePage extends PageBuilder{

	 public static final String PAGE = "GooglePage";
	 
	@SearchWith (inPage = GooglePage.PAGE, locatorsFile = "src\\test\\java\\jsonPage\\TestJsonPage.json", name = "cmpPesquisa")
	private WebElement txtSearch;
	
	
	public void enviar_texto() {
		super.buildPage2().sendKeys(txtSearch, "Teste com elemento fluente");
	}
	
}
