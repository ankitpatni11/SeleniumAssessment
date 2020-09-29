package seleniumTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class wayFairTest {
	static WebDriver driver = null;

	@Test(priority = 1)
	public void launch_wayFairTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String url = "https://www.wayfair.com/";
		driver.get(url);
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void select_SectionalTest() {
		List<WebElement> furniture = driver.findElements(By.xpath("//*[@class='DepartmentItem-link']"));
		for (WebElement furnElement : furniture) {
			if (furnElement.getText().equals("Furniture")) {
				furnElement.click();
				break;
			}
		}
		driver.findElement(By.xpath("//a[contains(text(),'Living Room Furniture')]")).click();

	}

	@Test(priority = 3)
	public void select_homeFurnitureTest() {

		List<WebElement> livingRoomCategory = driver
				.findElements(By.xpath("//*[@class='CategoryCarousel-imageTitle']"));
		for (WebElement category : livingRoomCategory) {
			if (category.getText().equals("Sectionals")) {
				category.click();
				break;
			}

		}
	}

	@Test(priority = 4)
	public void select_12thProduct_PrintRating() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='bd']/div[2]/div[2]/div[12]")).click();
		Thread.sleep(10000);

		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(tabs.size());
		// Use the list of window handles to switch between windows
		driver.switchTo().window((String) tabs.get(1));

		String Rating = driver
				.findElement(By.xpath("//*[@id='bd']/div[1]/div[2]/div/div[1]/div[1]/header/div/button/span/span[1]"))
				.getText();
		System.out.println("**************************************");
		System.out.println("Rating is: " + Rating);
		System.out.println("**************************************");

		driver.findElement(By.xpath("//*[@id='btn-add-to-cart']")).click();
		String amount = driver.findElement(By.xpath("//*[@class='MinicartProductCard-price']")).getText();

		System.out.println("**************************************");
		System.out.println("Total amount is: " + amount);
		System.out.println("**************************************");

	}

}
