package Pages;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RightAboveButtonsPage extends BasePage {

	WebDriver driver;

	public RightAboveButtonsPage(WebDriver driver) {
		// this.driver = driver;
		super(driver);

	}

	public void ClickMainPageService() {

		WebElement servicesButton = checkPresenceOfElementBy(moremenu);
		clickElementOnPage(servicesButton);
		ArrayList<String> listOfElements = new ArrayList();
		listOfElements.add("HPE GreenLake");
		listOfElements.add("Cloud Services");
		listOfElements.add("HPE GreenLake Central");
		listOfElements.add("Data Services");
		listOfElements.add("Compute");
		listOfElements.add("Connectivity");
		listOfElements.add("Aruba Central");
		listOfElements.add("Support");
		listOfElements.add("Financial Services");
		listOfElements.add("Developer");
		listOfElements.add("Communities");
		listOfElements.add("www.hpe.com");

		java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
		for (WebElement webelement : linklist) {
			System.out.println(webelement.getText());
		}

		for (WebElement webelement_one : linklist) {
			int i;
			for (i = 0; i < listOfElements.size() - 1; i++) {
				if (listOfElements.get(i).equals(webelement_one.getText())) {
					System.out.println(webelement_one.getText() + " is equal with " + listOfElements.get(i));
				}
			}
		}
	}

	public void HpeGreenLake() {
		try {
			WebElement servicesButton = checkPresenceOfElementBy(moremenu);
			clickElementOnPage(servicesButton);
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"HPE GreenLake");
		} catch (Exception e) {
			System.out.println("HpeGreenLake is not appropriate");
		}
	}

	public void HpeCloudServices() {
		try {
			WebElement servicesButton = checkPresenceOfElementBy(moremenu);
			clickElementOnPage(servicesButton);
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Cloud Services");
		} catch (Exception e) {
			System.out.println("HpeCloudServices is not appropriate");
		}

	}

	public void HpeCompute() {
		try {
			WebElement servicesButton = checkPresenceOfElementBy(moremenu);
			clickElementOnPage(servicesButton);
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Compute");
		} catch (Exception e) {
			System.out.println("HpeCompute is not appropriate");
		}
	}

	public void HpeConnectivity() {
		try {
			WebElement servicesButton = checkPresenceOfElementBy(moremenu);
			clickElementOnPage(servicesButton);
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Connectivity");
		} catch (Exception e) {
			System.out.println("HpeConnectivity is not appropriate");
		}
	}

	public void HpeDataServices() {
		try {
			WebElement servicesButton = checkPresenceOfElementBy(moremenu);
			clickElementOnPage(servicesButton);
			java.util.List<WebElement> linklist = checkPresenceOfElements(linksOnPage);
			findElementInList(linklist,"Data Services");
		} catch (Exception e) {
			System.out.println("HpeDataServices is not appropriate");
		}

	}

	public WebDriver return_drv() {
		return driver;
	}
}
