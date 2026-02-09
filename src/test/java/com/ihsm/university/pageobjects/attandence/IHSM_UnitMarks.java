package com.ihsm.university.pageobjects.attandence;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ihsm.university.base.BasePage;

public class IHSM_UnitMarks extends BasePage {

	public IHSM_UnitMarks(WebDriver driver) {
		super(driver);
	}

	// locate the web element here

	@FindBy(xpath = "//div[@class='departmentname']")
	private WebElement chooseDegreeFaculty; // now hardcode for the degree fac

	@FindBy(xpath = "//div[@class='departmentname' and normalize-space()='Manager']")
	private WebElement choosePosition; // now this one is also hard code

	@FindBy(xpath = "//a[@id='a7']//span[normalize-space()='Teacher']")
	private WebElement teacherTab;

	@FindBy(xpath = "//a[@href='#/Class/UnitMarks']")
	private WebElement unitMarksTab;

	@FindBy(xpath = "//input[@name='rClass']")
	private WebElement checkbox;

	@FindBy(name = "dttUnitDate")
	private WebElement unitDateField;

	@FindBy(xpath = "(//input[@name='intTotalCreditHours'])[1]")
	private WebElement input1;

	@FindBy(xpath = "(//input[@name='intTotalCreditHours'])[2]")
	private WebElement input2;

	@FindBy(xpath = "//input[@name='intCreditPracticalhours']")
	private List<WebElement> inputListOfAllField;

	@FindBy(xpath = "//div[@id='divUnitMarksStudents']//button[contains(@class, 'btnprimary') and text()='Save']")
	private WebElement saveBtn;

	// method to perform the actions

	public void chooseDegreeFaculty() {
		blinkElement(chooseDegreeFaculty);
		safeClick(chooseDegreeFaculty);
	}

	public void choosePosition() {
		safeClick(choosePosition);
	}

	public void teacherTab() {
		safeClick(teacherTab);
	}

	public void unitMarksTab() {
		safeClick(unitMarksTab);
	}

	public void checkbox() {
		safeClick(checkbox);
	}

	public void unitDateField(String date) {
		blinkElement(unitDateField);
		safeClick(unitDateField);
		unitDateField.sendKeys(date);
	}

	public void input1(String inputFirst) {
		input1.clear();
		input1.sendKeys(inputFirst);
	}

	public void input2(String inputSecond) {
		input2.clear();
		input2.sendKeys(inputSecond);
	}

	public void enterInputAllInputMarks(List<Integer> values) {

		if (values.size() != inputListOfAllField.size()) {
			throw new IllegalArgumentException("Values count (" + values.size() + ") does not match row count ("
					+ inputListOfAllField.size() + ")");
		}

		for (int i = 0; i < inputListOfAllField.size(); i++) {
			WebElement input = inputListOfAllField.get(i);
			input.clear();
			input.sendKeys(String.valueOf(values.get(i)));
		}
	}

	public void saveBtn() {
		safeClick(saveBtn);
	}

	// fill the unit marks
	public void fillUnitMarksInformation(String date, String input1, String input2, List<Integer> values) {
		chooseDegreeFaculty();
		choosePosition();
		teacherTab();
		unitMarksTab();
		checkbox();
		unitDateField(date);
		input1(input1);
		input2(input2);
		enterInputAllInputMarks(values);
		saveBtn();
	}
}
