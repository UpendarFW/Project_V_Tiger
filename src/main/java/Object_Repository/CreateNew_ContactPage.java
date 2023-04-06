package Object_Repository;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utilities.Webdriver_Utility;



public class CreateNew_ContactPage {

	@FindBy(name = "lastname")
	private WebElement lastnameedt;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orglookupimg;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement contactsavebtn;

	@FindAll({ @FindBy(id = "search_txt"), @FindBy(name = "search_text") })
	private WebElement orgsearchEdt;

	@FindBy(name = "search")
	private WebElement orgsearchBtn;

	public CreateNew_ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameedt() {
		return lastnameedt;
	}

	public WebElement getOrglookupimg() {
		return orglookupimg;
	}

	public WebElement getContactsavebtn() {
		return contactsavebtn;
	}

	// Business class
	public void Contact_LastNameEdt(String lastname) {
		lastnameedt.sendKeys(lastname);
		contactsavebtn.click();
	}

	public void Contact_Lastname_OrgImg_Save(WebDriver driver, String lastname, String orgName) {
		lastnameedt.sendKeys(lastname);
		orglookupimg.click();

		// Child Window of ORGANIZATION AND search
		Webdriver_Utility wu = new Webdriver_Utility();
		wu.switchWindow(driver, "Accounts&action");
		orgsearchEdt.sendKeys(orgName);
		orgsearchBtn.click();

		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wu.switchWindow(driver,"Contacts&action");
		
		contactsavebtn.click();
	}
}
