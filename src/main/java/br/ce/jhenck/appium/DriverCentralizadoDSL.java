package br.ce.jhenck.appium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.jhenck.appium.core.DSL;
import br.ce.jhenck.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class DriverCentralizadoDSL {

	private DSL dsl = new DSL();

	@Before
	public void inicializarAppium() throws MalformedURLException {

		// Selecionar formulário
		dsl.clicarPorTexto("Formulário");
	}

	@After
	public void tearDown() {

		// Fechar todos browsers
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// Escrever nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Johnny");

		// Checar nome escrito
		assertEquals("Johnny", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		// Clicar no combo e selecionar opção desejada
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		// Verificar opção desejada
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", text);
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// Verificar status dos elementos
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		// Clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// Verificar status alterados
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		
		// Preencher campos
		dsl.escrever(By.className("android.widget.EditText"), "Manoel");
		dsl.selecionarCombo(By.className("android.widget.Spinner"), "PS4");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		
		// Salvar cadastro
		dsl.clicarPorTexto("SALVAR");
		
		//Verificações
		dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Manoel']"));
		Assert.assertEquals("Nome: Manoel", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Manoel']")));
		Assert.assertEquals("Console: ps4", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
	}
}
