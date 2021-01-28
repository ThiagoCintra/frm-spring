package br.com.cintra.execute;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import br.com.cintra.interfaces.annotation.type_test.api.ApiTest;

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
