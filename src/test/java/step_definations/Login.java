package step_definations;

import org.openqa.selenium.WebDriver;

import factory_driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.AccountPage;
import page_objects.HomePage;
import page_objects.LoginPage;

import org.junit.Assert;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;

	@Given("Navigate to tutorialsninja login page")
	public void Navigate_to_tutorialsninja_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);

		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}

	@When("^Enter valid email address (.+) in email field$")
	public void enter_valid_email_address_in_email_field(String email) {
		loginPage.enterEmailAddress(email);
	}

	@And("^Enter valid password (.+) in password field$")
	public void enter_valid_password_in_password_field(String password) {
		loginPage.enterPassword(password);
	}

	@And("Click on the Login button")
	public void click_on_the_login_button() {
		accountPage = loginPage.clickOnLoginBtn();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("Enter invalid email address {string} in email field")
	public void enter_invalid_email_address_in_email_field(String invalidEmail) {
		loginPage.enterEmailAddress(invalidEmail);
	}

	@And("Enter invalid password {string} in password field")
	public void enter_invalid_password_in_password_field(String invalidPassword) {
		loginPage.enterPassword(invalidPassword);
	}

	@Then("User should get a warning message as No match for E-Mail Address and\\/or Password.")
	public void user_should_get_a_warning_message_as_no_match_for_e_mail_address_and_or_password() {
		Assert.assertTrue(loginPage.getWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("Do not enter email address in email field")
	public void do_not_enter_email_address_in_email_field() {
		// Intentionally Kept Blank OR Pass Empty Data
	}

	@And("Do not enter password in password field")
	public void do_not_enter_password_in_password_field() {
		// Intentionally Kept Blank OR Pass Empty Data
	}

}
