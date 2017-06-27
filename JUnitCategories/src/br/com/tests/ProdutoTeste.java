package br.com.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import br.com.categorias.NegativoInterface;
import br.com.categorias.PositivoInterface;

public class ProdutoTeste {

	@Test
	@Category({PositivoInterface.class})
	public void testVendaComSucesso() {
		System.out.println("testVendaComSucesso");
	}
	
	@Test
	@Category({NegativoInterface.class})
	public void testVendaSemSucesso(){
		System.out.println("testVendaSemSucesso");
	}
}
