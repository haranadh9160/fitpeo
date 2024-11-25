package fitpeo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class molfitpio {

	WebDriver driver;
	@Test
   public void wechecthesample() {
	   WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fitpeo.com/");
		driver.findElement(By.xpath("/html/body/div[2]/header/div/div[3]/div[6]/a/div")).click();
   }
}
