package br.com.cintra.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.cintra.Application;
import br.com.cintra.helper.screenshot.PdfGenerete;
import br.com.cintra.interfaces.annotation.selenium.SeleniumTest;
import br.com.cintra.test_pages.HomePage;
import br.com.cintra.test_steps.GoggleSteps;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SeleniumTest(driver = ChromeDriver.class, 
				driverExe = "webdriver.chrome.driver", 
				drivePath = "C:\\chromedriver.exe", baseUrl = "https://google.com.br")

public class GoogleTest {

	@Autowired
	GoggleSteps googleSteps;


	@Test
	public void pesquisaGooglePageFactory() throws Exception {
		googleSteps.init().executeStep("acesso a page do google e digito")
		  .executeStep("campo de deve conter texto");
		
	}
	
	@Test
	public void pesquisaGoogleModifyPageFactory() throws Exception {
		googleSteps.init().executeStep("google page enviar texto");
	}
}
