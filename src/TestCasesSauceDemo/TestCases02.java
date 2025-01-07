package TestCasesSauceDemo;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestCases02 {
	WebDriver driver = new ChromeDriver();

	Random rand = new Random();

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

	// code el login ma 3adlna 3aleh kter ela enu defna el WebElement as datatype

	@Test(priority = 1)

	public void Login() {

		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInputField.sendKeys(userName);
		PasswordInputField.sendKeys(passwordInput);
		LoginButton.click();

	}

	// ma tensa ana 3amlt la elo disable had bedef kol el items

	@Test(priority = 2, enabled = false)
	public void AddAllItems() {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 1; i < AddToCartButtons.size(); i = i + 2) {
			AddToCartButtons.get(i).click();
		}
	}

	// task darore t7elooooo

	@Test(priority = 2, enabled = false)
	public void AddCertainNumberOfItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddToCartButtons.size(); i++) {

			if (i == 0 && i == 2) {
				continue;
			}

			AddToCartButtons.get(i).click();

		}

	}

	@Test(priority = 2, enabled = false)
	public void AddItemsThatStartsWithSauce() {

		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			if (ItemsNames.get(i).getText().startsWith("Sauce")) {
				continue;

			}
			AddToCartButtons.get(i).click();

		}
	}

	@Test(priority = 3)

	public void AddRandomitem() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		int randomIndex = rand.nextInt(AddToCartButtons.size());

		System.out.println(randomIndex);

//		double randomIndex = Math.floor(Math.random()*AddToCartButtons.size());
//		System.out.println(	Math.random()*AddToCartButtons.size());
//		System.out.println(Math.floor(6.9));
//		System.out.println(Math.ceil(88.5));

		AddToCartButtons.get(randomIndex).click();

	}

	@Test(priority = 4)
	public void CheckoutProcess() {

		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();

		WebElement Checkoutbutton = driver.findElement(By.id("checkout"));
		Checkoutbutton.click();
		// Array of first names

		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };

		int RandomFirstName = rand.nextInt(firstNames.length);

		// Array of last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		int RandomLastName = rand.nextInt(lastNames.length);

		String[] postalCodes = { "12345", "67890", "54321", "98765", "11223" };
		int RandomPostalCode = rand.nextInt(postalCodes.length);

		WebElement FirstnameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostCodeInput = driver.findElement(By.id("postal-code"));

		FirstnameInput.sendKeys(firstNames[RandomFirstName]);
		;
		LastNameInput.sendKeys(lastNames[RandomLastName]);
		PostCodeInput.sendKeys(postalCodes[RandomPostalCode]);
		
		WebElement ContinueButton = driver.findElement(By.id("continue"));
		ContinueButton.click();
		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();
	}


}
