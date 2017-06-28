package com.tests;

import static org.junit.Assert.assertEquals;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import wtbox.util.WaitTool;

public class DragAndDropComprasTest {


	private WebDriver driver;
	private String baseUrl;
	private File scrFile01;
	private File scrFile02;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		baseUrl = "http://demo.tutorialzine.com/2009/09/shopping-cart-php-jquery/demo.php";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	public void testDragAndDrop() throws Exception {

		//WaitTool.waitForElementPresent(driver, By.xpath("//img[@alt='iPod']"), 10);
		
		scrFile01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile01, new File("f:\\temp\\screenshot01.png"));
		
		WebElement iPhone = driver.findElement(By.xpath("//img[@alt='iPhone']"));
		WebElement iPodShuffle = driver.findElement(By.xpath("//img[@alt='iPod Shuffle']"));
		WebElement AppleTV = driver.findElement(By.xpath("//img[@alt='Apple TV']"));
		WebElement toCart = driver.findElement(By.xpath("//div[@class='content drop-here ui-droppable']"));

		new Actions(driver).dragAndDrop(iPhone, toCart).perform();
		Thread.sleep(1000);
		new Actions(driver).dragAndDrop(iPhone, toCart).perform();
		new Actions(driver).dragAndDrop(iPodShuffle, toCart).perform();
		new Actions(driver).dragAndDrop(AppleTV, toCart).perform();
		
		scrFile02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile02, new File("f:\\temp\\screenshot02.png"));
		
		assertEquals("$400", driver.findElement(By.xpath("//*[@id='table_3']/tbody/tr/td[2]")).getText());
		assertEquals("$49", driver.findElement(By.xpath("//*[@id='table_4']/tbody/tr/td[2]")).getText());
		assertEquals("$300", driver.findElement(By.xpath("//*[@id='table_6']/tbody/tr/td[2]")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
