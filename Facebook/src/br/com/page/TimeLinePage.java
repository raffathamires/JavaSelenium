package br.com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeLinePage {
	private WebDriver driver;
	private WebElement name;
	private WebElement textArea;
	
	public TimeLinePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void mapearName() {
		name = driver.findElement(By.xpath(".//*[@id='navItem_100005504922759']/a/div"));
	}
	
	public void mapearTextArea() {
		
	}
	
	public String logadoSucesso() {
		mapearName();
		String result = name.getText();
		return result;
	}
}
