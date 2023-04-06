package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_LookupPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement organizationlookupimg;
	
	//Create Constructor
	public Organization_LookupPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationlookupimg() {
		return organizationlookupimg;
	}
	
	//Business Class
	public void Organization_LookupImg() {
		organizationlookupimg.click();
	}
	
}
