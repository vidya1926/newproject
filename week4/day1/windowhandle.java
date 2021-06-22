package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandle {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		
	    String Window1= driver.getWindowHandle();
	    
	    driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
	    Set<String> winshow= driver.getWindowHandles();
	    
		System.out.println(winshow.size());
		
		//driver.switchTo().frame(1);	
		List <String>firstwin=new ArrayList<String>(winshow);
		driver.switchTo().window(firstwin.get(2));
		System.out.println(driver.getTitle());
		driver.switchTo().window(firstwin.get(1));
		System.out.println(driver.getTitle());
		driver.quit();
		
	}

}
