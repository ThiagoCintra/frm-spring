package br.com.cintra.execute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import br.com.cintra.helper.element.element_locator_factory.FileBasedElementLocatorFactory;
import br.com.cintra.helper.element.search.SearchWithFieldDecorator;
import br.com.cintra.helper.screenshot.PdfGenerete;
import br.com.cintra.interfaces.annotation.type_test.api.ApiTest;
import br.com.cintra.interfaces.annotation.type_test.selenium.SeleniumTest;

import static br.com.cintra.helper.test.TestHelper.setCurrentTest;
import static br.com.cintra.helper.test.TestHelper.setDriver;
import static br.com.cintra.helper.test.TestHelper.setFactory;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

import org.junit.Rule;
import org.junit.rules.TestName;

public class ApiTestExecutionListener extends AbstractTestExecutionListener {

	private ApiTest annotation;
	private ApplicationContext context = null;
	private ConfigurableApplicationContext configurableApplicationContext;
	private ConfigurableListableBeanFactory bf;
	
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

	
	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		this.annotation = findAnnotation(testContext.getTestClass(), ApiTest.class);
		context = testContext.getApplicationContext();
		configurableApplicationContext = (ConfigurableApplicationContext) this.context;
		bf = configurableApplicationContext.getBeanFactory();
	}

	
	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		
	}

	@Override
	public void afterTestMethod(final TestContext testContext) throws Exception {
		
	}
	
}
