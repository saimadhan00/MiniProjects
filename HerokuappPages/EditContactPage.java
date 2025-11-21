package HerokuappPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//table[@class=\"contactTable\"]//tr[1]//td[2]")
	WebElement Contactable;
	
	@FindBy(xpath="//button[@id='edit-contact']")
	WebElement EditContact;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement submit;
	
	@FindBy(xpath="//button[@id='return']")
	WebElement ReturntoContact;
	

	@FindBy(xpath="//button[@id='cancel']")
	WebElement cancel;
	
	public EditContactPage (WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactable() {
		return Contactable;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getEditContact() {
		return EditContact;
	}

	public void setEditContact(WebElement editContact) {
		EditContact = editContact;
		
	}

	public WebElement getReturntoContact() {
		return ReturntoContact;
	}

	public WebElement getCancel() {
		return cancel;
	}
	

	
}
