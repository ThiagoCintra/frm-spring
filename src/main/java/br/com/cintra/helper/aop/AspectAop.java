package br.com.cintra.helper.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.helper.step.StepsBuilder;

@Aspect
@Component
public class AspectAop {

	Logger logger = LoggerFactory.getLogger(AspectAop.class);

//-----------------------------STEPS-----------------------------------------------------------------
	@Around("@annotation(br.com.cintra.interfaces.annotation.aop.log.clazz.StepAop)")
	public Object logStepsAop(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Step method that will be executed [" + joinPoint.getSignature() + "]");
		return joinPoint.proceed();
	}

	@Around("@annotation(br.com.cintra.interfaces.annotation.aop.log.clazz.StepAop) && args(stepAnnotation)")
	public Object logStepsAop(ProceedingJoinPoint joinPoint, String stepAnnotation) throws Throwable {
		logger.info("Step Method that will be executed [" + joinPoint.getSignature() + "] with paramether ["
				+ stepAnnotation + "]");
		return joinPoint.proceed();
	}

	@AfterReturning(value = "@annotation(br.com.cintra.interfaces.annotation.aop.log.clazz.StepAop)", returning = "stepsBuilder")
	public void logStepsAop(JoinPoint joinPoint, StepsBuilder stepsBuilder) throws Throwable {
		logger.info("Step Method executed [" + joinPoint.getSignature() + "] on Step class [" + stepsBuilder.toString()
				+ "]");
	}

//	@AfterReturning(value = "@annotation(br.com.cintra.interfaces.annotation.aop.log.clazz.StepAop)",argNames = "stepAnnotation")
//	public void logStepsAop(JoinPoint joinPoint, StepsBuilder stepsBuilder, String stepAnnotation) throws Throwable {
//		logger.info(
//				"Step Method executed [" + joinPoint.getSignature() + stepAnnotation+"] on Step class [" + stepsBuilder.toString() + "]");
//	}

//-----------------------------PAGES-----------------------------------------------------------------
	@Around("@annotation(br.com.cintra.interfaces.annotation.aop.log.clazz.PageAop)")
	public Object logPageAop(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Page Method that will be executed [" + joinPoint.getSignature() + "]");
		return joinPoint.proceed();
	}

	@AfterReturning(value = "@annotation(br.com.cintra.interfaces.annotation.aop.log.clazz.PageAop)", returning = "pageBuilder")
	public void logPageAop(JoinPoint joinPoint, PageBuilder pageBuilder) throws Throwable {
		logger.info("Page Method executed [" + joinPoint.getSignature() + "] on Page class ["
				+ pageBuilder.getClassName() + "]");
	}
//-----------------------------Default-----------------------------------------------------------------
	
}
