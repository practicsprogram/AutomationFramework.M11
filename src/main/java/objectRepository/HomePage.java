package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {//Rule 1: Create a separate POM class for every web page
	
	//Rule 2: identify the web elements using @FindBy
	//Declaration - webelements - dropdown, windows, frames, mousehovering
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
		
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
		
	@FindBy(linkText = "Sign Out")
	private WebElement singoutLink;
		
	//Rule 3: Create constructor - Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: provide getters - Utilization
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSingoutLink() {
		return singoutLink;
	}
		
	//Business Library - Generic Method related to Project
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink() 
	{
		contactsLink.click();
	}
		
	/**
	 * This method will perform logout of application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutApp(WebDriver driver) throws InterruptedException 
	{
		mouseOverAction(driver, administratorImg);
		Thread.sleep(1000);
		singoutLink.click();
	}
}
