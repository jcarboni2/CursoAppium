package br.ce.jhenck.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;;

public class DesafioCadastro {

	@Test
	public void deveCadastrar() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Qualquer");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:/Cursos e Treinamentos/Curso Android com Appium/CursoAppium/src/main/resources/CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Selecionar formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		// Preencher campo
		driver.findElement(By.xpath("//android.widget.EditText[@text='Nome']")).sendKeys("Manoel dos Santos");

		// Clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// Select opção
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

		// Verificar status, clicar e validar status alterado
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(By.className("android.widget.Switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		check.click();
		switc.click();
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(switc.getAttribute("checked").equals("true"));

		// Salvar cadastro
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
		
		// Close all browsers
		driver.quit();

	}
}