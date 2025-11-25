package DemoBlazeWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.BrowsingPage;
import DemoBlazePages.LoginPage;

public class BrowsingAndNavigation {
  WebDriver driver;
  @BeforeClass
  public void login() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.demoblaze.com/");
}
	
	
	@Test(priority=1)
	public void Category() throws InterruptedException, IOException {
	
		
		File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Username = format.formatCellValue(row.getCell(0));
		String Password = format.formatCellValue(row.getCell(1));
		
		LoginPage Lp=new LoginPage (driver);
		Lp.getLoginButton1().click();
		Thread.sleep(4000);
		Lp.getUserName().sendKeys(Username);
		Lp.getUserpassword().sendKeys(Password);
		Thread.sleep(2000);
		Lp.getLoginButton2().click();
		Thread.sleep(3000);
		BrowsingPage bp=new BrowsingPage(driver);
		bp.getCategorieslaptop().click();
		Thread.sleep(2000);
		wb.close();
		fis.close();
	}
	
		@Test(priority=2)
		public void image() throws InterruptedException {
		BrowsingPage bp=new BrowsingPage(driver);
		bp.getImageClick().click();
		Thread.sleep(2000);
		}		
		@Test(priority=3)
		public void Home() throws InterruptedException {
		BrowsingPage bp=new BrowsingPage(driver);
		bp.getHomebar().click();
		Thread.sleep(2000);
		}
		
		@Test(priority=4)
		public void Navigation() throws InterruptedException {
		BrowsingPage bp=new BrowsingPage(driver);
		bp.getHomebar().click();
		Thread.sleep(2000);
		bp.getCartLoginpage().click();
		Thread.sleep(2000);
		bp.getContactLoginpage().click();
		Thread.sleep(2000);
		bp.getContactClosenpage().click();
		Thread.sleep(2000);
		
		}
		@AfterClass
		public void Logout() {
			  driver.close();  
		  }
}
