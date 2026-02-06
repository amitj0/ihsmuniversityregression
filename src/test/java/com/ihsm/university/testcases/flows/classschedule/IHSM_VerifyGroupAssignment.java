package com.ihsm.university.testcases.flows.classschedule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_FacultyGroupAssignment;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_VerifyGroupAssignment extends BaseClass {

	private WebDriver driver;

	public IHSM_VerifyGroupAssignment(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 2)
	public void verifyGroupAssignment() {
		ExtentListener.createNode("Group Assignment Information");
		logger.info("Filling Group Assignment Information...");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		try {
			IHSM_FacultyGroupAssignment facultyGroup = new IHSM_FacultyGroupAssignment(getDriver());
			facultyGroup.fillGroupAssignmentInfo("2026 -2027", "1", "CENTRAL / Bachelor / MBBS", "1", "Main");
			logger.info("Group Assignment Information Successfully");
			ExtentListener.getNode().pass("Group Assignment Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Group Assignment Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("GROUP ASSIGNMENT INFORMATION");

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Group Assignment Information sections executed successfully.");
		} else {
			ExtentListener.getNode().fail("Total Failed Sections in Group Assignment Information Flow: " + failCount);
		}

		soft.assertAll();
	}
}
