package br.ce.jhenck.appium.tests;

import static br.ce.jhenck.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class OpcaoEscondidaTest extends BaseTest {

	private MenuPageInheritance menu =  new MenuPageInheritance();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formul�rio']")));
		System.out.println("Come�ando");
		
		//Scroll down
		menu.scrollDown();
		
		//Clicar menu
		menu.clicarPorTexto("Op��o bem escondida");
		
		//Verificar mansagem
		Assert.assertEquals("Voc� achou essa op��o", menu.obterMensagemAlerta());
		
		//Sair
		menu.clicarPorTexto("OK");
		
	}
}
