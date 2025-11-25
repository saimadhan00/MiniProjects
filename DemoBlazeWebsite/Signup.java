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

import DemoBlazePages.SignUpPage;

public class Signup {
	
	WebDriver driver;
	
	@BeforeClass
	public void login() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
	}
@Test(priority=1)
	public void SignupWebsite() throws InterruptedException, IOException {
		
	File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
	FileInputStream fis = new FileInputStream(f);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheetAt = wb.getSheetAt(0);
	XSSFRow row = sheetAt.getRow(1);
	
	DataFormatter format = new DataFormatter();
	String Username = format.formatCellValue(row.getCell(0));
	String Password = format.formatCellValue(row.getCell(1));
        
		
		SignUpPage sup=new SignUpPage(driver);
		sup.getSignupButton().click();
		Thread.sleep(3000);
		sup.getUserName().sendKeys(Username);
		sup.getUserpassword().sendKeys(Password);
		sup.getSignupclick().click();
		//driver.switchTo().alert().accept();
		driver.navigate().refresh();
		Thread.sleep(2000);
		wb.close();
		fis.close();
	}
  @Test(priority=2)
   public void SignuWithSameDetails() throws InterruptedException, IOException {
	
	  File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(2);
		
		DataFormatter format = new DataFormatter();
		String Username = format.formatCellValue(row.getCell(0));
		String Password = format.formatCellValue(row.getCell(1));
	  
	  
	SignUpPage sup=new SignUpPage(driver);
	sup.getSignupButton().click();
	Thread.sleep(2000);
	sup.getUserName().clear();
	sup.getUserpassword().clear();
	Thread.sleep(2000);
	sup.getUserName().sendKeys(Username);
	sup.getUserpassword().sendKeys(Password);
	sup.getSignupclick().click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	driver.navigate().refresh();
	Thread.sleep(3000);
	wb.close();
	fis.close();
}
  
  @Test(priority=3)
	public void SignupWithoutDetails() throws InterruptedException, IOException {

	  File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt=wb.getSheetAt(0);
		XSSFRow row=sheetAt.getRow(3);
		
		DataFormatter format=new DataFormatter();
		String username =format.formatCellValue(row.getCell(0));
		String Password=format.formatCellValue(row.getCell(1));
		
		SignUpPage sup=new SignUpPage(driver);
		sup.getSignupButton().click();
		Thread.sleep(3000);
		sup.getUserName().sendKeys(username);
		sup.getUserpassword().sendKeys(Password);
		Thread.sleep(3000);
		sup.getSignupclick().click();
		Thread.sleep(3000);
		driver.close();
		wb.close();
		fis.close();
	
}
  @AfterClass
  public void Logout() {
	  driver.close();  
  }
}