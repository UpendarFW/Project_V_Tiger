package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utilities.Webdriver_Utility;



public class CreateNew_OrganizationPage extends Webdriver_Utility{

	@FindBy(name = "accountname")
	private WebElement organizationnameEdt;
	
	@FindBy(name = "industry")
	private WebElement orgindustry;
	
	@FindBy(name = "accounttype")
	private WebElement orgaccounttype;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement organizationsaveBtn;

	//Create Constructor
	public CreateNew_OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Getters For Elements
	public WebElement getOrganizationnameEdt() {
		return organizationnameEdt;
	}

	public WebElement getOrgindustry() {
		return orgindustry;
	}

	public WebElement getOrgaccounttype() {
		return orgaccounttype;
	}
	
	public WebElement getOrganizationsaveBtn() {
		return organizationsaveBtn;
	}
	//Business class
	public void OrganizationName_Edt(String ORGNAME) {
		organizationnameEdt.sendKeys(ORGNAME);
		organizationsaveBtn.click();
	}
	
	public void OrganizationName_IndustryDrop(String ORGNAME,String orgIndustry) {
		organizationnameEdt.sendKeys(ORGNAME);
		handleDropdownBy_Value(orgindustry,orgIndustry);
		organizationsaveBtn.click();
	}
	
	public void OrganizationNAme_Type(String ORGNAME,String orgType) {
		organizationnameEdt.sendKeys(ORGNAME);
		handleDropdownBy_Value(orgaccounttype, orgType);
		organizationsaveBtn.click();
	}
	
	
	/**
	 * This Method will use to perform Organization Name,Industry,Type operation at a time
	 * @param orgName
	 * @param orgIndustry
	 * @param orgType
	 */
	public void Org_Name_Industry_Type_Save(String orgName,String orgIndustry,String orgType) {
		organizationnameEdt.sendKeys(orgName);
		handleDropdownBy_Value(orgindustry, orgIndustry);
		handleDropdownBy_Value(orgaccounttype, orgType);
		organizationsaveBtn.click();
	}
	
}
