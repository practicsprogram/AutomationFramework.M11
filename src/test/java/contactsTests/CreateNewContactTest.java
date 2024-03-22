package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createNewContactWithMandatoryFields() throws EncryptedDocumentException, IOException
	{
		/*Read Test Data - Excel File*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		// Step 3: Navigate to Contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		// Step 4: Click ON Create Contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		
		// Step 5: Create Contact with Mandatory Information and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContacts(LASTNAME);
		
//		Assert.fail();
		
		// Step 6: Validate for the Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
	}
	
	@Test
	/*this will not run from suite because grouping is not done*/
	public void sample()
	{
		System.out.println("DEMO");
	}
	
	@Test
	public void Demo()
	{
		System.out.println("Just check for poll SCM in jenkins");
	}
}
