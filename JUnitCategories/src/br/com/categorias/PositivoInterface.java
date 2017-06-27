package br.com.categorias;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.suites.AllTests;

@RunWith(Categories.class)
@SuiteClasses({AllTests.class})
@IncludeCategory({PositivoInterface.class})

public interface PositivoInterface {

}