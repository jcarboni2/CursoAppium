package br.ce.jhenck.appium.page;

import static br.ce.jhenck.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.jhenck.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPageInheritance extends BasePage{

	private static int posicaoInt = 0;
	public String posicaoString = null;

	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSeekBar(double posicao) {
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		
		int delta = 43;
		
		int xinicial = seek.getLocation().x + delta;		
		int x = (int) (xinicial + ((seek.getSize().width - 2*delta) * posicao));
		System.out.println("Posição x: " + x);
	
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println("Posição y: " + y);
		
		tap(x, y);
		
		posicaoInt = (int) (posicao * 100);
		posicaoString = Integer.toString(posicaoInt);
	}
	
	public void Salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void SalvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterValorSeekBar() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
	}
	
	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}
}
