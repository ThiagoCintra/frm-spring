package br.com.cintra.helper.element.scroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("prototype")
public class ScrollToElement {

	JavascriptExecutor js = null;

	public void setsetJavascriptExecutor(RemoteWebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
