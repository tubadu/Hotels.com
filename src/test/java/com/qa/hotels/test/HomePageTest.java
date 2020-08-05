package com.qa.hotels.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.Homepage;
import com.qa.hotels.util.AppConstants;

public class HomePageTest {
WebDriver driver;
BasePage basePage;
Properties prop;
Homepage homepage;
@BeforeTest
public void setUp(){
	basePage=new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	homepage=new Homepage(driver);
}
@Test(priority=1)
public void verifyHomePageTitle(){
	String title=homepage.getpageTitle();
	System.out.println(title);
	Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	
}
@Test(priority=2)
public void destinationChoosing(){
	homepage.whereTo();
}

@AfterTest 
public void tearDown(){
	driver.quit();
}
}
