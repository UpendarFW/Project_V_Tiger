package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utilities.Webdriver_Utility;



public class Contacts_InfoPage extends Webdriver_Utility {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteContactbtn;
	
	public Contacts_InfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Getters
	public WebElement getContactHeader() {
		return contactHeader;
	}

	public WebElement getDeleteContactbtn() {
		return deleteContactbtn;
	}
	
	//Business Class
	public String Contact_Header() {
		String contacttext=contactHeader.getText();
		return contacttext;
	}
	public void Contact_Delete(WebDriver driver) {
		deleteContactbtn.click();
		alert_Accept(driver);
		
	}
	
}
