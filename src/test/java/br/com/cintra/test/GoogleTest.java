package br.com.cintra.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.cintra.Application;
import br.com.cintra.features.GoogleFeature;
import br.com.cintra.interfaces.annotation.SeleniumTest;
import br.com.cintra.pages.HomePage;
import static br.com.cintra.helper.PageHelper.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SeleniumTest(driver = ChromeDriver.class, 
				driverExe = "webdriver.chrome.driver", 
				drivePath = "C:\\chromedriver.exe", baseUrl = "https://google.com.br")

public class GoogleTest {

	@Autowired
	GoogleFeature google;
	
	
	
	
	@Test
	public void containsActuatorLinks() throws InterruptedException {
		google.teste01();
	}

	@Test
	public void containsActuatorLinksA() throws InterruptedException {
		google.teste02();
	}
}
