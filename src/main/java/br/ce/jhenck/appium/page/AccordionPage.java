package br.ce.jhenck.appium.page;

import org.openqa.selenium.By;

import br.ce.jhenck.appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void selecionarOp1() {
		clicarPorTexto("Opção 1");
	}
	
	public String obterValorOp1() {
		return obterTexto(By.xpath("//*[@text='Opção 1']/../../following::android.widget.TextView[1]"));
	}

}
