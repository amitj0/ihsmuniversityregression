package com.ihsm.university.testcases.flows.classschedule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_FacultyShowData;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_ShowDataGroupAssignTest extends BaseClass {

	private WebDriver driver;

	public IHSM_ShowDataGroupAssignTest(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void showDataofGroupAssignment() {
		ExtentListener.createNode("Group Assign Information");
		logger.info("Filling Group Assign Data Information...");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		try {
			IHSM_FacultyShowData data = new IHSM_FacultyShowData(getDriver());
			data.fillFacultyShowData("2026 -2027", "1", "CENTRAL / Bachelor / MBBS", "1", "Демонстрационный факультет 3 (Demo Faculty 3)");
			logger.info("Group Assign Data add successfully");
			ExtentListener.getNode().pass("Subject Assign Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Group Assign Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("GROUP ASSIGN INFORMATION");

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Group Assign  Information sections executed successfully.");
		} else {
			ExtentListener.getNode().fail("Total Failed Sections in Group Assign  Information Flow: " + failCount);
		}

		soft.assertAll();
	}

}
