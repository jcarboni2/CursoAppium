package br.ce.jhenck.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.jhenck.appium.core.BasePage;

public class SBContasPage extends BasePage {
	
	public void setConta(String name) {
		escrever(By.className("android.widget.EditText"), name);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void excluir() {
		clicarPorTexto("EXCLUIR");
	}
	
	public void selecionarConta(String conta) {
		cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
	}

}
