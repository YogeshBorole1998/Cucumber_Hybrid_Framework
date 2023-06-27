package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber_config_utils.CommonUtils;
import cucumber_config_utils.ElementsUtils;

public class SearchResultPage {
	WebDriver driver;
	private ElementsUtils elementsUtils;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementsUtils = new ElementsUtils(driver);
	}

	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement warningMsg;

	public boolean verifyValidHPProductStatus() {
		return elementsUtils.displayStatusOfElement(validHPProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getNoMatchWarningMsg() {
		return elementsUtils.getTextFromElement(warningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
