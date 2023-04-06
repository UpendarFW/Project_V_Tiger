package organization_Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_Repository.CreateNew_OrganizationPage;
import Object_Repository.Home_Page;
import Object_Repository.Organization_Information_Page;
import Object_Repository.Organization_LookupPage;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.Java_Utility;

@Listeners(generic_Utilities.ListnersImplimentaion.class)
public class Create_OrgWithIndustry_TypeTest extends BaseClass {

	@Test(groups = "SmokeSuite",retryAnalyzer = generic_Utilities.RetryAnaliserImplimentation.class)
	public void createOrganizationWith_IndustryType() throws Throwable {
		//Step 1:Click on Organizations Link
		Home_Page hp=new Home_Page(driver);
		hp.Organization_Link();
		
		Reporter.log("Click on Organizations Link Sucess",true);
		
		//Step 2:Click on Organization lookup image
		Organization_LookupPage ol=new Organization_LookupPage(driver);
		Thread.sleep(3000);
		ol.Organization_LookupImg();
		Reporter.log("Click on Organization lookup image Sucessful",true);
		
		//Step 3:Enter Organization name and Industry Type Using Excel utility
		Java_Utility ju=new Java_Utility();
		int rand=ju.getRandomNumber();
		
		Excel_Utility eu=new Excel_Utility();
		String ORGNAME=eu.getExcelData("Organizations",7,2)+rand;
		String INDUSTRYNAME=eu.getExcelData("Organizations",7,3);
		String TYPE=eu.getExcelData("Organizations",7,4);
		
		CreateNew_OrganizationPage cn=new CreateNew_OrganizationPage(driver);
		cn.Org_Name_Industry_Type_Save(ORGNAME, INDUSTRYNAME, TYPE);
		
		Reporter.log("Enter Organization name and Industry and Type Using Excel utility Sucessful",true);

		//Step 4:Validate the Organization
		Organization_Information_Page oi=new Organization_Information_Page(driver);
		String Actual=oi.Organization_Header();
		
		Assert.assertTrue(Actual.contains(ORGNAME));
	}
}
