package com.ihsm.university.pageobjects.classchedule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ihsm.university.base.BasePage;

public class IHSM_FacultyGroupAssignment extends BasePage {

	public IHSM_FacultyGroupAssignment(WebDriver driver) {
		super(driver);
	}

	// locate the web element here
	@FindBy(xpath = "//a[@id='a6']//span[normalize-space()='Course Planner']")
	private WebElement coursePlannerTab;

	@FindBy(xpath = "//a[@href='#/AcademicFacultyGroup']")
	private WebElement facGroupAssignmentTab;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='intSessionId']")
	private WebElement facultySessionField;

	@FindBy(xpath = "//ng-select[@name='intSessionId']//div[@role='option']")
	private List<WebElement> facultySessionList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strBatchId']")
	private WebElement facultyBatchField;

	@FindBy(xpath = "//ng-select[@name='strBatchId']//div[@role='option']")
	private List<WebElement> facultyBatchFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strAcademicPlanId']")
	private WebElement facultyAcadPlanField;

	@FindBy(xpath = "//ng-select[@name='strAcademicPlanId']//div[@role='option']")
	private List<WebElement> facultyAcadPlanFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strSemesterId']")
	private WebElement facultySemField;

	@FindBy(xpath = "//ng-select[@name='strSemesterId']//div[@role='option']")
	private List<WebElement> facultySemFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='SUBJECT_TYPE']")
	private WebElement facultySubTypeField;

	@FindBy(xpath = "//ng-select[@name='SUBJECT_TYPE']//div[@role='option']")
	private List<WebElement> facultySubTypeFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//div[contains(@class,'card-footer')]//button[normalize-space()='Search']")
	private WebElement searchButton;

	// method to perform the action

	public void coursePlannerTab() {
		safeClick(coursePlannerTab);
	}

	public void facGroupAssignmentTab() {
		safeClick(facGroupAssignmentTab);
	}

	public void facultySessionField() {
		safeClick(facultySessionField);
	}

	public void facultySessionList(String facultyList) {
		safeClick(facultySessionField);

		for (WebElement option : facultySessionList) {
			if (option.getText().trim().equalsIgnoreCase(facultyList)) {
				safeClick(option);
				return;
			}
		}
	}

	public void facultyBatchField() {
		safeClick(facultyBatchField);
	}

	public void facultyBatchFieldList(String batchName) {
		safeClick(facultyBatchField);

		for (WebElement option : facultyBatchFieldList) {
			if (option.getText().trim().equalsIgnoreCase(batchName)) {
				safeClick(option);
				return;
			}
		}
	}

	public void facultyAcadPlanField() {
		safeClick(facultyAcadPlanField);
	}

	public void facultyAcadPlanFieldList(String value) {
		safeClick(facultyAcadPlanField);
		for (WebElement option : facultyAcadPlanFieldList) {
			if (option.getText().trim().equalsIgnoreCase(value)) {
				safeClick(option);
				return;
			}
		}
	}

	public void facultySemField() {
		safeClick(facultySemField);
	}

	public void facultySemFieldList(String facultySemPlan) {
		safeClick(facultySemField);

		for (WebElement option : facultySemFieldList) {
			if (option.getText().trim().equalsIgnoreCase(facultySemPlan)) {
				safeClick(option);
				return;
			}
		}
	}

	public void facultySubTypeField() {
		safeClick(facultySubTypeField);
	}

	public void facultySubTypeFieldList(String facultySubType) {
		safeClick(facultySubTypeField);

		for (WebElement option : facultySubTypeFieldList) {
			if (option.getText().trim().equalsIgnoreCase(facultySubType)) {
				safeClick(option);
				return;
			}
		}
	}

	public void searchButton() {
		blinkElement(searchButton);
		safeClick(searchButton);
	}

	// fill the Faculty Group Assignment Information
	public void fillGroupAssignmentInfo(String facList, String facBatch, String facAcad, String facSem,
			String facSubType) {
		coursePlannerTab();
		facGroupAssignmentTab();
		facultySessionField();
		facultySessionList(facList);
		facultyBatchField();
		facultyBatchFieldList(facBatch);
		facultyAcadPlanField();
		facultyAcadPlanFieldList(facAcad);
		facultySemField();
		facultySemFieldList(facSem);
		facultySubTypeField();
		facultySubTypeFieldList(facSubType);
		searchButton();

	}

}
