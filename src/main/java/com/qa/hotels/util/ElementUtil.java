package com.qa.hotels.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.qa.hotels.base.BasePage;

public class ElementUtil extends BasePage {
	WebDriver driver;
	JavaSCripUtil javaScriptUtil;

	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
public String doGetPageTitle(String title){
	try {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
		
	} catch (Exception e) {
		System.out.println("some exception got occured while getting the title...");
		
	}return null;
	
}public void SelectbyValue(WebElement element,String value){
	Select select=new Select(element);
	select.selectByValue(value);;
}

public void waitForElementPresentBy(By locator) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}
public WebElement getElement(By locator){
	WebElement  element=null;
	try {
		element=driver.findElement(locator);
		if (highlightElement.equals("yes")) {
			javaScriptUtil.flash(element, driver);
		}
	} catch (Exception e) {
		System.out.println("some exception got occured while creating the web element " + locator);
	}return element;
}public void doClick(By locator){
	try {
		getElement(locator).click();
	} catch (Exception e) {
		System.out.println("some exception got occured while clicking the web element " + locator);
	}
}public void doSendKeys(By locator,String value){
	try {
		WebElement element=getElement(locator);
		element.clear();
		element.sendKeys(value);
		
		} catch (Exception e) {
		System.out.println("some exception got occured while entering values in a field " + locator);
	}
	
}public boolean doIsDisplayed(By locator){
	try {
		return getElement(locator).isDisplayed();
	} catch (Exception e) {
		System.out.println("some exception got occured isEnabled method");
	}return false;
	
}public boolean doIsSelected(By locator){
	try {
		return getElement(locator).isSelected();
	} catch (Exception e) {
		System.out.println("some exception got occured isSelected method");
	}return false;
}public String doGetText(By locator){
	try {
		return getElement(locator).getText();
		
	} catch (Exception e) {
		System.out.println("some exception got occured while getting text... " + locator);
	}
	return null;
}
}
