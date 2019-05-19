package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.MenuPageInheritance;
import br.ce.jhenck.appium.page.SwipeListPage;

public class SwipeElementTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private SwipeListPage swipeList = new SwipeListPage();
	
	
	@Test
	public void deveResolverDesafio() {
		
		//Clicar swipe list
		menu.clicarSwipeList();
		
		//Op��o1 para a direita
		swipeList.swipeElementRight("Op��o 1");
		
		//Op��o1 +
		swipeList.clicarBotaoMais();
		
		//Verificar Op��o1+
		Assert.assertTrue(swipeList.existeElementoPorTexto("Op��o 1 (+)"));
		
		//Op��o4 para a direita
		swipeList.swipeElementRight("Op��o 4");
		
		//Op��o4 -
		swipeList.clicarPorTexto("(-)");
		
		//Verificar Op��o4-
		Assert.assertTrue(swipeList.existeElementoPorTexto("Op��o 4 (-)"));
		
		//Op��o5 para a esquerda
		swipeList.swipeElementLeft("Op��o 5 (-)");
		
		//Verificar Op��o5
		Assert.assertTrue(swipeList.existeElementoPorTexto("Op��o 5"));
	}

}
