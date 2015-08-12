// Change package details as per your Project:
package com.deep.IntegrationUtil;

import java.io.File;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;

public class TestngUtil {

	public static void main(String[] args) throws Exception {

		String str;
		System.out.println(readsource.getInstance().getProperty("firstName"));
		// change file path
		String fileData[] = FileUtils.readFileToString(new File("C:\\Users\\diptmang\\Desktop\\testcodes.txt"))
				.split("\n");

		{

			for (String fileLine : fileData) {
				String lineSplit[] = fileLine.split("=");
				String testCode = lineSplit[0];
				String testClasses[] = lineSplit[1].split(",");
				runAndVerify(testCode, testClasses);
			}
		}
	}

	public static void runAndVerify(String testCode, String[] testClassNames) throws Exception {

		if (testClassNames.length <= 0) {
			throw new AssertionError("no test class specified.");
		}

;		Class<?> testClasses[] = new Class<?>[testClassNames.length];
		int ctr = 0;
		for (int i = 0; i < testClassNames.length; i++) {
			try {
				testClasses[ctr++] = Class.forName(testClassNames[i].trim());
			} catch (Exception e) {

			}
		}

		// run testng tests
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testNG = new TestNG();

		for (Class<?> testClass : testClasses) {
			testNG.setTestClasses(new Class<?>[] { testClass });
			testNG.addListener(tla);
			testNG.run();
		}

		List<ITestResult> failedTests = Lists.newArrayList();
		failedTests.addAll(tla.getFailedTests());
		failedTests.addAll(tla.getConfigurationFailures());
		// JIRA connections
		WebClient wc = new WebClient();
		WebRequest wr = new WebRequest(new URL("http://localhost:8080//rest/api/2/issue/" + testCode + "/transitions"),
				HttpMethod.POST);
		Map<String, String> headers = new HashMap<String, String>();
		// User id password with basic encryption : base 64 fiddler text wizard
		headers.put("Authorization", "Basic ZGVlcHRtYW4uZ3VwdGFAbGl2ZS5jb206SmlyYS0yMDE1");
		headers.put("Content-Type", "application/json");
		wr.setAdditionalHeaders(headers);
		// update scenarios as per your uses : action id update

		if (failedTests.isEmpty()) {
			try {
				String body = "{    \"update\": {        \"comment\": [            {                \"add\": {                    \"body\": \"Bug has  been fixed.\"                }            }        ]    },    \"transition\": {        \"id\": \"21\"    }}";

				wr.setRequestBody(body);
				wc.getPage(wr);

			}

			catch (RuntimeException ex) {
				ex.getCause();
			}
		}

	}
}
