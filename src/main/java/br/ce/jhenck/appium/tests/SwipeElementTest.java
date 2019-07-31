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
		
		//Opção1 para a direita
		swipeList.swipeElementRight("Opção 1");
		
		//Opção1 +
		swipeList.clicarBotaoMais();
		
		//Verificar Opção1+
		Assert.assertTrue(swipeList.existeElementoPorTexto("Opção 1 (+)"));
		
		//Opção4 para a direita
		swipeList.swipeElementRight("Opção 4");
		
		//Opção4 -
		swipeList.clicarPorTexto("(-)");
		
		//Verificar Opção4-
		Assert.assertTrue(swipeList.existeElementoPorTexto("Opção 4 (-)"));
		
		//Opção5 para a esquerda
		swipeList.swipeElementLeft("Opção 5 (-)");
		
		//Verificar Opção5
		Assert.assertTrue(swipeList.existeElementoPorTexto("Opção 5"));
	}

}
