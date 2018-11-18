package AmazonTest.Amazon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyCart {

	WebDriver driver;
	public String destpath="C:\\Users\\Vibha\\eclipse-workspace\\Amazon\\Screenshots\\Mycart.jpeg";
	
	@FindBy(how = How.XPATH , using="//a[@id='hlb-view-cart-announce']")
	private WebElement cart_button;
	
	public MyCart(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void showcart()
	{
		
		cart_button.click();
		
		//taking screenshot of cart
		
		TakesScreenshot screen=((TakesScreenshot)driver);
		File srcfile=screen.getScreenshotAs(OutputType.FILE);
		
		//create new file at a destination
		File destfile=new File(destpath);
		
		//copy source file to destination
		try {
			FileUtils.copyFile(srcfile,destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
