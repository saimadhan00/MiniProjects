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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ParaBankPages.LoanPage;
import ParaBankPages.LoginPage;

public class Loan {
	
	WebDriver driver;
	
	@BeforeClass
	public void LoginUrl() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
	}
	@Test(priority=1)
	public void loanRequest() throws InterruptedException, IOException {
		
		
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
		
		
		LoanPage lp=new LoanPage(driver);
		lp.getLoanRequestLoginPage().click();
		Thread.sleep(2000);
		lp.getLoanAmountField().sendKeys("200000");
		Thread.sleep(2000);
		lp.getDownapaymentField().sendKeys("10");
		Thread.sleep(2000);
		lp.getApplynowbutton().click();
		Thread.sleep(2000);
		
	}

	@Test(priority=2)
	public void loanRequestempty() throws InterruptedException, IOException{
	
		
		LoanPage lp=new LoanPage(driver);
		lp.getLoanRequestLoginPage().click();
		Thread.sleep(2000);
		lp.getLoanAmountField().sendKeys("");
		Thread.sleep(2000);
		lp.getDownapaymentField().sendKeys("");
		Thread.sleep(2000);
		lp.getApplynowbutton().click();
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void loanRequestExceeds() throws InterruptedException, IOException{
	
		
		LoanPage lp=new LoanPage(driver);
		lp.getLoanRequestLoginPage().click();
		Thread.sleep(2000);
		lp.getLoanAmountField().sendKeys("200000");
		Thread.sleep(2000);
		lp.getDownapaymentField().sendKeys("10000");
		Thread.sleep(2000);
		lp.getApplynowbutton().click();
		Thread.sleep(2000);
	}
	@AfterClass
	  public void Logout() {
		  driver.close();  
	  }
}
