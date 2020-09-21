package br.com.cintra.helper.element.element_locator_factory;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import br.com.cintra.helper.element.custom_annotation.CustomAnnotations;
import br.com.cintra.interfaces.annotation.page.Page;

public class FileBasedElementLocatorFactory implements ElementLocatorFactory {

	private final SearchContext searchContext;

	public FileBasedElementLocatorFactory(SearchContext searchContext) {
		this.searchContext = searchContext;
	}

	public ElementLocator createLocator(Field field) {

		Page page = field.getDeclaringClass().getAnnotation(Page.class);
		return new FileBasedElementLocator(searchContext, new CustomAnnotations(field, page.name()));
	}
}