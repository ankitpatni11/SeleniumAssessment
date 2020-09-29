package seleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class stepDefinitions {

	static WebDriver driver;
	private WebDriverWait wait;

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://www.amazon.com";
		driver.get(url);
		Thread.sleep(1000);
	}

	@Then("^user search for Appium Book$")
	public void user_search_for_Appium_Book() {
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Appium");
		// driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
		driver.findElement(By.xpath("//*[@value='Go']")).click();
	}

	// *[@id="nav-search"]/form/div[2]/div/input

	@Then("^user selects the (\\d+)th Book$")
	public void user_selects_the_th_Book(int arg1) throws Throwable {
		driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[10]")).click();
		Thread.sleep(10000);

	}

	@Then("^Print the rating of the Book$")
	public void print_the_rating_of_the_Book() throws Throwable {
		driver.findElement(By.xpath("//*[@id='acrCustomerReviewText']")).click();
		String customerReview = driver
				.findElement(By.xpath("//*[@id='reviewsMedley']/div/div[1]/div[2]/div[1]/div/div[2]/div/span/span"))
				.getText();
		String[] rating = customerReview.split(" ");
		System.out.println("************************************************************");
		System.out.println("Rating for the book is: " + rating[0]);
		System.out.println("************************************************************");
		// id =acrPopover
		// xpath = //div[@id='averageCustomerReviews']//span[@id='acrPopover']
	}

	@Then("^Add Book into the Cart$")
	public void add_Book_into_the_Cart() throws Throwable {
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(10000);
	}

	@Then("^Print Total AMount of the Book$")
	public void print_Total_AMount_of_the_Book() {
		String amount = driver
				.findElement(By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]"))
				.getText();                       

		System.out.println("************************************************************");
		System.out.println("Total amount for the book is: " + amount);
		System.out.println("************************************************************");

	}

}
