package br.com.automation;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

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
	
	@Test
	public void testAcessarCheckBox() throws InterruptedException{
		List<WebElement> elementsCheck = driver.findElements(By.name("chkbox"));
		for(WebElement e : elementsCheck){
			System.out.println(e.getAttribute("value").toString());
			
			if(!e.getAttribute("value").equals("Check Box 3 selecionado")){
				e.click();
				assertTrue(e.isSelected());
				Thread.sleep(3000);
				break;
			}
		}
	}
	
	@Test
	public void testDropDownList() throws InterruptedException{
		WebElement dropdownlist = driver.findElement(By.name("dropdownlist"));
		Select listboxelements = new Select(dropdownlist);
		listboxelements.selectByIndex(6);
		listboxelements.selectByVisibleText("Item 8");
		listboxelements.selectByVisibleText("Item 7");
			System.out.println("Lista Simples: " + 
					listboxelements.getFirstSelectedOption().getText());
		assertEquals("Item 7", listboxelements.getFirstSelectedOption().getText());
		Thread.sleep(3000);
	}
	
	@Test
	public void testDropDownMultipleList() throws InterruptedException{
		WebElement multiselectdropdown = driver.findElement(By.name("multiselectdropdown"));
		Select listboxelements = new Select(multiselectdropdown);
		
		if(listboxelements.isMultiple()) {
		listboxelements.selectByVisibleText("Item 5");
		listboxelements.selectByVisibleText("Item 8");
		listboxelements.selectByVisibleText("Item 9");
		}
		
		List<WebElement> elementsCheck = listboxelements.getAllSelectedOptions();
		
		for(WebElement e : elementsCheck){
			System.out.println("Lista selecionada: " + e.getText());
			boolean isSelected = ((e.getText().equals("Item 5"))
					|| (e.getText().equals("Item 8"))
					|| (e.getText().equals("Item 9")));
			assertTrue(isSelected);
		}
		listboxelements.deselectAll();
		
		Thread.sleep(3000);
		
	}
	@Test
	public void testiFrame() throws InterruptedException{
		driver.switchTo().frame("iframe_b");
		WebElement txtSearch = driver.findElement(By.id("term"));
		txtSearch.sendKeys("Testes");
		assertEquals("Testes", driver.findElement(By.id("term")).getAttribute("value"));
		Thread.sleep(3000);
		System.out.println("Frame 1 passed");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe_d");
		WebElement txtSearch2 = driver.findElement(By.id("q"));
		txtSearch2.sendKeys("Testes");
		assertEquals("Testes", driver.findElement(By.id("q")).getAttribute("value"));
		Thread.sleep(3000);
		System.out.println("Frame 2 passed");
	}
	
	@Test
	public void testAlert() throws InterruptedException {
		//Alert
		WebElement buttonAlert = driver.findElement(By.name("alertbtn"));
		buttonAlert.click();
		//Cria alerta
		Alert myAlert = driver.switchTo().alert();
		//printa a mensagem do alert no console
		System.out.println(myAlert.getText());
		//faz a validacao do texto esperado com a mensagem exibida no alert
		assertEquals("Eu sou um alerta!", myAlert.getText());
		Thread.sleep(3000);
		myAlert.accept();
				
	}

}

