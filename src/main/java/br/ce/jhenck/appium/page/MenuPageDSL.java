package br.ce.jhenck.appium.page;

import br.ce.jhenck.appium.core.BasePage;
import br.ce.jhenck.appium.core.DSL;

public class MenuPageDSL extends BasePage {
	
	private DSL dsl = new DSL();

	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}

}
