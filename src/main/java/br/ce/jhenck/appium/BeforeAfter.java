package br.ce.jhenck.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BeforeAfter {

	private AndroidDriver<MobileElement> driver;

	@Before
	public void inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Qualquer");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:/Cursos e Treinamentos/Curso Android com Appium/CursoAppium/src/main/resources/CTAppium-1-1.apk");

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar formul�rio
		driver.findElement(By.xpath("//*[@text='Formul�rio']")).click();
	}

	@After
	public void tearDown() {

		// Fechar todos browsers
		driver.quit();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// Escrever nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Johnny");

		// Checar nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Johnny", text);
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		// Clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// Selecionar op��o desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// Verificar op��o desejada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));

		// Clicar nos elementos
		check.click();
		switc.click();

		// Verificar status alterados
		Assert.assertTrue(check.getAttribute("checked").equals("true"));
		Assert.assertTrue(switc.getAttribute("checked").equals("false"));
	}
}
