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

	LinkedHashMap<String, HashMap<String, BufferedImage>> scenarioScreenshot = new LinkedHashMap<String, HashMap<String, BufferedImage>>();
	
	public void takeScreenshot(String name) {
		if(scenarioScreenshot.get(getCurrentTest())==null) {
			scenarioScreenshot.put(getCurrentTest(), new HashMap<String, BufferedImage>());
		}
		 Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getDriver());
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
