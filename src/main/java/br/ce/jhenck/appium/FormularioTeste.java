package br.ce.jhenck.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "192.168.11.101:5555");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Johnny/learning/CursoAppium/src/main/resources/CTAppium-1-1.apk");
	    
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar formulário
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
/*		for(MobileElement elemento: elementosEncontrados)
			System.out.println(elemento.getText());*/
		
		elementosEncontrados.get(1).click();
		
		//Escrever nome
		MobileElement campoNome =  driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Johnny");
		
		//Checar nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Johnny", text);
	    
	    driver.quit();
	
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "192.168.11.101:5555");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Johnny/learning/CursoAppium/src/main/resources/CTAppium-1-1.apk");
	    
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//Clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//Selecionar opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//Verificar opção desejada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);
		
	    //Close all browsers
	    driver.quit();
	
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "192.168.11.101:5555");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Johnny/learning/CursoAppium/src/main/resources/CTAppium-1-1.apk");
	    
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
		//Verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		
		//Clicar nos elementos
		check.click();
		switc.click();
		
		//Verificar status alterados
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(switc.getAttribute("checked").equals("true"));
		
	    //Close all browsers
	    driver.quit();
	
	}

}
