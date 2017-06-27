package br.com.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.tests.LoginTeste;
import br.com.tests.ProdutoTeste;

@RunWith(Suite.class)
@SuiteClasses({LoginTeste.class, ProdutoTeste.class})

public class AllTests {

}
