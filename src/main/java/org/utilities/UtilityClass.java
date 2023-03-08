package org.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {
	public static WebDriver driver;

	public static WebDriver launchBrowser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.err.println("Invalid BrowSer Name");
			throw new WebDriverException();
		}

		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void click(WebElement e) {
		try{e.click();
		
		}
		catch (Exception ex) {
			jsClick(e);
		}
	}

	public static void closeBrowser() {
		driver.quit();

	}

	public static String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}
	public static boolean getCurrentUrl(String url) {
		WebDriverWait w= new WebDriverWait(driver, 20);
		return w.until(ExpectedConditions.urlContains(url));
		
		
	}
	
	public static String getPropertValue(String key) {
		Properties p = new Properties();
		String vv=null;
		try {
			p.load(new FileReader(
					System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\config.properties"));
			Object ob = p.get(key);
			vv = ob.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vv;

	}
	public static String getTitle() {
		return driver.getTitle();

	}

	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");

	}
	
	public static String getAttribute(WebElement e,String atname) {
		return e.getAttribute(atname);

	}

	public static String getText(WebElement e) {
		return e.getText();

	}

	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	public static void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void selectByText(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}

	public static WebElement findElement(String locatorName, String locValue) {
		WebElement e = null;
		if (locatorName.equals("id")) {
			e = driver.findElement(By.id(locValue));
		} else if (locatorName.equals("name")) {
			e = driver.findElement(By.name(locValue));
		} else if (locatorName.equals("xpath")) {
			e = driver.findElement(By.xpath(locValue));
		}
		return e;

	}

	public static void takeScreenShot(String imagename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShots\\" + imagename + ".png");
		FileUtils.copyFile(src, des);

	}

	public static void jsSendKeys(WebElement e, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", e);

	}
	public static void jsClick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);
		
	}

}
