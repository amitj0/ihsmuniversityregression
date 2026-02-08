package com.ihsm.university.utilities;

import org.testng.annotations.DataProvider;

public class ClassScheduleCreditDataProvider {

	@DataProvider(name = "subjectCreditData")
	public Object[][] subjectCreditData() {

		String filePath = System.getProperty("user.dir")
				+ "/src/test/resources/student_registration.xlsx";

		return ExamUtility.getTestData(filePath, "subjectCreditData");
	}
}
