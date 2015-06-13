package com.deep.common;



import org.testng.annotations.Test;

import com.deep.configuration.JavaBase;
@Test
public class Common extends JavaBase {

	public void login() throws InterruptedException {

		if (isLoggedIn) {
		//	logout();
		}

		String username = CONFIGPROP.getProperty("username");
		String password = CONFIGPROP.getProperty("password");
		Thread.sleep(5000);
		getObject("username_input").sendKeys(username);
		getObject("password_input").sendKeys(password);
	
		getObject("login_button").click();
		Thread.sleep(5000);
		getObject("login_button").click();
	}
	}

//	public void logout() {
	//	getObject("username_link").click();
	//	getObject("logout_link").click();
//	}
	