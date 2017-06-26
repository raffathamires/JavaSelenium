package br.com.automation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class DragAndDrop {
	private WebDriver driver;
	WebElement Origem;
	WebElement Destino; 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sala01\\Documents\\JavaSelenium\\CursoSeleniumJava\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	private void assertDrag(){
		assertEquals("Drag me to my target", driver.findElement(By.id("draggable")).getText());
	}
	private void assertDrop(){
		assertEquals("Drop here", driver.findElement(By.id("droppable")).getText());
	}
	private void assertDropped(){
		assertEquals("Dropped!", driver.findElement(By.id("droppable")).getText());
	}

	@Test
	public void test() throws InterruptedException, IOException {
		Origem = driver.findElement(By.id("draggable"));
		assertDrag();
		Destino = driver.findElement(By.id("droppable"));
		assertDrop();
		File beforeScrnShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(beforeScrnShot, new File("C:\\Users\\sala01\\Documents\\JavaSelenium\\teste1.png"));
		new Actions(driver).dragAndDrop(Origem, Destino).perform();
		assertDropped();
		File AfterScrnShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(AfterScrnShot, new File("C:\\Users\\sala01\\Documents\\JavaSelenium\\teste2.png"));
		Thread.sleep(3000);
	}

}
