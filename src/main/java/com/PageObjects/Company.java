package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utils.Utils;
import com.base.Testbase;

public class Company extends Testbase
{

	public Company() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
    //edit
	@FindBy(xpath="//i[contains(@class,'fa-pencil')]")
	WebElement Edit;
	//save
	@FindBy(xpath="//button[text()=' Save']")
	WebElement save;
	//search
	@FindBy(xpath="//input[contains(@class,'form-control-sm')]")
	WebElement search;
	//table
	@FindBy(xpath="//table/tbody/tr/td[9]")
	WebElement table;
	public Company(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}
	public Company editcompany() throws Throwable
	{
		Utils.scroll(0,250);
		 Utils.javaScriptClick(Edit);
		 Utils.scroll(0,250);
		return new Company();	
	}
	public Company verify() throws Throwable
	{
		search.sendKeys(props.getProperty("warehousenum"));	
		String text=table.getText();
		if(text.equalsIgnoreCase(text))
		{
			Assert.assertEquals(text,props.getProperty("warehousenum"));
		}
		
		return new Company();
	}
}
