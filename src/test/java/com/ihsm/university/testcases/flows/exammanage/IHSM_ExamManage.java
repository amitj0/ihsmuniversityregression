package com.ihsm.university.testcases.flows.exammanage;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ihsm.university.base.BaseClass;
import com.ihsm.university.pageobjects.exammanagement.IHSM_ManageExam;
import com.ihsm.university.utilities.ExamManageDataProvider;
import com.ihsm.university.utilities.ExtentListener;
import com.ihsm.university.utilities.RetryAnalyzer;

public class IHSM_ExamManage extends BaseClass {

    private Map<String, String> stepStatus = new LinkedHashMap<>();
    private SoftAssert soft = new SoftAssert();

    @Test(description = "Verify the Exam Manage Module", retryAnalyzer = RetryAnalyzer.class,
          dataProvider = "examManageData", dataProviderClass = ExamManageDataProvider.class)
    public void verifyExamManage(String program, String semester, String startDate, String endDate) {
        ExtentListener.createNode("Exam Manage Information");
        try {
            IHSM_ManageExam exam = new IHSM_ManageExam(getDriver());
            exam.fillExamManageInfo(program, semester, startDate, endDate);
            ExtentListener.getNode().pass("Exam Manage Information Test Passed");
            stepStatus.put("Exam Manage", "PASS");
            boolean allPassed = stepStatus.values().stream().allMatch(status -> status.equals("PASS"));
            soft.assertTrue(allPassed, "One or more steps in Exam Manage Flow failed!");
        } catch (Exception e) {
            ExtentListener.getNode().fail("Exam Manage Information Failed: " + e.getMessage());
            stepStatus.put("Exam Manage", "FAIL");
            soft.fail("Exam Manage Information Failed: " + e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void summarizeExamManageFlow() {
        System.out.println("==== Exam Manage Flow Status ====");
        stepStatus.forEach((step, status) -> System.out.println(step + " : " + status));
        System.out.println("================================");
        soft.assertAll();
    }
}
