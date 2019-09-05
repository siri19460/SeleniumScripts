package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(name = "userName")
	private WebElement uName;

	@FindBy(name = "password")
	private WebElement pass;

	@FindBy(name = "login")
	private WebElement signin;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void applicationLogin(String userName, String password) {
		uName.clear();
		uName.sendKeys(userName);
		pass.sendKeys(password);
		signin.click();
	}

}
