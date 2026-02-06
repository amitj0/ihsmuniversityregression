package com.ihsm.university.testcases.flows.employee;

import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.employee.designation.Designation_EmploymentRights;
import com.ihsm.university.pageobjects.employee.designation.Designation_Position;
import com.ihsm.university.pageobjects.employee.documents.Documents_Documents;
import com.ihsm.university.pageobjects.employee.documents.Documents_Passport;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_FullDocumentsFlow extends BaseClass {

	public void execute() throws Exception {
		logger.info("===== STARTING FULL DOCUMENTS INFORMATION FLOW =====");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;
		// --------------------------DOCUMENTS INFORMATION FLOW -----------
		// Documents
		try {
			logger.info("Filling Documents Information...");
			ExtentListener.createNode("Document Information");
			Documents_Documents docInfo = new Documents_Documents(getDriver());
			docInfo.fillDocumentInformation("Diploma", TestDataGenerator.randomNotes(),
					TestDataGenerator.randomPhotoFile());
			logger.info("Documents Information submitted successfully");
			ExtentListener.getNode().pass("Documents Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Documents Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			logger.info("Filling Passport Information.....");
			ExtentListener.createNode("Passport Information");
			Documents_Passport docPassInfo = new Documents_Passport(getDriver());
			docPassInfo.fillPassportDetails("Development", "England", TestDataGenerator.randomIssueAgency(),
					TestDataGenerator.randomNumber(5), "ABCD1234567", "Manchester",
					"01012026", "01012027");
			logger.info("Passport Information submitted successfully");
			ExtentListener.getNode().pass("Passport Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Passport Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("DOCUMENTS INFORMATION FLOW SUMMARY");

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Documents Information sections executed successfully.");
		} else {
			ExtentListener.getNode().fail("Total Failed Sections in Documents Information Flow: " + failCount);
		}
		soft.assertAll();
		logger.info("===== FULL DESIGNATION INFORMATION FLOW COMPLETED =====");
	}

}
