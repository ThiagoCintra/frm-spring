package br.com.cintra.features;

import static br.com.cintra.helper.PageHelper.getPage;
import br.com.cintra.interfaces.annotation.Feature;
import br.com.cintra.pages.HomePage;

@Feature(nameFeature = "TesteGoogle")
public class GoogleFeature {

	HomePage homePage;
	
	public void teste01() {
		homePage = (HomePage) getPage(HomePage.class);
		homePage.test();
	}
	
	public void teste02() {
		homePage = (HomePage) getPage(HomePage.class);
		homePage.test2();
	}
}
