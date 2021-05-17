package com.w2a.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.base.TestBase;

public class Utilities extends TestBase {

	public static String ScreenshotPath;
	public static String ScreenshotName;
	public static void takeScreenshot() throws IOException {
		
		Date d=new Date();
		ScreenshotName=d.toString().replace(":", "_").replace(" ", "_");
		
		File scrShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		ScreenshotPath=System.getProperty("user.dir")+"//target//surefire-reports//html//"+ScreenshotName+".jpg";
		FileUtils.copyFile(scrShot, new File(ScreenshotPath));
		
		
	}
}
