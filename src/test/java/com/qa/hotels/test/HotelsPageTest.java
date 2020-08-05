package com.qa.hotels.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.Homepage;
import com.qa.hotels.page.HotelsPage;

import com.qa.hotels.util.AppConstants;

public class HotelsPageTest {
WebDriver driver;
BasePage basePage;
Properties prop;
Homepage homepage;
HotelsPage hotelsPage;
@BeforeTest
public void Setup(){
	basePage=new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	homepage=new Homepage(driver);
	hotelsPage=new HotelsPage(driver);
	hotelsPage=homepage.whereTo();
}
@Test(priority=1)
public void verifyTitle(){
	String title=hotelsPage.getpageTitle();
	System.out.println(title);
	Assert.assertEquals(title, AppConstants.Hotel_PAGE_TITLE);
}
@Test(priority=2)
public void Star(){
	hotelsPage.Click3star();
}
@Test(priority=3)
public void hotelList() throws InterruptedException{
	hotelsPage.hotelList();
}
@AfterTest
public void tearDown(){
	driver.quit();
}
}
