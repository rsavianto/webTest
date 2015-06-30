package com.happyfresh.web;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;

public class WebBaseTesting {
	protected WebDriver driver;
	protected WebElement element;
	String BASE_URL = System.getenv("WEB_URL");
	
	@BeforeClass
	protected void setupBrowser(){
		driver = new FirefoxDriver();
		//Set maximize windows
		driver.manage().window().maximize();
		//Set timeouts
		WebDriver.Timeouts timeoutOptions = driver.manage().timeouts();
		// if it is not immediately present
		timeoutOptions.implicitlyWait(30, TimeUnit.SECONDS);
		// amount of time to wait for page load to complete
		timeoutOptions.pageLoadTimeout(30, TimeUnit.SECONDS);
		// amount of time to wait for an asynchronous t finish execution
		timeoutOptions.setScriptTimeout(30, TimeUnit.SECONDS);
	}
	
	protected void isElementExist(By by){
		//Assert.assertArrayEquals(message, expecteds, actuals);
	}
	
	protected void isHome(){
		driver.get(BASE_URL);
	}
	
	protected void isWait(int second){
		WebDriver.Timeouts timeoutOptions = driver.manage().timeouts();
		// amount of time to wait for page load to complete
		//timeoutOptions.pageLoadTimeout(second, TimeUnit.SECONDS);
		timeoutOptions.implicitlyWait(second, TimeUnit.SECONDS);
		//timeoutOptions.implicitlyWait(second, TimeUnit.SECONDS);
	}
	
	protected void scrollingToBottomofAPage() {
		driver.navigate().to(BASE_URL);
		 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	protected void scrollTo(int dur){
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,dur)", "");
	}
	

	protected void elementCrossOver(WebElement element) {
		Actions builder = new Actions(driver);
	    Action mouseOverHome = builder
	             .moveToElement(element)
	             .build();      
	    mouseOverHome.perform();
	}

}
