package com.ihsm.university.pageobjects.classchedule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.ihsm.university.base.BasePage;

public class IHSM_ClassSchedule extends BasePage {

	public IHSM_ClassSchedule(WebDriver driver) {
		super(driver);
	}

	// locate the web element here
	@FindBy(xpath = "(//div[@class='departmentbox'])[2]")
	private WebElement chooseDegreeFaculty; // now hardcode for the degree fac

	@FindBy(xpath = "(//div[@class='departmentbox'])[3]")
	private WebElement choosePosition; // now this one is also hard code

	@FindBy(xpath = "//a[@id='a6']//span[normalize-space()='Course Planner']")
	private WebElement coursePlannerTab;

	@FindBy(xpath = "//a[@href='#/ClassSchedule']")
	private WebElement classSchedule;

	@FindBy(name = "intSessionId")
	private WebElement sessionField;

	@FindBy(xpath = "//ng-select[@name='intSessionId']//div[@role='option']")
	private List<WebElement> sessionFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strBatchId']")
	private WebElement batchField;

	@FindBy(xpath = "//ng-select[@name='strBatchId']//div[@role='option']")
	private List<WebElement> batchFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='strAcademicPlanId']")
	private WebElement academicPlanField;

	@FindBy(name = "intSemesterId")
	private WebElement semField;

	@FindBy(xpath = "(//ng-select[@name='strAcademicPlanId']//div[@role='option'])[3]")
	private List<WebElement> semFieldList;

	@FindBy(xpath = "//div[@id='Tab1']//ng-select[@name='SUBJECT_TYPE']")
	private WebElement subjectTypeField;

	@FindBy(xpath = "//div[@id='Tab1']//button[contains(@class, 'btnprimary') and text()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[contains(normalize-space(.),'LEC - 49')]")
	private WebElement lecField;

	@FindBy(xpath = "(//input[@name='SubjectGroup'])[1]")
	private WebElement groupFieldCheckBox1;

	@FindBy(xpath = "(//input[@name='SubjectGroup'])[2]")
	private WebElement groupFieldCheckBox2;

	@FindBy(xpath = "(//p[contains(normalize-space(),'From Date')]/parent::div//input[@type='date'])[1]")
	private WebElement fromDateField;

	@FindBy(xpath = "(//p[contains(normalize-space(),'To Date')]/parent::div//input[@type='date'])[1]")
	private WebElement toDateField;

	@FindBy(xpath = "//p[contains(text(),'First Week')]/following::div[contains(@class,'selectgroup-pills')][1]//label//span")
	private List<WebElement> weekFieldList;

	@FindBy(xpath = "//label[normalize-space()='ONLINE']")
	private WebElement onlineClass;

	@FindBy(xpath = "//div[@id='Tab1']//label[contains(normalize-space(),'Time')]/following::ng-select[1]//div[@class='ng-select-container']")
	private WebElement timeField;

	@FindBy(xpath = "//div[@role='listbox']//span[@class='ng-option-label']")
	private List<WebElement> timeSlt;

	@FindBy(xpath = "//div[contains(label,'CONSTRAINTS')]//select")
	private WebElement constraintsField;

	@FindBy(xpath = "//div[contains(label,'CONSTRAINTS')]//option")
	private List<WebElement> constList;

	@FindBy(xpath = "(//div[@id='btnSaveSchedule'])[2]")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@id='AlertSuccesModal' and contains(@class,'show')]//button[normalize-space()='Ok']")
	private WebElement okButton;

	@FindBy(xpath = "//div[@id='AlertErrorModal' and contains(@class,'show')]//button[normalize-space()='Ok']")
	private WebElement errorButton;

	// method to perform the action on these elements
	// -------------------- Navigation --------------------

	public void chooseDegreeFaculty() {
		safeClick(chooseDegreeFaculty);
	}

	public void choosePosition() {
		safeClick(choosePosition);
	}

	public void openCoursePlannerTab() {
		safeClick(coursePlannerTab);
	}

	public void openClassSchedule() {
		safeClick(classSchedule);
	}

	// -------------------- Session --------------------

	public void selectSession(String sessionName) {
		safeClick(sessionField);

		for (WebElement option : sessionFieldList) {
			if (option.getText().trim().equalsIgnoreCase(sessionName)) {
				safeClick(option);
				return;
			}
		}
	}

	// -------------------- Batch --------------------

	public void selectBatch(String batchName) {
		safeClick(batchField);

		for (WebElement option : batchFieldList) {
			if (option.getText().trim().equalsIgnoreCase(batchName)) {
				safeClick(option);
				return;
			}
		}
	}

	// -------------------- Academic Plan --------------------

	public void selectAcademicPlanByIndex(int index) {

		// Open dropdown
		safeClick(academicPlanField);

		// Build xpath using index
		WebElement option = academicPlanField
				.findElement(By.xpath(".//div[@role='option' and contains(@id,'-" + index + "')]"));

		safeClick(option);
	}

	// -------------------- Semester --------------------

	public void selectSemester(int semesterIndex) {
		safeClick(semField);

		// Build xpath using index
		WebElement option = semField
				.findElement(By.xpath(".//div[@role='option' and contains(@id,'-" + semesterIndex + "')]"));
		safeClick(option);
	}

	// -------------------- Subject Type --------------------

	public void selectSubjectType(int subjectTypeIndex) {
		safeClick(subjectTypeField);

		// Build xpath using index
		WebElement option = subjectTypeField
				.findElement(By.xpath(".//div[@role='option' and contains(@id,'-" + subjectTypeIndex + "')]"));
		safeClick(option);
	}

	// -------------------- Search --------------------

	public void clickSearch() {
		safeClick(searchButton);
	}

	public void lecField() {
		safeClick(lecField);
	}

	public void groupField1() {
		safeClick(groupFieldCheckBox1);
	}

	public void groupdField2() {
		safeClick(groupFieldCheckBox2);
	}

	public void fromDateField(String date) {
		enterDate(fromDateField, date);
	}

	public void toDateField(String date) {
		enterDate(toDateField, date);
	}

	public void weekSelect(String weekList) {

		String[] days = weekList.split(",");

		for (String day : days) {

			for (WebElement option : weekFieldList) {

				if (option.getText().trim().equalsIgnoreCase(day.trim())) {
					safeClick(option);
					break;
				}
			}
		}
	}

	public void onlineClass() {
		safeClick(onlineClass);
	}

	public void timeField() {
		safeClick(timeField);
	}

	public void timeSlt(String timesStr) {
		for (WebElement option : timeSlt) {
			if (option.getText().trim().equalsIgnoreCase(timesStr)) {
				safeClick(option);
				return;
			}
		}
	}

	public void contraintsField() {
		safeClick(constraintsField);
	}

	public void constList(String value) {
		Select dropdown = new Select(constraintsField);
		List<WebElement> options = dropdown.getOptions();
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(value)) {
				option.click();
				return;
			}
		}
	}

	public void saveBtn() {
		safeClick(saveBtn);
	}

	public void okButton() {
		blinkElement(okButton);
		handleModalOk(okButton);
	}

	public void errorButton() {

		try {
			if (errorButton.isDisplayed()) {
				blinkElement(errorButton);
				safeClick(errorButton);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// fill the class scheduling information

	public void fillClassSchedulingInformation(String session, String batch, int optionIndex, int sem, int subject,
			String enterFromDate, String enterToDate, String week, String conList, String timeSelect)
			throws InterruptedException {
		openCoursePlannerTab();
		openClassSchedule();
		selectSession(session);
		selectBatch(batch);
		selectAcademicPlanByIndex(optionIndex);
		selectSemester(sem);
		selectSubjectType(subject);
		clickSearch();
		lecField();
		groupField1();

		fromDateField(enterFromDate);
		toDateField(enterToDate);
		weekSelect(week);
		onlineClass();
		timeField();
		timeSlt(timeSelect);
		constList(conList);
		saveBtn();
		okButton();
		errorButton();
	}
}
