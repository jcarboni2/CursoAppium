package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.CliquesPage;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class CliquesTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private CliquesPage cliques = new CliquesPage();
	
	@Before
	//Acessar Menu
	public void setup() {
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		
		//Clique longo
		cliques.cliqueLongo();
		
		//Verificar texto
		Assert.assertEquals("Clique Longo", cliques.obterTextoCampo());
		
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		
		//Clique longo
		cliques.clicarPorTexto("Clique duplo");
		cliques.clicarPorTexto("Clique duplo");
		
		//Verificar texto
		Assert.assertEquals("Duplo Clique", cliques.obterTextoCampo());
		
	}

}
