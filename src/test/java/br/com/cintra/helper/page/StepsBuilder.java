package br.com.cintra.helper.page;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.List;

import br.com.cintra.features.GoggleSteps;


public abstract class StepsBuilder {

	Method method[] ;
	Annotation[] annotation;
	
	public StepsBuilder initSteps() {
		method = this.getClass().getDeclaredMethods();
		List<Annotation> Arrayannotations = null;
		for(Method m : method) {
			annotation = m.getAnnotations();
			for(Annotation a : annotation) {
				Arrayannotations.add(a);
			}
		}
		
		return this;
	}
	
	
}
