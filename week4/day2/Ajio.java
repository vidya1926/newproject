package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
		
		//ChromeDriver driver=new ChromeDriver();
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notification");
		ChromeDriver driver=new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(" https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		/*Actions actions = new Actions(driver);
		WebElement target =driver.findElement(By.linkText("WOMEN"));
		actions.moveToElement(target).perform();*/
		driver.findElement(By.tagName("input")).sendKeys("BAGS",Keys.ENTER);
		
		
		
		
		
		
		
		
		driver.findElement(By.xpath("//label[contains(@class,'facet-linkname facet-linkname-l1l3nestedcategory')]")).click();
		driver.findElement(By.className("five-grid")).click();
		WebElement sortByRele = driver.findElement(By.tagName("select")); 
		new Select(sortByRele).selectByIndex(3); 
		driver.findElement(By.xpath("//span[text()='price']")).click();
		driver.findElement(By.id("minPrice")).sendKeys("3000");
		driver.findElement(By.id("maxPrice")).sendKeys("5000");
		
		driver.findElement(By.xpath("//button[@class='rilrtl-button ic-toparw']")).click();	
		
		
		driver.findElement(By.xpath("//img[contains(@class,'rilrtl-lazy-img ')]")).click();
      
		Set<String> winshow= driver.getWindowHandles();
		System.out.println(winshow.size());
		List <String>firstwin=new ArrayList<String>(winshow);
		String window1=firstwin.get(1);
		driver.switchTo().window(window1);
        Thread.sleep(2000);
		
		String rs = driver.findElement(By.className("prod-sp")).getText();
		int actualrs=Integer.parseInt(rs.replaceAll("\\D", ""));
		System.out.println("The Actual price is :"+actualrs);
		
		
		String discount  = driver.findElement(By.xpath("//div[@class='promo-discounted-price']//span[1]")).getText();
		int disprice=Integer.parseInt(discount .replaceAll("\\D", ""));
		System.out.println("The Discounted price is :"+disprice);
		
	
		String useCodeSPECIAL = driver.findElement(By.xpath("//div[@class='promo-title-blck']//div[1]")).getText();
		String[] split=useCodeSPECIAL.split("Code");
		String special=(split[split.length-1]).replaceAll("[^a-zA-Z]","");
		System.out.println("The Coupon Code is :  " +special);
				
		
		driver.findElement(By.xpath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']")).click();
		
		  
	//	driver.findElement(By.xpath("//*[@id='edd']/div[1]/div/span[2]")).click();  
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='edd-pincode']/div/div/div[2]/form/div/input")).sendKeys("560043");		
		driver.findElement(By.className("edd-pincode-modal-submit-btn")).click();
		String expectedDelivery = driver.findElement(By.xpath("//li[text()='Expected Delivery: ']")).getText();
		System.out.println(expectedDelivery);
		
		
		
		driver.findElement(By.xpath("//div[text()='Other information']")).click();
		String aJIOCoReliance = driver.findElement(By.xpath("//div[@id='appContainer']/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/section[1]/h2[1]/ul[1]/li[10]/div[1]/div[3]")).getText();
        System.out.println(aJIOCoReliance);
        
        driver.findElement(By.xpath("//div[@class='pdp-addtocart-button']//div[1]")).click();        
        
        driver.findElement(By.xpath("//div[text()='PROCEED TO BAG']")).click();
        
  driver.findElement(By.id("couponCodeInput")).sendKeys(special);    
  driver.findElement(By.xpath("//button[text()='Apply']")).click();
  
  
  
    String orderprice = driver.findElement(By.xpath("//div[@class='net-price best-price-strip']")).getText();
    int netprice=Integer.parseInt(orderprice.replaceAll("\\D",""))  ;
   // TO compare
   System.out.println("The Total netprice=  ;"+netprice);
   if(netprice==disprice)
   {System.out.println("The Bill amount is matching with discount price");
   }else 
    System.out.println("Not Matching");
 

  driver.findElement(By.xpath("//*[@id='dCartWrapper']/div[2]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div")).click();
  driver.findElement(By.xpath("(//div[@class='delete-btn'])[2]")).click();
  driver.quit();
  
	}

}
/*1) Go to the URL https://www.ajio.com/shop/sale "
2) Enter Bags in the Search field and Select Women Handbags 
3) Click on five grid and Select SORT BY as "What's New"
4) Click Price on the side menu and Enter Price Range Min as 2000 and Max as 5000
5) Click on the first product 
6) Get the actual price, coupon code and discount price
7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
8) Click on Other Informations under Product Details and Print the Customer Care details
9) Click on ADD TO BAG and then GO TO BAG 
10) Check the Order Total before apply coupon 
11) Enter Coupon Code and Click Apply 
12) Print the warning message if the product is not eligible discount
    12(a) Verify the bill amount is matching with the discount price or not 
13) Click on Delete and Delete the item from Bag 
14) Close all the browsers
 String Window1= driver.getWindowHandle();
		 Set<String> winshow= driver.getWindowHandles();
		    
			System.out.println(winshow.size());
			
			
			List <String>firstwin=new ArrayList<String>(winshow);
			driver.switchTo().window(firstwin.get(2));
			

*/
