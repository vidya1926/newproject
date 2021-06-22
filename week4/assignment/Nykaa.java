package week4.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notification");
		
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();		
		driver.findElement(By.id("SearchInputBox")).sendKeys("Perfumes",Keys.ENTER);
	
		 List<WebElement> Perfumes = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']"));
	        System.out.println(Perfumes.size());
	        for (WebElement webElement : Perfumes) {
	            String name = webElement.getText();
	            String pdtname=name.replaceAll("a-z","");	            
	            System.out.println("The Available perfume Product Names are    "+pdtname);
	     }
	        List<WebElement> Perfumeprice = driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));

	        for (WebElement webElement1 : Perfumeprice) {
	            String Mrpname = webElement1.getText();
	            String pdtmrp=Mrpname.replaceAll("0-9","");	            
	            System.out.println("The Available perfume Product cost are  : "+pdtmrp);        
	     }
	        Actions builder=new Actions(driver);
	       WebElement sortby=driver.findElement(By.xpath("//span[@class='pull-right']//i[1]"));
	       builder.click(sortby).perform();
	       WebElement highp=driver.findElement(By.xpath("//input[@id='5']/following-sibling::div[1]"));       
	       builder.click(highp).perform();
	       driver.findElement(By.xpath("//div[contains(@class,'product-list-box card')]")).click();
	        WebElement fper=   driver.findElement(By.xpath("//img[@class='listing-img']"));
	        builder.moveToElement(fper).perform();	        
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	        driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
	        WebElement c = driver.findElement(By.xpath("//button[text()='Added To Bag']"));
	        String cmsg=  wait.until(ExpectedConditions.visibilityOf(c)).getText();
	    	 System.out.println(cmsg);  
	    	 Set<String> winshow= driver.getWindowHandles();   
		 		System.out.println(winshow.size());	 		
		 		List <String>firstwin=new ArrayList<String>(winshow);
		 		driver.switchTo().window(firstwin.get(1));
		 		Thread.sleep(2000);
		 		driver.close();
		 		driver.switchTo().window(firstwin.get(0));
		 		driver.findElement(By.className("AddBagIcon")).click();	
		 		String grandTotal = driver.findElement(By.xpath("//div[text()='Grand Total:']")).getText();		 	
		 		System.out.println("The grandtotal of the product is   "  +grandTotal);		 		
		 		driver.findElement(By.xpath("//span[text()='Proceed']")).click();	    	 
		 		driver.findElement(By.xpath("(//button[contains(@class,'btn full')])[2]")).click();
		 		driver.findElement(By.name("name")).sendKeys("Sanjay",Keys.TAB);
		 		driver.findElement(By.name("email")).sendKeys("aksan@gmail.com",Keys.TAB);
		 		driver.findElement(By.name("phoneNumber")).sendKeys("8648923645",Keys.TAB);		
		 		driver.findElement(By.name("pinCode")).sendKeys("600077",Keys.TAB);
		 		driver.findElement(By.xpath("//textarea[@class='textarea-control prl10']")).sendKeys("RSA Nagar,Chennai");
		 		driver.findElement(By.xpath("//button[contains(@class,'btn full')]")).click();
		 		Thread.sleep(1000);
		 		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 		String thisFieldIs = driver.findElement(By.xpath("//span[@class='field-error']")).getText();
		 		System.out.println("CardNumber " +thisFieldIs);
		 		String  Expiry= driver.findElement(By.xpath("//span[text()='Required']")).getText();
		 		System.out.println("Expirydate  "+Expiry);
		 		String required = driver.findElement(By.xpath("(//span[text()='Required'])[2]")).getText();
	            System.out.println("CCV" +required);
	            File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	            File file = new File("C://demo/snap4.jpg");
	            FileUtils.copyFile(screenshotAs, file);
	           
		        driver.close();
		        
		
		
		
		
	}		
		
}	
	

/*Enter text as Perfumes in Search Bar and press Enter
3. Get The Names Of all the Perfumes Displayed 
4. Get The Price of all the Perfumes Displayed
5. Click on the Highest Price Perfume  
6. Click on Add To Bag
7. verify Message Product Added To the bag 
8. Click on bag Icon
9. Get the Grand Total Value
10. Click on Proceed
11. Click on Continue as Guest
12. Fill all the Fields in Address 
13. Click on Paynow
14. Get the Error Message displayed in Red Color
15. close the current browser*/
