package com.ihsm.university.testcases.flows.student;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.student.status.Status_Status;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_StatusFullFlowTest extends BaseClass {

	private StudentFullRegistrationDataVariables student;
	private Map<String, String> stepStatus;

	@Test(dependsOnMethods = "com.ihsm.university.testcases.flows.student.IHSM_AcademicFullFlowTest.qualificationInformation", dataProvider = "studentData", dataProviderClass = StudentFullRegistrationDataProvider.class)
	public void statusInformation(StudentFullRegistrationDataVariables student) {
		this.student = student;
		stepStatus = new LinkedHashMap<>();
		ExtentListener.createNode("Status Information");
		try {
			Status_Status statusInfo = new Status_Status(getDriver());
			statusInfo.fillStatusStatusForm(student.status, student.statusDate, student.statusCode,
					student.statusRemarks, getTestDataPath(student.statusImage));
			ExtentListener.getNode().pass("Status Information completed");
			stepStatus.put("Status Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Status Information failed: " + e.getMessage());
			stepStatus.put("Status Information", "FAIL");
		}
	}

	@AfterClass(alwaysRun = true)
	public void summarizeStatusFlow() {
		System.out.println(
				"==== Status Flow Status for Student: " + student.firstName + " " + student.lastName + " ====");
		stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
		System.out.println("=================================================");
	}
}
