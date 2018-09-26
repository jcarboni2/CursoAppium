package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.MenuPageInheritance;
import br.ce.jhenck.appium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		
		//Acessar Menu Splash
		menu.acessarSplash();
		
		//Verificar que o Splash esta sendo exibido
		splash.isTelaSplashVisivel();
		
		//Aguardar saida do Splash
		splash.aguardarSplashSumir();
		
		//Verificar que o Formulário esta aparecendo
		Assert.assertTrue(splash.existeElementoPorTexto("Formulário"));
	}

}
