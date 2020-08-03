package br.com.cintra.execute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import br.com.cintra.helper.element.element_locator_factory.FileBasedElementLocatorFactory;
import br.com.cintra.interfaces.annotation.selenium.SeleniumTest;

import static br.com.cintra.helper.page.PageHelper.setDriver;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static br.com.cintra.helper.page.PageHelper.setFactory;
public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

	private static RemoteWebDriver driver;
	private ApplicationContext context = null;
	private SeleniumTest annotation;
	private ConfigurableApplicationContext configurableApplicationContext;
	private ConfigurableListableBeanFactory bf;
	private ElementLocatorFactory factory;
	
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		if (driver != null) {
			return;
		}
		try {
			if (context == null) {
				this.annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
				System.setProperty(annotation.driverExe(), annotation.drivePath());
				context = testContext.getApplicationContext();
				configurableApplicationContext = (ConfigurableApplicationContext) this.context;
				bf = configurableApplicationContext.getBeanFactory();
			}
			driver = BeanUtils.instantiateClass(annotation.driver());
			factory = new FileBasedElementLocatorFactory(driver);
			bf.registerResolvableDependency(WebDriver.class, driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		if (driver != null) {
			setDriver(driver);
			this.annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
			setFactory(factory);
			driver.get(annotation.baseUrl());
		} else {
			prepareTestInstance(testContext);
		}
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		if (driver != null) {
			killDriver();
			context = null;
		}
	}

	@Override
	public void afterTestMethod(final TestContext testContext) throws Exception {
		if (testContext.getTestException() == null) {
			killDriver();
			return;
		}
		killDriver();
	}

	public void killDriver() {
		driver.close();
		driver.quit();
		driver = null;
	}
}
