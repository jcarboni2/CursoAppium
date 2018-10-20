package br.ce.jhenck.appium.tests;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.jhenck.appium.core.DriverFactory;
import br.ce.jhenck.appium.page.FormularioPageDSL;
import br.ce.jhenck.appium.page.MenuPageDSL;

public class PageObjects {
	
	private MenuPageDSL menu = new MenuPageDSL();
	private FormularioPageDSL form = new FormularioPageDSL();

	@Before
	public void inicializarAppium() throws MalformedURLException {

		menu.acessarFormulario();
	}

	@After
	public void tearDown() {

		// Fechar todos browsers
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		form.escreverNome("Johnny");
		assertEquals("Johnny", form.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		form.selecionarCombo("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", form.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(form.isCheckMarcado());
		Assert.assertTrue(form.isSwitchMarcado());

		form.clicarCheck();
		form.clicarSwitch();

		Assert.assertTrue(form.isCheckMarcado());
		Assert.assertFalse(form.isSwitchMarcado());
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		form.escreverNome("Manoel");
		form.selecionarCombo("PS4");
		form.clicarCheck();
		form.clicarSwitch();
		
		form.Salvar();
		
		Assert.assertEquals("Nome: Manoel", form.obterNomeCadastrado());
		Assert.assertEquals("Console: ps4", form.obterConsoleCadastrado());
		Assert.assertTrue(form.obterSwitchCadastrado().endsWith("Off"));
		Assert.assertTrue(form.obterCheckCadastrado().endsWith("Marcado"));
	}
}
