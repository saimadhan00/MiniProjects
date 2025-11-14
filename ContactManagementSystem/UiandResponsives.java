package ContactManagementSystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import HerokuappPages.Loginpage;

public class UiandResponsives {

	WebDriver driver;
	int tolerance = 5;
	@Test(priority=1)
	public void Allignment() throws InterruptedException {


		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Loginpage Lp=new Loginpage(driver);
		Lp.getEmailIdField().sendKeys("saimadhan0009@gmail.com");
		Lp.getPasswordField().sendKeys("9688317700@ss");
		Lp.getSubmitBtnField().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='add-contact']")).click();

		int labelfirstName = driver.findElement(By.xpath("//label[text()=' * First Name:']")).getLocation().getY();		
		int firstName = driver.findElement(By.xpath("//input[@id='firstName']")).getLocation().getY();

		if (Math.abs(labelfirstName - firstName) <= tolerance) {
			System.out.println("Label and firstName are vertically aligned");
		} else {
			System.out.println("Label and firstName are NOT vertically aligned");
		}

		int labelLastName = driver.findElement(By.xpath("//label[text()=' * Last Name:']")).getLocation().getY();		
		int lastName = driver.findElement(By.xpath("//input[@id='lastName']")).getLocation().getY();

		if (Math.abs(labelLastName - lastName) <= tolerance) {
			System.out.println("Label and lastName are vertically aligned");
		} else {
			System.out.println("Label and lastName are NOT vertically aligned");
		}

		int lableemail = driver.findElement(By.xpath("//label[text()=' Email:']")).getLocation().getY();
		int email =driver.findElement(By.xpath("//input[@id='email']")).getLocation().getY();
		
		if(Math.abs(lableemail-email)<= tolerance) {
			System.out.println("Label and Email are vertically aligned");
		}else {
			System.out.println("Label and Email are NOT vertically aligned");
		}
		
	   int labelphone =driver.findElement(By.xpath("//label[text()=' Phone:']")).getLocation().getY();
	   int phone=driver.findElement(By.xpath("//input[@id='phone']")).getLocation().getY();
	   
	   if(Math.abs(labelphone-phone)<= tolerance) {
			System.out.println("Label and Phone are vertically aligned");
		}else {
			System.out.println("Label and Phone are NOT vertically aligned");
		}
	   int labelAddress1 = driver.findElement(By.xpath("//label[text()=' Street Address 1:']")).getLocation().getY();
	   int Address1=driver.findElement(By.xpath("//input[@id='street1']")).getLocation().getY();
	   
	   
	   if (Math.abs(labelAddress1 - Address1) <= tolerance) {
		    System.out.println("Label and Address1 are vertically aligned");
		} else {
		    System.out.println("Label and Address1 are NOT vertically aligned");
		}
	   int labelAddress2 = driver.findElement(By.xpath("//label[text()=' Street Address 2:']")).getLocation().getY();
	   int Address2=driver.findElement(By.xpath("//input[@id='street1']")).getLocation().getY();
	   
	   
	   if (Math.abs(labelAddress2 - Address2) <= tolerance) {
		    System.out.println("Label and Address2 are vertically aligned");
		} else {
		    System.out.println("Label and Address2 are NOT vertically aligned");
		}
     int lablecity= driver.findElement(By.xpath("//label[text()=' City:']")).getLocation().getY();
     int city=driver.findElement(By.xpath("//input[@id='city']")).getLocation().getY();
     
     if(Math.abs(lablecity-city)<= tolerance){
    	 System.out.println("Label and city are vertically aligned");
		} else {
		    System.out.println("Label and city are NOT vertically aligned");
		}
    	
	int lablestateProvince= driver.findElement(By.xpath("//label[text()=' State or Province:']")).getLocation().getY();
    int stateProvince=driver.findElement(By.xpath("//input[@id='stateProvince']")).getLocation().getY();
    
    if(Math.abs(lablestateProvince-stateProvince)<= tolerance){
   	 System.out.println("Label and stateProvince are vertically aligned");
		} else {
		    System.out.println("Label and stateProvince are NOT vertically aligned");
		}
    int lablepostalCode= driver.findElement(By.xpath("//label[text()=' Postal Code:']")).getLocation().getY();
    int postalCode=driver.findElement(By.xpath("//input[@id='postalCode']")).getLocation().getY();
    
    if(Math.abs(lablepostalCode-postalCode)<= tolerance){
   	 System.out.println("Label and postalCode are vertically aligned");
		} else {
		    System.out.println("Label and postalCode are NOT vertically aligned");
		}
    int lablecountry= driver.findElement(By.xpath("//label[text()=' Country:']")).getLocation().getY();
    int country=driver.findElement(By.xpath("//button[@id='submit']")).getLocation().getY();
    
    if(Math.abs(lablecountry-country)<= tolerance){
   	 System.out.println("Label and country are vertically aligned");
		} else {
		    System.out.println("Label and country are NOT vertically aligned");
		}

		/*27.Verify toast messages or success indicators
		 Scenario: Add or delete a contact.
		 Expected: Brief confirmation message or status update is shown.
		 unable to do this task because add contact or delete contact sucess indicators not available.
*/ 
	}

}
