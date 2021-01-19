package br.com.cintra.test_steps.herokuapp;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintra.helper.step.StepsBuilder;
import br.com.cintra.interfaces.annotation.step.Step;
import br.com.cintra.interfaces.annotation.step.Steps;
import br.com.cintra.test_pages.herokuapp.FormularioPage;
import br.com.cintra.test_pages.herokuapp.HomePage;
import br.com.cintra.test_pages.herokuapp.ListaFuncinalidadePage;

@Steps
public class HerokuappStep extends StepsBuilder {

	@Autowired
	HomePage homePage;

	@Autowired
	ListaFuncinalidadePage funcionalidadePage;

	@Autowired
	FormularioPage formularioPage;

	@Step(name = "Acessar automação web")
	private void acessarAutWeb() throws Exception {
		homePage.buildPageFactory().click("btnAutomacaoWeb");
	}

	@Step(name = "Acessar Formulario")
	private void acessarFormulario() throws Exception {
		funcionalidadePage.buildPageFactory().takeScreenshot("teste").click("btnFormulario").click("btnCriarUsario").takeScreenshot("teste2");
	}

	@Step(name = "Preencher formulario")
	private void preencherFormulario() throws Exception {
		formularioPage.buildPageFactory().sendKeys("txtNome", "Thiago").sendKeys("txtUltimoNome", "Cintra")
				.sendKeys("txtEmail", "thiagoscintra74@gmail.com").sendKeys("txtEndero", "VPG");
	}
}
