package com.deep.common;

import org.testng.annotations.Test;

import com.deep.configuration.JavaBase;
import com.deep.utility.ExcelUtils;

@Test
public class Common extends JavaBase {

	public void login() throws Exception {

	
	

	//	String username = CONFIGPROP.getProperty("username");
		
		String xusername = ExcelUtils.getCellData(1,1);
		System.out.println(xusername);
		String password = CONFIGPROP.getProperty("password");
		Thread.sleep(5000);
		getObject("username_input").sendKeys(xusername);
		Thread.sleep(5000);
		getObject("password_input").sendKeys(password);
		
		getObject("login_button").submit();
	
	}
}

