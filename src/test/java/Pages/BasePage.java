package Pages;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	// WebDriver driver;
	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		if (driver != null) {
			this.driver = driver;
			wait = new WebDriverWait(driver, 30);
		}
	}

	// Green Lake
	public By heading = By.className("ccs-form-heading");

	// Product
	By manualsandDrivers = By.xpath("//*[@id=\"manualsAndGuides__item\"]");
	By driversandSoftware = By.xpath("//*[@id=\"driversAndSoftware__item\"]");
	By driversAndSoftware = By.xpath("//*[@id=\"DriversandSoftware\"]");
	By alerts = By.xpath("//*[@id=\"alerts__item\"]");
	By videos = By.xpath("//*[@id=\"videos__item\"]");
	By Products = By.id("Products");
	By ResultList = By.id("resultList-container");
	By coveo = By.className("coveo-summary-section");
	By checkboxes = By.className("coveo-checkbox-button");
	By dinamicFacet = By.className("coveo-dynamic-facet-values");
	By moremenu = By.id("hpehf-more-menu");

	// Menu{
	public By menuButton = By.xpath("//*[@id=\"Layer_1-8\"]");
	public By linksOnPage = By.xpath("//*[@href]");
	//public By autosugest = By.xpath("//input[@type='search' AND @id='autosuggest-input-24']");
	public By autosugest = By.xpath("//*[@id=\"autosuggest-input-23\"]");
	public static String expectedGreenLakeTitle = "HPE GreenLake";
	public static String expectedCloudServicesTitle = "HPE GreenLake Hub - HPE GreenLake - Sign In";
	public static String expectedDataServicesTitle = "HPE GreenLake";
	public static String expectedDataCenterDataSheetTitle = "HPE Datacenter Care Service data sheet";
	public static String expectedGreenLakeDataSheetTitle = "HPE GreenLake data sheet";
	public static String expectedCasesDataSheetTitle = "Sign In | HPE Support Center";
	public static String expectedMyContractTitle = "Sign In | HPE Support Center";
	public static String expectedProductTitle = "Home | HPE Support";
	
	void clickElementOnPage(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		waitMiliSec(2000);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		System.out.println("Element is clicked");
	}

	public void sendKeys(By element, String key) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);
		System.out.println("Element is clicked");
	}

	public void clickElementOnPageBy(By element) {
		System.out.println("Prepare to be clicked");
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		System.out.println("Element is clicked");
	}

	public java.util.List<WebElement> checkPresenceOfElements(By elements) {
		java.util.List<WebElement> linklist = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
		return linklist;

	}

	public void sendEnter(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(Keys.ENTER);

	}

	public WebElement checkPresenceOfElementBy(By element) {
		WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return elem;
	}

	public void waitMiliSec(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findElementInList(java.util.List<WebElement> linklist, String keyword) {
	for (WebElement webelement : linklist) {

		System.out.println(webelement.getText());

		if (webelement.getText().contains(keyword)) {
			System.out.println(webelement.getText());
			clickElementOnPage(webelement);
			waitMiliSec(3000);
			break;
		}
	}
	}
	
	public void compareTitle(String expectedtitle) {
		try {
		 WebDriverWait wait = new WebDriverWait(driver, 15);
		 waitMiliSec(6000);
		 wait.until(ExpectedConditions.titleContains(expectedtitle));
		} catch  (Exception e) {
			System.out.println("title is not appropriate");
		}
		
	}

	public void checkPage(String data) {
		System.out.println(driver.getTitle());
		try {
			Assert.assertEquals(driver.getTitle(), "HPE GreenLake", "Something is wrong");

		} catch (Exception e) {
			System.out.println("checkPage is not appropriate");
		}
	}

	public WebDriver return_drv() {
		return driver;
	}

}
