package br.com.testes;

import org.testng.annotations.Test;

import br.com.util.SpreadsheetData;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class TestNGDataDriven {
	private WebDriver driver;
	private String baseURL;
	
  @Test(dataProvider = "dbPaises")
  public void testDaraDrivenExcel(String nome) {
	  driver.get(baseURL);
	  driver.findElement(By.id("searchInput")).clear();
	  driver.findElement(By.id("searchInput")).sendKeys(nome);
	  driver.findElement(By.id("searchButton")).click();
	  String titlePage = driver.findElement(By.id("firstHeading")).getText();
	  assertTrue("Deveria ter apresentado o resultado de pesquisa!", nome.equals(titlePage.trim()));
  }

  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sala01\\Documents\\JavaSelenium\\CursoSeleniumJava\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseURL = "https://en.wikipedia.org/wiki/Main_Page";
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @DataProvider(name = "dbPaises")
  public Object[][] createData() {
	Object[][] testData = SpreadsheetData.readExcelData("Paises", "db/paises.xls", "Dados");
    return testData;
  }
}
