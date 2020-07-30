package br.com.cintra.helper.page;
import static br.com.cintra.helper.page.PageHelper.getDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBuilder {

	private String text;
	private static boolean  pageFactoryInitilize;
	
	@Override
	public String toString() {
		return text;
	}
	
	public PageBuilder click(WebElement element) {
		element.click();
		return this;
	}
	
	public PageBuilder sendKeys(WebElement element,String txt) {
		element.sendKeys(txt);
		return this;
	}
	
	public PageBuilder getText(WebElement element) {
		text = element.getText();
		return this;
	}

	public PageBuilder buildPage() {
		if(!pageFactoryInitilize) {
			PageFactory.initElements(getDriver(), this);
			pageFactoryInitilize = true;
		}
		return this;
	}
	
	public PageBuilder killPage() {
		pageFactoryInitilize= false;
		return this;
	}
}
