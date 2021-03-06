package br.ce.jhenck.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraA5Teste {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("udid", "52107343b8c0351d");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Qualquer");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		MobileElement el1 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/bt_02");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Mais");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/bt_02");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Igual");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Campo de entrada da Calculadora");
		Assert.assertEquals("4", el5.getText());

		driver.quit();

	}

}
