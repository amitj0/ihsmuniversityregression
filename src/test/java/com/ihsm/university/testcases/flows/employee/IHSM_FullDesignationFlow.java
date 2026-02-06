package com.ihsm.university.testcases.flows.employee;

import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.employee.designation.Designation_EmploymentRights;
import com.ihsm.university.pageobjects.employee.designation.Designation_Position;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_FullDesignationFlow extends BaseClass {
	public void execute() throws Exception {
		logger.info("===== STARTING FULL DESIGNATION INFORMATION FLOW =====");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		// --------------------------DESIGNATION INFORMATION FLOW -----------
		// Employee Rights
		try {
			logger.info("Filling Employee Rights Information...");
			ExtentListener.createNode("Employee Rights Information");
			Designation_EmploymentRights empRights = new Designation_EmploymentRights(getDriver());
			empRights.fillEmploymentRightsForm("Part Time", "0.25", "Transfer", TestDataGenerator.randomNumber(5),
					"01012026", "01012027", "Academic", "Vice Rector", "CENTRAL / Bachelor / MBBS", "2", "01012026",
					TestDataGenerator.randomNumber(3), "200000", TestDataGenerator.randomNotes());
			logger.info("Employee Rights Information submitted successfully");
			ExtentListener.getNode().pass("Employee Rights Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Rights Information Failed :" + e.getMessage());
			failCount++;
		}

		// Employee Position
		try {
			logger.info("Filling Employee Position Information.....");
			ExtentListener.createNode("Employee Position Information");
			Designation_Position empPosition = new Designation_Position(getDriver());
			empPosition.fillPositionInOtherOrgForm("Experience in IHSM", "01/01/2026", "01/01/2027",
					TestDataGenerator.randomUniversity(), TestDataGenerator.randomUniversityPosition(),
					TestDataGenerator.randomNotes());
			logger.info("Employee Position Information submitted successfully");
			ExtentListener.getNode().pass("Employee Position Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Position Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("DESIGNATION INFORMATION FLOW SUMMARY");

		if (failCount == 0) {
		    ExtentListener.getNode().pass("All Designation Information sections executed successfully.");
		} else {
		    ExtentListener.getNode().fail("Total Failed Sections in Designation Information Flow: " + failCount);
		}
		soft.assertAll();
		logger.info("===== FULL DESIGNATION INFORMATION FLOW COMPLETED =====");
	}

}
