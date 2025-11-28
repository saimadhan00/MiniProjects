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

public class FundTransfer {
	
	WebDriver driver;
	@BeforeClass
	public void login() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@Test(priority=1)
 public void ParaLogin() throws InterruptedException, IOException {
		
		
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
		wb.close();
    	fis.close();
		
	}	
         @Test(priority=2)
        public void SavingsAccountopennew() throws InterruptedException {
			AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
			af.getOpennewaccbuttonlogin().click();
	        Thread.sleep(2000);
	        af.getDropdownsavingsclick().click();
	        Thread.sleep(2000);
	        af.getOpennewaccbuttoninside().click();
	        Thread.sleep(2000);
 
		}
		
	@Test(priority=3)
	  public void SavingsAccountFundTransfer() throws InterruptedException {
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
	@Test(priority=4)
public void FundtransfertoMoreAmount() throws InterruptedException {
		
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
		Thread.sleep(2000);
		af.getTransferFunds().click();
		af.getAmountButton().sendKeys("2000000");
		Thread.sleep(2000);
		af.getDropdownselectScheme().click();
		Thread.sleep(3000);
		af.getFundTransferbutton().click();
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
public void FundtransferEmptyinamount() throws InterruptedException {
		
		AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
		Thread.sleep(2000);
		af.getTransferFunds().click();
		af.getAmountButton().sendKeys("");
		Thread.sleep(2000);
		af.getDropdownselectScheme().click();
		Thread.sleep(3000);
		af.getFundTransferbutton().click();
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void FundtransferSameAccount() throws InterruptedException {
			
			AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
			Thread.sleep(2000);
			af.getTransferFunds().click();
			af.getAmountButton().sendKeys("22");
			Thread.sleep(3000);
			af.getFundTransferbutton().click();
			Thread.sleep(3000);
}
	@Test(priority=7)
	public void FundtransferDecimal() throws InterruptedException {
			
			AccountFunctionalityPage af =new AccountFunctionalityPage(driver);
			Thread.sleep(2000);
			af.getTransferFunds().click();
			af.getAmountButton().sendKeys("20.00");
			Thread.sleep(3000);
			af.getFundTransferbutton().click();
			Thread.sleep(3000);
}
	@AfterClass
	  public void Logout() {
		  driver.close();  
	  }

}