package br.com.cintra.features;

import static br.com.cintra.helper.page.PageHelper.getPage;

import br.com.cintra.interfaces.annotation.Feature;
import br.com.cintra.pages.HomePage;

@Feature(name = "Teste")
public class  GoggleSteps {
	
	HomePage homePage;
	
	public void teste01() {
		homePage = (HomePage) getPage(HomePage.class);
		homePage.TesteComElementoFluenteEnivar();
	}
	
	public void teste02() {
		homePage = (HomePage) getPage(HomePage.class);
		homePage.TesteComElementoFluentePegarTexto();
	}
}
