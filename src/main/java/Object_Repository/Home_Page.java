package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utilities.Webdriver_Utility;

public class Home_Page {

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationlink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactslink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminsignoutimg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutlink;
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getAdminsignoutimg() {
		return adminsignoutimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	//Business Class
	public void Organization_Link() {
		organizationlink.click();
	}
	
	public void Contacts_Link() {
		contactslink.click();
	}
	
	public void Signout_Application(WebDriver driver) {
		Webdriver_Utility wu=new Webdriver_Utility();
		wu.mouseMoveto_Element(driver, adminsignoutimg);
		
		signoutlink.click();
	}
	
}
