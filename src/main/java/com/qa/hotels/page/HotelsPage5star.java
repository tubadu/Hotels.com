package com.qa.hotels.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaSCripUtil;


public class HotelsPage5star extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	JavaSCripUtil javaScriptUtil;

	By fiveStar= By.id("f-star-rating-5");
	By landmark= By.id("filter-landmarks-contents");
	//WebElement landmark=driver.findElement(By.id("filter-landmarks-contents"));
	By citycenter= By.id("f-lid-1401516");
	By miles= By.id("f-distance");

	public HotelsPage5star(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		javaScriptUtil=new JavaSCripUtil(driver);
	}
public void Click5star(){
	elementUtil.doClick(fiveStar);
}

public void distance() throws InterruptedException{
	//elementUtil.doClick(landmark);
	WebElement land=driver.findElement(landmark);
	javaScriptUtil.clickElementByJS(land, driver);

	//elementUtil.doClick(citycenter);
	WebElement city=driver.findElement(citycenter);
	javaScriptUtil.clickElementByJS(city, driver);
	
	WebElement element=driver.findElement(miles);
	elementUtil.SelectbyValue(element, "10.0");



}public void goDown() throws InterruptedException {
	
	javaScriptUtil.scrollDownPage(1000);
Thread.sleep(2000);

}public void hotelList() throws InterruptedException{
	
			
		List<WebElement> linklist =driver.findElements(By.className("property-name-link")); // tag name provides links 
			
			System.out.println("Total links are : "+ linklist.size());
			for (int i = 0; i < linklist.size(); i++) {
				String text=linklist.get(i).getText();
				System.out.println(text);
				
			}

}}
