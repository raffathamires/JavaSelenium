package br.com.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import br.com.categorias.NegativoInterface;
import br.com.categorias.PositivoInterface;

public class LoginTeste {

	@Test
	@Category({PositivoInterface.class})
	public void testLoginValido() {
		System.out.println("testLoginValido");
	}

	@Test
	@Category({NegativoInterface.class})
	public void testLoginSenhaInvalida() {
		System.out.println("testLoginSenhaInvalida");
	}
	
	@Test
	@Category({NegativoInterface.class})
	public void testLoginUsuaropInvalido(){
		System.out.println("testLoginUsuarioInvalido");
	}

}
