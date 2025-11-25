package DemoBlazeWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import DemoBlazePages.CartPage;
import DemoBlazePages.LoginPage;
public class UIAndUXTesting {
	
WebDriver driver;

@BeforeClass
public void login() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.demoblaze.com/");
}
	
	@Test(priority=1)
	public void GridVerify() throws InterruptedException, IOException {
	    

	    File f = new File("C:\\Users\\saima\\Sample\\Test Data for Demoblaze.xlsx");
	    FileInputStream fis = new FileInputStream(f);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheetAt = wb.getSheetAt(0);
	    XSSFRow row = sheetAt.getRow(1);

	    DataFormatter format = new DataFormatter();
	    String Username = format.formatCellValue(row.getCell(0));
	    String Password = format.formatCellValue(row.getCell(1));

	    LoginPage Lp = new LoginPage(driver);
	    Lp.getLoginButton1().click();
	    Thread.sleep(4000);
	    Lp.getUserName().sendKeys(Username);
	    Lp.getUserpassword().sendKeys(Password);
	    Thread.sleep(2000);
	    Lp.getLoginButton2().click();
	    Thread.sleep(3000);

	    List<WebElement> products = driver.findElements(By.cssSelector(".card.h-100"));
	    System.out.println("Total products found: " + products.size());
	    Thread.sleep(3000);

	    for (WebElement product : products) {
	        String productName = product.findElement(By.cssSelector(".card-title")).getText();
	        System.out.println("Product: " + productName);
	        Thread.sleep(2000);
	    }
	    Lp.getLogoutButton().click();
	    Thread.sleep(2000);

	    wb.close();
	    fis.close();
	}

	@Test(priority=2)
	public void ActionButton () throws InterruptedException {	
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean addToCartVisible = driver.findElement(By.xpath("//*[@id=\"cartur\"]")).isDisplayed();
		boolean loginVisible = driver.findElement(By.xpath("//*[@id=\"login2\"]")).isDisplayed();
		boolean signUpVisible = driver.findElement(By.xpath("//*[@id=\"signin2\"]")).isDisplayed();

		if (addToCartVisible && loginVisible && signUpVisible) {
		    System.out.println("All buttons are visible and clickable");
		} else {
		    System.out.println("One or more buttons are not visible");
		}
	 
	}

       @Test(priority=3)
	public void Consistency() throws InterruptedException, IOException {
		    

		    String[] urls = {
		        "https://www.demoblaze.com/index.html",
		        "https://www.demoblaze.com/cart.html",
		    };

	
		    String commonElementSelector = "a.navbar-brand"; 

		    String expectedFontFamily = "";
		    String expectedFontSize = "";

		    for (int i = 0; i < urls.length; i++) {
		        driver.get(urls[i]);
		        Thread.sleep(2000);  

		        WebElement element = driver.findElement(By.cssSelector(commonElementSelector));
		        String fontFamily = element.getCssValue("font-family");
		        String fontSize = element.getCssValue("font-size");

		        System.out.println("Page: " + urls[i]);
		        System.out.println("Font family: " + fontFamily);
		        System.out.println("Font size: " + fontSize);

		        if (i == 0) {
		            
		            expectedFontFamily = fontFamily;
		            expectedFontSize = fontSize;
		        } else {
		            
		            if (!expectedFontFamily.equals(fontFamily) || !expectedFontSize.equals(fontSize)) {
		                System.out.println("Font inconsistency detected on page: " + urls[i]);
		            }
		            
		            
		        }
		    }
		}

       @Test(priority=4)
   	public void alertandpopup() throws InterruptedException {
    	   
    	   CartPage cp=new CartPage(driver);
   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   		cp.getHomepage().click();
   		cp.getProdouctClick2().click();
   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   		cp.getAddCartClick().click();
   		Thread.sleep(2000);
   		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
   		String alertText = alert.getText();
   		System.out.println("Alert Text: " + alertText);

   		if (alertText.contains("added to cart")) {
   		    System.out.println("Alert message is correct and readable.");
   		} else {
   		    System.out.println("Unexpected alert message.");
   		}

   		alert.accept();
   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   	    
       }
       
       @Test(priority=5)
      	public void horizontal() throws InterruptedException {

         driver.manage().window().setSize(new Dimension(375, 667));
    	driver.get("https://www.demoblaze.com/");
    	Thread.sleep(2000); 
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	Long scrollWidth = (Long) js.executeScript("return document.documentElement.scrollWidth");
    	Long clientWidth = (Long) js.executeScript("return document.documentElement.clientWidth");
    	System.out.println("Scroll Width: " + scrollWidth);
    	System.out.println("Viewport Width: " + clientWidth);

    	if (scrollWidth > clientWidth) {
    	    System.out.println("Horizontal scrolling is required on smaller screen.");
    	} else {
    	    System.out.println("No horizontal scrolling required on smaller screen.");
    	}

    	
       }
       @AfterClass
      public void logout() {
    	  driver.close();
      }
}
