package AmazonTest.Amazon;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;

	public class ProductDetails {
		
		
		private WebDriver driver;
		
		@FindBy(how = How.ID, using="add-to-cart-button")
		private WebElement add_cart;
		
		
		public  ProductDetails(WebDriver driver)
		{
			this.driver=driver;
			
			PageFactory.initElements(driver,this);
			
		}
		
		public void add_to_cart()
		{
			
			add_cart.click();		
		}
		
      public void get_prod_title()
      {
           System.out.println(add_cart.getAttribute("title"));
      }
}





