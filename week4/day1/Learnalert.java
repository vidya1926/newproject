package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learnalert {

	public static void main(String[] args) {
		// TODO Auto-generated method stubpublic static void main(String[] args) {
		
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		driver.manage().window().maximize();
		driver.switchTo().frame(1);		
		 driver.findElement(By.xpath("//html/body/button\r\n")).click();	
		 Alert alert =driver.switchTo().alert();
		 System.out.println(alert.getText());
		 alert.accept();
		System.out.println(driver.findElement(By.xpath("//*[@id='demo']")).getText());
		//System.out.println(text);
	}

}
