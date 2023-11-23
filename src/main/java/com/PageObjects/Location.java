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

public class Location extends Testbase
{

	public Location() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//addnew
    @FindBy(xpath="//i[contains(@class,'fa-plus')]")
    WebElement addnew;
    //search
    @FindBy(xpath="//input[contains(@class,'form-control-sm')]")
    WebElement search;
    //edit
    @FindBy(xpath="//i[contains(@class,'fa-pencil')]")
    WebElement edit;
    //delete
    @FindBy(xpath="//i[contains(@class,'fa-trash')]")
    WebElement delete;
    //yes
    @FindBy(xpath="//button[text()='Yes']")
    WebElement yes;
    //table
    @FindBy(xpath="//table[@id=\"mydatatable\"]/tbody/tr/td")
    List<WebElement> table;
    public Location(WebDriver driver)throws Throwable
    {
    	PageFactory.initElements(driver,this);
    }
    public LocationTypeData addlocation() throws Throwable
    {
    	 Utils.javaScriptClick(addnew);
		return new LocationTypeData();
    	
    }
    public LocationTypeData editlocation() throws Throwable
    {
    	search.sendKeys(props.getProperty("location"));
    	Utils.javaScriptClick(edit);
		return new LocationTypeData();	
    }
    public Location  deletecustomer()throws Throwable
    {
    	search.sendKeys(props.getProperty("clocation"));
    	Utils.javaScriptClick(delete);
    	 yes.click();
		return new Location(); 	
    }
    public void verification()
    {
    	search.sendKeys(props.getProperty("clocation"));
    	for(WebElement row:table)
    	{
    		String Text=row.getText();
    		System.out.println(Text);
    		Assert.assertEquals(Text,"No matching records found");
    	}
    }
}
