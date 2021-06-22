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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pepperfry {
@Test
	public  void pepperfry() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notification");
		
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.pepperfry.com");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		driver.findElementByXPath("//*[@id=\"regPopUp\"]/a").click();
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	       driver.findElement(By.className("close")).click();
	        driver.switchTo().defaultContent();	        
		Thread.sleep(3000);
		WebElement furniture=driver.findElementByXPath("//*[@id='menu_wrapper']/ul/li[1]/a");
        actions.moveToElement(furniture).perform();
       WebElement chair= driver.findElement(By.linkText("Office Chairs"));
       actions.click(chair).perform();
        driver.findElement(By.xpath("(//div[@class='cat-wrap-img'])[2]")).click();
        driver.findElement(By.xpath("//input[@class='clipFilterDimensionHeightValue']")).sendKeys("50",Keys.ENTER);
        driver.findElementByXPath("//input[@id='search']").sendKeys("Galician High Back",Keys.ENTER);
        driver.findElement(By.xpath("//a[@data-productname='Galician High Back Executive Chair in Black Colour']")).click();
        WebElement bedroom = driver.findElement(By.linkText("Bedroom"));
        actions.moveToElement(bedroom).perform();
        driver.findElement(By.xpath("//*[@id='meta-bedroom']/div/div[4]/div[2]/div[3]/a")).click();
        driver.findElement(By.xpath("//label[@for='brandsnameSpacewood']")).click();
       
          WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   	
	     WebElement choose= driver.findElement(By.xpath("//label[text()='₹ 7,000 to ₹ 8,000']"));
          actions.click(choose).perform();		
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	       driver.findElement(By.className("close")).click();
	        driver.switchTo().defaultContent();
	        Thread.sleep(2000);
		WebElement table=driver.findElement(By.xpath("//a[@data-productname='SOS Carter Study Table in Lorraine walnut & silver grey Finish']"));
		table.click();
		String cartcount = driver.findElement(By.xpath("//span[@class='header-nav-cnt count_alert']")).getText(); 
		System.out.println(cartcount);
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)'])[2]")).click();
		driver.findElement(By.xpath("//a[@class='addtocart_icon']")).click();
		driver.findElement(By.xpath("//*[@id='minicart_footer']/div/a")).click();
        driver.findElement(By.id("pin_code")).sendKeys("600028");
        driver.findElement(By.id("pin_check")).click();
        driver.findElement(By.xpath("//a[@class='btn_green_big']")).click();
        
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File file = new File("C://demo/snap3.jpg");
        FileUtils.copyFile(screenshotAs, file);
        driver.close();

	}

	

	
	
	
}
