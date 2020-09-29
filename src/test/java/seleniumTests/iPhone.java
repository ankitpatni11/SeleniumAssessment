package seleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iPhone {
	static WebDriver driver = null;

	@Test(priority = 1)
	public void Login_Amazon() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://www.amazon.com/";
		driver.get(url);
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void search_Iphone() throws InterruptedException {
		String phone = "iPhone 11 Pro";
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone");
		// driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
		driver.findElement(By.xpath("//*[@value='Go']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//*[@class='a-size-base-plus a-link-normal']"));
		for (WebElement w : names) {
			if (w.getText().equals(phone.trim())) {
				w.click();
			}
		}

	}

	@Test(priority = 3)
	public void print_Rating() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@class='qa-average-customer-rating-review-text']")).click();
		String customerReview = driver
				.findElement(By.xpath("//*[@id='reviewsMedley']/div/div[1]/div[2]/div[1]/div/div[2]/div/span/span"))
				.getText();
		String[] rating1 = customerReview.split(" ");
		System.out.println("************************************************************");
		System.out.println("Rating for the book is: " + rating1[0]);
		System.out.println("************************************************************");
		// id =acrPopover

	}

	@Test(priority = 4)
	public void add_to_cart_Print_Final_amount() throws InterruptedException {

		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(10000);

		String amount = driver.findElement(By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]")).getText();

		System.out.println("************************************************************");
		System.out.println("Total amount for the book is: " + amount);
		System.out.println("************************************************************");

	}

}
