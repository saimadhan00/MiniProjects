package ParaBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[7]/a")
	WebElement LoanRequestLoginPage ;
	
	@FindBy(xpath="//input[@id='amount'] ")
	WebElement LoanAmountField ;
	
	@FindBy(xpath="//*[@id=\"downPayment\"]")
	WebElement DownapaymentField  ;
	
	@FindBy(xpath="//*[@id=\"requestLoanForm\"]/form/table/tbody/tr[4]/td[2]/input")
	WebElement Applynowbutton;
	
	public LoanPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver1, this);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLoanRequestLoginPage() {
		return LoanRequestLoginPage;
	}

	public WebElement getLoanAmountField() {
		return LoanAmountField;
	}

	public WebElement getDownapaymentField() {
		return DownapaymentField;
	}

	public WebElement getApplynowbutton() {
		return Applynowbutton;
	}

}
