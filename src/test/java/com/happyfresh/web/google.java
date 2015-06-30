package com.happyfresh.web;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class google {
	WebDriver driver;
	
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
	
	public void elementHighlight(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: red; border: 3px solid red;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}
	
	@Test
	public void test(){
		driver.get("http://newtours.demoaut.com/");
		
	}
	
	@Test
	public void test_GoogleSearch() {
		WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver
                .findElement(By
                .xpath("//html/body/div"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr"));   
         
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(link_Home)
                .build();
         
        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);       
        mouseOverHome.perform();       
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
        driver.quit();
	}

}
