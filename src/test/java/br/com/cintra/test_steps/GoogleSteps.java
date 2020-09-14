package br.com.cintra.test_steps;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintra.helper.step.StepsBuilder;
import br.com.cintra.interfaces.annotation.step.Step;
import br.com.cintra.interfaces.annotation.step.Steps;
import br.com.cintra.test_pages.GooglePage;

@Steps
public class GoogleSteps extends StepsBuilder {

	@Autowired
	GooglePage googlePage;

	@Step(name = "google page enviar texto")
	private void digitarTextoEmCampoDeBuscaGoogle() throws Exception {
		googlePage.buildPageFactory().sendKeys("cmpPesquisa", "vai").takeScreenshot("Teste").scrollToElement("cmpPesquisa");
	}
}
