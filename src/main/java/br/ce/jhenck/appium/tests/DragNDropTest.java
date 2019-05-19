package br.ce.jhenck.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.jhenck.appium.core.BaseTest;
import br.ce.jhenck.appium.page.DragDropPage;
import br.ce.jhenck.appium.page.MenuPageInheritance;

public class DragNDropTest extends BaseTest {
	
	private MenuPageInheritance menu = new MenuPageInheritance();
	private DragDropPage dragDrop = new DragDropPage();
	
	private String[] estadoInicial = new String[]{"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado.",};
	private String[] estadoIntermediario = new String[]{"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta", "qualquer local desejado.",};
	private String[] estadoFinal = new String[]{"Fa�a um clique longo,", "� uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado.",};
	
	@Test
	public void deveEfetuarDragNDrop() {
		
		//Acessar menu
		menu.clicarDragNDrop();
		
		//Verificar estado inicial
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, dragDrop.obterLista());
		
		//Arrastar "Esta" para "e arraste para"
		dragDrop.arrastar("Esta", "e arraste para");
		
		//Verificar estado intermediario
		Assert.assertArrayEquals(estadoIntermediario, dragDrop.obterLista());
		
		//Arrastar "Fa�a um clique longo," para "� uma lista"
		dragDrop.arrastar("Fa�a um clique longo,", "� uma lista");
		
		//Verificar estado final
		Assert.assertArrayEquals(estadoFinal, dragDrop.obterLista());
	}

}
