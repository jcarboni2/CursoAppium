package br.ce.jhenck.appium.page;

import br.ce.jhenck.appium.core.BasePage;

public class MenuPageInheritance extends BasePage {

	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}

}
