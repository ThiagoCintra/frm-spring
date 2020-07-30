package br.com.cintra.features;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintra.helper.page.StepsBuilder;
import br.com.cintra.interfaces.annotation.Step;
import br.com.cintra.interfaces.annotation.Steps;
import br.com.cintra.pages.HomePage;

@Steps
public class GoggleSteps extends StepsBuilder {
	
	@Autowired
	HomePage homePage;
	
	@Step(name ="Teste02")
	public void digitarTextoEmCampoDeBusca() {
		homePage.TesteComElementoFluenteEnivar();
	}
	
	public void pegarTextoDoCampoDePesquisa() {
		homePage.TesteComElementoFluentePegarTexto();
	}
	
	
}
