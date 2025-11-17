package HerokuappPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement FirstNameField;
	
	@FindBy (xpath="//input[@id='lastName']")
	WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='birthdate']")
	WebElement birthdateField;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneField;
	
	@FindBy(xpath="//input[@id='street1']")
	WebElement street1Field;
	
	@FindBy(xpath="//input[@id='street2']")
	WebElement street2Field;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement cityField;
	
	@FindBy(xpath="//input[@id='stateProvince']")
	WebElement stateProvinceField;
	
	@FindBy(xpath="//input[@id='postalCode']")
	WebElement postalCodeField;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement countryField;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement submitField;
	
	//driver.findElement(By.xpath("//button[@id='add-contact']")).click();
	@FindBy(xpath="//button[@id='add-contact']")
	WebElement addcontact;
	
	
	public AddContactPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstNameField() {
		return FirstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getBirthdateField() {
		return birthdateField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getStreet1Field() {
		return street1Field;
	}

	public WebElement getStreet2Field() {
		return street2Field;
	}

	public WebElement getCityField() {
		return cityField;
	}

	public WebElement getStateProvinceField() {
		return stateProvinceField;
	}

	public WebElement getPostalCodeField() {
		return postalCodeField;
	}

	public WebElement getCountryField() {
		return countryField;
	}

	public WebElement getSubmitField() {
		return submitField;
	}

	public WebElement getAddcontact() {
		return addcontact;
	}
	

	


}