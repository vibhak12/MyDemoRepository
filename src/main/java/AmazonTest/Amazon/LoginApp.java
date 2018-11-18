package AmazonTest.Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LoginApp {
	
	//Locator:email
	@FindBy(how = How.ID , using="ap_email")
	private WebElement user_email;
	
	@FindBy(how = How.ID , using ="continue")
	private WebElement cont;
	
	@FindBy(how = How.ID , using="ap_password")
	private WebElement user_pass;
	
	@FindBy(how = How.ID , using="signInSubmit")
	private WebElement signbutton;
	
	@FindBy(how = How.XPATH , using="//*[@id='nav-link-yourAccount']/span[1]")
	private WebElement acc_link;
	
	@FindBy(how = How.XPATH , using="//a[@href='https://www.amazon.ca/gp/profile?ref_=ya_d_l_profile']")
	//@FindBy(how = How.XPATH , using="//span[@class='a-list-item']//a[contains(text(),'Profile')]")
	private WebElement profile_link;
	
	//@FindBy(how = How.XPATH , using="//input[@name='name']")
	@FindBy(how = How.XPATH , using="//div[@class='a-row a-spacing-none name-container']/span")
	private WebElement public_user_name;
	
	
	
	public String user_name;
	private WebDriver driver;
	
	
	public LoginApp(WebDriver driver)
	{
	     this.driver=driver; 	
		
		//Initialize the elements
	     	PageFactory.initElements(driver,this);     	     	
	}
	
	
	public HomePage login(String emailaddr,String pass)
	{
		
		
		
		user_email.clear();
		user_email.sendKeys(emailaddr);
		user_pass.sendKeys(pass);
		signbutton.click();
		
		return new HomePage(driver);
		//String text= driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]")).getText();
	
		//Assert.assertTrue("Incorrect login/password", text.contains("Vibhavari"));		
		
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	/*public void click_continue()
	{
		cont.click();
		
	}*/
	
	
	public void successful_login() 
	{
		
		user_name=acc_link.getText();
		acc_link.click();
		profile_link.click();
		Assert.assertEquals("Log-In failed", (user_name.contains(public_user_name.getText())));
	}
	
	}