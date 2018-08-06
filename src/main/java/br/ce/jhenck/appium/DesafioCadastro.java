package br.ce.jhenck.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import io.appium.java_client.android.AndroidDriver;

public class DesafioCadastro {
	
	@Test
	public void deveCadastrar() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("plataformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("MobileCapabilityType.APP", "/Users/Johnny/eclipse-workspace/CursoAppium/src/main/resources/CTAppium-1-1.apk");		

		AndroidDriver<WebElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar Formulário
		
	}
	

}