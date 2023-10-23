package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExentReportNG {
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "Reports\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("RedIff AutomationTest Results");
		reporter.config().setDocumentTitle("Automation Test Results.");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Rahul Choudhary");
		return extent;
	}
}
