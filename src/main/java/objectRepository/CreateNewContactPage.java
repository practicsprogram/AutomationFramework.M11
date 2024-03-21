package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {//Rule 1: Create a Separate POM Class for every web pages
	
	//Rule 2: identify the web elements using @FindBy
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
		
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
		
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
		
	//Rule 3: Create Constructor - Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide Getters - Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
		
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	//Business Library - Generic Method related to Project
	/**
	 * This method will create new contacts and Savw
	 * @param LASTNAME
	 */
	public void createNewContacts(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
		
	/**
	 * This method will create new contact with lead source dropdown and save
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContacts(String LASTNAME, String LEADSOURCE)
	{
		lastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropDown, LEADSOURCE);
		saveBtn.click();
	}


}
