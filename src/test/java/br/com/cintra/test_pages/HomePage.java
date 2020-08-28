package br.com.cintra.test_pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;

import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.page.Page;

@Page
@Scope("prototype")
public class HomePage extends PageBuilder {

	@FindBy(name = "q")
	private WebElement txtSearch;

	@FindBy(name = "q")
	private WebElement txtA;

	public void enviar_texto() {
		super.buildPage().sendKeys(txtSearch, "Teste com elemento fluente");
	}

	public String get_texto() {
		return super.getAtribute(txtSearch, "value").toString();
	}
}
