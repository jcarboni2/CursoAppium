package br.ce.jhenck.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;;

public class DesafioCadastro {
	
	@Test
	public void deveCadastrar() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("plataformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("MobileCapabilityType.APP", "/Users/Johnny/eclipse-workspace/CursoAppium/src/main/resources/CTAppium-1-1.apk");		

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//Preencher campo
		driver.findElement(By.xpath("//android.widget.EditText[@text='Nome']")).sendKeys("Manoel dos Santos");
		
		//Clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//Select opção
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		
		//Deslizar barra - CONTINUAR DAQUI!!!
		driver.findElement(MobileBy.AccessibilityId("slid"));
		
		
		
	}
}