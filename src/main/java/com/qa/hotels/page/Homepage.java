package com.qa.hotels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.AppConstants;
import com.qa.hotels.util.ElementUtil;

public class Homepage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	By destination=By.id("qf-0q-destination");
	By datecheckin=By.id("qf-0q-localised-check-in");
	By datecheckout=By.id("qf-0q-localised-check-out");
	By selectchild=By.id("qf-0q-room-0-children");
	//WebElement selectchild=driver.findElement(By.id("qf-0q-room-0-children"));
	By firstchildage=By.id("qf-0q-room-0-child-0-age");
	By secondchildage=By.id("qf-0q-room-0-child-1-age");
	By search=By.xpath("//button[@type='submit']");
	By close=By.xpath("//button[@aria-label='Close overlay']");
	public Homepage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	public String getpageTitle(){
	return elementUtil.doGetPageTitle(AppConstants.HOME_PAGE_TITLE);
	}
	public HotelsPage whereTo(){
		 elementUtil.doSendKeys(destination, "Boston, Massachusetts, United States of America");
		 elementUtil.doSendKeys(datecheckin, "08/10/2020");
		 elementUtil.doSendKeys(datecheckout, "08/20/2020");
		 WebElement child=elementUtil.getElement(selectchild);
			elementUtil.SelectbyValue(child,"2" );
			WebElement child1=elementUtil.getElement(firstchildage);
			elementUtil.SelectbyValue(child1, "4");
			WebElement child2=elementUtil.getElement(secondchildage);
			elementUtil.SelectbyValue(child2, "9");
			//elementUtil.doClick(close);
			elementUtil.doClick(search);
			return new HotelsPage(driver);
			
			
		
	}
	
   
	
}
