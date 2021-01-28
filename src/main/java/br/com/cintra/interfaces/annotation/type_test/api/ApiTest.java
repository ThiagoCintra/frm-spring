package br.com.cintra.interfaces.annotation.type_test.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;

import br.com.cintra.execute.ApiTestExecutionListener;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestExecutionListeners(
        listeners = ApiTestExecutionListener.class,
        mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
public @interface ApiTest {
	
	String baseUri() default "";
	String basePort() default "";
	String jsonFile () default "";
	
}
