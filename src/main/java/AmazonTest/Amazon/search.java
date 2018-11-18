package AmazonTest.Amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class search {
	
	//Locator
	
	@FindBy(how = How.ID , using="twotabsearchtextbox")
	private WebElement search_text;
	
	@FindBy(how = How.ID , using="searchDropdownBox")
	private WebElement search_dropdown;
	
	@FindBy(how = How.XPATH , using="//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal' and contains(text(),'Head First Java')]")
    private WebElement selected_book;
	
	
	private WebDriver driver;
	
	public search(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void searchitem(String category,String item)
	{
		Select sel=new Select(search_dropdown);
		sel.selectByVisibleText(category);
		search_text.sendKeys(item);
		search_text.sendKeys(Keys.RETURN);
		
	}
   
	public void click_item()
	{
		selected_book.click();
	}
	
	
}
