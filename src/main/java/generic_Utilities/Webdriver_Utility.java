package generic_Utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility {

	public void Maximize_Window(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void Minimize_Window(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void reSize_Page(WebDriver driver,int width,int height) {
		driver.manage().window().setSize(new Dimension(width,height));
	}
	
	public void reLocate_Page(WebDriver driver,int X_axis,int Y_axis) {
		driver.manage().window().setPosition(new Point(X_axis,Y_axis));
	}
	
	public void switchWindow(WebDriver driver,String PAGENAME) {
		Set<String>win=driver.getWindowHandles();
		Iterator<String>it=win.iterator();
		
		while(it.hasNext()) {
			String child=it.next();
			driver.switchTo().window(child);
			String title=driver.getTitle();
			
			if(title.contains(PAGENAME)) {
				break;
			}
		}
	}
	
	public void handleDropdownBy_Value(WebElement element,String ValueName) {
		Select s=new Select(element);
		s.selectByValue(ValueName);
	}
	

	public void handleDropdownBy_Text(WebElement element,String Text) {
		Select s=new Select(element);
		s.selectByVisibleText(Text);
	}
	
	public void handleDropdownBy_Index(WebElement element,int IndexNumber) {
		Select s=new Select(element);
		s.selectByIndex(IndexNumber);
	}
	
	public void mouseMoveto_Element(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void mouseRightClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick();
	}
	
	public void mouseRightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	
	public void mouseMoveto_ElementRightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().perform();
	}
	
	public void mouse_DoubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick();
	}
	
	public void mouse_DoubleClickElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	
	public void mouseMoveto_ElementDoubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).doubleClick().perform();
	}

	public void pageDown() throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	public void handleFrame_ByIndex(WebDriver driver,int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	public void handleFrame_BynameORid(WebDriver driver,String nameORid) {
		driver.switchTo().frame(nameORid);
	}
	
	public void handleFrame_ByElement(WebDriver driver,WebElement Frameelement) {
		driver.switchTo().frame(Frameelement);
	}
	
	public void handle_ParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void handle_DefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void alert_Accept(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	public void alert_Dismiss(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	
	public String alert_GetText(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		String alertText=alt.getText();
		return alertText;
	}
	
	public String takeScreenShot(WebDriver driver,String ScreenShotname) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShots\\"+ScreenShotname+".png");
		
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath();
	}
}
