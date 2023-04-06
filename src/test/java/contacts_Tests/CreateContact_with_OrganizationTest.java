package contacts_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_Repository.Contacts_InfoPage;
import Object_Repository.Contacts_LookUp_Page;
import Object_Repository.CreateNew_ContactPage;
import Object_Repository.CreateNew_OrganizationPage;
import Object_Repository.Home_Page;
import Object_Repository.Organization_Information_Page;
import Object_Repository.Organization_LookupPage;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.Java_Utility;

@Listeners(generic_Utilities.ListnersImplimentaion.class)
public class CreateContact_with_OrganizationTest extends BaseClass {

	@Test(groups = "RegressionSuite",retryAnalyzer = generic_Utilities.RetryAnaliserImplimentation.class)
	public void createContactWith_Organization() throws Throwable {
		//Step 1:Click on Organizations Link
		Home_Page hp=new Home_Page(driver);
		hp.Organization_Link();
		
		Reporter.log("Click on Organizations Link Sucess",true);
		
		//Step 2:Click on Organization lookup image
		Organization_LookupPage ol=new Organization_LookupPage(driver);
		Thread.sleep(3000);
		ol.Organization_LookupImg();
		Reporter.log("Click on Organization lookup image Sucessful",true);
		
		//Step 3:Enter Organization name Using Excel utility
		Java_Utility ju=new Java_Utility();
		int rand=ju.getRandomNumber();
		
		Excel_Utility eu=new Excel_Utility();
		String ORGNAME=eu.getExcelData("Contacts",4,2)+rand;
		
		CreateNew_OrganizationPage cn=new CreateNew_OrganizationPage(driver);
		cn.OrganizationName_Edt(ORGNAME);
		
		Reporter.log("Enter Organization name Using Excel utility Sucessful",true);

		//Step 4:Validate the Organization
		Organization_Information_Page oi=new Organization_Information_Page(driver);
		String Actual=oi.Organization_Header();
		
		Assert.assertTrue(Actual.contains(ORGNAME));
		Reporter.log("Organization Created Sucessfully",true);
		
		//Step 5:Click on Contacts Link
		hp.Contacts_Link();
		Reporter.log("Click on Contacts Link Sucessful",true);
		
		//Step 6:Click on Contacts LookUp Image
		Contacts_LookUp_Page cl=new Contacts_LookUp_Page(driver);
		Thread.sleep(3000);
		cl.Contacts_LookUpImg();
		Reporter.log("Click on Contacts LookUp Image",true);
		
		//Step 7:Enter Lastname and Orgname using Excel Utility
		String LASTNAME=eu.getExcelData("Contacts",4,3)+rand;
		
		CreateNew_ContactPage cnc=new CreateNew_ContactPage(driver);
		cnc.Contact_Lastname_OrgImg_Save(driver,LASTNAME, ORGNAME);
		
		Reporter.log("Enter Lastname and Orgname using Excel Utility Sucessful",true);
		
		//Step 8:Validate Contact page
		Contacts_InfoPage ci=new Contacts_InfoPage(driver);
		String actual=ci.Contact_Header();
		Assert.assertTrue(actual.contains(LASTNAME));
		Reporter.log("Contact Created Sucessfully");
		
	}
	
}
