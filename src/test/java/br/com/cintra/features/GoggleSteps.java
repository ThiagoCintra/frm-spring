package br.com.cintra.features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintra.helper.page.StepsBuilder;
import br.com.cintra.interfaces.annotation.Step;
import br.com.cintra.interfaces.annotation.Steps;
import br.com.cintra.pages.HomePage;

@Steps
public class GoggleSteps extends StepsBuilder {

	@Autowired
	HomePage homePage;

	@Step(name = "acesso a page do gogole e digito")
	private void digitarTextoEmCampoDeBusca() {
		homePage.enviar_texto();
	}

	@Step(name = "campo de deve conter texto")
	private void pegarTextoDoCampoDePesquisa() {
		assertEquals("Teste com elemento fluente", homePage.get_texto());
	}

}
