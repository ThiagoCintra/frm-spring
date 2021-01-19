package br.com.cintra.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.cintra.Application;
import br.com.cintra.interfaces.annotation.type_test.selenium.SeleniumTest;
import br.com.cintra.test_steps.herokuapp.HerokuappStep;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SeleniumTest(driver = ChromeDriver.class, 
				driverExe = "webdriver.chrome.driver", 
				drivePath = "C:\\Projects\\chromedriver.exe", 
				baseUrl = "https://automacaocombatista.herokuapp.com")

public class HeroKuapp {

	@Autowired
	HerokuappStep herokuappStep;
	
	@Test
	public void preencherFormulario() throws Exception {
		herokuappStep.init().executeStep("Acessar automação web")
			.executeStep("Acessar Formulario").executeStep("Preencher formulario");
	}
	
}
