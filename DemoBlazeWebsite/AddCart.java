package DemoBlazeWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DemoBlazePages.CartPage;
import DemoBlazePages.LoginPage;

public class AddCart {
	
WebDriver driver;

@BeforeClass
public void login() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.demoblaze.com/");
}
	
	@Test(priority=1)
	public void AddCartProduct() throws InterruptedException, IOException {

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
		wb.close();
		fis.close();
		
		CartPage cp=new CartPage(driver);
		cp.getProdouctClick().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getAddCartClick().click();
		Thread.sleep(2500);
		
		Alert alert = driver.switchTo().alert(); 
		String alertText = alert.getText();       
		alert.accept();      
	        if (alertText.equals("Product added.")) {
	            System.out.println("Product added Sucessfully.");
	        } else {
	            System.out.println("Product is not Added");
	        }

}

	@Test(priority=2)
	public void AddCartVerify() {
		
		CartPage cp=new CartPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getCartLoginpage().click();
		driver.navigate().refresh();	
	}
	
	@Test(priority=3)
	public void DeleteCart() throws InterruptedException {
		
		CartPage cp=new CartPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getDeleteProduct().click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	@Test(priority=4)
	public void AddMultipleProducts() throws InterruptedException {
		
		CartPage cp=new CartPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getHomepage().click();
		cp.getProdouctClick2().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getAddCartClick().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		cp.getHomepage().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getProdouctClick3().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getAddCartClick().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		cp.getHomepage().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getProdouctClick4().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cp.getAddCartClick().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		cp.getHomepage().click();
		Thread.sleep(2000);
		driver.close();

	}
	@AfterClass
	public void Logout() {
		  driver.close();  
	  }
}