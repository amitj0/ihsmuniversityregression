package com.ihsm.university.testcases.flows.classschedule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule_SubjectCredits;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule_SubjectHours;
import com.ihsm.university.pageobjects.classchedule.IHSM_FacultyGroupAssignment;
import com.ihsm.university.pageobjects.classchedule.IHSM_FacultyShowData;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_ClassSubjectCreditTest extends BaseClass {

	private WebDriver driver;

	public IHSM_ClassSubjectCreditTest(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 0)
	public void verifySubjectCredit() {

		ExtentListener.createNode("Subject Credit Information");
		logger.info("Filling Subject Credit Information...");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		try {
			IHSM_ClassSchedule_SubjectCredits subject = new IHSM_ClassSchedule_SubjectCredits(getDriver());
			subject.fillSubjectCreditInformatioin("2026 -2027", "1", 1, "1", "1");
			logger.info("Subject credit add successfully");
			ExtentListener.getNode().pass("Subject Credit Information Test Passed");

		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Subject Credit Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("SUBJECT CREDIT INFORMATION");

		if (failCount == 0) {
		    ExtentListener.getNode().pass("All Subject Credit Information sections executed successfully.");
		} else {
		    ExtentListener.getNode().fail("Total Failed Sections in Subject Credit Information Flow: " + failCount);
		}

		soft.assertAll();
	}

}
