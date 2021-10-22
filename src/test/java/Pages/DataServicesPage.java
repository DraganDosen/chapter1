package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DataServicesPage extends BasePage {

	public DataServicesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void checkPage(String data) {
		compareTitle(data);
		System.out.println(driver.getTitle());
		try {
			Assert.assertEquals(driver.getTitle(),data, "Something is wrong");

		} catch (Exception e) {
			System.out.println("checkPage is not appropriate");
		}

	}
	public WebDriver return_drv() {
		return driver;
	}

}
