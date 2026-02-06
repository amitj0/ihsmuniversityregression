package com.ihsm.university.testcases.flows.classschedule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule_SubjectHours;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_SubjectCreditHoursTest extends BaseClass {

	private WebDriver driver;

	public IHSM_SubjectCreditHoursTest(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void verifySubjectCredit() {
		ExtentListener.createNode("Subject Credit HOURS Information");
		logger.info("Filling Subject Credit Information...");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		try {
			IHSM_ClassSchedule_SubjectHours hours = new IHSM_ClassSchedule_SubjectHours(getDriver());
			hours.fillSubjectHoursInformation("2026 -2027", "1", 1, "1", "900", "900", "900", "900", "900", "900",
					"500", "300", "50", "50", "Exam", "40", "100", "40", "70");
			logger.info("Subject credit HOURS add successfully");
			ExtentListener.getNode().pass("Subject Credit HOURS Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Subject Credit HOURS Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("SUBJECT CREDIT HOURS INFORMATION");

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Subject Credit HOURS Information sections executed successfully.");
		} else {
			ExtentListener.getNode()
					.fail("Total Failed Sections in Subject Credit HOURS Information Flow: " + failCount);
		}

		soft.assertAll();
	}

}
