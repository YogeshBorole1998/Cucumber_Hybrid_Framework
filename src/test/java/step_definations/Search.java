package step_definations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory_driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage;
import page_objects.SearchResultPage;

public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;

	@Given("Navigate to tutorialsninja search page")
	public void navigate_to_tutorialsninja_search_page() {
		driver = DriverFactory.getDriver();
	}

	@When("Enter valid product name {string} into searchbox field")
	public void enter_valid_product_name_into_searchbox_field(String validProduct) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProduct);
	}

	@And("Click on the Search button")
	public void click_on_the_search_button() {
		searchResultPage = homePage.clickOnSearchBtn();
	}

	@Then("User should get valid product displayed in the search result")
	public void user_should_get_valid_product_displayed_in_the_search_result() {
		Assert.assertTrue(searchResultPage.verifyValidHPProductStatus());
	}

	@When("Enter invalid product name {string} into searchbox field")
	public void enter_invalid_product_name_into_searchbox_field(String invalidProduct) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.",
				searchResultPage.getNoMatchWarningMsg());
	}

	@When("Do not enter any product name into searchbox field")
	public void do_not_enter_any_product_name_into_searchbox_field() {
		homePage = new HomePage(driver);
	}

}
