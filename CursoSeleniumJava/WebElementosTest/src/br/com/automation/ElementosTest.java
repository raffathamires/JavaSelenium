package br.com.automation;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementosTest {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sala01\\Documents\\JavaSelenium\\CursoSeleniumJava\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://treinoautomacao.hol.es/elementsweb.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testEscreverNome() throws InterruptedException {
		WebElement txtNome = driver.findElement(By.name("txtbox1"));
		txtNome.sendKeys("Raffaela");
		assertEquals("Raffaela", driver.findElement(By.name("txtbox1")).getAttribute("value"));
		
		Thread.sleep(3000); //wait 3 seconds
	}
	
	@Test
	public void testRadioButton() throws InterruptedException{
		List<WebElement> elementsRadio = driver.findElements(By.name("radioGroup1"));
		
		for(WebElement e : elementsRadio){
			System.out.println(e.getAttribute("value").toString());
			if(e.getAttribute("value").equals("Radio Button 3 selecionado")){
				e.click();
				System.out.println("Opcao 3 foi selecionada");
				assertEquals("Opcao 3 deveria estar selecionada", "true", e.getAttribute("checked"));
				Thread.sleep(3000);
				break;
			}
		}
	}

}
