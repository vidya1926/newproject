package week4.day1;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
public static void main(String[] args) throws InterruptedException, IOException {
	
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	ChromeOptions Options=new ChromeOptions();
	Options.addArguments("--disable-notification");
	
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("https://www.snapdeal.com");
	driver.manage().window().maximize();
	Actions actions = new Actions(driver);
	WebElement target = driver.findElement(By.xpath(
			"//div[@id='leftNavMenuRevamp']/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
	actions.moveToElement(target).perform();
	driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
	String  items = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
	System.out.println("The count of the sports shoes  :" +items);

	driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	String tshoe = driver.findElement(By.className("category-count")).getText();
	System.out.println(tshoe);
	Thread.sleep(7000);
	driver.findElement(By.xpath("//span[text()='Sort by:']")).click();

	driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();	
	
	 WebDriverWait wait=new WebDriverWait(driver,DurationofSeconds(60));

List<WebElement> price = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

 
 List<Integer> sort=new ArrayList<Integer>();
for (int i = 0; i < price.size(); i++) {
	
	 String text = price.get(i).getText();
	 String numbers = text.replaceAll("\\D", "");
	 int sorted = Integer.parseInt(numbers);
	 sort.add(sorted);
	 System.out.println(sorted);
	}
Collections.sort(sort);

driver.findElement(By.id("searchWithinSearch")).sendKeys("puma blue",Keys.ENTER);
Thread.sleep(3000);
actions.moveToElement(driver.findElement(By.xpath("//p[text()='Puma Blue Training Shoes']"))).perform();;
driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
Thread.sleep(3000);
String text = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
String text2 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
//Set<String> windowHandles = driver.getWindowHandles();
//System.out.println(windowHandles.size());
System.out.println("The cost is"+" "+text);
System.out.println("The discount is"+" "+text2);
File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
File file = new File("C://demo/snap2.jpg");
FileUtils.copyFile(screenshotAs, file);

driver.close();
driver.quit();

}

private static Duration DurationofSeconds(int i) {
	// TODO Auto-generated method stub
	return null;
}        
}
	

