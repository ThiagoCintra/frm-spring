package br.com.cintra.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cintra.Application;
import br.com.cintra.interfaces.SeleniumTest;
import br.com.cintra.pages.HomePage;
import static br.com.cintra.helper.PageHelper.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SeleniumTest(driver = ChromeDriver.class, baseUrl = "https://google.com.br")
public class HomeControllerTest {

	@Autowired
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		setDriverPage(driver);
	}

	@Test
	public void containsActuatorLinks() throws InterruptedException {
		HomePage homePage = (HomePage) getPage(HomePage.class);
		homePage.test();
	

	}
	
	@Test
	public void containsActuatorLinks2() throws InterruptedException {
		HomePage homePage = (HomePage) getPage(HomePage.class);
		homePage.test();
	}

}
