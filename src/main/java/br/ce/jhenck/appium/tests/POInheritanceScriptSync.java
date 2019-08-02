package br.ce.jhenck.appium.tests;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.core.DriverFactory;
import br.ce.jhenck.appium.page.FormularioPageInheritance;
import br.ce.jhenck.appium.page.MenuPageInheritance;
import io.appium.java_client.MobileBy;

public class POInheritanceScriptSync extends BaseTest{
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private FormularioPageInheritance form = new FormularioPageInheritance();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		form.escreverNome("Joaquim");
		assertEquals("Joaquim", form.obterNome());
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
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		form.escreverNome("Manoel");
		
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		form.SalvarDemorado();
		//esperar(3000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Manoel']")));
		
		Assert.assertEquals("Nome: Manoel", form.obterNomeCadastrado());
	}
	
	@Test
	public void deveAlterarData() throws ParseException {
		form.clicarData();
		form.selecionarAno("2010");
		form.selecionarMes("May");
		form.clicarPorTexto("18");
		form.clicarOK();
		Assert.assertTrue(form.existeElementoPorTexto("18/5/2010"));
	}
	
	@Test
	public void deveAlterarHora() {
		form.clicarPorTexto("06:00");
		form.clicar(MobileBy.AccessibilityId("10"));
		form.clicar(MobileBy.AccessibilityId("25"));
		form.clicarPorTexto("OK");
		Assert.assertTrue(form.existeElementoPorTexto("10:25"));
	}
	
	@Test
	public void deveInteragirComSeekBar() {
		
		//clicar no seekbar
		form.clicarSeekBar(0.65);
		
		//Salvar
		form.Salvar();
		
		//Obter o Valor
		Assert.assertEquals("Slider: " + form.posicaoString, form.obterValorSeekBar());		
	}
}
