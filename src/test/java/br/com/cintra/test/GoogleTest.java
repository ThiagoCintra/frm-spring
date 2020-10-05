package br.com.cintra.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.cintra.Application;
import br.com.cintra.helper.screenshot.PdfGenerete;
import br.com.cintra.interfaces.annotation.type_test.selenium.SeleniumTest;
import br.com.cintra.test_steps.GoogleSteps;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SeleniumTest(driver = ChromeDriver.class, 
				driverExe = "webdriver.chrome.driver", 
				drivePath = "E:\\Projects\\chromedriver.exe", baseUrl = "https://google.com.br")

public class GoogleTest {

	@Autowired
	GoogleSteps googleSteps;
	
	@Autowired
	PdfGenerete pdf;

	
	@Test
	public void pesquisaGoogleModifyPageFactory1() throws Exception {
		googleSteps.init().executeStep("google page enviar texto");
		pdf.createPdf("pesquisaGoogleModifyPageFactory");
	}
	
	@Test
	public void pesquisaGoogleModifyPageFactory2() throws Exception {
		googleSteps.init().executeStep("google page enviar texto");
		pdf.createPdf("pesquisaGoogleModifyPageFactory");
	}
	
}
