package br.ce.jhenck.appium.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.MenuPageInheritance;
import br.ce.jhenck.appium.page.WebViewPage;

public class WebViewTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private WebViewPage webViewPage = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		
		//Acessar menu
		menu.acessarSBHibrido();
		esperar(3000);
		webViewPage.entrarComTextoWeb();
		
		//Preencher email cadastrado no site http://seubarriga.wcaquino.me
		webViewPage.setEmail("user@user.com");
		
		//Preencher senha cadastrada no site http://seubarriga.wcaquino.me
		webViewPage.setSenha("1234");
		
		//Entrar
		webViewPage.entrar();
		
		//Alterar NomeUsuário por nome cadastrado no site http://seubarriga.wcaquino.me
		Assert.assertEquals("Bem vindo, User!", webViewPage.getMensagem());
	}
	
	@After
	public void tearDown() {
		webViewPage.sairComTextoWeb();
	}

}
