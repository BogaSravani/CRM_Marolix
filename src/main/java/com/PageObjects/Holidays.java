package com.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Testbase;

public class Holidays extends Testbase
{ 
	public Holidays() throws Throwable {
		super();	 
	}
//adddnew
@FindBy(xpath="//a[@href='/Master/HolidayTypedata']")
WebElement addnew;
//holiday date
@FindBy(xpath="//input[@type='date']")
WebElement date;
//name
@FindBy(id="HolidayName")
WebElement name;
//desc
@FindBy(id="HolidayDesc")
WebElement desc;
//save
@FindBy(xpath="//button[text()=' Save']")
WebElement savebtn;
//table
@FindBy(xpath="//table[contains(@class,'table-striped')]/tbody/tr")
List<WebElement>  rows;
//edit
@FindBy(xpath="//i[contains(@class,'fa-pencil')]")
WebElement edit;
//delete
@FindBy(xpath="//i[contains(@class,'fa-trash-o')]")
WebElement delete;
//yes
@FindBy(xpath="//button[text()='Yes']")
WebElement yes;
//desc text
@FindBy(xpath="//table[contains(@class,'table-striped')]/tbody/tr/td[4]")
List<WebElement> desctxt;
public static int size;
public Holidays(WebDriver driver)throws Throwable

{
PageFactory.initElements(driver,this);
}
public  void addholiday()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click()",addnew);
	date.sendKeys(props.getProperty("date"));
	name.sendKeys(props.getProperty("hname"));
	desc.sendKeys(props.getProperty("desc"));
 	js.executeScript("arguments[0].click()",savebtn);
 size= rows.size();
System.out.println(size);
}
public void editholiday()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	for(WebElement r:rows)
	{
		String rowtext=r.getText();
	 for(WebElement d:desctxt)
	 {
		 String dtxt=d.getText();
		if(rowtext.contains(props.getProperty("desc"))&&dtxt.equals(props.getProperty("desc")))		
		{			 
			js.executeScript("arguments[0].click()",edit);
			break;
		}
	}
	}
	date.sendKeys(props.getProperty("cdate"));
	name.clear();
	 name.sendKeys(props.getProperty("cname"));
	 desc.clear();
	 desc.sendKeys(props.getProperty("cdesc"));
	js.executeScript("arguments[0].click()",savebtn);
	 
}
public void deleteholiday()
{

	JavascriptExecutor js = (JavascriptExecutor) driver;
	for(WebElement r:rows)
	{
		String rowtext=r.getText();
		 
		if(rowtext.contains(props.getProperty("cdesc")))
		{		 
			js.executeScript("arguments[0].click()",delete);
			break;
		}
	}
	yes.click();
}
 public void verify()
 
 {
	 int size1=rows.size();
	 Assert.assertEquals( Holidays.size-1,size1);
	 
 }
}
