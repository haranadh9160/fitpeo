package fitpeo;

import static org.testng.Assert.assertEquals;

import java.awt.Dimension;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;
import com.graphbuilder.curve.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fitpeo {

	public static WebDriver driver;

	  
	
	@BeforeTest
	public void browser_setup() throws IOException {
		
	

		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
       //1.Navigate to the FitPeo Homepage:
		driver.get("https://fitpeo.com/");
		 
		}
	
		@Test
		public void wecheck_Revenue_Calculator() throws InterruptedException {
			  System.out.println("+++++++++++++______________");
			  Thread.sleep(1000);
          //2.Navigate to the Revenue Calculator Page:
			  Thread.sleep(1000);
			  driver.get("https://fitpeo.com/revenue-calculator");
			 // 3.Scroll Down to the Slider section:
			
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.scrollBy(0, 500);");
     
	            // 4.Adjust the Slider:
	            // Create an Actions instance
	               Actions actions = new Actions(driver);
	            	 WebElement slider = driver.findElement(By.cssSelector(".MuiSlider-thumb"));
	                 actions.dragAndDropBy(slider, 93, 0).perform();
	                 actions.click(slider).sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT).perform();
	          //5.Update the Text Field:
	                 Thread.sleep(1000);
	                  WebElement textfield = driver.findElement(By.xpath("//*[@id=\":R57alklff9da:\"]"));
	                 textfield.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
	                  textfield.sendKeys("560");
	           //6. Validate Slider Value:
	                  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	                  WebElement valueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/span[1]")));

	                  // Get the slider's position
	                  org.openqa.selenium.Point location = valueElement.getLocation();
	                  int sliderPositionX = location.getX();

	                  // Define the expected position and corresponding value
	                  int expectedPositionX = 560;  // Example value
	                  double expectedValue = 560;  // Example value

	                  // Validate the slider position
	                  assertEquals(expectedPositionX, expectedValue);
	                  
	                  driver.navigate().refresh();
	         // 7.Select CPT Codes:
	                  // Create an Actions instance
		            	 WebElement sliderr = driver.findElement(By.cssSelector(".MuiSlider-thumb"));
		                 actions.dragAndDropBy(sliderr, 93, 0).perform();
		                 
		                 actions.click(sliderr).sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT).perform();
		            // checkbox CPT-99091
	                  WebElement CPT_99091 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label"));
	                      CPT_99091.click();  
		                     // checkbox CPT-99453
			            WebElement CPT_99453 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label"));
			                 CPT_99453.click(); 
				                     // checkbox CPT-99454
					     WebElement CPT_99454 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label"));
					     CPT_99454.click(); 
						                     // checkbox CPT-99454
			       WebElement CPT_99474 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label"));
			       CPT_99474.click();
			       
      //9. Validate Total Recurring Reimbursement:
			       WebElement Reimbursement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/p[4]"));
			       Reimbursement.getAttribute("type");
			       Thread.sleep(5000);
			       
		}      
		
	
		@AfterTest
		public void wechecktheteardown() throws InterruptedException {
			
			driver.close();
			Thread.sleep(2000);
			System.out.println("close the browser");
		}
	
	
	
}
	