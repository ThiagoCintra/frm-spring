package br.com.cintra.execute;

import static br.com.cintra.helper.test.TestHelper.setPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import br.com.cintra.interfaces.annotation.page.Page;

@Component
public class BeanProcessor implements BeanPostProcessor {

	Logger logger = LoggerFactory.getLogger(BeanProcessor.class);
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(Page.class)) {
			logger.info("Create Bean [" + bean.getClass().getName() + "] Page Annotation [" + bean.getClass().getAnnotation(Page.class).name()+ "]");
			setPage(bean.getClass(), bean);
		}else {
			logger.info("Create Bean " + bean.getClass().getName());
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
