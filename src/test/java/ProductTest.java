
import Pages.MenuPage;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.BasePage;
public class ProductTest {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		// initialize new WebDriver session
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
	        options.addArguments("--headless");
		options.addArguments("--window-size=1920x1080");
		driver = new ChromeDriver(options);
		driver.get("https://itg-ext.support.hpe.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void checkProduct() {

		// Validate page title

		MenuPage objMenu = new MenuPage(driver);
		System.out.println("objMenu is created");
		objMenu.findProliant();
		objMenu.clickProduct();
		objMenu.checkProduct();
		objMenu.manuals();
		objMenu.return_drv();
		System.out.println("Menu fuction is done");

	}

	
	
	@AfterMethod
	public void afterMethod() {

		// close and quit the browser
		driver.quit();
	}

}
