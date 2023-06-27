package cucumber_config_utils;

import java.util.Date;

public class CommonUtils {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;

	public String generateRandomEmail() {
		Date date = new Date();
		return "byogesh" + date.toString().replace(" ", "").replace(":", "") + "@gmail.com";
	}

}
