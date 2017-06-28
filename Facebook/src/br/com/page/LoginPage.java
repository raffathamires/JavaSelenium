package br.com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	private WebElement loginInput;
	private WebElement passwordInput;
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public LoginPage abre() {
		driver.get("https://www.facebook.com/");
		return new LoginPage(driver);
	}
	
	public void mapearLogar(){
		loginInput = driver.findElement(By.id("email"));
		passwordInput = driver.findElement(By.id("pass"));
		loginButton = driver.findElement(By.id("u_0_r"));
	}
	public TimeLinePage logar(String email, String password){
		mapearLogar();
		loginInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		return new TimeLinePage(driver);
	}

}
