package ArekCompany.SeleniumFrameworkDesigne;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ArekCompany.TestComponents.BaseTest;

//arek@wp.pl
//6kV3@Jbyuq7bJ8k 

public class SubmitOrderTest extends BaseTest {

	@Test
	public void SubmitOrder() throws IOException {
		String productName = "ZARA COAT 3";
		String confirmationMessage = "THANKYOU FOR THE ORDER.";

		ProductCataloge cataloge = landingPage.login("arek@wp.pl", "6kV3@Jbyuq7bJ8k");

		cataloge.addProductToCart(productName);

		CartPage cart = cataloge.goToCart();

		Assert.assertTrue(cart.verifyIfProductIsInCart(productName));

		CheckoutPage checkout = cart.goToCheckout();
		checkout.selectCountry("india");

		ConfirmationPage confirmationPage = checkout.submit();

		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase(confirmationMessage));
	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrderHistoryTest() {
		ProductCataloge cataloge = landingPage.login("arek@wp.pl", "6kV3@Jbyuq7bJ8k");
		OrderPage order = cataloge.goToOrderPage();
		Assert.assertTrue(order.verifyOrderDisplay("ZARA COAT 3"));
	}

}
