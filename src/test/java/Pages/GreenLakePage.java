package Pages;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GreenLakePage extends BasePage {
	//WebDriver driver;

	public GreenLakePage(WebDriver driver) {
		// this.driver = driver;
		super(driver);

	}

	public void checkPage(String data) {
		System.out.println(driver.getTitle());
		compareTitle(data);
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
