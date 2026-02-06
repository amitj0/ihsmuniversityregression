package com.ihsm.university.testcases.flows.employee;

import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_ProfessionalInfoAcademics;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_ProfessionalInfoDegreeLvl;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_ProfessionalInfoTitle;
import com.ihsm.university.utilities.ExtentListener;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_DevResearch_Attestations;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_DevResearch_Patent;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_DevResearch_Rewards;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_DevResearch_SciResearch;
import com.ihsm.university.pageobjects.employee.professionalinformation.ProfInfo_Military;

public class IHSM_FullProfessionalInformation extends BaseClass {

	public void execute() throws Exception {
		logger.info("===== STARTING FULL PROFESSIONAL INFORMATION FLOW =====");
		SoftAssert soft = new SoftAssert();
		int failCount = 0;

		// --------------------------PROFESSIONAL INFORMATION FLOW -----------
		try {
			logger.info("Filling Professional Information...");
			ExtentListener.createNode("Professional Information");
			ProfInfo_ProfessionalInfoDegreeLvl profInfo = new ProfInfo_ProfessionalInfoDegreeLvl(getDriver());
			profInfo.fillProfessionalInformationForm("Диплом кандидата медицинских наук", "Biology",
					TestDataGenerator.randomUniversity(), TestDataGenerator.randomNumber(4), "01012026", "01012027",
					TestDataGenerator.randomNotes());
			logger.info("Professional Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			ExtentListener.createNode("Professional Prof Information");
			ProfInfo_ProfessionalInfoAcademics profAcadInfo = new ProfInfo_ProfessionalInfoAcademics(getDriver());
			profAcadInfo.fillAcademicInfoForm("Residency", "Сертификат", "01012026", "01012027",
					TestDataGenerator.randomAcademicDegree(), TestDataGenerator.randomUniversity(),
					TestDataGenerator.randomSpeciality(), TestDataGenerator.randomNumber(4), "01012028",
					TestDataGenerator.randomNotes());
			logger.info("Professional Academic Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Academic Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Academic Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			ExtentListener.createNode("Professional Title Information");
			ProfInfo_ProfessionalInfoTitle profTitleInfo = new ProfInfo_ProfessionalInfoTitle(getDriver());
			profTitleInfo.fillTitleForm("Professor", TestDataGenerator.randomUniversity(),
					TestDataGenerator.randomNumber(5), "01012026", TestDataGenerator.randomNotes(),
					TestDataGenerator.randomPhotoFile());
			logger.info("Professional Title Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Title Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Title Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			ProfInfo_DevResearch_SciResearch profSciResearchInfo = new ProfInfo_DevResearch_SciResearch(getDriver());
			profSciResearchInfo.fillDevResearchForm("Методические рекомедации", "01012026", "Республикалық деңгей",
					TestDataGenerator.randomUrl(), TestDataGenerator.randomMagazineName(),
					TestDataGenerator.randomArticleName(), TestDataGenerator.randomAuthors(),
					TestDataGenerator.randomNotes());
			logger.info("Professional Scientific Research Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Scientific Research Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Scientific Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			ProfInfo_DevResearch_Rewards profRewardsInfo = new ProfInfo_DevResearch_Rewards(getDriver());
			profRewardsInfo.fillRewardsForm(TestDataGenerator.randomDocumentType(), "01012026",
					TestDataGenerator.randomDocumentType(), TestDataGenerator.randomNumber(4),
					TestDataGenerator.randomNotes());
			logger.info("Professional Rewards Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Rewards Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Rewards Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			ProfInfo_DevResearch_Patent profPatentInfo = new ProfInfo_DevResearch_Patent(getDriver());
			profPatentInfo.fillDevResearchPatentForm("Patent", TestDataGenerator.randomInvention(), "Republican",
					TestDataGenerator.randomAuthors(), TestDataGenerator.randomString(4), "01012026",
					TestDataGenerator.randomNumber(5), TestDataGenerator.randomNotes());
			logger.info("Professional Patent Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Patent Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Patent Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			ProfInfo_DevResearch_Attestations profAttestationsInfo = new ProfInfo_DevResearch_Attestations(getDriver());
			profAttestationsInfo.fillAttestationsForm("Excellent", "Not Suitable", "Ok", "Appropriate", "01012026",
					TestDataGenerator.randomNotes());
			logger.info("Professional Attestations Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Attestations Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Attestations Information Failed :" + e.getMessage());
			failCount++;
		}

		try {
			ProfInfo_Military profMilitaryInfo = new ProfInfo_Military(getDriver());
			profMilitaryInfo.fillMilitaryInformationForm("Lieutenant General", TestDataGenerator.randomNumber(4),
					"01012026", TestDataGenerator.randomNotes());
			logger.info("Professional Military Information submitted successfully");
			ExtentListener.getNode().pass("Prfessional Military Information Test Passed");
		} catch (Exception e) {
			ExtentListener.getNode().fail(e);
			soft.fail("Employee Professional Military Information Failed :" + e.getMessage());
			failCount++;
		}
		ExtentListener.createNode("PROFESSIONAL INFORMATION FLOW SUMMARY");

		if (failCount == 0) {
			ExtentListener.getNode().pass("All Professional Information sections executed successfully.");
		} else {
			ExtentListener.getNode().fail("Total Failed Sections in Professional Information Flow: " + failCount);
		}
		soft.assertAll();
		logger.info("===== FULL PROFESSIONAL INFORMATION FLOW COMPLETED =====");
	}

}
