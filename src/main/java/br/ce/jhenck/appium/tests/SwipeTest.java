package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class SwipeTest extends BaseTest {
	
	private MenuPageInheritance menu  = new MenuPageInheritance();
	
	@Test
	public void deveRealizarSwipe() {
		
		//Acessar menu
		menu.acessarSwipe();
		
		//Verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//Swipe para a direita
		menu.swipeRight();
		
		//Verificar texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//Clicar botão direito
		menu.clicarPorTexto("›");
		
		//Verificar texto 'Chegar at� o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		
		//Swipe para a esquerda
		menu.swipeLeft();
		
		//Clicar botão esquerdo
		menu.clicarPorTexto("‹");
		
		//Verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
	}

}
