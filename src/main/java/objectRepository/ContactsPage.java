package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//Rule 1: Create a Separate POM class for every web pages
	
	//Rule 2: identify the web elements using @FindBy
	// declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookupImg;
		
	//Rule 3: Create Constructor - Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//Rule 4: Provide Getters - Utilization
	public WebElement getCreateContactLookupImageEdt() {
		return createContactLookupImg;
	}
		
	//Business Library - Generic Method related to Project
	/**
	 * This method will click on create contact look Up Image
	 */
	public void clickOnCreateContactLookupImg()
	{
		createContactLookupImg.click();
	}
}
