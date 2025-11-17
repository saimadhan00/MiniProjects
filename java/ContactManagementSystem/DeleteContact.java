package ContactManagementSystem;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ContactManagementSystem.Listner.class)

public class DeleteContact {
	
	WebDriver driver;
  @Test(priority=1)
	public void DeleteContactDetails() throws InterruptedException {
	  
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://thinking-tester-contact-list.herokuapp.com/");
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("saimadhan0009@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("9688317700@ss");
		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@class=\"contactTable\"]//tr[1]//td[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='delete']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
	}
  @Test(priority=2)
  public void DeleteContactAlert() throws InterruptedException {
	  
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
