package br.com.cintra.execute;

import static br.com.cintra.helper.page.PageHelper.setPage;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import br.com.cintra.interfaces.annotation.Feature;
import br.com.cintra.interfaces.annotation.Page;

@Component
public class BeanProcessor implements BeanPostProcessor {


	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(Page.class)) {
			setPage(bean.getClass(), bean);
//		}else if (bean.getClass().isAnnotationPresent(Feature.class)) {
//			return bean;
		}
		return bean;
	}

	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
