package com.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utils.Utils;
import com.base.Testbase;

public class Shifts extends Testbase {
    //addnew
	@FindBy(xpath="//i[contains(@class,'fa-plus')]")
	WebElement addnew;
	//search
	@FindBy(xpath="//input[contains(@class,'form-control-sm')]")
	WebElement search;
	//delete
	@FindBy(xpath="//button[contains(@class,'btn-danger')]")
	WebElement Delete;
	//yes
	@FindBy(xpath="//button[text()='Yes']")
	WebElement yes;
	//table
	 @FindBy(xpath="//table[contains(@class,'dataTable')]/tbody/tr/td")
	    List<WebElement> table;
public Shifts() throws Throwable {
		super();
	}

public Shifts(WebDriver driver) throws Throwable{
	 PageFactory.initElements(driver,this);
}
public  Shifts addShift() throws Throwable
{
	 Utils.javaScriptClick(addnew);
	return new Shifts();
}
public Shifts deleteShift() throws Throwable
{
	search.sendKeys(props.getProperty("shiftname"));
	Delete.click();
	yes.click();
	return new Shifts();
	
}
public Shifts verify() throws Throwable
{
	search.sendKeys(props.getProperty("shiftname"));
	for(WebElement row:table)
	{
		String text=row.getText();
		Assert.assertEquals(text,"No matching records found");
	}
	return new Shifts();
	
}
}
