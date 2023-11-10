package com.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Testbase;

public class Condition extends Testbase{

	public Condition() throws Throwable {
		super();
	}
    //add new
	@FindBy(xpath="//i[contains(@class,'fa-plus')]")
	WebElement addnew;
	//search
	@FindBy(xpath="//input[contains(@class,'form-control-sm')]")
	WebElement search;
	//edit
	@FindBy(xpath="//i[contains(@class,'fa-pencil')]")
	WebElement edit;
	//delete
	@FindBy(xpath="//button[contains(@class,'btn-danger')]")
	WebElement delete;
	//yes
	@FindBy(xpath="//button[text()='Yes']")
	WebElement yes;
	//table
	@FindBy(xpath="//table[@id='mydatatable']/tbody/tr/td")
	List<WebElement> tconditioname;
	//back
	public Condition(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}
	 JavascriptExecutor jse=(JavascriptExecutor)driver;
	public  ConditionTypeData addCondition() throws Throwable {
		 
		 jse.executeScript("arguments[0].click()",addnew);
		return new ConditionTypeData();
		 
	}
	public ConditionTypeData editCondition(String Conditionname) throws Throwable
	{
		search.sendKeys(Conditionname);
		 jse.executeScript("arguments[0].click()",edit);
		return new ConditionTypeData();	
	}
	public Condition deleteCondition(String changedcname) throws Throwable
	{
		search.sendKeys(changedcname);
		jse.executeScript("arguments[0].click()",delete);
		jse.executeScript("arguments[0].click()",yes);
		return new Condition();	
	}
	public Condition verify(String changedcname) throws Throwable
	{
		search.sendKeys(changedcname);
		for(WebElement cname:tconditioname)
		{
			String rowtxt=cname.getText();
			System.out.println(rowtxt);
			Assert.assertEquals(rowtxt,"No matching records found");
			break;
		}
		return new Condition();
	}
}
