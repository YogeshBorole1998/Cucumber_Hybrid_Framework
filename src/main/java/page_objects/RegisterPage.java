package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber_config_utils.CommonUtils;
import cucumber_config_utils.ElementsUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementsUtils elementsUtils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneNumField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement YesNewsLetterOption;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateAccountWarningMsg;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public void enterFirstName(String firstName) {
		elementsUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterLastName(String lastName) {
		elementsUtils.typeTextIntoElement(lastNameField, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterEmail(String email) {
		elementsUtils.typeTextIntoElement(emailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterTelephoneNumber(String telephone) {
		elementsUtils.typeTextIntoElement(telephoneNumField, telephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String password) {
		elementsUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void confirmPassword(String password) {
		elementsUtils.typeTextIntoElement(confirmPasswordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectPrivacypolicyCheckbox() {
		elementsUtils.clickOnElement(privacyPolicyCheckbox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectYesForNewsLetterOption() {
		elementsUtils.clickOnElement(YesNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public AccountSuccessPage clickOnContinueBtn() {
		elementsUtils.clickOnElement(continueBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}

	public String getDuplicateAccountWarningMsg() {
		return elementsUtils.getTextFromElement(duplicateAccountWarningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getFirstNameWarning() {
		return elementsUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getLastNameWarning() {
		return elementsUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getEmailWarning() {
		return elementsUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getTelephoneWarning() {
		return elementsUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getPasswordWarning() {
		return elementsUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
