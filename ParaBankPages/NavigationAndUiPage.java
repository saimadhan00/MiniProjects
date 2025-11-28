package ParaBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationAndUiPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"footerPanel\"]/ul[1]/li[1]/a")
	WebElement HomeButton;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[2]/a")
	WebElement AccountOverviewButton;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[3]/a")
	WebElement TransferFundsButton;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[7]/a")
	WebElement LoanButton;
	
	@FindBy(xpath="//*[@id=\"footerPanel\"]/ul[1]/li[8]/a")
	WebElement ContactUsButton;
	
	@FindBy(xpath="//*[@id=\"topPanel\"]/a[2]/img")
	WebElement LogLinkButton;
	
	public NavigationAndUiPage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver1, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHomeButton() {
		return HomeButton;
	}

	public WebElement getAccountOverviewButton() {
		return AccountOverviewButton;
	}

	public WebElement getTransferFundsButton() {
		return TransferFundsButton;
	}

	public WebElement getLoanButton() {
		return LoanButton;
	}

	public WebElement getContactUsButton() {
		return ContactUsButton;
	}

	public WebElement getLogLinkButton() {
		return LogLinkButton;
	}

}
