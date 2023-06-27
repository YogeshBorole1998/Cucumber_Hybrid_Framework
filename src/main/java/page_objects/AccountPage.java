package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber_config_utils.CommonUtils;
import cucumber_config_utils.ElementsUtils;

public class AccountPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement EditYourAccountInformationOption;

	public boolean displayStatusOfEditYourAccountInformationOption() {
		return elementsUtils.displayStatusOfElement(EditYourAccountInformationOption,
				CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
