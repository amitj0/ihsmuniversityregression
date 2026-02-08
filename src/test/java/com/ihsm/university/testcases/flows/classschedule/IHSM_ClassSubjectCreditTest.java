package com.ihsm.university.testcases.flows.classschedule;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule_SubjectCredits;
import com.ihsm.university.pageobjects.classchedule.IHSM_ClassSchedule_SubjectHours;
import com.ihsm.university.utilities.ClassScheduleCreditDataProvider;
import com.ihsm.university.utilities.ExtentListener;
import com.ihsm.university.utilities.RetryAnalyzer;

public class IHSM_ClassSubjectCreditTest extends BaseClass {

	private Map<String, String> stepStatus = new LinkedHashMap<>();

	@Test(retryAnalyzer = RetryAnalyzer.class, priority = 0, dataProvider = "subjectCreditData", dataProviderClass = ClassScheduleCreditDataProvider.class, testName = "Verify Subject Credit")
	public void verifySubjectCredit(String sessionField, String batchField, String academicPlanField, String semField,
			String value) {

		ExtentListener.createNode("Subject Credit Information");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;

		try {
			IHSM_ClassSchedule_SubjectCredits subject = new IHSM_ClassSchedule_SubjectCredits(getDriver());
			int academicPlan = Integer.parseInt(academicPlanField.trim());
			subject.fillSubjectCreditInformatioin(sessionField, batchField, academicPlan, semField, value);
			ExtentListener.getNode().pass("Subject Credit Information Test Passed");
			stepStatus.put("Subject Credit", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Subject Credit Information failed: " + e.getMessage());
			stepStatus.put("Subject Credit", "FAIL");
			soft.fail("Subject Credit Information failed: " + e.getMessage());
			failCount++;
		}

		if (failCount > 0) {
			ExtentListener.getNode().fail("Total Failed Sections in Subject Credit Flow: " + failCount);
		}

		soft.assertAll();
	}

	@Test(testName = "Verify Subject Hours",priority = 1, dependsOnMethods = "verifySubjectCredit", alwaysRun = true)
	public void verifySubjectHours() {
		ExtentListener.createNode("Subject Credit HOURS Information");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;

		try {
			IHSM_ClassSchedule_SubjectHours hours = new IHSM_ClassSchedule_SubjectHours(getDriver());
			hours.fillSubjectHoursInformation("2026 -2027", "1", 1, "1", "900", "900", "900", "900", "900", "900",
					"500", "300", "50", "50", "Exam", "40", "100", "40", "70");
			ExtentListener.getNode().pass("Subject Credit HOURS Information Test Passed");
			stepStatus.put("Subject Hours", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Subject Credit HOURS Information failed: " + e.getMessage());
			stepStatus.put("Subject Hours", "FAIL");
			soft.fail("Subject Credit HOURS Information failed: " + e.getMessage());
			failCount++;
		}

		if (failCount > 0) {
			ExtentListener.getNode().fail("Total Failed Sections in Subject Credit HOURS Flow: " + failCount);
		}

		soft.assertAll();
	}

	@AfterClass(alwaysRun = true)
	public void summarizeClassSubjectCreditFlow() {
		System.out.println("==== Class Subject Credit Flow Status ====");
		stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
		System.out.println("=========================================");
	}
}
