package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyCartTestt {
	

		public static void main(String args[]){

		System.setProperty("webdriver.chrome.driver","C:\\Selenium Install Files\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://MycartTestEnv.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
		}

