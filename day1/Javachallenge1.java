package JavaLearning;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javachallenge1 {

	public static void main(String[] args) {

		//input="We Learn Java In Week3 Java"
				String input="We Learn Java In Week3 Java";
				String[] split = input.split(" ");
				Set<String> dupset=new LinkedHashSet<String>(Arrays.asList(split));
				dupset.retainAll(dupset);
		System.out.println(dupset);
		
	

		/*
		 * driver = new ChromeDriver(); WebDriverManager.chromedriver().setup();
		 * WebDriver driver = new ChromeDriver();
		 * 
		 * 
		 * To be validated with getShadowRoot method InProgress ,same is Successful with
		 * sugku driver.get("chrome://downloads"); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * SearchContext shadowRoot =
		 * driver.findElement(By.tagName("downloads-manager")).getShadowRoot();
		 * WebElement ele = shadowRoot.findElement(By.cssSelector("#searchInput"));
		 * Thread.sleep(10000); ele.sendKeys("test");
		 * 
		 * 
		 * 
		 * Handling shadow DOM with sugku external maven dependency
		 * driver.get("chrome://downloads"); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); Shadow
		 * shadow = new Shadow(driver); WebElement ele =
		 * shadow.findElementByXPath("//input[@id='searchInput']");
		 * ele.sendKeys("test shadow dom");
		 * 
		 * 
		 * 
		 * 
		 * getShadowRoot method from webElement Interface
		 * driver.get("https://books-pwakit.appspot.com/explore?q=");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * SearchContext shadowRoot =
		 * driver.findElement(By.tagName("book-app")).getShadowRoot();
		 * shadowRoot.findElement(By.id("input")).sendKeys("test");
		 * return.document.querySelector("body > book-app").shadowRoot.querySelector(
		 * "#input");
		 * 
		 * 
		 * getShadowRoot supporting only JavaScript
		 * driver.get("http://watir.com/examples/shadow_dom.html");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * SearchContext shadowRoot =
		 * driver.findElement(By.id("shadow_host")).getShadowRoot(); WebElement ele =
		 * shadowRoot.findElement(By.linkText("scroll.html")); Thread.sleep(10000);
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", ele);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */ }

}
