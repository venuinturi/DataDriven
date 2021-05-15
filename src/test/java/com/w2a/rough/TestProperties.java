package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		//System.out.println(System.getProperty("user.dir"));
		
		
		Properties config=new Properties();
		Properties config2 =new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Or.properties");
		config2.load(fis);
		System.out.println(config2.get("BMLbtn"));
				
		System.out.println(config.get("browser"));
	}
}
