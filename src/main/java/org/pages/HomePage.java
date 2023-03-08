package org.pages;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.utilities.UtilityClass;

public class HomePage extends UtilityClass {
	public HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']")
	private WebElement menu;

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']//li[text()='HOME']")
	private WebElement homeMenu;

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']//li[text()='MOVIES']")
	private WebElement moviesMenu;

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']//li[text()='TV SHOWS']")
	private WebElement tvMenu;

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']//li[text()='LIVE TV']")
	private WebElement liveTvMenu;

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']//li[text()='MUSIC VIDEOS']")
	private WebElement musicMenu;

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']//li[text()='COMEDY']")
	private WebElement comedyMenu;

	@FindBy(xpath = "//ul[@class='header_menu__cfTtF']\\li")
	private List<WebElement> menuOption;

	@FindBy(xpath = "//button[text()='Languages']")
	private WebElement langunage;

	@FindBy(xpath = "//div[@class='header_languages_list__gaALr']//li")
	private List<WebElement> allLangunage;

	@FindBy(xpath = "//div[@class='livetv_bloc_tabs__VMluf']//button")
	private List<WebElement> languageList;

	@FindBy(xpath = "//div[@id='liveTVChannelsList']")
	private WebElement channelList;

	public List<WebElement> getLanguageList() {
		return languageList;
	}

	public WebElement getChannelList() {
		return channelList;
	}

	public WebElement getMenu() {
		return menu;
	}

	public List<WebElement> getMenuOptions() {
		return menuOption;
	}

	public WebElement getHomeMenu() {
		return homeMenu;
	}

	public WebElement getMoviesMenu() {
		return moviesMenu;
	}

	public WebElement getTvMenu() {
		return tvMenu;
	}

	public WebElement getLiveTvMenu() {
		return liveTvMenu;
	}

	public WebElement getMusicMenu() {
		return musicMenu;
	}

	public WebElement getComedyMenu() {
		return comedyMenu;
	}

	public List<WebElement> getMenuOption() {
		return menuOption;
	}

	public WebElement getLangunage() {
		return langunage;
	}

	public List<WebElement> getAllLangunage() {
		return allLangunage;
	}

	public boolean verifyMenuOption() throws InterruptedException {
		boolean result = false;
		click(getHomeMenu());
		String option = "";
		option = getText(getHomeMenu()).toLowerCase().split(" ")[0];
		if (getCurrentUrl(option)) {
			result = true;
			System.out.println("User in " + option + " page");
		}
		Thread.sleep(2000);
		click(getMoviesMenu());
		option = getText(getMoviesMenu()).toLowerCase().split(" ")[0];
		if (getCurrentUrl("movie")) {
			result = true;
			System.out.println("User in " + option + " page");
		}
		Thread.sleep(2000);
		click(getTvMenu());
		option = getText(getTvMenu()).toLowerCase().split(" ")[0];
		if (getCurrentUrl(option)) {
			result = true;
			System.out.println("User in " + option + " page");
		}
		Thread.sleep(2000);
		click(getLiveTvMenu());
		option = getText(getLiveTvMenu()).toLowerCase().split(" ")[0];
		if (getCurrentUrl(option)) {
			result = true;
			System.out.println("User in " + option + " page");
		}
		Thread.sleep(2000);
		click(getMusicMenu());
		option = getText(getMusicMenu()).toLowerCase().split(" ")[0];
		if (getCurrentUrl(option)) {
			result = true;
			System.out.println("User in " + option + " page");
		}
		Thread.sleep(2000);
		click(getComedyMenu());
		option = getText(getComedyMenu()).toLowerCase().split(" ")[0];
		if (getCurrentUrl(option)) {
			result = true;
			System.out.println("User in " + option + " page");
		}
		Thread.sleep(2000);
		return result;
	}

	public boolean verifyAllLanguaeSelected() {
		boolean result = false;
		moveToElement(getLangunage());
		List<WebElement> ll = getAllLangunage();
		for (WebElement e : ll) {

			if (getAttribute(e, "class").contains("selected")) {
				System.out.println(getText(e) + " was Selected");
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

	public void getEachLanguageChannelList() {
		click(getLiveTvMenu());
		List<WebElement> lang = getLanguageList();
		for (int i = 0; i < lang.size(); i++) {
			String l = getText(lang.get(i));
			WebElement ll = driver
					.findElement(By.xpath("//div[@class='livetv_bloc_tabs__VMluf']//span[text()='" + l + "']"));
			ll.click();
			System.out.println("Channel Language......" + l);
			WebDriverWait w= new WebDriverWait(driver, 20);
			WebElement ele = w.until(ExpectedConditions.visibilityOf(getChannelList()));
			System.out.println(getText(ele));
		}

	}
}
