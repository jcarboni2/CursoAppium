package br.ce.jhenck.appium.core;

import static br.ce.jhenck.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class BasePage {

	public void escrever(By by, String texto) {
		
		// Escrever nome
		getDriver().findElement(by).sendKeys(texto);
	}
	
	
	public String obterTexto(By by) {
		
		// Checar nome escrito
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor) {
		
		// Clicar no combo
		getDriver().findElement(by).click();

		// Selecionar opção desejada
		clicarPorTexto(valor);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() > 0;		
	}
}
