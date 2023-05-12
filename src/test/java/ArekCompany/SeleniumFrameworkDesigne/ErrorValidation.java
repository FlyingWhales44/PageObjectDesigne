package ArekCompany.SeleniumFrameworkDesigne;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ArekCompany.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException {
		landingPage.login("ffrek@wp.pl", "6kV3@Jbyuq7bJ8k");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
	}

}
