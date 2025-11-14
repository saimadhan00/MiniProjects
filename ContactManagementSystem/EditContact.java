package ContactManagementSystem;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import HerokuappPages.EditContactPage;
import HerokuappPages.Loginpage; 

public class EditContact {
	WebDriver driver;
	@Test(priority=1)
	public void EditContactDetails() throws InterruptedException, IOException {
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		
		Loginpage LP = new Loginpage(driver);
		LP.getEmailIdField().sendKeys("saimadhan009@gmail.com");
		LP.getPasswordField().sendKeys("9688317700@ss");
		LP.getSubmitBtnField().click();
		Thread.sleep(5000);
		
		EditContactPage Epc= new EditContactPage(driver);
		
		Epc.getFirstName().clear();
		Epc.getFirstName().sendKeys("Madhan00");
		Epc.getLastName().clear();
		Epc.getLastName().sendKeys("Kumar00");
		Epc.getEmail().clear();
		Epc.getEmail().sendKeys("Addcontact@gmail.com");
		Epc.getPhone().clear();
		Epc.getPhone().sendKeys("0000000000");
		Epc.getContactable().click();;
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		TakesScreenshot shot= (TakesScreenshot)driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File desitnation=new File("C:\\Users\\saima\\eclipse-workspace\\ContactManagementSystem\\Screenshots\\EditContactScreenshots");
		FileUtils.copyFile(source, desitnation);
	}
//	@Test(priority=2)
//    public void cancel() throws InterruptedException {
//    	driver.findElement(By.xpath("//button[@id='return']")).click();
//    	Thread.sleep(3000);
//		driver.findElement(By.xpath("//table[@class=\"contactTable\"]//tr[1]//td[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='edit-contact']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Madhan01");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@id='cancel']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='edit-contact']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='cancel']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='return']")).click();
//    }
//	@Test(priority=3)
//	public void validation () throws InterruptedException{
//
//		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
//		
//		
//	}
}
