package step_definations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber_config_utils.CommonUtils;
import factory_driver.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.AccountSuccessPage;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class Register {
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;

	@Given("Navigate to tutorialsninja Register Account page")
	public void navigate_to_tutorialsninja_register_account_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);

		homePage.clickOnMyAccount();
		registerPage = homePage.selectRegisterOption();
	}

	@When("Enters the details into below fields")
	public void enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		commonUtils = new CommonUtils();
		registerPage.enterEmail(commonUtils.generateRandomEmail());
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.confirmPassword(dataMap.get("password"));
	}

	@When("Enters the duplicate details into below fields")
	public void enters_the_duplicate_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.confirmPassword(dataMap.get("password"));
	}

	@And("Select privacy policy checkbox")
	public void select_privacy_policy_checkbox() {
		registerPage.selectPrivacypolicyCheckbox();
	}

	@And("Click on the Continue button")
	public void click_on_the_continue_button() {
		accountSuccessPage = registerPage.clickOnContinueBtn();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}

	@And("Select subscribe Yes for Newsletter")
	public void select_subscribe_yes_for_newsletter() {
		registerPage.selectYesForNewsLetterOption();
	}

	@Then("User should get a warning message like E-Mail Address is already registered")
	public void user_should_get_a_warning_message_like_e_mail_address_is_already_registered() {
		Assert.assertTrue(registerPage.getDuplicateAccountWarningMsg()
				.contains("Warning: E-Mail Address is already registered!"));
	}

	@When("do not enters any details into all fields")
	public void do_not_enters_any_details_into_all_fields() {
		// Intentionally Kept Blank OR Pass Empty Data
	}

	@Then("User should get a warning message for every mandatory field including Privacy Policy")
	public void user_should_get_a_warning_message_for_every_mandatory_field_including_privacy_policy() {

		Assert.assertTrue(registerPage.getDuplicateAccountWarningMsg()
				.contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());
	}

}
