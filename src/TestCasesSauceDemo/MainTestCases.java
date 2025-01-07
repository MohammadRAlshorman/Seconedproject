package TestCasesSauceDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases {

	// standard_user

	WebDriver driver = new ChromeDriver();

	String myWebSite = "https://www.saucedemo.com/";

	String userName = "standard_user";
	String passwordInput = "secret_sauce";

	@BeforeTest

	public void MySetup() {

		driver.get(myWebSite);

		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();

	}

	@Test(priority = 1)

	public void Login() {
		driver.findElement(By.id("user-name")).sendKeys(userName);

		driver.findElement(By.id("password")).sendKeys(passwordInput);
		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority = 2,enabled=false)

	public void AddToItemToCart() {


		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn")) ;
		for(int i = 0 ; i < AddToCartButtons.size();i=i+2 ) {
			AddToCartButtons.get(i).click();
	}

	}
     @Test(priority=2,enabled = false)
     public void AddCertainNumberOfItems() {
    	 List<WebElement> AddToCartButtons = driver.findElements(By.className("btn")) ;
    	 
    	 
 		for(int i = 0 ; i < AddToCartButtons.size();i++ ) {
 			if(i==0 || i==2) {
 				continue;
 			}
 			
 			AddToCartButtons.get(i).click();
 			
 		
 	}
	
	
    }

@Test(priority=2)
public void AddItemsThatStartWithSauce() {
	
	List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
	List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
	
	for(int i = 0;i< ItemsNames.size();i++) {
		
		if(ItemsNames.get(i).getText().startsWith("Sauce")) {
			AddToCartButtons.get(i).click();
		}
	}
	
}




	@Test(priority = 3, enabled = false)

	public void RemoveItemFromThecart() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	}

	@AfterTest
	public void PostTesting() {

	}
}