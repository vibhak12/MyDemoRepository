package AmazonTest.Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	

	//Locators
	
	
	@FindBy(how = How.XPATH , using=".//*[@id='twotabsearchtextbox']")
	private WebElement search_text;
	
	@FindBy(how = How.XPATH , using="//div[@id='nav-signin-tooltip']//span[contains(text(),'Sign in')]")
	private WebElement signinbutton;
	
	public HomePage(WebDriver driver)
	{
		
		this.driver=driver; 	
		
		//Initialize Element
		PageFactory.initElements(driver, this);
	}
	
	public LoginApp sign_in()
	{
		
		Actions act=new Actions(driver); 
		act.moveToElement(signinbutton).build().perform();
		
		signinbutton.click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return new LoginApp(driver);
	}
	

	
}

