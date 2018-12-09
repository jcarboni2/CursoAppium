package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.MenuPageInheritance;
import br.ce.jhenck.appium.page.seuBarriga.SBContasPage;
import br.ce.jhenck.appium.page.seuBarriga.SBHomePage;
import br.ce.jhenck.appium.page.seuBarriga.SBLoginPage;
import br.ce.jhenck.appium.page.seuBarriga.SBMenuPage;
import br.ce.jhenck.appium.page.seuBarriga.SBMovimentacaoPage;

public class SBTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private SBLoginPage sbLoginPage = new SBLoginPage();
	private SBMenuPage sbMenu = new SBMenuPage();
	private SBHomePage sbHome = new SBHomePage();
	private SBContasPage sbContas = new SBContasPage();
	private SBMovimentacaoPage sbMov = new SBMovimentacaoPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		
		//Login
		sbLoginPage.setEmail("jch@jch.com");
		sbLoginPage.setSenha("1234");
		sbLoginPage.entrar();
		
		//Reset
		sbMenu.acessarHome();
		sbHome.reset();
		Assert.assertTrue(sbHome.existeElementoPorTexto("Dados resetados com sucesso!"));
	}
	
	@Test
	public void deveInserirContaComSucesso() {
		//Entrar em contas
		sbMenu.acessarContas();
		
		//Digitar nome conta
		sbContas.setConta("Contas de Teste");
		
		//Salvar
		sbContas.salvar();
		
		//Verificar mensagem
		Assert.assertTrue(sbContas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta() {
		
		//Entrar em contas
		sbMenu.acessarContas();
		
		//Clique longo na conta
		sbContas.selecionarConta("Conta para alterar");
		
		//Excluir
		sbContas.excluir();
		
		//Verificar mensagem
		Assert.assertTrue(sbContas.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov() {
		
		//Entrar em Movimentações
		sbMenu.acessarMovimentacoes();
		
		//Validar descrição
		sbMov.salvar();
		Assert.assertTrue(sbMov.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		//Validar interessado
		sbMov.setDescricao("Desc");
		sbMov.salvar();
		Assert.assertTrue(sbMov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		//Validar valor
		sbMov.setInteressado("Interessado");
		sbMov.salvar();
		Assert.assertTrue(sbMov.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		//Validar conta
		sbMov.setValor("12345");
		sbMov.salvar();
		Assert.assertTrue(sbMov.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		//Inserir com sucesso
		sbMov.setConta("Conta com movimentacao");
		sbMov.salvar();
		Assert.assertTrue(sbMov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}

}
