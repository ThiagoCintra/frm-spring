package br.com.cintra.execute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import br.com.cintra.interfaces.SeleniumTest;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

	private RemoteWebDriver driver;
	private ApplicationContext context;

	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		if (driver != null) {
			return;
		}
		context = testContext.getApplicationContext();
		if (context instanceof ConfigurableApplicationContext) {
			SeleniumTest annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
			driver = BeanUtils.instantiateClass(annotation.driver());
			ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
			ConfigurableListableBeanFactory bf = configurableApplicationContext.getBeanFactory();
			bf.registerResolvableDependency(WebDriver.class, driver);
		}
	}

	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
//		context.
		if (driver != null) {
			SeleniumTest annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
			driver.get(annotation.baseUrl());
		}
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

}
