package ContactManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import HerokuappPages.Loginpage;
@Listeners(ContactManagementSystem.Listner.class)

public class SessionAndNavigation {
	
	WebDriver driver;
	@Test(priority=1)
	public void loginpagetoLogout () throws InterruptedException, IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));

		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='logout']")).click();
		Thread.sleep(3000);
		wb.close();
		fis.close();
		
	}
	@Test(priority=2)
	public void Refersh() throws InterruptedException, IOException {
		File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));

		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		wb.close();
		fis.close();
		
	}
	
	@Test(priority=3)
	public void verifyUrl () throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(3000);
		driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");
		driver.navigate().refresh();
		Thread.sleep(3000);

	}
	@Test(priority=4)
	public void verifyBack () throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='logout']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		
		driver.close();
		
	}	

}
