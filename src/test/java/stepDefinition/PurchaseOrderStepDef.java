package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;
import eCommerceSite.CheckOutPage;
import eCommerceSite.ConfirmPage;
import eCommerceSite.LoginPage;
import eCommerceSite.PaymentPage;
import eCommerceSite.ProductCatlogPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseOrderStepDef extends BaseTest {

	public LoginPage loginPage;
	public ProductCatlogPage prodCat;
	public CheckOutPage checkOut;
	public PaymentPage pay;
	public ConfirmPage confirm;

	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {

		loginPage = launchApplication();
	}

	@Given("Logged in with username {string} and password {string}") // Regular expression in short regex (.+)
	public void logged_in_with_username_and_password(String username, String password) {

		prodCat = loginPage.loginToApp(username, password);
		prodCat.resetPage();
	}

	@When("Add {string} to cart")
	public void add_to_cart(String productName) throws InterruptedException {

		List<WebElement> productList = prodCat.getListOfProducts();
		prodCat.addProductName(productName);

	}

	@And("Checkout {string} and submit the order")
	public void checkout_and_submit_the_order(String productName) {
		checkOut = new CheckOutPage(driver);
		checkOut.getCheckOutDetails();
		Boolean match = checkOut.matchProdctDetails(productName);
		Assert.assertTrue(match);
		pay = new PaymentPage(driver);
		pay.selectOption("IND");
		pay.placeOrder();
	}

	@Then("{string} message is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String string) {

		confirm = new ConfirmPage(driver);
		String confirmMsg = confirm.getConfirmMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase(string));
		tearDown();

	}
}
