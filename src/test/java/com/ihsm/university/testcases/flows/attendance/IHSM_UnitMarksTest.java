package com.ihsm.university.testcases.flows.attendance;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.attandence.IHSM_ClassAttendance;
import com.ihsm.university.pageobjects.attandence.IHSM_UnitMarks;
import com.ihsm.university.testcases.flows.classschedule.TestDataGenerator;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_UnitMarksTest extends BaseClass {
	private Map<String, String> stepStatus = new LinkedHashMap<>();
	private SoftAssert soft = new SoftAssert();

	@Test(priority = 0, testName = "Verify Class Unit Marks")
	public void verifyClassAttendace2() {

		String[] dates = TestDataGenerator.getRandomScheduleDates();

		ExtentListener.createNode("Class Unit Marks Information");
		int failCount = 0;
		
		boolean skipThisTest = true;

		if (skipThisTest) {
		    stepStatus.put("Unit Marks Information", "SKIPPED");
		    throw new SkipException("Skipping Unit Marks Information – UI issue");
		}

		try {
			List<Integer> attendanceValues = Arrays.asList(20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				    20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20);
			IHSM_UnitMarks classUnitMarks = new IHSM_UnitMarks(getDriver());
			classUnitMarks.fillUnitMarksInformation("09022026", "100", "100", attendanceValues);
			ExtentListener.getNode().pass("Class Unit Marks added successfully");
			stepStatus.put("Class Unit Marks", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Class Unit Marks  failed: " + e.getMessage());
			stepStatus.put("Class Unit Marks", "FAIL");
			soft.fail("Class Unit Marks  failed: " + e.getMessage());
			failCount++;
		}

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Class Unit Marks sections executed successfully.");
		} else {
			ExtentListener.getNode().fail("Total Failed Sections in Class Unit Marks  Flow: " + failCount);
		}

		soft.assertAll();
	}

}
