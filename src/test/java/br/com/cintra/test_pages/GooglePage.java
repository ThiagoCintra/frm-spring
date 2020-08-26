package br.com.cintra.test_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;

import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.page.Page;


@Page(name = "googlePage")
@Scope("prototype")
public class GooglePage extends PageBuilder{
	
	@SearchAll
	List<WebElement> jsonElements;
	
	public void enviar_texto() throws Exception {
		super.buildPage2().sendKeys("cmpPesquisa", "abc").click("btnPesquisar").getAtribute("cmpPesquisa", "value");
	}
	
}
