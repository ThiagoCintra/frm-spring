# frm-spring — projeto inteiro em um único arquivo

Este arquivo foi solicitado para fornecer o projeto completo a outra IA em uma única entrada. Cada seção abaixo corresponde a um arquivo original e preserva seu caminho relativo. Não edite apenas este documento para corrigir o software: use os caminhos dos títulos para reconstruir ou alterar os arquivos originais.

## Inventário incluído

Arquivos versionados e artefatos presentes em `target/` no momento da consolidação. O próprio `PROJECT_CONTEXT.md` foi excluído para evitar recursão. Arquivos binários são representados em Base64 e devem ser decodificados para recuperar os bytes originais.

Arquivos incluídos: 46

## Visão rápida do projeto

É um framework Java/Spring Boot para automação de testes web com Selenium. O código principal está em `src/main/java`, os recursos em `src/main/resources` e o exemplo de integração em `src/test`. O build usa Maven (`pom.xml`), Java 8, Spring Boot 2.3.1 e Selenium 3.141.59. O fluxo principal usa anotações próprias (`@Page`, `@Steps`, `@Step`, `@SearchWith`, `@SearchAll`, `@SeleniumTest`), Page Objects definidos por JSON, `PageBuilder`, `StepsBuilder`, listeners de execução e componentes de screenshot/PDF.

## Como usar este conteúdo

1. Separe cada seção pelo título de caminho.
2. Grave o conteúdo do bloco no mesmo caminho relativo.
3. Para blocos `base64`, decodifique o conteúdo em bytes; eles são artefatos gerados, não código-fonte.
4. Execute `mvn test` ou `mvn package` após reconstruir o projeto; o teste Selenium de exemplo exige ChromeDriver e acesso externo.
5. Revise caminhos Windows, versões antigas de Selenium/Spring e configurações locais antes de corrigir problemas de execução.

## Conteúdo completo dos arquivos

### `.classpath`

```text
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" output="target/classes" path="src/main/java">
		<attributes>
			<attribute name="optional" value="true"/>
			<attribute name="maven.pomderived" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry excluding="**" kind="src" output="target/classes" path="src/main/resources">
		<attributes>
			<attribute name="maven.pomderived" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="src" output="target/test-classes" path="src/test/java">
		<attributes>
			<attribute name="optional" value="true"/>
			<attribute name="maven.pomderived" value="true"/>
			<attribute name="test" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5">
		<attributes>
			<attribute name="maven.pomderived" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER">
		<attributes>
			<attribute name="maven.pomderived" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="output" path="target/classes"/>
</classpath>
```

### `.gitignore`

```text
/target/
```

### `.project`

```text
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>automation-framework-spring-boot</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
		<buildCommand>
			<name>org.eclipse.m2e.core.maven2Builder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
		<nature>org.eclipse.m2e.core.maven2Nature</nature>
	</natures>
</projectDescription>
```

### `.settings/org.eclipse.core.resources.prefs`

```properties
eclipse.preferences.version=1
encoding//src/main/java=UTF-8
encoding//src/main/resources=UTF-8
encoding//src/test/java=UTF-8
encoding//src/test/java/jsonPage/herokuapp/FormularioPage.json=UTF-8
encoding//src/test/java/jsonPage/herokuapp/HomePage.json=UTF-8
encoding//src/test/java/jsonPage/herokuapp/ListaDeFuncionalidade.json=UTF-8
encoding//src/test/resources=UTF-8
encoding/<project>=UTF-8
```

### `.settings/org.eclipse.jdt.core.prefs`

```properties
eclipse.preferences.version=1
org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode=enabled
org.eclipse.jdt.core.compiler.codegen.methodParameters=generate
org.eclipse.jdt.core.compiler.codegen.targetPlatform=1.5
org.eclipse.jdt.core.compiler.codegen.unusedLocal=preserve
org.eclipse.jdt.core.compiler.compliance=1.5
org.eclipse.jdt.core.compiler.debug.lineNumber=generate
org.eclipse.jdt.core.compiler.debug.localVariable=generate
org.eclipse.jdt.core.compiler.debug.sourceFile=generate
org.eclipse.jdt.core.compiler.problem.assertIdentifier=error
org.eclipse.jdt.core.compiler.problem.enablePreviewFeatures=disabled
org.eclipse.jdt.core.compiler.problem.enumIdentifier=error
org.eclipse.jdt.core.compiler.problem.forbiddenReference=warning
org.eclipse.jdt.core.compiler.problem.reportPreviewFeatures=ignore
org.eclipse.jdt.core.compiler.release=disabled
org.eclipse.jdt.core.compiler.source=1.5
```

### `.settings/org.eclipse.m2e.core.prefs`

```properties
activeProfiles=
eclipse.preferences.version=1
resolveWorkspaceProjects=true
version=1
```

### `debug.log` (binário; Base64)

```base64
WzEyMjIvMTAxOTMwLjA1NjpFUlJPUjpkaXJlY3RvcnlfcmVhZGVyX3dpbi5jYyg0MyldIEZpbmRGaXJzdEZpbGU6IE8gc2lzdGVtYSBu428gcG9kZSBlbmNvbnRyYXIgbyBjYW1pbmhvIGVzcGVjaWZpY2Fkby4gKDB4MykKWzEyMjIvMTEyMTI1LjM1OTpFUlJPUjpkaXJlY3RvcnlfcmVhZGVyX3dpbi5jYyg0MyldIEZpbmRGaXJzdEZpbGU6IE8gc2lzdGVtYSBu428gcG9kZSBlbmNvbnRyYXIgbyBjYW1pbmhvIGVzcGVjaWZpY2Fkby4gKDB4MykKWzAxMTkvMTQwNTA3LjE3MDpFUlJPUjpkaXJlY3RvcnlfcmVhZGVyX3dpbi5jYyg0MyldIEZpbmRGaXJzdEZpbGU6IE8gc2lzdGVtYSBu428gcG9kZSBlbmNvbnRyYXIgbyBjYW1pbmhvIGVzcGVjaWZpY2Fkby4gKDB4MykKWzAxMTkvMTQxMDExLjUzMzpFUlJPUjpkaXJlY3RvcnlfcmVhZGVyX3dpbi5jYyg0MyldIEZpbmRGaXJzdEZpbGU6IE8gc2lzdGVtYSBu428gcG9kZSBlbmNvbnRyYXIgbyBjYW1pbmhvIGVzcGVjaWZpY2Fkby4gKDB4MykK
```

### `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>br.com.cintra</groupId>
	<artifactId>automation-framework-spring-boot</artifactId>
	<version>0.0.05</version>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jms</artifactId>
			<version>5.2.4.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<version>2.3.1.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
			<version>2.3.1.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<version>2.3.1.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
			<version>2.3.1.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
		</dependency>


		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.5</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-aop -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
			<version>2.3.1.RELEASE</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/ru.yandex.qatools.ashot/ashot -->
		<dependency>
			<groupId>ru.yandex.qatools.ashot</groupId>
			<artifactId>ashot</artifactId>
			<version>1.5.4</version>
		</dependency>

		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>itextpdf</artifactId>
			<version>5.0.6</version>
		</dependency>
		
	</dependencies>



	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

### `src/main/java/br/com/cintra/Application.java`

```java
package br.com.cintra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
```

### `src/main/java/br/com/cintra/execute/ApiTestExecutionListener.java`

```java
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
import br.com.cintra.interfaces.annotation.type_test.selenium.SeleniumTest;

import static br.com.cintra.helper.test.TestHelper.setCurrentTest;
import static br.com.cintra.helper.test.TestHelper.setDriver;
import static br.com.cintra.helper.test.TestHelper.setFactory;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

import org.junit.Rule;
import org.junit.rules.TestName;

public class ApiTestExecutionListener extends AbstractTestExecutionListener {

	
	private static RemoteWebDriver driver;
	private ApplicationContext context = null;
	private SeleniumTest annotation;
	private ConfigurableApplicationContext configurableApplicationContext;
	private ConfigurableListableBeanFactory bf;
	private SearchWithFieldDecorator factory;
	
	
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

	
	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		if (driver != null) {
			return;
		}
		try {
			if (context == null) {
				this.annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
				System.setProperty(annotation.driverExe(), annotation.drivePath());
				context = testContext.getApplicationContext();
				configurableApplicationContext = (ConfigurableApplicationContext) this.context;
				bf = configurableApplicationContext.getBeanFactory();
			}
			driver = BeanUtils.instantiateClass(annotation.driver());
			bf.registerResolvableDependency(WebDriver.class, driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		if (driver != null) {
			factory = new SearchWithFieldDecorator(new FileBasedElementLocatorFactory(driver));
			setDriver(driver);
			setFactory(factory);
			driver.get(annotation.baseUrl());
			setCurrentTest(testContext.getTestMethod().getName());
		} else {
			prepareTestInstance(testContext);
		}
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		if (driver != null) {
			killDriver();
			context = null;
		}
	}

	@Override
	public void afterTestMethod(final TestContext testContext) throws Exception {
		if (testContext.getTestException() == null) {
			killDriver();
			return;
		}
		killDriver();
	}

	public void killDriver() {
		driver.close();
		driver.quit();
		driver = null;
	}
	
}
```

### `src/main/java/br/com/cintra/execute/BeanProcessor.java`

```java
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
```

### `src/main/java/br/com/cintra/execute/SeleniumTestExecutionListener.java`

```java
package br.com.cintra.execute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import br.com.cintra.helper.aop.AspectAop;
import br.com.cintra.helper.element.element_locator_factory.FileBasedElementLocatorFactory;
import br.com.cintra.helper.element.search.SearchWithFieldDecorator;
import br.com.cintra.helper.screenshot.PdfGenerete;
import br.com.cintra.interfaces.annotation.type_test.selenium.SeleniumTest;

import static br.com.cintra.helper.test.TestHelper.setCurrentTest;
import static br.com.cintra.helper.test.TestHelper.setDriver;
import static br.com.cintra.helper.test.TestHelper.setFactory;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

import java.util.Map;

import org.junit.Rule;
import org.junit.rules.TestName;

public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

	private static RemoteWebDriver driver;
	private ApplicationContext context = null;
	private SeleniumTest annotation;
	private ConfigurableApplicationContext configurableApplicationContext;
	private ConfigurableListableBeanFactory bf;
	private SearchWithFieldDecorator factory;
	private PdfGenerete pdf;

	private Logger logger = LoggerFactory.getLogger(SeleniumTestExecutionListener.class);

	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		if (driver != null) {
			return;
		}
		try {
			if (context == null) {
				this.annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
				System.setProperty(annotation.driverExe(), annotation.drivePath());
				context = testContext.getApplicationContext();
				configurableApplicationContext = (ConfigurableApplicationContext) this.context;
				bf = configurableApplicationContext.getBeanFactory();
			}
			pdf = context.getBean(PdfGenerete.class);
			driver = BeanUtils.instantiateClass(annotation.driver());
			driver.manage().window().maximize();
			bf.registerResolvableDependency(WebDriver.class, driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		if (driver != null) {
			factory = new SearchWithFieldDecorator(new FileBasedElementLocatorFactory(driver));
			setDriver(driver);
			setFactory(factory);
			driver.get(annotation.baseUrl());
			setCurrentTest(testContext.getTestMethod().getName());
		} else {
			prepareTestInstance(testContext);
		}
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		if (driver != null) {
			killDriver();
			context = null;
		}
	}

	@Override
	public void afterTestMethod(final TestContext testContext) throws Exception {
		try {
			if (testContext.getTestException() == null) {
				logger.info("Faild", testContext.getTestException());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			killDriver();
			pdf.createPdf(testContext.getTestMethod().getName());
		}

	}

	public void killDriver() {
		try {
			driver.close();
			driver.quit();
			driver = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```

### `src/main/java/br/com/cintra/helper/aop/AspectAop.java`

```java
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
```

### `src/main/java/br/com/cintra/helper/element/bys/ByType.java`

```java
package br.com.cintra.helper.element.bys;

import static br.com.cintra.helper.element.files.ElementConstants.getMapBy;
import static br.com.cintra.helper.element.files.JsonFiles.getFileInstantiete;
import static br.com.cintra.helper.element.files.JsonFiles.getJsonArray;
import static br.com.cintra.helper.element.files.JsonFiles.getJsonIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.cintra.helper.aop.AspectAop;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;

public class ByType {

	Logger logger = LoggerFactory.getLogger(ByType.class);
	
	SearchWith search;
	SearchAll searchall;
	String pageName;

	public ByType(SearchWith search, String pageName) {
		this.search = search;
		this.pageName = pageName;
		logger.info("Search  ["+search+"]");
		logger.info("Page Name  ["+pageName+"]");
	}

	public ByType(SearchAll searchall, String pageName) {
		this.searchall = searchall;
		this.pageName = pageName;
		logger.info("Search  ["+searchall+"]");
		logger.info("Page Name  ["+pageName+"]");
	}

	public ByType(String pageName) {
		this.pageName = pageName;
		logger.info("Page Name  ["+pageName+"]");
	}

	public By by() {
		Preconditions.checkArgument(search != null, "Failed to locate the annotation @SearchWith");
		String elementName = search.name();
		String locatorsFile;
		logger.info("Element Name  ["+elementName+"]");
		if (search.locatorsFile().isEmpty()) {
			locatorsFile = pageName;
		} else {
			locatorsFile = search.locatorsFile();
		}
		
		logger.info("Locators File  ["+locatorsFile+"]");
		
		Preconditions.checkArgument(isNotNullAndEmpty(elementName), "Element name is not found.");
		Preconditions.checkArgument(isNotNullAndEmpty(locatorsFile), "Locators File name not provided");
		Preconditions.checkArgument(getFileInstantiete().get(locatorsFile).exists(),
				"Unable to locate " + locatorsFile);

		try {

			Iterator<JsonElement> iterator = getJsonIterator(locatorsFile);
			JsonObject foundObject = null;
			
			logger.info("Searching for object in json");
			
			while (iterator.hasNext()) {
				JsonObject object = iterator.next().getAsJsonObject();
				if (elementName.equalsIgnoreCase(object.get("name").getAsString())) {
					foundObject = object;
					logger.info("Found object ["+foundObject.get("name").getAsString()+"]");
					break;
				}
			}

			Preconditions.checkState(foundObject != null, "No entry found for the page [" + locatorsFile + "] in the "
					+ "locators file [" + locatorsFile + "]");
			String locateUsing = foundObject.get("locateUsing").getAsString();

			String type = getMapBy(locateUsing);

			if (type == null) {
				throw new UnsupportedOperationException("Currently " + locateUsing + " is NOT supported ");
			}

			String locator = foundObject.get("locator").getAsString();

			Preconditions.checkArgument(isNotNullAndEmpty(locator), "Locator cannot be null (or) empty.");
			
			logger.info("Object ["+foundObject.get("name").getAsString()+"] locator type ["+locator+"]");
			
			return type(type, locator);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public By[] allBys() {
		int i = 0;
		JsonObject object;
		List<String> ignores = Arrays.asList(searchall.ignore());
		int size = getJsonArray(pageName).size();
		
		if(!ignores.isEmpty() && (!ignores.contains(""))) {
			size-=ignores.size();
		}
		
		By[] bys = new By[size];
		
		try {

			Iterator<JsonElement> iterator = getJsonIterator(pageName);

			while (iterator.hasNext()) {

				object = iterator.next().getAsJsonObject();
				String name = object.get("name").getAsString();
				
				if (!ignores.contains(name)) {
					String type = getMapBy(object.get("locateUsing").getAsString());

					if (type == null) {
						throw new UnsupportedOperationException("Currently is NOT supported " + type);
					}

					String locator = object.get("locator").getAsString();
					bys[i] = type(type, locator);
					i++;
				}
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return bys;
	}

	private boolean isNotNullAndEmpty(String arg) {
		return ((arg != null) && (!arg.trim().isEmpty()));
	}

	public By type(String type, String locator) {
		if (type.equalsIgnoreCase("name")) {
			logger.info("Returning [By.ByName]");
			return new By.ByName(locator);

		} else if (type.equalsIgnoreCase("id")) {
			logger.info("Returning [By.ById]");
			return new By.ById(locator);

		} else if (type.equalsIgnoreCase("className")) {
			logger.info("Returning [By.ByClassName]");
			return new By.ByClassName(locator);

		}

		else if (type.equalsIgnoreCase("css")) {
			logger.info("Returning [By.ByCssSelector]");
			return new By.ByCssSelector(locator);
		}

		else {
			logger.info("Returning [By.ByXPath]");
			return new By.ByXPath(locator);
		}
	}
}
```

### `src/main/java/br/com/cintra/helper/element/custom_annotation/CustomAnnotations.java`

```java
package br.com.cintra.helper.element.custom_annotation;

import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.ByAll;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.cintra.helper.element.bys.ByType;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;

import static br.com.cintra.helper.element.files.ElementConstants.getMapBy;
import static br.com.cintra.helper.element.files.JsonFiles.getFileInstantiete;
import static br.com.cintra.helper.element.files.JsonFiles.getFileJsonParse;
import static br.com.cintra.helper.element.files.JsonFiles.getJsonArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomAnnotations extends AbstractAnnotations {

	private final Field field;
	private final String pageName;
	
	public CustomAnnotations(Field field,String pageName) {
		this.field = field;
		this.pageName = pageName;
	}

	@Override
	public By buildBy() {

		SearchWith search = field.getAnnotation(SearchWith.class);
		SearchAll searchAll = field.getAnnotation(SearchAll.class);

		if (search != null) {
			ByType type = new ByType(search, pageName);
			return type.by();

		} else if (searchAll != null) {
			ByType type = new ByType(searchAll, pageName);
			return new ByAll(type.allBys());
		} else {
			return null;
		}
	}

	@Override
	public boolean isLookupCached() {
		return (field.getAnnotation(CacheLookup.class) != null);
	}

}
```

### `src/main/java/br/com/cintra/helper/element/element_locator_factory/FileBasedElementLocator.java`

```java
package br.com.cintra.helper.element.element_locator_factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class FileBasedElementLocator implements ElementLocator {

	private final SearchContext searchContext;
	private final boolean shouldCache;
	private final By by;
	private WebElement cachedElement;
	private List<WebElement> cachedElementList;

	public FileBasedElementLocator(SearchContext searchContext, AbstractAnnotations annotations) {
		this.searchContext = searchContext;
		this.shouldCache = annotations.isLookupCached();
		this.by = annotations.buildBy();
	}

	public WebElement findElement() {
		if (cachedElement != null && shouldCache) {
			return cachedElement;
		}

		WebElement element = searchContext.findElement(by);
		if (shouldCache) {
			cachedElement = element;
		}

		return element;
	}

	public List<WebElement> findElements() {
		if (cachedElementList != null && shouldCache) {
			return cachedElementList;
		}

		List<WebElement> elements = searchContext.findElements(by);
		if (shouldCache) {
			cachedElementList = elements;
		}
		return elements;

	}

}
```

### `src/main/java/br/com/cintra/helper/element/element_locator_factory/FileBasedElementLocatorFactory.java`

```java
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
```

### `src/main/java/br/com/cintra/helper/element/files/ElementConstants.java`

```java
package br.com.cintra.helper.element.files;

import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class ElementConstants {

	public static HashMap<String, String> by = new HashMap<String, String>();
	
	public ElementConstants() {
		by.put("name", "name");
		by.put("id", "id");
		by.put("className", "className");
		by.put("css", "css");
		by.put("xpath", "xpath");
	}
	
	public static String getMapBy(String By) {
		return by.get(By);
	}
}
```

### `src/main/java/br/com/cintra/helper/element/files/JsonFiles.java`

```java
package br.com.cintra.helper.element.files;

import static br.com.cintra.helper.element.files.JsonFiles.getFileInstantiete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


@Component
@PropertySource(value = "classpath:application.properties")
public class JsonFiles {

	private Map<String, String> files;
	private static Map<String, File> fileInstantiete = new HashMap<String, File>();
	private static Map<String, JsonElement> fileJsonParse = new HashMap<String, JsonElement>();

	
	public JsonFiles(@Value("#{${file.init.jsonfile-map}}")Map<String, String> files) {
		this.files = files;
		
		for(Map.Entry<String, String> entry : files.entrySet()) {
			fileInstantiete.put(entry.getKey(),new File(entry.getValue()));
			try {
				fileJsonParse.put(entry.getKey(), new JsonParser().parse(new FileReader(fileInstantiete.get(entry.getKey()))));
			} catch (JsonIOException e) {
				e.printStackTrace();
			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Map<String, File> getFileInstantiete() {
		return fileInstantiete;
	}
	
	public static Map<String, JsonElement> getFileJsonParse() {
		return fileJsonParse;
	}

	public static void setFileJsonParse(Map<String, JsonElement> fileJsonParse) {
		JsonFiles.fileJsonParse = fileJsonParse;
	}

	public static JsonArray getJsonArray(String key) {
		return fileJsonParse.get(key).getAsJsonArray();
	}
	
	public static Iterator<JsonElement> getJsonIterator(String key) {
		return fileJsonParse.get(key).getAsJsonArray().iterator();
	}

}
```

### `src/main/java/br/com/cintra/helper/element/scroll/ScrollToElement.java`

```java
package br.com.cintra.helper.element.scroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("prototype")
public class ScrollToElement {

	JavascriptExecutor js = null;

	public void setsetJavascriptExecutor(RemoteWebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
```

### `src/main/java/br/com/cintra/helper/element/search/SearchWithFieldDecorator.java`

```java
package br.com.cintra.helper.element.search;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;

public class SearchWithFieldDecorator extends DefaultFieldDecorator {

	public SearchWithFieldDecorator(ElementLocatorFactory factory) {
		super(factory);
		this.factory = factory;
	}

	protected boolean isDecoratableList(Field field) {
		if (!List.class.isAssignableFrom(field.getType())) {
			return false;
		}

		Type genericType = field.getGenericType();
		if (!(genericType instanceof ParameterizedType)) {
			return false;
		}

		Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

		if (!WebElement.class.equals(listType)) {
			return false;
		}

		return field.getAnnotation(FindBy.class) != null || field.getAnnotation(FindBys.class) != null
				|| field.getAnnotation(FindAll.class) != null || field.getAnnotation(SearchWith.class) != null
				|| field.getAnnotation(SearchAll.class) != null;
	}

	public String getPageName() {
		return this.getClass().getName();
	}
}
```

### `src/main/java/br/com/cintra/helper/page/PageBuilder.java`

```java
package br.com.cintra.helper.page;

import static br.com.cintra.helper.element.files.JsonFiles.getJsonIterator;
import static br.com.cintra.helper.test.TestHelper.getDriver;
import static br.com.cintra.helper.test.TestHelper.getFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.cintra.helper.element.scroll.ScrollToElement;
import br.com.cintra.helper.screenshot.TakeScreenshot;
import br.com.cintra.interfaces.annotation.aop.log.clazz.PageAop;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.page.Page;

public abstract class PageBuilder {

	private String text;
	private HashMap<String, WebElement> mapOfElements = new HashMap<String, WebElement>();
	private List<WebElement> listElements;
	private String pageName;
	private Field field;
	private WebDriverWait wait;

	@Autowired
	private TakeScreenshot screenshot;
	
	@Autowired
	ScrollToElement scrollToElement;

	@Override
	public String toString() {
		return text;
	}

	@PageAop
	public PageBuilder click(WebElement element) {
		element.click();
		return this;
	}

	@PageAop
	public PageBuilder click(String name) {
		try {
			mapOfElements.get(name).click();
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}

	@PageAop
	public PageBuilder sendKeys(WebElement element, String txt) {
		element.sendKeys(txt);
		return this;
	}

	@PageAop
	public PageBuilder sendKeys(String name, String txt) {
		try {
			mapOfElements.get(name).sendKeys(txt);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}
	
	@PageAop
	public PageBuilder clear(WebElement element) {
		element.clear();
		return this;
	}
	
	@PageAop
	public PageBuilder clear(String name) {
		try {
			mapOfElements.get(name).clear();
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}

	@PageAop
	public PageBuilder getText(WebElement element) {
		text = element.getText();
		return this;
	}

	@PageAop
	public PageBuilder getText(String name) {
		try {
			text = mapOfElements.get(name).getText();
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}

	@PageAop
	public PageBuilder getAtribute(String name, String attribute) {
		try {
			text = mapOfElements.get(name).getAttribute(attribute);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		return this;
	}

	@PageAop
	public WebElement getElementInList(String nameOfList, String attribte, String value) {

		try {
			Field list = this.getClass().getDeclaredField(nameOfList);
			list.setAccessible(true);

			@SuppressWarnings("unchecked")
			List<WebElement> sameType = (List<WebElement>) field.get(this);

			for (WebElement element : sameType) {
				if (element.getAttribute(attribte).equals(value)) {
					return element;
				}
			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PageAop
	public WebElement getElementInList(String nameOfList, String text) {
		try {
			Field list = this.getClass().getDeclaredField(nameOfList);
			list.setAccessible(true);

			@SuppressWarnings("unchecked")
			List<WebElement> sameType = (List<WebElement>) field.get(this);

			for (WebElement element : sameType) {
				if (element.getText().equals(text)) {
					return element;
				}
			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PageAop
	public PageBuilder getAtribute(WebElement element, String attribute) {
		text = element.getAttribute(attribute);
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsVisible(WebElement element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(element));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsVisible(String element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(mapOfElements.get(element)));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsNotVisible(WebElement element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.invisibilityOf(element));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementIsNotVisible(String element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.invisibilityOf(mapOfElements.get(element)));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementToBeClickable(WebElement element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(element));
		return this;
	}

	@PageAop
	public PageBuilder waitUntilElementToBeClickable(String element, int time) {
		wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOf(mapOfElements.get(element)));
		return this;
	}

	@PageAop
	public PageBuilder buildPage() {
		PageFactory.initElements(getDriver(), this);
		scrollToElement.setsetJavascriptExecutor(getDriver());
		return this;
	}

	@PageAop
	public PageBuilder buildPageFactory() throws Exception {
		Page page = this.getClass().getAnnotation(Page.class);
		this.pageName = page.name();
		PageFactory.initElements(getFactory(), this);
		initElements();
		scrollToElement.setsetJavascriptExecutor(getDriver());
		return this;
	}

	@SuppressWarnings("unchecked")
	@PageAop
	private void initElements() throws Exception {

		Field[] fields = this.getClass().getDeclaredFields();
		SearchAll searchAll = null;
		List<String> ignores = null;

		for (Field field : fields) {
			
			if (searchAll == null) {
				searchAll = field.getAnnotation(SearchAll.class);
				this.field = field;
			
			}else {
				
				if(field.getAnnotation(SearchAll.class)!=null) {
					throw new Exception("Only one variable is supported with the annotation @SearchAll ["+this.getClassName()+"]");
				}
				
			}
			
		}

		if (searchAll != null) {
			try {
				field.setAccessible(true);
				listElements = (List<WebElement>) field.get(this);
				ignores = Arrays.asList(searchAll.ignore());
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			if ((pageName != null) && (!pageName.equals(""))) {
				mapOfElements.clear();
				if (ignores.contains("") || ignores == null) {
					putInMap();
				} else {
					putInMapIgnoreElements(ignores);
				}

			}
		}
	}

	@PageAop
	public PageBuilder takeScreenshot(String screenshotName) {
		screenshot.takeScreenshot(screenshotName);
		return this;
	}
	
	@PageAop
	public PageBuilder scrollToElement(WebElement element) {
		scrollToElement.scrollToElement(element);
		return this;
	}
	
	@PageAop
	public PageBuilder scrollToElement(String name) {
		try {
			scrollToElement.scrollToElement(mapOfElements.get(name));
			return this;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException(
					"element not find using this name [ " + name + " ] in json file [ " + pageName + " ]");
		}
		
	}

	// populate MAP of elements , if SearchAll not contains ignore
	public void putInMap() throws Exception {
		
		Iterator<JsonElement> iterator = getJsonIterator(pageName);
		int count = 0;
		
		while (iterator.hasNext()) {
			JsonObject object = iterator.next().getAsJsonObject();

			if (mapOfElements.get(object.get("name").getAsString()) == null) {
				mapOfElements.put(object.get("name").getAsString(), listElements.get(count));
				count++;
			} else {
				throw new Exception("Duplicate element in json file [ " + pageName + " ] with the name [ "
						+ object.get("name").getAsString() + " ]");
			}

		}
	}

	// populate MAP of elements , if SearchAll contains ignore
	public void putInMapIgnoreElements(List<String> ignores) throws Exception {
		
		Iterator<JsonElement> iterator = getJsonIterator(pageName);
		int count = 0;
		
		while (iterator.hasNext()) {
			JsonObject object = iterator.next().getAsJsonObject();

			if (mapOfElements.get(object.get("name").getAsString()) == null && (!ignores.contains(object.get("name").getAsString()))) {
				mapOfElements.put(object.get("name").getAsString(), listElements.get(count));
				count++;

			} else if (mapOfElements.get(object.get("name").getAsString()) != null) {
				throw new Exception("Duplicate element in json file [ " + pageName + " ] with the name [ "
						+ object.get("name").getAsString() + " ]");
			}

		}
	}

	public String getClassName() {
		return this.getClass().getName();
	}
}
```

### `src/main/java/br/com/cintra/helper/screenshot/PdfGenerete.java`

```java
package br.com.cintra.helper.screenshot;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Lazy
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PdfGenerete {

	private Document document = new Document();
	private Paragraph paragraph = new Paragraph();
	private static Font CAT_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font NORMAL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	private static Font HEADER_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
	private float xImg;
	
	@Value("#{${env.pdf.file}}")
	private String pa;
	
	private Path path;
	
	@Autowired
	TakeScreenshot takeScreenshot;

	private void createDocument(String testName) throws URISyntaxException {
		path = Paths.get(pa + testName);
		
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			document.setPageSize(PageSize.A4.rotate());

			try {
				PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
			} catch (DocumentException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
		document.open();
		document.addTitle(testName);
	}
	
	public Image getImageInBuffer(BufferedImage bufferedImage) throws BadElementException, IOException {
		Image image = Image.getInstance(bufferedImage, null);
		image.scaleAbsolute(800, 400);
		xImg = (PageSize.A4.rotate().getWidth() - image.getScaledWidth()) / 2;
		image.setAbsolutePosition(xImg, 50f);
		return image;
	}

	public Paragraph getTextsInBuffer(String description) throws IOException, DocumentException {
		paragraph.clear();
		paragraph.add(description);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;

	}
	
	private void constructPdf(String testName) throws IOException, DocumentException {
		//Paragraph pDate = new Paragraph(date+ "   "+ "ass: ");
		Paragraph pNumber = new Paragraph();
	//	pDate.setAlignment(Element.ALIGN_LEFT);
		pNumber.setAlignment(Element.ALIGN_RIGHT);
		int pages = 1;
		for (Entry<String, BufferedImage> textAndImage : takeScreenshot.getBufferImageMap(testName).entrySet()) {
			pNumber.clear();
			document.add(getTextsInBuffer(textAndImage.getKey()));
			document.add(getImageInBuffer(textAndImage.getValue()));
//			document.add(pDate);
			pNumber.add(String.valueOf(pages));
			document.add(pNumber);
			document.newPage();
			pages++;
		}
	}
	
	public void createPdf(String testName) throws DocumentException, IOException, ParseException, URISyntaxException {
		createDocument(testName);
		try {
			constructPdf(testName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			document.close();
			takeScreenshot.clearCurrentScenarioScreenshot(testName);
		}
	}
}
```

### `src/main/java/br/com/cintra/helper/screenshot/TakeScreenshot.java`

```java
package br.com.cintra.helper.screenshot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import static br.com.cintra.helper.test.TestHelper.getCurrentTest;
import static br.com.cintra.helper.test.TestHelper.getDriver;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TakeScreenshot {

	private LinkedHashMap<String, LinkedHashMap<String, BufferedImage>> scenarioScreenshot = new LinkedHashMap<String, LinkedHashMap<String, BufferedImage>>();
	private Screenshot screenshot;
	
	public void takeScreenshot(String name) {
		if (scenarioScreenshot.get(getCurrentTest()) == null) {
			scenarioScreenshot.put(getCurrentTest(), new LinkedHashMap<String, BufferedImage>());
		}
		screenshot = null;
		screenshot = new AShot().takeScreenshot(getDriver());
		scenarioScreenshot.get(getCurrentTest()).put(name, screenshot.getImage());
	}

	public HashMap<String, BufferedImage> getBufferImageMap(String key) {
		return scenarioScreenshot.get(key);
	}

	public void clearCurrentScenarioScreenshot(String key) {
		scenarioScreenshot.get(key).clear();
	}

	public void clearAllScenarioScreenshot(String key) {
		scenarioScreenshot.clear();
	}
}
```

### `src/main/java/br/com/cintra/helper/step/StepsBuilder.java`

```java
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
	private boolean init = false;

	@StepAop
	public StepsBuilder init() throws Exception {

		if (init == false) {
			methods = this.getClass().getDeclaredMethods();
			for (Method m : methods) {
				annotations = m.getAnnotations();
				for (Annotation a : annotations) {
					if (a.toString().contains("Step")) {
						stepAnnotation = (Step) a;
						if (mapMethod.get(stepAnnotation.name()) != null) {
							throw new Exception();
						}
						mapMethod.put(stepAnnotation.name(), m);
					}

				}

			}
			init = true;
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
```

### `src/main/java/br/com/cintra/helper/test/TestHelper.java`

```java
package br.com.cintra.helper.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.springframework.beans.factory.config.SetFactoryBean;

import br.com.cintra.helper.element.search.SearchWithFieldDecorator;

public abstract class TestHelper {

	private static HashMap<Class, Object> pages = new HashMap<Class,Object>();
	private static RemoteWebDriver driver;
	private static SearchWithFieldDecorator factory;
	private static String currentTest;
	
	public static void setPage(Class clazz, Object bean) {
		pages.put(clazz, bean);
	}

	public static Object getPage(Class name) {
		try {
			Object page = pages.get(name);
			return page;
		}catch(Exception e) {
			System.out.println("ainda nao instanciou");
		}
		return name;
	}
	
	public static void setDriver(RemoteWebDriver remoteDriver) {
		driver = remoteDriver;
	}
	
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	
	public static void setFactory(SearchWithFieldDecorator f) {
		factory = f;
	}
	
	public static SearchWithFieldDecorator getFactory() {
		return factory;
	}
	
	public static void setCurrentTest(String name) {
		currentTest = name;
	}
	
	public static String getCurrentTest() {
		return currentTest;
	}
}
```

### `src/main/java/br/com/cintra/interfaces/annotation/aop/log/clazz/PageAop.java`

```java
package br.com.cintra.interfaces.annotation.aop.log.clazz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PageAop {

}
```

### `src/main/java/br/com/cintra/interfaces/annotation/aop/log/clazz/StepAop.java`

```java
package br.com.cintra.interfaces.annotation.aop.log.clazz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StepAop {

}
```

### `src/main/java/br/com/cintra/interfaces/annotation/element/SearchAll.java`

```java
package br.com.cintra.interfaces.annotation.element;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchAll {
	String[] ignore() default "";
}
```

### `src/main/java/br/com/cintra/interfaces/annotation/element/SearchWith.java`

```java
package br.com.cintra.interfaces.annotation.element;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchWith {
    
	String locatorsFile() default "";
    String name();
    
}
```

### `src/main/java/br/com/cintra/interfaces/annotation/page/Page.java`

```java
package br.com.cintra.interfaces.annotation.page;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

import br.com.cintra.interfaces.annotation.aop.log.clazz.StepAop;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Page {
	String name() default "";
}
```

### `src/main/java/br/com/cintra/interfaces/annotation/step/Step.java`

```java
package br.com.cintra.interfaces.annotation.step;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Step {
	public String name();
}
```

### `src/main/java/br/com/cintra/interfaces/annotation/step/Steps.java`

```java
package br.com.cintra.interfaces.annotation.step;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Steps {
}
```

### `src/main/java/br/com/cintra/interfaces/annotation/type_test/api/ApiTest.java`

```java
package br.com.cintra.interfaces.annotation.type_test.api;

public @interface ApiTest {

}
```

### `src/main/java/br/com/cintra/interfaces/annotation/type_test/selenium/SeleniumTest.java`

```java
package br.com.cintra.interfaces.annotation.type_test.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;

import br.com.cintra.execute.SeleniumTestExecutionListener;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestExecutionListeners(
        listeners = SeleniumTestExecutionListener.class,
        mergeMode = MergeMode.MERGE_WITH_DEFAULTS)

public @interface SeleniumTest {
    Class<? extends RemoteWebDriver> driver() default ChromeDriver.class;
    String baseUrl() default "http://google.com.br";
    String driverExe() default "webdriver.chrome.driver";
    String drivePath();
}
```

### `src/main/resources/application.properties`

```properties
spring.thymeleaf.cache=false
security.basic.enabled=false
security.user.name=user
security.user.password=<REDACTED>
management.security.enabled=${security.basic.enabled}
file.init.jsonfile-map={homePage:"src\\test\\java\\jsonPage\\herokuapp\\HomePage.json", \
							listaDeFuncionalidade:"src\\test\\java\\jsonPage\\herokuapp\\ListaDeFuncionalidade.json", \
							formularioPage:"src\\test\\java\\jsonPage\\herokuapp\\FormularioPage.json"}
env.pdf.file = "C:\\Projects\\"
```

### `src/test/java/br/com/cintra/test/HeroKuapp.java`

```java
package br.com.cintra.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.cintra.Application;
import br.com.cintra.interfaces.annotation.type_test.selenium.SeleniumTest;
import br.com.cintra.test_steps.herokuapp.HerokuappStep;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@SeleniumTest(driver = ChromeDriver.class, 
				driverExe = "webdriver.chrome.driver", 
				drivePath = "C:\\Projects\\chromedriver.exe", 
				baseUrl = "https://automacaocombatista.herokuapp.com")

public class HeroKuapp {

	@Autowired
	HerokuappStep herokuappStep;
	
	@Test
	public void preencherFormulario() throws Exception {
		herokuappStep.init().executeStep("Acessar automação web")
			.executeStep("Acessar Formulario").executeStep("Preencher formulario");
	}
	
}
```

### `src/test/java/br/com/cintra/test_pages/herokuapp/FormularioPage.java`

```java
package br.com.cintra.test_pages.herokuapp;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import br.com.cintra.interfaces.annotation.page.Page;

@Page(name = "formularioPage")
@Scope("prototype")
public class FormularioPage extends PageBuilder{
		
	@SearchAll()
	List<WebElement> todos_os_elementos_ignorando_elementos;
	
}
```

### `src/test/java/br/com/cintra/test_pages/herokuapp/HomePage.java`

```java
package br.com.cintra.test_pages.herokuapp;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import br.com.cintra.interfaces.annotation.page.Page;

@Page(name = "homePage")
@Scope("prototype")
public class HomePage extends PageBuilder{
		
	@SearchAll()
	List<WebElement> todos_os_elementos_ignorando_elementos;
	
}
```

### `src/test/java/br/com/cintra/test_pages/herokuapp/ListaFuncinalidadePage.java`

```java
package br.com.cintra.test_pages.herokuapp;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import br.com.cintra.interfaces.annotation.page.Page;

@Page(name = "listaDeFuncionalidade")
@Scope("prototype")
public class ListaFuncinalidadePage extends PageBuilder{
		
	@SearchAll()
	List<WebElement> todos_os_elementos_ignorando_elementos;
	
}
```

### `src/test/java/br/com/cintra/test_steps/herokuapp/HerokuappStep.java`

```java
package br.com.cintra.test_steps.herokuapp;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cintra.helper.step.StepsBuilder;
import br.com.cintra.interfaces.annotation.step.Step;
import br.com.cintra.interfaces.annotation.step.Steps;
import br.com.cintra.test_pages.herokuapp.FormularioPage;
import br.com.cintra.test_pages.herokuapp.HomePage;
import br.com.cintra.test_pages.herokuapp.ListaFuncinalidadePage;

@Steps
public class HerokuappStep extends StepsBuilder {

	@Autowired
	HomePage homePage;

	@Autowired
	ListaFuncinalidadePage funcionalidadePage;

	@Autowired
	FormularioPage formularioPage;

	@Step(name = "Acessar automação web")
	private void acessarAutWeb() throws Exception {
		homePage.buildPageFactory().click("btnAutomacaoWeb");
	}

	@Step(name = "Acessar Formulario")
	private void acessarFormulario() throws Exception {
		funcionalidadePage.buildPageFactory().takeScreenshot("teste").click("btnFormulario").click("btnCriarUsario").takeScreenshot("teste2");
	}

	@Step(name = "Preencher formulario")
	private void preencherFormulario() throws Exception {
		formularioPage.buildPageFactory().sendKeys("txtNome", "Thiago").sendKeys("txtUltimoNome", "Cintra")
				.sendKeys("txtEmail", "thiagoscintra74@gmail.com").sendKeys("txtEndero", "VPG");
	}
}
```

### `src/test/java/jsonPage/herokuapp/FormularioPage.json`

```json
[
  {
    "name": "txtNome",
    "locateUsing": "id",
    "locator": "user_name"
  },
  {
    "name": "txtUltimoNome",
    "locateUsing": "id",
    "locator": "user_lastname"
  },
  {
    "name": "txtEmail",
    "locateUsing": "id",
    "locator": "user_email"
  },
   {
    "name": "txtEndero",
    "locateUsing": "id",
    "locator": "user_address"
  }
]
```

### `src/test/java/jsonPage/herokuapp/HomePage.json`

```json
[
  {
    "name": "btnAutomacaoWeb",
    "locateUsing": "xpath",
    "locator": "//a[text()='Começar Automação Web']"
  },
  {
    "name": "btnAutomacaoApi",
    "locateUsing": "xpath",
    "locator": "//a[text()='Começar Automação de Api']"
  }
]
```

### `src/test/java/jsonPage/herokuapp/ListaDeFuncionalidade.json`

```json
[
  {
    "name": "btnFormulario",
    "locateUsing": "xpath",
    "locator": "//a[text()='Formulário']"
  },
  {
    "name": "btnCriarUsario",
    "locateUsing": "xpath",
    "locator": "//a[text()='Criar Usuários']"
  },
  {
    "name": "btnBuscarUsuario",
    "locateUsing": "xpath",
    "locator": "//a[text()='Busca de elementos']"
  }
]
```

### `target/classes/application.properties`

```properties
spring.thymeleaf.cache=false
security.basic.enabled=false
security.user.name=user
security.user.password=<REDACTED>
management.security.enabled=${security.basic.enabled}
file.init.jsonfile-map={homePage:"src\\test\\java\\jsonPage\\herokuapp\\HomePage.json", \
							listaDeFuncionalidade:"src\\test\\java\\jsonPage\\herokuapp\\ListaDeFuncionalidade.json", \
							formularioPage:"src\\test\\java\\jsonPage\\herokuapp\\FormularioPage.json"}
env.pdf.file = "C:\\Projects\\"
```

### `target/classes/br/com/cintra/Application.class` (binário; Base64)

```base64
yv66vgAAADEAHwcAAgEAGWJyL2NvbS9jaW50cmEvQXBwbGljYXRpb24HAAQBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWAQAEQ29kZQoAAwAJDAAFAAYBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAbTGJyL2NvbS9jaW50cmEvQXBwbGljYXRpb247AQAEbWFpbgEAFihbTGphdmEvbGFuZy9TdHJpbmc7KVYHABEBABBqYXZhL2xhbmcvU3RyaW5nCgATABUHABQBACpvcmcvc3ByaW5nZnJhbWV3b3JrL2Jvb3QvU3ByaW5nQXBwbGljYXRpb24MABYAFwEAA3J1bgEAYihMamF2YS9sYW5nL0NsYXNzO1tMamF2YS9sYW5nL1N0cmluZzspTG9yZy9zcHJpbmdmcmFtZXdvcmsvY29udGV4dC9Db25maWd1cmFibGVBcHBsaWNhdGlvbkNvbnRleHQ7AQAEYXJncwEAE1tMamF2YS9sYW5nL1N0cmluZzsBAApTb3VyY2VGaWxlAQAQQXBwbGljYXRpb24uamF2YQEAGVJ1bnRpbWVWaXNpYmxlQW5ub3RhdGlvbnMBAD5Mb3JnL3NwcmluZ2ZyYW1ld29yay9ib290L2F1dG9jb25maWd1cmUvU3ByaW5nQm9vdEFwcGxpY2F0aW9uOwEAN0xvcmcvc3ByaW5nZnJhbWV3b3JrL3NjaGVkdWxpbmcvYW5ub3RhdGlvbi9FbmFibGVBc3luYzsAIQABAAMAAAAAAAIAAQAFAAYAAQAHAAAALwABAAEAAAAFKrcACLEAAAACAAoAAAAGAAEAAAAJAAsAAAAMAAEAAAAFAAwADQAAAAkADgAPAAEABwAAADkAAgABAAAACxIBA70AELgAElexAAAAAgAKAAAACgACAAAADAAKAA0ACwAAAAwAAQAAAAsAGAAZAAAAAgAaAAAAAgAbABwAAAAKAAIAHQAAAB4AAA==
```
