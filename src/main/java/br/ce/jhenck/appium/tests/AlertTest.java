package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.AlertaPage;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class AlertTest extends BaseTest {

	private MenuPageInheritance menu = new MenuPageInheritance();
	private AlertaPage alerta = new AlertaPage();
	
	@Before
	public void setup() {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {

		// Clicar em alerta confirm
		alerta.clicarAlertaConfirm();

		// Verificar os textos
		Assert.assertEquals("Info", alerta.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alerta.obterMensagemAlerta());
		
		
		// Confirmar alerta
		alerta.confirmar();

		// Verificar nova mensagem
		Assert.assertEquals("Confirmado", alerta.obterMensagemAlerta());

		// Sair
		alerta.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		
		//Clicar alerta simples
		alerta.clicarAlertaSimples();
		
		//Clicar fora da caixa
		esperar(1000);
		alerta.clicarForaCaixa();
		
		//Verificar que mensagem não está presente
		Assert.assertFalse(alerta.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
