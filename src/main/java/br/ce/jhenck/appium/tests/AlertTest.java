package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.AlertaPage;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class AlertTest extends BaseTest {

	private MenuPageInheritance menu = new MenuPageInheritance();
	private AlertaPage alerta = new AlertaPage();

	@Test
	public void deveConfirmarAlerta() {

		// Acessar menu alerta
		menu.acessarAlertas();

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
}
