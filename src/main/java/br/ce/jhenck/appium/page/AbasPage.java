package br.ce.jhenck.appium.page;

import br.ce.jhenck.appium.core.BasePage;

public class AbasPage extends BasePage {

	public boolean isAba1() {
		return existeElementoPorTexto("Este � o conte�do da Aba 1");
	}
	
	public void selecionarAba2() {
		clicarPorTexto("ABA 2");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("Este � o conte�do da Aba 2");
	}
}
