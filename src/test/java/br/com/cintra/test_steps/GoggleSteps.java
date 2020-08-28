package br.com.cintra.test_steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintra.helper.step.StepsBuilder;
import br.com.cintra.interfaces.annotation.step.Step;
import br.com.cintra.interfaces.annotation.step.Steps;
import br.com.cintra.test_pages.GooglePage;
import br.com.cintra.test_pages.HomePage;

@Steps
public class GoggleSteps extends StepsBuilder {

	@Autowired
	HomePage homePage;

	@Autowired
	GooglePage googlePage;

	@Step(name = "acesso a page do google e digito")
	private void digitarTextoEmCampoDeBusca() {
		homePage.enviar_texto();
	}

	@Step(name = "campo de deve conter texto")
	private void pegarTextoDoCampoDePesquisa() {
		assertEquals("Teste com elemento fluente", homePage.get_texto());
	}

	@Step(name = "google page enviar texto")
	private void digitarTextoEmCampoDeBuscaGoogle() throws Exception {
		googlePage.buildPage2().sendKeys("cmpPesquisa", "outro teste");
	}

}
