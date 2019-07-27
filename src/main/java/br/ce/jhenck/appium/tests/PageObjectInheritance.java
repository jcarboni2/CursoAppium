package br.ce.jhenck.appium.tests;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.FormularioPageInheritance;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class PageObjectInheritance extends BaseTest{
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private FormularioPageInheritance form = new FormularioPageInheritance();

	@Before
	public void inicializarAppium() throws MalformedURLException {

		menu.acessarFormulario();
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