package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1: Create a separate POM class for every web page
	
	//Rule 2: identify the web elements using @FindBy
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
		
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
		
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
		
	//Rule 3: Create a constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: provide Getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
		
	//Business Library - Generic Methods related to Project
	/**
	 * This method will perform Login Operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD) {
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}