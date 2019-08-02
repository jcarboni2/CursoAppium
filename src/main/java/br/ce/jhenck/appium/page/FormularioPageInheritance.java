package br.ce.jhenck.appium.page;

import static br.ce.jhenck.appium.core.DriverFactory.getDriver;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import br.ce.jhenck.appium.core.BasePage;
import br.ce.jhenck.appium.utils.DateUtils;
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
	
	public void clicarData() {
		clicarPorTexto("01/01/2000");
	}
	
	public void selecionarAno(String ano) {
		clicarPorTexto("2000");
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		int year = Integer.parseInt(ano);
		if (year >= 2000) {
			while (existeElementoPorTexto(ano)==false) {
				scroll(0.7, 0.3);
			}
		} else {
			while (existeElementoPorTexto(ano)==false) {
				scroll(0.3, 0.7);
			}
		}
		clicarPorTexto(ano);
	}
	
	public void selecionarMes(String mes) throws ParseException {
		int mesEsperado = DateUtils.getMonthNumber(mes);
		String mesDatePicker = obterTextoAtributo(By.xpath("//*[@class='android.view.View']//android.view.View[1]"), "content-desc").replaceAll("[0-9 ]+", "");
		int mesNumDataPicker = DateUtils.getMonthNumber(mesDatePicker);
		int qtdClicks;
		if (mesEsperado >= mesNumDataPicker) {
			qtdClicks = mesEsperado - mesNumDataPicker;
			for (int i=1; qtdClicks >= i; i++) {
				clicar(MobileBy.AccessibilityId("Next month"));
			}
		} else {
			qtdClicks = mesNumDataPicker - mesEsperado;
			for (int i=1; qtdClicks >= i; i++) {
				clicar(MobileBy.AccessibilityId("Previous month"));
			}
		}
	}
	
	public void clicarOK() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clicarPorTexto("OK");
	}
}
