package com.w2a.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.w2a.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		log.debug("inside login test");
		//System.out.println(or.getProperty("BMLbtn"));
		// same function as below libe : driver.findElement(By.xpath("(//div[@class='center']/button)[2]")).click();
		driver.findElement(By.xpath(or.getProperty("BMLbtn"))).click();
		Thread.sleep(3000);
		
		log.debug("Login successfully executed");
		
		//Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("AddCusbtn"))));
		Verify.verify(isElementPresent(By.xpath(or.getProperty("AddCusbtn"))));
		
		log.debug("button found successfully");
		System.out.println("executed final");
	}



}
