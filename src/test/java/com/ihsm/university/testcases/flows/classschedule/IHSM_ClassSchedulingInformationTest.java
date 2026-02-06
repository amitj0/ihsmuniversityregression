package com.ihsm.university.testcases.flows.classschedule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_ClassSchedulingInformationTest extends BaseClass {

	String[] dates = TestDataGenerator.getRandomScheduleDates();
	private WebDriver driver;

	public IHSM_ClassSchedulingInformationTest(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 3)
	public void verifyClassScheduleInfo() throws InterruptedException {
		ExtentListener.createNode("Subject Credit Information");
		logger.info("Filling Class Scheduling Information...");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		try {
			IHSM_ClassSchedule classInfo = new IHSM_ClassSchedule(getDriver());
			classInfo.fillClassSchedulingInformation("2026 -2027", "1", 1, 1, 1, dates[0], dates[1], "MON,FRI",
					"1 Class Every Week", "08:00 - 09:35");
			logger.info("Class Scheduling add successfully");
			ExtentListener.getNode().pass("Class Scheduling Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Class Scheduling Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("CLASS SCHEDULING INFORMATION");

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Class Scheduling Information sections executed successfully.");
		} else {
			ExtentListener.getNode().fail("Total Failed Sections in Class Scheduling Information Flow: " + failCount);
		}

		soft.assertAll();
	}

}
