package com.ihsm.university.testcases.flows.employee;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.employee.documents.Documents_Documents;
import com.ihsm.university.pageobjects.employee.documents.Documents_Passport;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_DocumentFullFlowTest extends BaseClass {

	private Map<String, String> stepStatus = new LinkedHashMap<>();

	@Test
	public void documentsInformation() {
		ExtentListener.createNode("Document Information");
		try {
			Documents_Documents docInfo = new Documents_Documents(getDriver());
			docInfo.fillDocumentInformation("Diploma", TestDataGenerator.randomNotes(),
					TestDataGenerator.randomPhotoFile());
			ExtentListener.getNode().pass("Documents Information completed");
			stepStatus.put("Document Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Documents Information failed: " + e.getMessage());
			stepStatus.put("Document Information", "FAIL");
		}
	}

	@Test(dependsOnMethods = "documentsInformation", alwaysRun = true)
	public void passportInformation() {
		boolean skipThisTest = true;

		if (skipThisTest) {
		    stepStatus.put("Passport Information", "SKIPPED");
		    throw new SkipException("Skipping Passport Information – loader issue");
		}

		ExtentListener.createNode("Passport Information");
		try {
			Documents_Passport docPassInfo = new Documents_Passport(getDriver());
			docPassInfo.fillPassportDetails("Development", "England", TestDataGenerator.randomIssueAgency(),
					TestDataGenerator.randomNumber(5), "ABCD1234567", "Manchester", "01012026", "01012027");
			ExtentListener.getNode().pass("Passport Information completed");
			stepStatus.put("Passport Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Passport Information failed: " + e.getMessage());
			stepStatus.put("Passport Information", "FAIL");
		}
	}

	// ---------------- SUMMARY ----------------
	@AfterClass(alwaysRun = true)
	public void summarizeDocumentsFlow() {
		System.out.println("==== Documents Flow Status for Employee ====");
		stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
		System.out.println("=================================================");
	}
}
