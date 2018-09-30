package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.AbasPage;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class AbasTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private AbasPage abas = new AbasPage();

	@Test
	public void deveInteragircomAbas() {
		
		//Acessar menu Abas
		menu.acessarAbas();
		
		//Verificar que esta na aba 1
		Assert.assertTrue(abas.isAba1());
		
		//Acessar aba 2
		abas.selecionarAba2();
		
		//Verificar que esta na aba 2
		Assert.assertTrue(abas.isAba2());
	}
}