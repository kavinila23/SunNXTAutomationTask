package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.utilities.UtilityClass;

public class SignUpPage extends UtilityClass {

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='header_myaccount_logo__LnEUB']")
	private WebElement signInlogo;

	@FindBy(xpath = "//div[@class='profile_signin']")
	private WebElement signInButton;

	@FindBy(xpath = "//a[text()='SIGN UP']")
	private WebElement signUpButton;

	@FindBy(name = "email")
	private WebElement mobileNo;

	@FindBy(xpath = "//input[@placeholder='Create Password']")
	private WebElement password;

	@FindBy(name = "name")
	private WebElement name;
	@FindBy(name = "age")
	private WebElement dropDownAge;
	@FindBy(xpath = "//label[@for='female']")
	private WebElement genderFemale;

	@FindBy(name = "country")
	private WebElement countryDropDown;

	@FindBy(name = "state")
	private WebElement stateDropDown;

	@FindBy(name = "terms")
	private WebElement termsAndConditions;

	@FindBy(name = "//button[@type='submit']")
	private WebElement signUpSubmit;
	// -------------------------------------------------------------------------------------------//
	// getters

	public WebElement getSignInlogo() {
		return signInlogo;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getDropDownAge() {
		return dropDownAge;
	}

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getStateDropDown() {
		return stateDropDown;
	}

	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getSignUpSubmit() {
		return signUpSubmit;
	}

}
