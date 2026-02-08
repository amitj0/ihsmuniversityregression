package com.ihsm.university.utilities;

import org.testng.annotations.DataProvider;

public class ExamManageDataProvider {

    @DataProvider(name = "examManageData")
    public static Object[][] examManageData() {
        return ExamUtility.getTestData(
            System.getProperty("user.dir") + "/src/test/resources/student_registration.xlsx",
            "examManageData"
        );
    }
}
