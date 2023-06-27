package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber_config_utils.CommonUtils;
import cucumber_config_utils.ElementsUtils;

public class LoginPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(id = "input-email")
	private WebElement inputEmailField;

	@FindBy(id = "input-password")
	private WebElement inputPasswordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement warningMsg;

	public void enterEmailAddress(String email) {
		elementsUtils.typeTextIntoElement(inputEmailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String password) {
		elementsUtils.typeTextIntoElement(inputPasswordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public AccountPage clickOnLoginBtn() {
		elementsUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}

	public String getWarningMsg() {
		return elementsUtils.getTextFromElement(warningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
