package com.ihsm.university.testcases.flows.student;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.student.documents.*;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_DocumentFullFlowTest extends BaseClass {

	private StudentFullRegistrationDataVariables student;
	private Map<String, String> stepStatus; // Track status per step
	private SoftAssert soft = new SoftAssert();

	@Test(dependsOnMethods = "com.ihsm.university.testcases.flows.student.IHSM_BasicFullFlowTest.medicalDisabilityInformation", dataProvider = "studentData", dataProviderClass = StudentFullRegistrationDataProvider.class)
	public void otherDocumentsInformation(StudentFullRegistrationDataVariables student) {
		this.student = student;
		stepStatus = new LinkedHashMap<>();
		ExtentListener.createNode("Other Documents Information");
		try {
			Documents_OtherDocuments documentsPage = new Documents_OtherDocuments(getDriver());
			documentsPage.fillOtherDocumentsForm(student.otherDocumentName,
					getTestDataPath(student.otherDocumentImage));
			ExtentListener.getNode().pass("Other Documents Information completed");
			stepStatus.put("Other Documents", "PASS");
			boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
			soft.assertTrue(allPassed, "One or more steps in Other Documents Flow failed!");

		} catch (Exception e) {
			ExtentListener.getNode().fail("Other Documents Information failed: " + e.getMessage());
			stepStatus.put("Other Documents", "FAIL");
			soft.fail("Other Documents Information Failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "otherDocumentsInformation", alwaysRun = true)
	public void identificationInformation() {
		ExtentListener.createNode("Identification Card Information");
		try {
			new Documents_IdentificationCard(getDriver()).fillIdentificationCardDetails(student.idNumber,
					student.idCountry, student.idIssueDate, student.idExpiryDate, getTestDataPath(student.idImage));
			ExtentListener.getNode().pass("Identification Card Information completed");
			stepStatus.put("Identification Card", "PASS");
			boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
			soft.assertTrue(allPassed, "One or more steps in Other Documents Flow failed!");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Identification Card Information failed: " + e.getMessage());
			stepStatus.put("Identification Card", "FAIL");
			soft.fail("Documents Identification Card Information Failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "identificationInformation", alwaysRun = true)
	public void visaOfflineInformation() {
		ExtentListener.createNode("Visa Offline Information");
		try {
			new Documents_VisaInfo_OffVisa(getDriver()).fillVisaInfoOffVisaForm(student.visaType,
					student.visaPlaceOfIssue, student.visaIssueDate, student.visaStartDate, student.visaEndDate,
					student.visaRenewDate, student.visaNumber, student.visaCountry, student.visaRemarks,
					getTestDataPath(student.visaImage));
			ExtentListener.getNode().pass("Visa Offline Information completed");
			stepStatus.put("Visa Offline", "PASS");
			boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
			soft.assertTrue(allPassed, "One or more steps in Other Documents Visa Information Flow failed!");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Visa Offline Information failed: " + e.getMessage());
			stepStatus.put("Visa Offline", "FAIL");
			soft.fail("Other Documents Visa Offline Information Failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "visaOfflineInformation", alwaysRun = true)
	public void visaOnlineInformation() {
		ExtentListener.createNode("Visa Online Information");
		try {
			new Documents_VisaInfo_OnVisa(getDriver()).fillOnlineVisaInfo(student.visaOnlineType,
					student.visaOnlineStartDate, student.visaOnlineIssueDate, student.visaOnlineEndDate,
					student.visaOnlineNumber);
			ExtentListener.getNode().pass("Visa Online Information completed");
			stepStatus.put("Visa Online", "PASS");
			boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
			soft.assertTrue(allPassed, "One or more steps in Other Documents Visa Online Information Flow failed!");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Visa Online Information failed: " + e.getMessage());
			stepStatus.put("Visa Online", "FAIL");
			soft.fail("Other Documents Visa Online Information Failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "visaOnlineInformation", alwaysRun = true)
	public void visaRegisterInformation() {
		ExtentListener.createNode("Visa Register Information");
		try {
			new Documents_VisaInfo_Register(getDriver()).fillRegisterInfo(student.visaRegisterPlace,
					student.visaRegisterCountry, student.visaRegisterDate, student.visaRegisterRemarks);
			ExtentListener.getNode().pass("Visa Register Information completed");
			stepStatus.put("Visa Register", "PASS");
			boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
			soft.assertTrue(allPassed, "One or more steps in Other Documents Visa Register Flow failed!");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Visa Register Information failed: " + e.getMessage());
			stepStatus.put("Visa Register", "FAIL");
			soft.fail("Other Documents Visa Register Information Failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "visaRegisterInformation", alwaysRun = true)
	public void passportLocationInformation() {
		ExtentListener.createNode("Passport Location Information");
		try {
			new Documents_VisaInfo_PassportLocation(getDriver()).fillPassportLocationInfo(student.passportLocation,
					student.passportLocationDate);
			ExtentListener.getNode().pass("Passport Location Information completed");
			stepStatus.put("Passport Location", "PASS");
			boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
			soft.assertTrue(allPassed, "One or more steps in Other Documents Passport Location Flow failed!");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Passport Location Information failed: " + e.getMessage());
			stepStatus.put("Passport Location", "FAIL");
			soft.fail("Other Documents Passport Location Information Failed: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "passportLocationInformation", alwaysRun = true)
	public void passportInformation() {
		ExtentListener.createNode("Passport Information");
		try {
			new Documents_PassportInformation(getDriver()).fillPassportInformation(student.passportNumber,
					student.passportIssuePlace, student.passportIssueDate, student.passportExpiryDate);
			ExtentListener.getNode().pass("Passport Information completed");
			stepStatus.put("Passport Information", "PASS");
			boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
			soft.assertTrue(allPassed, "One or more steps in Other Documents Pass Information Flow failed!");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Passport Information failed: " + e.getMessage());
			stepStatus.put("Passport Information", "FAIL");
			soft.fail("Other Documents Passport Information Failed: " + e.getMessage());
		}
	}

	// ---------------- SUMMARY ----------------
	@AfterClass(alwaysRun = true)
	public void summarizeDocumentFlow() {
		System.out.println(
				"==== Document Flow Status for Student: " + student.firstName + " " + student.lastName + " ====");
		stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
		System.out.println("=================================================");
	}
}
