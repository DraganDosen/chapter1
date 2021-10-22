
import Pages.GreenLakePage;
import Pages.MainPage;
import Pages.CloudServicesPage;
import Pages.DataServicesPage;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.BasePage;


public class MainPageTest {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		// initialize new WebDriver session
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage");
		//options.addArguments("--no-sandbox");
		options.addArguments("--headless");
		options.addArguments("--window-size=1920x1080");
		driver = new ChromeDriver(options);
		// driver = new FirefoxDriver();
		driver.get("https://itg-ext.support.hpe.com/");
		//driver.get("https://support.hpe.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void checkServiceButton() {
		MainPage objMainPage = new MainPage(driver);
		objMainPage.ClickMainPageService();
		objMainPage.return_drv();

	}

	@Test
	public void checkGreenLake() {
		MainPage objMainPage = new MainPage(driver);
		objMainPage.HpeGreenLake();
		objMainPage.return_drv();
		GreenLakePage objGLP = new GreenLakePage(driver);
		objGLP.checkPage(BasePage.expectedDataServicesTitle);
		objGLP.return_drv();

	}

	@Test
	public void checkCloudServices() {
		MainPage objMainPage = new MainPage(driver);
		objMainPage.HpeCloudServices();
		CloudServicesPage objDSPage = new CloudServicesPage(driver);
		objDSPage.checkPage(BasePage.expectedCloudServicesTitle);
		objDSPage.return_drv();
		

	}

	@Test
	public void checkDataServices() {
		MainPage objMainPage = new MainPage(driver);
		objMainPage.HpeDataServices();
		objMainPage.return_drv();
		DataServicesPage objDSPage = new DataServicesPage(driver);
		objDSPage.checkPage(BasePage.expectedDataServicesTitle);
		objDSPage.return_drv();
	}
       @Test
	public void checkCompute() {
		MainPage objMainPage = new MainPage(driver);
		objMainPage.HpeCompute();
		objMainPage.return_drv();

	}

	@Test
	public void checkConnectivity() {
		MainPage objMainPage = new MainPage(driver);
		objMainPage.HpeConnectivity();
		objMainPage.return_drv();

	}

	@AfterMethod
	public void afterMethod() {

		// close and quit the browser
		driver.quit();
	}

}
