package br.ce.jhenck.appium.page.seuBarriga;

import br.ce.jhenck.appium.core.BasePage;

public class SBMenuPage extends BasePage {
	
	public void acessarHome() {
		clicarPorTexto("HOME");
	}
	
	public void acessarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacoes() {
		clicarPorTexto("MOV...");
	}
	
	public void acessarResumo() {
		clicarPorTexto("RESUMO");
	}

}
