package com.qa.hotels.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaSCripUtil;


public class HotelsPage extends BasePage {
WebDriver driver;
ElementUtil elementUtil;
JavaSCripUtil javaScriptUtil;

By star=By.id("f-label-star-rating-3");

public HotelsPage(WebDriver driver) {
this.driver=driver;
elementUtil=new ElementUtil(driver);
javaScriptUtil=new JavaSCripUtil(driver);
}

public String getpageTitle(){
	return elementUtil.doGetPageTitle(AppConstants.Hotel_PAGE_TITLE);
	}
public void Click3star(){
	elementUtil.doClick(star);

}
public void hotelList() throws InterruptedException{
	for (int i = 0;i<45 ; i++) {
					
		
  javaScriptUtil.scrollDownPage(1000);
	Thread.sleep(2000);
	}
	
List<WebElement> linklist =driver.findElements(By.className("property-name-link")); // tag name provides links 
	
	System.out.println("Total links are : "+ linklist.size());
	
	
	for(int i= 0 ; i<linklist.size(); i ++){
		
		String text= linklist.get(i).getText();
	
	if (text.contains("Hilton")) {
		System.out.println("Yes it has Hilton");
		break;
		
	}
	
		
	}}
	}
