/**
 * 
 */
package com.deep.testCase;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.deep.common.Common;
import com.deep.configuration.JavaBase;

/**
 * @author DiptmanG
 *
 */
public class Mail extends JavaBase {

@BeforeTest
	public void loadConfig() throws IOException {
		Initialize();
	}
	
@Test
	public void loginmail(){
		
		driver.get(CONFIGPROP.getProperty("SiteName"));
		
		Common common = new Common();
		try {
			common.login();
			
		//	common.logout();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}