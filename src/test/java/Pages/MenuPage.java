
package Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MenuPage extends BasePage {

	 WebDriver driver;

	public MenuPage(WebDriver driver) {
		// this.driver = driver;
		super(driver);

	}
	
	

	public void MenuManageMyContracts() {

		clickMenuManage();
		java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
		findElementInList(linklist,"My Contracts");
		compareTitle(expectedMyContractTitle);
	}

	public void MenuServicesGreenLake() {
		try {
		clickMenuServices();
		java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
		findElementInList(linklist,"HPE GreenLake");
		ArrayList<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(browserTabs.get(1));
		compareTitle(expectedGreenLakeDataSheetTitle);
		System.out.println(driver.getTitle());
		waitMiliSec(3000);
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		} catch (Exception e) {
			System.out.println("GreenLake is not appropriate");
		}
	}

	public void MenuServicesDataCenterCare() {
		try {
		clickMenuServices();
		java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
		findElementInList(linklist,"HPE Datacenter Care");
		ArrayList<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(browserTabs.get(1));
		compareTitle(expectedDataCenterDataSheetTitle);
		System.out.println(driver.getTitle());
		waitMiliSec(3000);
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		} catch (Exception e) {
			System.out.println("DataCenterCare is not appropriate");
		}

	}

	public void clickMenuManage() {
		try {
			clickMenu();
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Manage");
		} catch (Exception e) {
			System.out.println("clickMenu_Manage is not appropriate");
		}
	}

	public void clickMenuServices() {
		try {
			clickMenu();
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Services");
		} catch (Exception e) {
			System.out.println("clickMenu_Services is not appropriate");
		}
	}

	public void clickMenuManageCases() {
		try {
			clickMenuManage();
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Cases");
			compareTitle(expectedCasesDataSheetTitle);
		} catch (Exception e) {
			System.out.println("clickMenu_Manage_Cases is not appropriate");
		}
	}

	public void clickMenu() {
		try {
			clickElementOnPageBy(menuButton);
			System.out.println("Menu is clicked!");
		} catch (Exception e) {
			System.out.println("clickMenu is not appropriate");
		}
	}

	public void clickMenu_Home() {
		try {
			clickMenu();
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Home");
			findElementInList(linklist,"HPE Support Center");
		} catch (Exception e) {
			System.out.println("clickMenu is not appropriate");
		}
	}

	public void clickProduct() {
		try {
			// click product
			clickElementOnPageBy(Products);
		} catch (Exception e) {
			System.out.println("clickProductis not appropriate");
		}
	}

	public void checkProduct() {
		try {
			// check product
			clickElementOnPageBy(ResultList);
			waitMiliSec(2000);
			System.out.println("Container is visible");
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);

			for (WebElement webelement : linklist) {
				if (webelement.getText().contains("HPE")) {
					System.out.println(webelement.getText());
					JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
					jsexecutor.executeScript("arguments[0].click()", webelement);
					break;
				}
			}
			waitMiliSec(3000);
		} catch (Exception e) {
			System.out.println("clickProductis not appropriate");
		}
	}

	public void manuals() {
		try {
			clickElementOnPageBy(manualsandDrivers);
			System.out.println("Manuals and Guides is clicked");
			waitMiliSec(3000);
			clickElementOnPageBy(driversandSoftware);
			System.out.println("Drivers and Software is clicked");
			waitMiliSec(3000);
			clickElementOnPageBy(alerts);
			System.out.println("Alerts is clicked");
			clickElementOnPageBy(videos);
			System.out.println("Video is visible and clicked");
			waitMiliSec(3000);
		} catch (Exception e) {
			System.out.println("manuals not appropriate");
		}
	}

	public void findProliant() {
		try {
			//System.out.println("I am here");
			//clickElementOnPageBy(autosugest);
			//System.out.println("I am here now!!");
			//WebElement field = checkPresenceOfElementBy(autosugest);
			sendKeys(autosugest, "Proliant");
			sendEnter(autosugest);
			waitMiliSec(5000);
			WebElement context = checkPresenceOfElementBy(coveo);
			String listOfElementBefore = (context.getText());
			String listOfElementAfter = (context.getText());
			int i = 0;
			boolean t = true;
			while (t) {
				System.out.println("list of elements before: " + listOfElementBefore);
				System.out.println("list of elements after: " + listOfElementAfter);
				i = i + 1;
				if (listOfElementBefore.equals(listOfElementAfter)) {
					System.out.println("In while loop waiting to change Results");
					WebElement contextafter = checkPresenceOfElementBy(coveo);
					listOfElementAfter = (contextafter.getText());
					System.out.println("list of elements after: " + listOfElementAfter);
					waitMiliSec(1000);
				}

				else {
					t = false;
				}
			}
		} catch (Exception e) {
			System.out.println("findProliant not appropriate");
		}
	}

	public void checkContentType() {
		try {
			checkPresenceOfElementBy(coveo);
			int y;
			for (y = 0; y < 5; y++) {
				System.out.println("number of recursion: " + y);
				WebElement context = checkPresenceOfElementBy(coveo);
				java.util.List<WebElement> Buttons = checkPresenceOfElements(checkboxes);
				String listOfElementBefore = (context.getText().substring(16, 22));
				WebElement forums = checkPresenceOfElementBy(dinamicFacet);
				System.out.println(forums.getText());
				String listOfElementAfter = (context.getText().substring(16, 22));
				Buttons.get(y).click(); // checked
				int i = 0;
				boolean t = true;
				while (t || i < 10) {
					System.out.println(i);
					System.out.println(listOfElementBefore);
					System.out.println(listOfElementAfter);
					i = i + 1;

					if (listOfElementBefore.equals(listOfElementAfter)) {
						System.out.println("In while loop waiting to change context");
						WebElement contextafter = checkPresenceOfElementBy(coveo);
						listOfElementAfter = (contextafter.getText().substring(16, 22));
						waitMiliSec(1000);
					}

					else {
						t = false;
					}

				}
				WebElement contextafterclick = checkPresenceOfElementBy(coveo);
				System.out.println("Results after click: " + contextafterclick.getText());
				listOfElementAfter = (context.getText().substring(16, 22));
				Assert.assertNotEquals(listOfElementBefore, listOfElementAfter);
				System.out.println("y is: " + " " + y);
				java.util.List<WebElement> Buttonuncheck = checkPresenceOfElements(checkboxes);
				Buttonuncheck.get(y).click(); // unchecked
			}
		} catch (Exception e) {
			System.out.println("checkDriversandSoftware not appropriate");
		}
	}

	public void checkDriversandSoftware() {
		try {
			checkPresenceOfElementBy(coveo);
			clickElementOnPageBy(driversAndSoftware);
			System.out.println("Drivers and Software is clicked");
			int y;
			for (y = 0; y < 15; y++) {
				System.out.println("number of recursion: " + y);
				WebElement context = checkPresenceOfElementBy(coveo);
				java.util.List<WebElement> Buttons = checkPresenceOfElements(checkboxes);
				String listOfElementBefore = (context.getText().substring(16, 22));
				WebElement forums = checkPresenceOfElementBy(dinamicFacet);
				System.out.println(forums.getText());
				String listOfElementAfter = (context.getText().substring(16, 22));
				Buttons.get(y).click(); // checked
				int i = 0;
				boolean t = true;
				while (t || i < 10) {
					System.out.println(i);
					System.out.println(listOfElementBefore);
					System.out.println(listOfElementAfter);
					i = i + 1;

					if (listOfElementBefore.equals(listOfElementAfter)) {
						System.out.println("In while loop waiting to change context");
						WebElement contextafter = checkPresenceOfElementBy(coveo);
						listOfElementAfter = (contextafter.getText().substring(16, 22));
						waitMiliSec(1000);
					}

					else {
						t = false;
					}

				}
				WebElement contextafterclick = checkPresenceOfElementBy(coveo);
				System.out.println("Results after click: " + contextafterclick.getText());
				listOfElementAfter = (context.getText().substring(16, 22));
				Assert.assertNotEquals(listOfElementBefore, listOfElementAfter);
				System.out.println("y is: " + y);
				java.util.List<WebElement> Buttonuncheck = checkPresenceOfElements(checkboxes);
				Buttonuncheck.get(y).click(); // unchecked
			}
		} catch (Exception e) {
			System.out.println("checkDriversandSoftware not appropriate");
		}
	}

	public WebDriver return_drv() {
		return driver;
	}
}
