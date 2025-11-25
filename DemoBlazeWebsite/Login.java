package DemoBlazeWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.LoginPage;

public class Login {
	
	WebDriver driver;
	@BeforeClass
	public void login() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
	}
	
	@Test(priority=1)
	public void loginwithvaliaddetails() throws InterruptedException, IOException {
		
		
		
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
	@Test(priority=2)
public void loginwithinvalidpassword() throws InterruptedException, IOException {
	
	    File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
	    FileInputStream fis= new FileInputStream(f);
	    XSSFWorkbook wb=new XSSFWorkbook(fis);
	    XSSFSheet sheetAt =wb.getSheetAt(0);
	    XSSFRow row=sheetAt.getRow(2);
	    
	    DataFormatter format=new DataFormatter();
	    String username = format.formatCellValue(row.getCell(0));
	    String Password = format.formatCellValue(row.getCell(1));
	
	
		LoginPage Lp=new LoginPage (driver);
		Lp.getLoginButton3().click();
		Thread.sleep(4000);
		Lp.getUserName().sendKeys(username);
		Lp.getUserpassword().sendKeys(Password);
		Thread.sleep(2000);
		Lp.getLoginButton2().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		wb.close();
		fis.close();
		
}
	@Test(priority=3)
public void loginwithinEmptypassword() throws InterruptedException, IOException {
		
		File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt=wb.getSheetAt(0);
		XSSFRow row=sheetAt.getRow(3);
		
		DataFormatter format=new DataFormatter();
		String username =format.formatCellValue(row.getCell(0));
		String Password=format.formatCellValue(row.getCell(1));
		
		
		LoginPage Lp=new LoginPage (driver);
		Lp.getLoginButton3().click();
		Thread.sleep(4000);
		Lp.getUserName().sendKeys(username);
		Lp.getUserpassword().sendKeys(Password);
		Thread.sleep(2000);
		Lp.getLoginButton2().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		wb.close();
		fis.close();
	}
   @Test(priority=4)
	public void loginwithinvalidemailformat() throws InterruptedException, IOException {
		
		File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt=wb.getSheetAt(0);
		XSSFRow row=sheetAt.getRow(4);
		
		DataFormatter format=new DataFormatter();
		String username =format.formatCellValue(row.getCell(0));
		String Password=format.formatCellValue(row.getCell(1));
		
		
		LoginPage Lp=new LoginPage (driver);
		Lp.getLoginButton3().click();
		Thread.sleep(4000);
		Lp.getUserName().sendKeys(username);
		Lp.getUserpassword().sendKeys(Password);
		Thread.sleep(2000);
		Lp.getLoginButton2().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.navigate().refresh();
		wb.close();
		fis.close();
	}
	@Test(priority=5)
	public void PasswordMaskCheck () throws IOException, InterruptedException{
		
		File f=new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheetAt=wb.getSheetAt(0);
		XSSFRow row=sheetAt.getRow(5);
		
		DataFormatter format=new DataFormatter();
		String username =format.formatCellValue(row.getCell(0));
		String Password=format.formatCellValue(row.getCell(1));

		
		LoginPage Lp=new LoginPage (driver);
		Lp.getLoginButton3().click();
		Thread.sleep(4000);
		Lp.getUserName().sendKeys(username);
		Lp.getUserpassword().sendKeys(Password);
		Thread.sleep(2000);
		wb.close();
		fis.close();
		driver.close();
		
	        // Locate the password field (change locator as needed)
	        WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"loginpassword\"]"));

	        // Verify the type attribute is 'password' (masked)
	        String fieldType = passwordField.getAttribute("type");
	        if (fieldType.equals("password")) {
	            System.out.println("Password field is masked.");
	        } else {
	            System.out.println("Password field is NOT masked!");
	        }
        
}
	@AfterClass
	public void Logout() {
		  driver.close();  
	  }
}