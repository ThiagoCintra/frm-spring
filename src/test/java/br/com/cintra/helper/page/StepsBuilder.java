package br.com.cintra.helper.page;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.cintra.interfaces.annotation.Step;

@Lazy
@Component
public abstract class StepsBuilder {

	Method methods[];
	Annotation[] annotations;
	HashMap<String, Method> mapMethod = new HashMap<String, Method>();
	Step stepAnnotation = null;
	Method method;
	
	public StepsBuilder init() {
		methods = this.getClass().getDeclaredMethods();
		for (Method m : methods) {
			annotations = m.getAnnotations();
			for (Annotation a : annotations) {
				if (a.toString().contains("Step")) {
					stepAnnotation = (Step) a;
					mapMethod.put(stepAnnotation.name(), m);
				}

			}
		}
		return this;
	}

	
	public StepsBuilder executeStep(String stepAnnotation) {
		try {
			method = mapMethod.get(stepAnnotation);
			method.setAccessible(true);
			method.invoke(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return this;
	}
}
