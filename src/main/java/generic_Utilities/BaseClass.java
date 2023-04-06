package generic_Utilities;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Object_Repository.Home_Page;
import Object_Repository.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public File_Utility fu=new File_Utility();
	public Excel_Utility eu=new Excel_Utility();
	public Java_Utility ju=new Java_Utility();
	public Webdriver_Utility wu=new Webdriver_Utility();
	
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void BeforeSuite() {
		System.out.println("DataBase Connection Sucessful");
	}
	@BeforeTest(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void BeforeTest() {
		System.out.println("Before Test");
	}
	
	
	/*@Parameters("browser") //This is for Cross Browser Execution
	@BeforeClass(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void launch_Browser(String BROWSER) throws Throwable {
	*/
	@BeforeClass(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void launch_Browser() throws Throwable {
		
		String BROWSER=fu.getDataFromProperty("browser");
		
		
		if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
			
			System.out.println(BROWSER+"--->"+"Launched Sucessfully");
		}
		
		else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();	
			
			System.out.println(BROWSER+"--->"+"Launched Sucessfully");
		}
		else if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			System.out.println(BROWSER+"--->"+"Launched Sucessfully");
		}
		
		else {
			System.out.println("Invalid Browser");
		}
		
		sDriver=driver;
        wu.Maximize_Window(driver);
		wu.implicitlyWait(driver);
		
		String URL=fu.getDataFromProperty("url");
		driver.get(URL);
		
		
		
		
	}
	
	@BeforeMethod(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	
	public void login_application() throws Throwable {
		
		Login_Page lp=new Login_Page(driver);
		
		lp.login_Application();
		
		System.out.println("===Login Sucessful===");
	}
	
	@AfterMethod(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void logout_Application() {
		Home_Page hp=new Home_Page(driver);
	
		hp.Signout_Application(driver);
		
		System.out.println("===SignOut Sucessful===");
	}
	
	@AfterClass(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void close_Driver() {
		driver.quit();
		System.out.println("===Driver Closed===");
	}
	
	@AfterTest(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void AfterTest() {
		System.out.println("After Test");
	}
	
	@AfterSuite(alwaysRun = true,groups ={"SmokeSuite","RegressionSuite"})
	public void AfterSuite() {
		System.out.println("====DB Connection Closed===");
	}
}
