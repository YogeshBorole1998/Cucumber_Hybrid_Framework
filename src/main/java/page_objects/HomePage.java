package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber_config_utils.CommonUtils;
import cucumber_config_utils.ElementsUtils;

public class HomePage {

	WebDriver driver;
	private ElementsUtils elementsUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement serachBoxField;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement serachBtn;

	public void clickOnMyAccount() {
		elementsUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public LoginPage selectLoginOption() {
		elementsUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}

	public RegisterPage selectRegisterOption() {
		elementsUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}

	public void enterProductIntoSearchBox(String product) {
		elementsUtils.typeTextIntoElement(serachBoxField, product, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public SearchResultPage clickOnSearchBtn() {
		elementsUtils.clickOnElement(serachBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultPage(driver);
	}

}
