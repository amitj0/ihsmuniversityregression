package com.ihsm.university.testcases.flows.employee;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_BiometricsInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_EnrollnmentInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_GuardianInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_LanguageInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_PersonalInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_VaccinationInformation;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_BasicFullFlowTest extends BaseClass {

	private Map<String, String> stepStatus = new LinkedHashMap<>();

	@Test
	public void enrollmentInformation() {
		ExtentListener.createNode("Enrollment Information");
		try {
			BasicInfo_EnrollnmentInformation enrollInfo = new BasicInfo_EnrollnmentInformation(getDriver());
			enrollInfo.fillEnrollnmentInformationForm(TestDataGenerator.generateRandomRussianFirstName(),
					TestDataGenerator.generateRandomFirstName(), TestDataGenerator.generateRandomGender(),
					TestDataGenerator.randomNumber(5), TestDataGenerator.randomEmail(), "India");
			ExtentListener.getNode().pass("Employee Enrollment Information completed");
			stepStatus.put("Enrollment Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Enrollment Information failed: " + e.getMessage());
			stepStatus.put("Enrollment Information", "FAIL");
		}
	}

	@Test(dependsOnMethods = "enrollmentInformation", alwaysRun = true)
	public void personalInformation() {
		ExtentListener.createNode("Personal Information");
		try {
			BasicInfo_PersonalInformation personalInfo = new BasicInfo_PersonalInformation(getDriver());
			personalInfo.fillPersonalInformationForm(TestDataGenerator.randomString(4),
					TestDataGenerator.randomString(3), TestDataGenerator.randomNumber(4),
					TestDataGenerator.randomNumber(5), "01012000", TestDataGenerator.generateRandomGender(),
					"Разведен(а) официально (развод зарегистрирован)", "01012026", "91",
					TestDataGenerator.randomPhone(), TestDataGenerator.randomIndianAddress(),
					TestDataGenerator.randomIndianAddress());
			ExtentListener.getNode().pass("Employee Personal Information completed");
			stepStatus.put("Personal Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Personal Information failed: " + e.getMessage());
			stepStatus.put("Personal Information", "FAIL");
		}
	}

	@Test(dependsOnMethods = "personalInformation", alwaysRun = true)
	public void guardianInformation() {
		ExtentListener.createNode("Guardian Information");
		try {
			BasicInfo_GuardianInformation guardianInfo = new BasicInfo_GuardianInformation(getDriver());
			guardianInfo.fillGuardianInformationForm("Father", TestDataGenerator.randomGuardianName(), "01011970",
					"No");
			ExtentListener.getNode().pass("Employee Guardian Information completed");
			stepStatus.put("Guardian Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Guardian Information failed: " + e.getMessage());
			stepStatus.put("Guardian Information", "FAIL");
		}
	}

	@Test(dependsOnMethods = "guardianInformation", alwaysRun = true)
	public void languageInformation() {
		ExtentListener.createNode("Language Information");
		try {
			BasicInfo_LanguageInformation languageInfo = new BasicInfo_LanguageInformation(getDriver());
			languageInfo.fillLanguageInformation("сертификат Duolingo", "B2");
			ExtentListener.getNode().pass("Employee Language Information completed");
			stepStatus.put("Language Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Language Information failed: " + e.getMessage());
			stepStatus.put("Language Information", "FAIL");
		}
	}

	@Test(dependsOnMethods = "languageInformation", alwaysRun = true)
	public void vaccinationInformation() {
		ExtentListener.createNode("Vaccination Information");
		try {
			BasicInfo_VaccinationInformation vaccinationInfo = new BasicInfo_VaccinationInformation(getDriver());
			vaccinationInfo.fillVaccinationForm("AstraZeneca", "2", TestDataGenerator.randomNumber(5), "01012026",
					TestDataGenerator.randomNotes());
			ExtentListener.getNode().pass("Employee Vaccination Information completed");
			stepStatus.put("Vaccination Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Vaccination Information failed: " + e.getMessage());
			stepStatus.put("Vaccination Information", "FAIL");
		}
	}

	@Test(dependsOnMethods = "vaccinationInformation", alwaysRun = true)
	public void biometricsInformation() {
		ExtentListener.createNode("Biometrics Information");
		try {
			BasicInfo_BiometricsInformation biometricsInfo = new BasicInfo_BiometricsInformation(getDriver());
			biometricsInfo.fillBiometricsInfo(TestDataGenerator.randomEmployeePhotoFile());
			ExtentListener.getNode().pass("Employee Biometrics Information completed");
			stepStatus.put("Biometrics Information", "PASS");
		} catch (Exception e) {
			ExtentListener.getNode().fail("Biometrics Information failed: " + e.getMessage());
			stepStatus.put("Biometrics Information", "FAIL");
		}
	}

	// ---------------- SUMMARY ----------------
	@AfterClass(alwaysRun = true)
	public void summarizeEmployeeFlow() {
		System.out.println("==== Basic Flow Status for Employee ====");
		stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
		System.out.println("=================================================");
	}
}
