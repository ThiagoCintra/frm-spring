package br.com.cintra.helper.step;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.cintra.interfaces.annotation.aop.log.clazz.StepAop;
import br.com.cintra.interfaces.annotation.step.Step;

@Lazy
@Component
public abstract class StepsBuilder {

	Method methods[];
	Annotation[] annotations;
	HashMap<String, Method> mapMethod = new HashMap<String, Method>();
	Step stepAnnotation = null;
	Method method;
	
	
	@StepAop
	public StepsBuilder init() throws Exception {
		methods = this.getClass().getDeclaredMethods();
		for (Method m : methods) {
			annotations = m.getAnnotations();
			for (Annotation a : annotations) {
				if (a.toString().contains("Step")) {
					stepAnnotation = (Step) a;
					if(mapMethod.get(stepAnnotation.name()) != null) {
						throw new Exception();
					}
					mapMethod.put(stepAnnotation.name(), m);
				}

			}
		}
		return this;
	}

	@StepAop
	public StepsBuilder executeStep(String stepAnnotation) throws IllegalAccessException, InvocationTargetException {
		try {
			method = mapMethod.get(stepAnnotation);
			method.setAccessible(true);
			method.invoke(this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new IllegalAccessException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new InvocationTargetException(e.getTargetException());
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException();
		}
		return this;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
