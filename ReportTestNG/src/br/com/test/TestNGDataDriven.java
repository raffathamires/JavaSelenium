package br.com.test;

import org.testng.annotations.Test;

import br.com.util.CaptureScreenShot;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNGDataDriven {
	WebDriver driver;
	private String baseURL;
	
  @Test
  public void testReport() {
	  driver.get(baseURL);
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sala01\\Documents\\JavaSelenium\\CursoSeleniumJava\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseURL = "http://treinoautomacao.hol.es/desafiosoma.html";
  }
  
  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException{
	  System.out.println(testResult.getStatus());
	  if(testResult.getStatus() == ITestResult.FAILURE){
		  new CaptureScreenShot(driver).captureScreenShot(testResult.getName());
	  }
	  driver.quit();
  }

}
