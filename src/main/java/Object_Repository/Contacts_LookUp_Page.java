package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts_LookUp_Page {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactslookupimg;
	
	public Contacts_LookUp_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Getters
	public WebElement getContactslookupimg() {
		return contactslookupimg;
	}
	
	//Business cls
	public void Contacts_LookUpImg() {
		contactslookupimg.click();
	}
	
}
