package br.com.element;

import org.openqa.selenium.WebElement;

public class TextField {
	WebElement element;
	
	public TextField(WebElement element){
		this.element = element;
	}
	
	public void type(String value){
		if (this.element.isEnabled()){
			this.element.sendKeys(value);
		}
	}
	
	public String getValue(){
		return this.element.getAttribute("value").toString();
	}

}