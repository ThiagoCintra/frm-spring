package br.com.cintra.features;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.cintra.interfaces.annotation.Steps;
import br.com.cintra.pages.HomePage;

@Steps
public class GoggleSteps {
	
	@Autowired
	HomePage homePage;
	
	public void digitarTextoEmCampoDeBusca() {
		homePage.TesteComElementoFluenteEnivar();
	}
	
	public void pegarTextoDoCampoDePesquisa() {
		homePage.TesteComElementoFluentePegarTexto();
	}
	
	
}
