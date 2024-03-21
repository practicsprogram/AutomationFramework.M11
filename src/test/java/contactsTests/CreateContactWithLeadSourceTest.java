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
public class CreateContactWithLeadSourceTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void createContactWithLeadSource() throws EncryptedDocumentException, IOException
	{
		/*Read Test Data - Excel File*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADNAME = eUtil.readDataFromExcel("Contacts", 4, 3);
		
		//Step 3: Navigate to Contact Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		// Step 4: Click ON Create Contact Look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
				
		// Step 5: Create Contact With Mandatory Information and save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContacts(LASTNAME, LEADNAME);
				
		// Step 6: Validate for the Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
	}
}
