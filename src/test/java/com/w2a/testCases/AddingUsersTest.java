package com.w2a.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.w2a.base.TestBase;
import com.w2a.utilities.ExcelReader;

public class AddingUsersTest extends TestBase{

	@Test(dataProvider="dataGetter")
	public void AddUsers(String FirstName, String LastName, String PostCode, String ValidationText) throws InterruptedException {
		
		//Verify.verify(isElementPresent(By.xpath(or.getProperty("AddCusbtn"))));
		
		driver.findElement(By.xpath(or.getProperty("AddCusbtn"))).click();
		driver.findElement(By.xpath(or.getProperty("firstNametextbox"))).sendKeys(FirstName);
		driver.findElement(By.xpath(or.getProperty("lastnametextbox"))).sendKeys(LastName);
		driver.findElement(By.xpath(or.getProperty("postCodeTextBox"))).sendKeys(PostCode.toString());
		driver.findElement(By.xpath(or.getProperty("SubmitButton"))).click();
		
		
		Thread.sleep(3000);
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(ValidationText));
		alert.accept();
		
		Thread.sleep(3000);
		
				
	}
	
	
	@DataProvider
	public Object[][] dataGetter() {
		
		
		excel=new ExcelReader(".\\src\\test\\resources\\excel\\TestData.xlsx");
		String sheetname="AddingUsersTest";
		int rows=excel.getRowCount(sheetname);
		int cols=excel.getColumnCount(sheetname);
		
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int i=2;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				
				data[i-2][j]=excel.getCellData(sheetname, j, i);
				System.out.println("data read is "+data[i-2][j]);
				
			}
		}
		
		return data;
		
	}
}
