package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import AmazonTest.Amazon.BaseClass;
import AmazonTest.Amazon.HomePage;
import AmazonTest.Amazon.LoginApp;
import junit.framework.Assert;

public class LoginPageTest extends BaseClass{
	
	LoginApp LoginPage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
		
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		homepage=new HomePage(driver);	
		LoginPage=new LoginApp(driver);
		
	}
	@Test
	public void SignIn()
	{
		
		//Create object of HomePage
		LoginPage=homepage.sign_in();
		homepage=LoginPage.login(prop.getProperty("uname"),prop.getProperty("pass"));
				
	}
	
	@Test
	public void validateTitleTest()
	{
		String title=LoginPage.validateLoginPageTitle();
		Assert.assertEquals(true,title.contains("Amazon.ca"));
		
	}
	
	/*@Test(dependsOnMethods= {"SignIn_Button"})
	public void userlogin() throws Exception
	{
		
		
        //Search a book	
		search book=new search(driver);
	    book.searchitem("Books","Head First Java");
	    book.click_item();
	    
	    //add to cart
	    ProductDetails book_detail=new ProductDetails(driver);
	    book_detail.get_prod_title();
	    book_detail.add_to_cart();
	    
	    //Check my cart
	    MyCart cart=new MyCart(driver);
	    cart.showcart();
	    
}*/
	@Test()
	public void loginPageTitleTest()
	{
		
		String title=LoginPage.validateLoginPageTitle();
		System.out.println(title);
		
	}
	
	@AfterTest
	public void Teardown()
	{
		
		driver.quit();
		
	}
	

}


