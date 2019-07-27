package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.AccordionPage;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class AccordionTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private AccordionPage accordion = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		
		//acessar menu
		menu.acessarAccordion();
		
		//clicar op 1
		accordion.selecionarOp1();
		
		//verificar texto op 1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", accordion.obterValorOp1());
	}

}
