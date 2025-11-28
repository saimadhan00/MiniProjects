package ParaBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountFunctionalityPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[2]/a")
	WebElement  AccountOverviewButton;
	
	@FindBy(xpath="//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
	WebElement  CheckingAccountButton;
	
	@FindBy(xpath="//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]/a")
	WebElement  SavingsAccountButton;
	

	@FindBy(xpath="//*[@id=\"amount\"]")
	WebElement  AmountButton;
	
	@FindBy(xpath="//select[@id='toAccountId'] /option[2]")
	WebElement  DropdownselectScheme;
	
	@FindBy(xpath="//*[@id=\"transferForm\"]/div[2]/input")
	WebElement  FundTransferbutton;
	
	
	@FindBy(xpath="//select[@id=\"type\"]/option[2]")
	WebElement  Dropdownsavingsclick;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[1]/a")
	WebElement opennewaccbuttonlogin;
	

	@FindBy(xpath="//*[@id=\"openAccountForm\"]/form/div/input")
	WebElement opennewaccbuttoninside;
	
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[3]/a")
	WebElement TransferFunds;
	
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]/ul/li[5]/a")
	WebElement FindTransactions;
	
	
	@FindBy(xpath="//input[@id='transactionDate']")
	WebElement FindTransactionsDate;
	
	
	@FindBy(xpath="//input[@id='amount']")
	WebElement FindTransactionsAmount;
	

	@FindBy(xpath="//*[@id=\"findByDate\"]")
	WebElement FindTransactionsdateinside;
	
	
	@FindBy(xpath="//*[@id=\"findByAmount\"]")
	WebElement FindTransactionsAmountinside;
	
	public  AccountFunctionalityPage(WebDriver driver1) {
		this.driver=driver1;		
		PageFactory.initElements(driver, this);
			
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAccountOverviewButton() {
		return AccountOverviewButton;
	}

	public WebElement getCheckingAccountButton() {
		return CheckingAccountButton;
	}

	public WebElement getSavingsAccountButton() {
		return SavingsAccountButton;
	}



	public WebElement getAmountButton() {
		return AmountButton;
	}

	public WebElement getDropdownselectScheme() {
		return DropdownselectScheme;
	}


	public WebElement getOpennewaccbuttonlogin() {
		return opennewaccbuttonlogin;
	}

	public WebElement getOpennewaccbuttoninside() {
		return opennewaccbuttoninside;
	}

	public WebElement getDropdownsavingsclick() {
		return Dropdownsavingsclick;
		
	}

	public WebElement getFundTransferbutton() {
		return FundTransferbutton;
	}

	public WebElement getTransferFunds() {
		return TransferFunds;
	}

	public WebElement getFindTransactions() {
		return FindTransactions;
	}

	public WebElement getFindTransactionsDate() {
		return FindTransactionsDate;
	}

	public WebElement getFindTransactionsAmount() {
		return FindTransactionsAmount;
	}

	public WebElement getFindTransactionsdateinside() {
		return FindTransactionsdateinside;
	}

	public WebElement getFindTransactionsAmountinside() {
		return FindTransactionsAmountinside;
	}

	
}
