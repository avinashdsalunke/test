package org.rahulshetty1;




import org.rahulshetty.TestUtils.AndroidBaseTest;
import org.rahulshettyacademy.pageObjects.android1.CartPage1;
import org.rahulshettyacademy.pageObjects.android1.ProductCatalogue1;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {

	
	@Test (dataProvider="getdata")
	public void FillForm(String name,String gender,String country) throws InterruptedException
	{
		
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		ProductCatalogue1 productcatalogue1= formPage.submitForm();
	
		//ProductCatalogue1 productcatalogue1 =new ProductCatalogue1(driver);
		productcatalogue1.addItemToCartByIndex(0);
		productcatalogue1.addItemToCartByIndex(0);
		CartPage1 CartPage1= productcatalogue1.GotoCartPage();
	
		double totalSum = CartPage1.getProductsSum();
		double displayFormattedSum = CartPage1.getTotalAmountDisplayed();
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		CartPage1.acceptTermsConditions();
		CartPage1.submitOrder();
		
		
	}
	
	@DataProvider
	public Object[][] getdata() {
		
		return new Object[][] { 
		{"rahul shetty","Female","Argentina"},{"rahul hhh shetty","male","Argentina"} ,{"pritam","male","Argentina"} };
	}
	
	
}





































