package DemoBlazeWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.LoginPage;

public class Logout {
	
WebDriver driver;

@BeforeClass
public void login() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.demoblaze.com/");
}

	@Test(priority=1)
	public void logout() throws InterruptedException, IOException {
		
	
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
		Lp.getLogoutButton().click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		wb.close();
		fis.close();

			}	

	@AfterClass
	public void Logoutover() {
		  driver.close();  
	  }
}
