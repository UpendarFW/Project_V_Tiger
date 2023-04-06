package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utilities.Webdriver_Utility;



public class Organization_Information_Page extends Webdriver_Utility{

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationHeader;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement orgdeletebtn;
	
	@FindBy(xpath = "//span[@class='genHeaderSmall']")
	private WebElement orgdeleteVerify;
	
	//Initiate Constructor with Parameter
	
	public Organization_Information_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getters
	
	public WebElement getOrganizationHeader() {
		return organizationHeader;
	}

	public WebElement getOrgdeletebtn() {
		return orgdeletebtn;
	}
	
	//Business Class
	
	public String Organization_Header() {
		String OrgText=organizationHeader.getText();
		return OrgText;
	}
	
	public void  Organization_Delete(WebDriver driver) {
		orgdeletebtn.click();
		//Accept Alert popup
		alert_Accept(driver);
		
	}
	
}
