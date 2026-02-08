package com.ihsm.university.testcases.flows.student;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.student.academics.*;
import com.ihsm.university.utilities.ExtentListener;

public class IHSM_AcademicFullFlowTest extends BaseClass {

    private StudentFullRegistrationDataVariables student;
    private Map<String, String> stepStatus; // Track status per step

    // ---------------- LAST EDUCATION ----------------
    @Test(dependsOnMethods = "com.ihsm.university.testcases.flows.student.IHSM_DocumentFullFlowTest.passportInformation", 
          dataProvider = "studentData", dataProviderClass = StudentFullRegistrationDataProvider.class)
    public void lastEducationInformation(StudentFullRegistrationDataVariables student) {
        this.student = student;
        stepStatus = new LinkedHashMap<>();
        ExtentListener.createNode("Academics - Last Education Information");
        try {
            Academics_Qualification_LastEducation lastInfo = new Academics_Qualification_LastEducation(getDriver());
            lastInfo.fillLastEducationInfo(student.lastEducation, student.lastEducationSchool,
                    student.lastEducationStartDate, student.lastEducationEndDate, student.lastEducationGraduationDate,
                    student.lastEducationMarks, student.lastEducationSubject, student.lastEducationPercentage,
                    getTestDataPath(student.lastEducationImage));
            ExtentListener.getNode().pass("Last Education Information completed");
            stepStatus.put("Last Education", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Last Education Information failed: " + e.getMessage());
            stepStatus.put("Last Education", "FAIL");
        }
    }

    // ---------------- DIPLOMA ----------------
    @Test(dependsOnMethods = "lastEducationInformation", alwaysRun = true)
    public void diplomaInformation() {
        ExtentListener.createNode("Academics - Diploma Information");
        try {
            Academics_Qualification_Diploma diplomaInfo = new Academics_Qualification_Diploma(getDriver());
            diplomaInfo.fillDiplomaDetails(student.diplomaCode, student.diplomaNumber, student.diplomaRegistration,
                    student.diplomaStartDate, student.diplomaEndDate, student.diplomaInstitution, student.diplomaRemarks,
                    student.diplomaType, student.diplomaMarks, student.diplomaGraduationDate,
                    getTestDataPath(student.diplomaImage));
            ExtentListener.getNode().pass("Diploma Information completed");
            stepStatus.put("Diploma", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Diploma Information failed: " + e.getMessage());
            stepStatus.put("Diploma", "FAIL");
        }
    }

    // ---------------- QUALIFICATION ----------------
    @Test(dependsOnMethods = "diplomaInformation", alwaysRun = true)
    public void qualificationInformation() {
        ExtentListener.createNode("Academics - Qualification Information");
        try {
            Academics_Qualification_Qualification qualificationInfo = new Academics_Qualification_Qualification(getDriver());
            qualificationInfo.fillQualificationInformation(student.qualificationType, student.qualificationInstitution,
                    student.qualificationRegistrationNumber, student.qualificationStartDate, student.qualificationEndDate,
                    student.qualificationCompletionDate, student.qualificationStatus, student.qualificationCountry,
                    student.qualificationState, student.qualificationCity, getTestDataPath(student.qualificationImage));
            ExtentListener.getNode().pass("Qualification Information completed");
            stepStatus.put("Qualification", "PASS");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Qualification Information failed: " + e.getMessage());
            stepStatus.put("Qualification", "FAIL");
        }
    }

    // ---------------- SUMMARY ----------------
    @AfterClass(alwaysRun = true)
    public void summarizeAcademicFlow() {
        System.out.println("==== Academic Flow Status for Student: " + student.firstName + " " + student.lastName + " ====");
        stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
        System.out.println("=================================================");
    }
}
