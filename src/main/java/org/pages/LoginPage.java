package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.UtilityClass;

public class LoginPage extends UtilityClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(id = "signin_btn")
	private WebElement loginButton;

	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement profile;

	@FindBy(xpath = "//div[contains(@class,'profile_name')]")
	private WebElement profileName;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getProfileName() {
		return profileName;
	}
	
	

}
