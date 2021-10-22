
import Pages.MenuPage;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MenuButtonsTest {

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
		//driver.get("https://support.hpe.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void menuHome() {

		MenuPage objMenu = new MenuPage(driver);
		objMenu.clickMenu_Home();
		objMenu.return_drv();

	}

	@Test
	public void menuManageCases()  {

		MenuPage objMenu = new MenuPage(driver);
		objMenu.clickMenuManageCases();
		objMenu.return_drv();
		System.out.println("Menu Manage Cases is done");

	}

	@Test
	public void menuManageMyContracts() {

		MenuPage objMenu = new MenuPage(driver);
		objMenu.MenuManageMyContracts();
		objMenu.return_drv();
		System.out.println("Menu Manage MyContracts is done");

	}

	@Test
	public void menuServicesGreenLake()  {

		MenuPage objMenu = new MenuPage(driver);
		objMenu.MenuServicesGreenLake();
		objMenu.return_drv();

		System.out.println("Menu Services HPE GreenLake  is done");

	}

	@Test
	public void menuServicesDataCenterCare()  {

		MenuPage objMenu = new MenuPage(driver);
		System.out.println("objMenu is created");
		objMenu.MenuServicesDataCenterCare();
		objMenu.return_drv();

		System.out.println("Menu Services Datacenter Care is done");
	}

	@Test
	public void contentType()  {

		MenuPage objMenu = new MenuPage(driver);
		objMenu.findProliant();
		objMenu.checkContentType();
		objMenu.return_drv();
        System.out.println("ContentType is done");

	}

	@Test
	public void driversAndSoftware() {

		MenuPage objMenu = new MenuPage(driver);
		objMenu.findProliant();
		objMenu.checkDriversandSoftware();
		objMenu.return_drv();

		System.out.println("ContentType is done");

	}

	@AfterMethod
	public void afterMethod() {

		// close and quit the browser
		driver.quit();
	}

}
