package br.ce.jhenck.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;;

public class DesafioCadastro {

	@Test
	public void deveCadastrar() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Qualquer");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		desiredCapabilities.setCapability("MobileCapabilityType.APP", "src/main/resources/CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Selecionar formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
		// Preencher campos
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Manoel");
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		
		// Salvar cadastro
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
		
		//Verificações
		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Manoel']"));
		Assert.assertEquals("Nome: Manoel", nome.getText());
		
		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		Assert.assertEquals("Console: ps4", combo.getText());
		
		MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		Assert.assertTrue(swit.getText().endsWith("Off"));
		
		MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		Assert.assertTrue(check.getText().endsWith("Marcado"));
		
		// Close all browsers
		driver.quit();

	}
}