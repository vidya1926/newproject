package week4.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notification");
		
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles",Keys.ENTER);
		String  Mrp= driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		
		System.out.println("The Model Price is rs." +Mrp );
		driver.findElement(By.xpath("//img[@class='s-image']")).click();
		Set<String> winshow= driver.getWindowHandles();   
 		System.out.println(winshow.size());	 		
 		List <String>firstwin=new ArrayList<String>(winshow);
 		driver.switchTo().window(firstwin.get(1));
 		String ratings = driver.findElement(By.xpath("//span[@id='acrCustomerReviewText']")).getText();
 		System.out.println(ratings);
 		driver.findElement(By.id("add-to-cart-button")).click();
 		Thread.sleep(2000);
 		String addedToCart = driver.findElement(By.xpath("(//h4[@class='a-alert-heading'])[3]")).getText();
 		System.out.println(addedToCart);
 		driver.findElement(By.xpath("//*[@id='attach-sidesheet-checkout-button']/span/input")).click();
 	//	driver.findElement(By.xpath("//a[text()[normalize-space()='Proceed to Buy (1 item)']]")).click();
 		//driver.switchTo().window(firstwin.get(2));
 		driver.findElement(By.xpath("//input[@id='continue']")).click();
 		String enterYourEmail = driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText();
 		System.out.println(enterYourEmail);
 		driver.quit();
	}

}
/*. Print the price of the first resulting mobile
4. Click on the Mobile (First resulting) image
5. Switch to the new window
6. Print the number of customer ratings
7. Click 'Add to Cart'
8. Confirm "Added to Cart" text message appeared
9. Click on Proceed to checkout
10. Confirm the title is "Amazon Sign In"
11. Click Continue (without entering mobile number/email)
12. Verify the error message: Enter your email or mobile phone number
13. Close both browsers */