package com.ihsm.university.utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ihsm.university.base.BaseClass;

import org.openqa.selenium.logging.*;
import org.testng.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class ExtentListener implements ITestListener {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> childTest = new ThreadLocal<>();

	// ================= SUITE START =================
	@Override
	public void onStart(ITestContext context) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
		String reportName = "IHSM_University_Report_" + timeStamp + ".html";

		String reportPath = System.getProperty("user.dir") + "/reports/" + reportName;

		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setDocumentTitle("IHSM University Automation Report");
		spark.config().setReportName("Automation Execution Report");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Project", "IHSM University");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("User", System.getProperty("user.name"));
	}

	// ================= TEST START =================
	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		ExtentTest parent = extent.createTest(testName);
		parent.assignAuthor("Automation Team");
		parent.assignCategory(result.getMethod().getGroups());

		parentTest.set(parent);
	}

	// ================= TEST PASS =================
	@Override
	public void onTestSuccess(ITestResult result) {

		parentTest.get().pass(MarkupHelper.createLabel("TEST PASSED", ExtentColor.GREEN));
	}

	// ================= TEST FAIL =================
	@Override
	public void onTestFailure(ITestResult result) {

		parentTest.get().fail(MarkupHelper.createLabel("TEST FAILED", ExtentColor.RED));

		parentTest.get().fail(result.getThrowable());

		try {
			String path = BaseClass.captureScreenshot(result.getName());
			parentTest.get().addScreenCaptureFromPath("../screenshots/" + new File(path).getName());
		} catch (Exception e) {
			parentTest.get().warning("Screenshot capture failed");
		}
	}

	// ================= TEST SKIP =================
	@Override
	public void onTestSkipped(ITestResult result) {

		parentTest.get().skip(MarkupHelper.createLabel("TEST SKIPPED", ExtentColor.YELLOW));
	}

	// ================= SUITE FINISH =================
	@Override
	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}
	}

	// ================= NODE CREATION =================
	public static ExtentTest createNode(String stepName) {

		ExtentTest node = parentTest.get().createNode(stepName);
		childTest.set(node);
		return node;
	}

	public static ExtentTest getNode() {
		return childTest.get();
	}

	public static ExtentTest getTest() {
		return parentTest.get();
	}
}
