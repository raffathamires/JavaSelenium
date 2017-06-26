package br.com.automation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	private WebDriver driver;
	WebElement DragAndDrop;
	String title;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sala01\\Documents\\JavaSelenium\\CursoSeleniumJava\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://treinoautomacao.hol.es");
		DragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private void assertHomeIndex(){
		assertEquals("Treino Automa��o de Testes", driver.getTitle());
	}
	
	private void assertDragAndDrop(){
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());
	}

	@Test
	public void testTitleOne() throws InterruptedException {
		assertHomeIndex();
		//clicka para abrir outra janela
		DragAndDrop.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//alteracao de foco da primeira para a segunda janela
		driver.switchTo().window(tabs.get(1));
		assertDragAndDrop();
		//volta o foco para a primeira janela
		driver.switchTo().window(tabs.get(0));
		//validar novamente o titulo da primeira pagina
		assertHomeIndex();
		
		
		Thread.sleep(3000);
	}

}
