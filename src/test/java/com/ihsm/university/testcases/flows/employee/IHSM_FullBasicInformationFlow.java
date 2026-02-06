package com.ihsm.university.testcases.flows.employee;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.markuputils.Markup;
import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_BiometricsInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_EnrollnmentInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_GuardianInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_LanguageInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_PersonalInformation;
import com.ihsm.university.pageobjects.employee.basicinformation.BasicInfo_VaccinationInformation;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_FullBasicInformationFlow extends BaseClass {

	public void execute() throws Exception {
		logger.info("===== STARTING FULL BASIC INFORMATION FLOW =====");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;

		// --------------------------BASIC INFORMATION FLOW -----------
		// Enrollnment Information
		try {
			ExtentListener.createNode("Enrollnment Information");
			logger.info("Filling Employee Enrollnment Information...");
			BasicInfo_EnrollnmentInformation enrollInfo = new BasicInfo_EnrollnmentInformation(getDriver());
			enrollInfo.fillEnrollnmentInformationForm(TestDataGenerator.generateRandomRussianFirstName(),
					TestDataGenerator.generateRandomFirstName(), TestDataGenerator.generateRandomGender(),
					TestDataGenerator.randomNumber(5), TestDataGenerator.randomEmail(), "India");
			logger.info("Employee Enrollnment Information submitted successfully");
			ExtentListener.getNode().pass("Employee Enrollnment Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Enrollnment Information Failed :" + e.getMessage());
			failCount++;
		}
		// Personal Information
//		try {
//			ExtentListener.createNode("Personal Information");
//			logger.info("Filling Employee Personal Information...");
//			BasicInfo_PersonalInformation personalInfo = new BasicInfo_PersonalInformation(getDriver());
//			personalInfo.fillPersonalInformationForm(TestDataGenerator.randomString(4),
//					TestDataGenerator.randomString(3), TestDataGenerator.randomNumber(4),
//					TestDataGenerator.randomNumber(5), "01012000", TestDataGenerator.generateRandomGender(),
//					"Разведен(а) официально (развод зарегистрирован)", "01012026", "91",
//					TestDataGenerator.randomPhone(), TestDataGenerator.randomIndianAddress(),
//					TestDataGenerator.randomIndianAddress());
//			logger.info("Employee Personal Information submitted successfully");
//			ExtentListener.getNode().pass("Employee Personal Information Test Passed");
//		} catch (Exception e) {
//			ExtentListener.getNode().fail(e);
//			soft.fail("Employee Personal Information Failed :" + e.getMessage());
//			failCount++;
//		}
//
//		// Guardian Information
//		try {
//			ExtentListener.createNode("Guardian Information");
//			logger.info("Filling Employee Guardian Information...");
//			BasicInfo_GuardianInformation guardianInfo = new BasicInfo_GuardianInformation(getDriver());
//			guardianInfo.fillGuardianInformationForm("Father", TestDataGenerator.randomGuardianName(), "01011970",
//					"No");
//			logger.info("Employee Guardian Information submitted successfully");
//			ExtentListener.getNode().pass("Employee Guardian Information Test Passed");
//		} catch (Exception e) {
//			ExtentListener.getNode().fail(e);
//			soft.fail("Employee Guardian Information Failed :" + e.getMessage());
//			failCount++;
//		}
//
//		// Language Information
//		try {
//			ExtentListener.createNode("Language Information");
//			logger.info("Filling Employee Language Information...");
//			BasicInfo_LanguageInformation languageInfo = new BasicInfo_LanguageInformation(getDriver());
//			languageInfo.fillLanguageInformation("сертификат Duolingo", "B2");
//			logger.info("Employee Language Information submitted successfully");
//			ExtentListener.getNode().pass("Employee Language Information Test Passed");
//		} catch (Exception e) {
//			ExtentListener.getNode().fail(e);
//			soft.fail("Employee Language Information Failed :" + e.getMessage());
//			failCount++;
//		}
//
//		// Vaccination Information
//		try {
//			ExtentListener.createNode("Vaccination Information");
//			logger.info("Filling Employee Vaccination Information...");
//			BasicInfo_VaccinationInformation vaccinationInfo = new BasicInfo_VaccinationInformation(getDriver());
//			vaccinationInfo.fillVaccinationForm("AstraZeneca", "2", TestDataGenerator.randomNumber(5), "01012026",
//					TestDataGenerator.randomNotes());
//			logger.info("Employee Vaccination Information submitted successfully");
//			ExtentListener.getNode().pass("Employee Vaccination Information Test Passed");
//		} catch (Exception e) {
//			ExtentListener.getNode().fail(e);
//			soft.fail("Employee Vaccination Information Failed :" + e.getMessage());
//			failCount++;
//		}
//
//		// Biometrics Information
//		try {
//			ExtentListener.createNode("Biometrics Information");
//			logger.info("Filling Employee Biometrics Information...");
//			BasicInfo_BiometricsInformation biometricsInfo = new BasicInfo_BiometricsInformation(getDriver());
//			biometricsInfo.fillBiometricsInfo(TestDataGenerator.randomEmployeePhotoFile());
//			logger.info("Employee Biometrics Information submitted successfully");
//			ExtentListener.getNode().pass("Employee Biometrics Information Test Passed");
//		} catch (Exception e) {
//			ExtentListener.getNode().fail(e);
//			soft.fail("Employee Biometrics Information Failed :" + e.getMessage());
//			failCount++;
//		}
//		ExtentListener.createNode("BASIC INFORMATION FLOW SUMMARY");
//
//		if (failCount == 0) {
//			ExtentListener.getNode().pass("All Basic Information sections executed successfully.");
//		} else {
//			ExtentListener.getNode().fail("Total Failed Sections in Basic Information Flow: " + failCount);
//		}
//
//		soft.assertAll();
		logger.info("===== FULL BASIC INFORMATION FLOW COMPLETED =====");
	}

}
