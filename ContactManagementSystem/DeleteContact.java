package ContactManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import HerokuappPages.Loginpage;
@Listeners(ContactManagementSystem.Listner.class)

public class DeleteContact {
	
	WebDriver driver;
  @Test(priority=1)
	public void DeleteContactDetails() throws InterruptedException, IOException {
	  
	  File f=new File("C:\\Users\\saima\\Sample\\TestData for Herokpage.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetAt = wb.getSheetAt(0);
		XSSFRow row = sheetAt.getRow(1);
		
		DataFormatter format = new DataFormatter();
		String Email = format.formatCellValue(row.getCell(2));
		String Password = format.formatCellValue(row.getCell(3));
	  
	  
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://thinking-tester-contact-list.herokuapp.com/");
	  
	  Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys(Email);
		LP.getPasswordField().sendKeys(Password);
		LP.getSubmitBtnField().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@class=\"contactTable\"]//tr[1]//td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='delete']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		wb.close();
		fis.close();
	}
  @Test(priority=2)
  public void DeleteContactAlert() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("//table[@class=\"contactTable\"]//tr[1]//td[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@id='delete']")).click();
	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	System.out.println(text);
	Assert.assertEquals("Are you sure you want to delete this contact?", text);
	Thread.sleep(3000);
	driver.navigate().refresh();
	
	}
  @Test(priority=3)
 public void confirmDelete() throws InterruptedException {
	 
	 driver.findElement(By.xpath("//button[@id='delete']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		if(driver.findElements(By.xpath("//table[@class=\"contactTable\"]//tr[1]//td[2]")).size() > 0) {
		    System.out.println("Element is not deleted");
		} else {
		    System.out.println("Element is Deleted");
		}	
		
 }
}
