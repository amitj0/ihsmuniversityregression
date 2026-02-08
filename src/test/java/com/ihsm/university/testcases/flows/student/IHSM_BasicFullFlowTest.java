package com.ihsm.university.testcases.flows.student;

import java.awt.AWTException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.student.basicinformation.*;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_BasicFullFlowTest extends BaseClass {

    public static String studentEnrollmentId;
    private StudentFullRegistrationDataVariables student;

    // Track status of each step
    private Map<String, String> stepStatus;

    @Test(dataProvider = "studentData", dataProviderClass = StudentFullRegistrationDataProvider.class)
    public void enrollmentInformation(StudentFullRegistrationDataVariables student) {
        this.student = student;
        stepStatus = new LinkedHashMap<>();
        ExtentListener.createNode("Enrollment Information");
        try {
            new BasicInfo_EnrollnmentInformation(getDriver())
                .fillEnrollmentInformation(student.term, student.course, student.year, student.semester, student.pin,
                    student.firstName, student.middleName, student.lastName, student.gender, student.dob, student.country,
                    student.state, student.mobile, student.email, student.nationality);
            ExtentListener.getNode().pass("Enrollment Information completed");
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
            new BasicInfo_PersonalInformation(getDriver())
                .fillPersonalInformationForm(student.firstName2, student.lastName2, student.city, student.maritalStatus, student.country2);
            ExtentListener.getNode().pass("Personal Information completed");
            stepStatus.put("Personal Information", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Personal Information failed: " + e.getMessage());
            stepStatus.put("Personal Information", "FAIL");
        }
    }

    @Test(dependsOnMethods = "personalInformation", alwaysRun = true)
    public void biometricsInformation() {
        ExtentListener.createNode("Biometrics Information");
        try {
            new BasicInfo_Biometrics(getDriver()).fillBiometricsInfo(getTestDataPath(student.biometricsImage));
            ExtentListener.getNode().pass("Biometrics Information completed");
            stepStatus.put("Biometrics Information", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Biometrics Information failed: " + e.getMessage());
            stepStatus.put("Biometrics Information", "FAIL");
        }
    }

    @Test(dependsOnMethods = "biometricsInformation", alwaysRun = true)
    public void familyInformation() {
        ExtentListener.createNode("Family Information");
        try {
            new BasicInfo_FamilyInformation(getDriver())
                .fillFamilyInformation(student.relation, student.familyName, student.familyDob, student.occupation,
                    student.countryCode, student.phone, student.dependent, student.famCountry, student.famState,
                    student.famCity, student.famNationality);
            ExtentListener.getNode().pass("Family Information completed");
            stepStatus.put("Family Information", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Family Information failed: " + e.getMessage());
            stepStatus.put("Family Information", "FAIL");
        }
    }

    @Test(dependsOnMethods = "familyInformation", alwaysRun = true)
    public void languageInformation() {
        ExtentListener.createNode("Language Information");
        try {
            new BasicInfo_LanguageInformation(getDriver())
                .fillLanguageInformationForm(student.language, student.languageLevel);
            ExtentListener.getNode().pass("Language Information completed");
            stepStatus.put("Language Information", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Language Information failed: " + e.getMessage());
            stepStatus.put("Language Information", "FAIL");
        }
    }

    @Test(dependsOnMethods = "languageInformation", alwaysRun = true)
    public void preRightsInformation() {
        ExtentListener.createNode("Pre Rights Information");
        try {
            new BasicInfo_GeneralInformation_Prerights(getDriver())
                .fillPreferRightsInformation(student.preRights, getTestDataPath(student.preRightsImage));
            ExtentListener.getNode().pass("Pre Rights Information completed");
            stepStatus.put("Pre Rights Information", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Pre Rights Information failed: " + e.getMessage());
            stepStatus.put("Pre Rights Information", "FAIL");
        }
    }

    @Test(dependsOnMethods = "preRightsInformation", alwaysRun = true)
    public void socialStatusInformation() {
        ExtentListener.createNode("Social Status Information");
        try {
            new BasicInfo_GeneralInformation_SocialStatus(getDriver())
                .fillSocialStatusForm(student.socialStatus, getTestDataPath(student.socialStatusImage));
            ExtentListener.getNode().pass("Social Status Information completed");
            stepStatus.put("Social Status Information", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Social Status Information failed: " + e.getMessage());
            stepStatus.put("Social Status Information", "FAIL");
        }
    }

    @Test(dependsOnMethods = "socialStatusInformation", alwaysRun = true)
    public void workLocationInformation() {
        ExtentListener.createNode("Work Location Information");
        try {
            new BasicInfo_GeneralInformation_SocialWorkLocation(getDriver())
                .fillSocialWorkLocationDetails(getTestDataPath(student.workLocationImage));
            ExtentListener.getNode().pass("Work Location Information completed");
            stepStatus.put("Work Location Information", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Work Location Information failed: " + e.getMessage());
            stepStatus.put("Work Location Information", "FAIL");
        }
    }

    @Test(dependsOnMethods = "workLocationInformation", alwaysRun = true)
    public void medicalVaccinationInformation() {
        ExtentListener.createNode("Medical Vaccination Information");
        try {
            new BasicInfo_MedicalInformation_Vaccination(getDriver())
                .fillVaccinationInfo(student.vacDose, student.vacNumber, student.vacDate, student.vacCode, student.vacRemarks, getTestDataPath(student.vacImage));
            ExtentListener.getNode().pass("Medical Vaccination completed");
            stepStatus.put("Medical Vaccination", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Medical Vaccination Information failed: " + e.getMessage());
            stepStatus.put("Medical Vaccination", "FAIL");
        }
    }

    @Test(dependsOnMethods = "medicalVaccinationInformation", alwaysRun = true)
    public void medicalAtPolyInformation() {
        ExtentListener.createNode("Medical At Poly Information");
        try {
            new BasicInfo_MedicalInforamtion_AtPoly(getDriver())
                .fillAtPolyMedicalInformation(student.polyDate, student.polyType, getTestDataPath(student.polyImage));
            ExtentListener.getNode().pass("Medical At Poly completed");
            stepStatus.put("Medical At Poly", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Medical At Poly Information failed: " + e.getMessage());
            stepStatus.put("Medical At Poly", "FAIL");
        }
    }

    @Test(dependsOnMethods = "medicalAtPolyInformation", alwaysRun = true)
    public void medicalInsuranceInformation() {
        ExtentListener.createNode("Medical Insurance Information");
        try {
            new BasicInfo_MedicalInformation_Insurance(getDriver())
                .fillInsuranceInformation(student.insStartDate, student.insEnd, getTestDataPath(student.insImage));
            ExtentListener.getNode().pass("Medical Insurance completed");
            stepStatus.put("Medical Insurance", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Medical Insurance Information failed: " + e.getMessage());
            stepStatus.put("Medical Insurance", "FAIL");
        }
    }

    @Test(dependsOnMethods = "medicalInsuranceInformation", alwaysRun = true)
    public void medicalDisabilityInformation() {
        ExtentListener.createNode("Medical Disability Information");
        try {
            new BasicInfo_MedicalInformation_Disability(getDriver())
                .fillDisabilityForm(student.disType, student.disCode, student.disDate, getTestDataPath(student.disImage));
            ExtentListener.getNode().pass("Medical Disability completed");
            stepStatus.put("Medical Disability", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Medical Disability Information failed: " + e.getMessage());
            stepStatus.put("Medical Disability", "FAIL");
        }
    }

    // ---------------- SUMMARY ----------------
    @AfterClass(alwaysRun = true)
    public void summarizeStudentFlow() {
        System.out.println("==== Basic Flow Status for Student: " + student.firstName + " " + student.lastName + " ====");
        stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
        System.out.println("=================================================");
    }
}
