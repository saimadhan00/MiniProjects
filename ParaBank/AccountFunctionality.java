package ParaBank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import ParaBankPages.AccountFunctionalityPage;
import ParaBankPages.LoginPage;

public class AccountFunctionality {
	
	WebDriver driver;
	@BeforeClass
	public void login() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	@Test(priority=1)
	public void AccountSummaryCheckingAccount() throws IOException, InterruptedException {
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for ParaBank.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);

		DataFormatter format = new DataFormatter();
		String UserName = format.formatCellValue(row.getCell(8));
		String Password = format.formatCellValue(row.getCell(9));
		
		LoginPage Lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Lp.getUsernameButton().sendKeys(UserName);
		Lp.getPasswordButton().sendKeys(Password);
		Lp.getLoginButton().click();
		Thread.sleep(2000);
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
        af.getAccountOverviewButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        af.getCheckingAccountButton().click();
		wb.close();
		fis.close();
	}
	@Test(priority=2)
	public void SavingsAccountopen() throws InterruptedException {
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
		af.getOpennewaccbuttonlogin().click();
        Thread.sleep(2000);
        af.getDropdownsavingsclick().click();
        Thread.sleep(2000);
        af.getOpennewaccbuttoninside().click();
        Thread.sleep(2000);
	}
	@Test(priority=3)
	public void AccountSummarySavingsAccount() throws InterruptedException {
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
        af.getAccountOverviewButton().click();
        Thread.sleep(2000);
        af.getSavingsAccountButton().click();
        Thread.sleep(2000);
  
	}

	@Test(priority=4)
	public void FundtransfertosavingsAccount() throws InterruptedException {
		
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
		Thread.sleep(2000);
		af.getTransferFunds().click();
		af.getAmountButton().sendKeys("2");
		Thread.sleep(2000);
		af.getDropdownselectScheme().click();
		Thread.sleep(3000);
		af.getFundTransferbutton().click();
		Thread.sleep(3000);
	}
	@Test(priority=5)
	public void TransactionWithDate() throws InterruptedException {
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
		Thread.sleep(2000);
		af.getFindTransactions().click();
		Thread.sleep(2000);
		af.getFindTransactionsDate().sendKeys("11-28-2025");
		Thread.sleep(3000);
		af.getFindTransactionsdateinside().click();
		Thread.sleep(3000);
		
	}
	@Test(priority=6)
	public void TransactionWithAmount() throws InterruptedException {
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
		Thread.sleep(2000);
		af.getFindTransactions().click();
		Thread.sleep(2000);
		af.getFindTransactions().sendKeys("2");
		Thread.sleep(3000);
		af.getFindTransactionsAmountinside().click();
		Thread.sleep(3000);
		
	}

@AfterClass
public void Logout() {
	  driver.close();  
}

}
