package contacts_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_Repository.Contacts_InfoPage;
import Object_Repository.Contacts_LookUp_Page;
import Object_Repository.CreateNew_ContactPage;
import Object_Repository.Home_Page;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.Java_Utility;

@Listeners(generic_Utilities.ListnersImplimentaion.class)
public class Create_Contact_Test extends BaseClass {

	@Test(groups = "SmokeSuite",retryAnalyzer = generic_Utilities.RetryAnaliserImplimentation.class)
	public void createContact() throws Throwable {
	
		//Step 1:Click on Contacts Link
		Home_Page hp=new Home_Page(driver);
		hp.Contacts_Link();
		Reporter.log("Click on Contacts Link Sucessful",true);
		
		//Step 2:Click on Contacts Lookup image
		Contacts_LookUp_Page cl=new Contacts_LookUp_Page(driver);
		Thread.sleep(3000);
		cl.Contacts_LookUpImg();
		Reporter.log("Click on Contacts Lookup image Sucessful",true);
		
		//Step 3:Enter Last name Using Excel Utility 
		Java_Utility ju=new Java_Utility();
		int rand=ju.getRandomNumber();
		Excel_Utility eu=new Excel_Utility();
		String LASTNAME=eu.getExcelData("Contacts",1,2)+rand;
		
		CreateNew_ContactPage cnc=new CreateNew_ContactPage(driver);
		cnc.Contact_LastNameEdt(LASTNAME);
		
		Reporter.log("Enter Last name Using Excel Utility Sucessful",true);
		
		//Step 4 :Validate the Contact
		Contacts_InfoPage ci=new Contacts_InfoPage(driver);
		String Actual=ci.Contact_Header();
		
		Assert.assertTrue(Actual.contains(LASTNAME));
		Reporter.log("Contact Created Sucessfully",true);
		
	}
	
}
