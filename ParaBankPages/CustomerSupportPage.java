package ParaBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSupportPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"footerPanel\"]/ul[1]/li[8]/a")
	WebElement ContactUs;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement ContactUsNameField;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement ContactUsEmailField;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement ContactUsPhoneField;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement ContactUsTextareaField;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input")
	WebElement SendToCustomerCareField;

	public CustomerSupportPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver1,this );
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactUs() {
		return ContactUs;
	}

	public WebElement getContactUsNameField() {
		return ContactUsNameField;
	}

	public WebElement getContactUsEmailField() {
		return ContactUsEmailField;
	}

	public WebElement getContactUsPhoneField() {
		return ContactUsPhoneField;
	}

	public WebElement getContactUsTextareaField() {
		return ContactUsTextareaField;
	}

	public WebElement getSendToCustomerCareField() {
		return SendToCustomerCareField;
	}
	
}
