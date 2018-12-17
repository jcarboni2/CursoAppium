package br.ce.jhenck.appium.page.seuBarriga;

import static br.ce.jhenck.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.jhenck.appium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {
	
	public void clicarAtualizar() {
		clicarPorTexto("ATUALIZAR");
	}
	
	public void excluirMovimentacao(String desc) {
		
		MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}

}
