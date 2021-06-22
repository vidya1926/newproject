package week4.day2;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouseactions {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://leafground.com/pages/Dropdown.html");
	
	driver.manage().window().maximize();
	WebElement item1 = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option"));
	
	WebElement item4 = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[6]/select[1]/option[5]"));
	Actions builder=new Actions(driver);
	builder.keyDown(Keys.CONTROL).click(item1).click(item4).keyUp(Keys.CONTROL).perform();
	
}
}
