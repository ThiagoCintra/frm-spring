package br.com.cintra.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.cintra.Application;
import br.com.cintra.features.GoggleSteps;
import br.com.cintra.interfaces.annotation.SeleniumTest;
import br.com.cintra.pages.HomePage;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SeleniumTest(driver = ChromeDriver.class, 
				driverExe = "webdriver.chrome.driver", 
				drivePath = "C:\\chromedriver.exe", baseUrl = "https://google.com.br")

public class GoogleTest {

	@Autowired
	GoggleSteps googleSteps;

	@Test
	public void pesquisaGoogle() throws InterruptedException {
		googleSteps.init().executeStep("acesso a page do gogole e digito")
		  .executeStep("campo de deve conter texto");
	}
}
