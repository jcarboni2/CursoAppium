package br.ce.jhenck.appium.page;

import static br.ce.jhenck.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.jhenck.appium.core.BasePage;

public class MenuPageInheritance extends BasePage {

	public void acessarFormulario() {
		clicarPorTexto("Formul�rio");
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}

	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() {
		clicarPorTexto("Abas");
	}
	
	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}
	
	public void clicarSwipeList() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formul�rio']")));
		scrollDown();
		clicarPorTexto("Swipe List");
	}
	
	public void clicarDragNDrop() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formul�rio']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
}
