package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {//Rule 1: Create a separate POM Class for every web pages
	
	//Rule 2: identify the web elements using @FindBy
		@FindBy(className = "dvHeaderText")
		private WebElement contactHeaderText;
		
		//Rule 3: Create Constructor - Initialization
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Rule 4: Provide Getters - Utilization
		public WebElement getContactHeaderText() {
			return contactHeaderText;
		}
		
		//Business Library - Generic Method related to Project
		/**
		 * This method will capture header text and return it to caller
		 * @return
		 */
		public String captureContactHeader()
		{
			return contactHeaderText.getText();
		}
}
