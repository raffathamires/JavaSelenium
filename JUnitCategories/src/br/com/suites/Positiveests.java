package br.com.suites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.categorias.PositivoInterface;

@RunWith(Categories.class)
@SuiteClasses({ AllTests.class })
@IncludeCategory({ PositivoInterface.class })

public class Positiveests {

}
