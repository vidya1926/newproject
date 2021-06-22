package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Railalert {

	public static void main(String[] args) throws InterruptedException {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notification");
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
driver.findElement(By.xpath("//button[text()='OK']")).click();
Thread.sleep(3000);
		
		driver.findElement(By.linkText("FLIGHTS")).click();
		
	 Set<String> winshow= driver.getWindowHandles();
		    
		System.out.println(winshow.size());
		
		
		List <String>firstwin=new ArrayList<String>(winshow);
		String window2=firstwin.get(1);
		driver.switchTo().window(window2);
		String flightsirctccoin = driver.findElement(
		By.xpath("(//div[contains(@class,'block-nav-right d-none')]//a)[3]")).getText();
		System.out.println(flightsirctccoin);

				
		System.out.println(driver.getTitle());
		String window1=firstwin.get(0);
		driver.switchTo().window(window1);
		driver.close();
		 Set<String> winopen= driver.getWindowHandles();

		System.out.println(winopen.size());

		
}}
