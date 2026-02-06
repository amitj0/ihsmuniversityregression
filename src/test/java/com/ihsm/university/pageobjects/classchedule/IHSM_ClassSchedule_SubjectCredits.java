package com.ihsm.university.pageobjects.classchedule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ihsm.university.base.BasePage;

public class IHSM_ClassSchedule_SubjectCredits extends BasePage {

	public IHSM_ClassSchedule_SubjectCredits(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@id='a6']//span[normalize-space()='Course Planner']")
	private WebElement coursePlannerTab;

	@FindBy(xpath = "//a[@href='#/CoursePlanner/SubjectCredits']")
	private WebElement subjectCredit;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strSessionId']")
	private WebElement sessionField;

	@FindBy(xpath = "//ng-select[@name='strSessionId']//div[@role='option']")
	private List<WebElement> sessionFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strBatchId']")
	private WebElement batchField;

	@FindBy(xpath = "//ng-select[@name='strBatchId']//div[@role='option']")
	private List<WebElement> batchFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strAcademicPlanId']")
	private WebElement acaPlanField;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strAcademicPlanId']")
	private List<WebElement> acaPlanFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strSemesterId']")
	private WebElement semField;

	@FindBy(xpath = "//ng-select[@name='strSemesterId']//div[@role='option']")
	private List<WebElement> semFieldList;

	@FindBy(xpath = "//div[contains(@class,'card-footer')]//button[normalize-space()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@id='AlertSuccesModal' and contains(@class,'show')]//button[normalize-space()='Ok']")
	private WebElement okBtn;
	// method to perform the action

	public void coursePlannerTab() {
		safeClick(coursePlannerTab);
	}

	public void subjectCredit() {
		safeClick(subjectCredit);
	}

	public void sessionField() {
		safeClick(sessionField);
	}

	public void sessionFieldList(String value) {
		safeClick(sessionField);
		for (WebElement option : sessionFieldList) {
			if (option.getText().trim().equalsIgnoreCase(value)) {
				safeClick(option);
				return;
			}
		}

	}

	public void batchField() {
		safeClick(batchField);
	}

	public void batchFieldList(String value) {
		safeClick(batchField);
		for (WebElement option : batchFieldList) {
			if (option.getText().trim().equalsIgnoreCase(value)) {
				safeClick(option);
				return;
			}
		}

	}

	public void acaPlanField() {
		safeClick(acaPlanField);
	}

	public void selectAcademicPlanByIndex(int index) {

		// Open dropdown
		safeClick(acaPlanField);

		// Build xpath using index
		WebElement option = acaPlanField
				.findElement(By.xpath(".//div[@role='option' and contains(@id,'-" + index + "')]"));

		safeClick(option);
	}

	public void semField() {
		safeClick(semField);
	}

	public void semFieldList(String value) {
		safeClick(semField);
		for (WebElement option : semFieldList) {
			if (option.getText().trim().equalsIgnoreCase(value)) {
				safeClick(option);
				return;
			}
		}

	}

	public WebElement inputByValue(String value) {
		return driver.findElement(By.xpath("//input[@value='" + value + "']"));
	}

	public void saveButton() {
		blinkElement(saveBtn);
		safeClick(saveBtn);
	}
	
	public void okBtn() {
		blinkElement(okBtn);
		handleModalOk(okBtn);
	}

	// fill the subject credit information

	public IHSM_ClassSchedule fillSubjectCreditInformatioin(String sessionField, String batchField, int acaPlanField,
			String semField, String value) {
		coursePlannerTab();
		subjectCredit();
		sessionField();
		sessionFieldList(sessionField);
		batchFieldList(batchField);
		selectAcademicPlanByIndex(acaPlanField);
		semFieldList(semField);
		inputByValue(value).click();
		saveButton();
		okBtn();
		
		return new IHSM_ClassSchedule(driver);

	}
}
