package br.com.automation;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeradorCPFTest {
	private WebDriver driver;
	WebElement textField;
	WebElement geraButton;
	WebElement pontoCheckBox;

	@Before
	public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sala01\\Documents\\JavaSelenium\\CursoSeleniumJava\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.geradordecpf.org/");
			geraButton = driver.findElement(By.id("btn-gerar-cpf"));
			textField = driver.findElement(By.name("numero"));
			pontoCheckBox = driver.findElement(By.id("cbPontos"));
		}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testGeradorCPFSemPonto() throws InterruptedException {
		geraButton.click();
		String cpfReturn = textField.getAttribute("value");
		System.out.println("CPF gerado: " + cpfReturn);
		boolean result = validateCPF(cpfReturn);
		assertEquals(result, true);
		Thread.sleep(3000);
	}
	@Test
	public void testGeradorCPFComPonto() throws InterruptedException {
		pontoCheckBox.click();
		geraButton.click();
		String cpfReturn = textField.getAttribute("value");
		System.out.println("CPF gerado: " + cpfReturn);
		boolean result = validateCPF(cpfReturn);
		assertEquals(result, true);
		Thread.sleep(3000);
	}
	private boolean validateCPF(String cpfToValidate){
		return cpfToValidate.matches("^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}$");
	}

}
