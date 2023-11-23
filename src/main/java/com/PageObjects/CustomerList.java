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

public class CustomerList extends Testbase{
	 public CustomerList() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//customer name
	    @FindBy(name="FullName")
	    WebElement name;
	    //save
	    @FindBy(xpath="//button[text()=' Save']")
	    WebElement save;
	    //search
	@FindBy(xpath="//input[contains(@class,'form-control-sm')]")
	    WebElement search;
	    //edit
	    @FindBy(xpath="//i[contains(@class,'fa-pencil')]")
	    WebElement edit;
	    //table
	    @FindBy(xpath="//table[contains(@class,'dataTable')]/tbody/tr/td[2]")
	    List<WebElement> table;
	    //delete
	    @FindBy(xpath="//i[contains(@class,'fa-trash-o')]")
	    WebElement delete;
	    //yes
	    @FindBy(xpath="//button[text()='Yes']")
	    WebElement yes;
	    //no matches
	    @FindBy(xpath="//table[contains(@class,'dataTable')]/tbody/tr/td")
	    List<WebElement> table2;
	    
	    public CustomerList(WebDriver driver)throws Throwable
	    {
	    	PageFactory.initElements(driver,this);
	    }
	    public  CustomerList editcustomer() throws Throwable
	    {
	    	search.sendKeys(props.getProperty("name"));
	    	for(WebElement row:table)
	    	{
	    		String nametxt=row.getText();
	    		if(nametxt.equals(props.getProperty("name")))
	    		{
	    			Utils.javaScriptClick(edit);
	    		}
	    	}
			name.clear();
			name.sendKeys(props.getProperty("changedname"));
			Utils.javaScriptClick(save);
			return new CustomerList();
	    }
	    public  CustomerList deletecustomer() throws Throwable
	    {
	    	search.sendKeys(props.getProperty("changedname"));	
	    	for(WebElement row:table)
	    	{
	    		String txt=row.getText();
	     if(txt.equals(props.getProperty("changedname")))
	     {
			Utils.javaScriptClick(delete);
		   yes.click();
	    	
	    }
	    	}
			return new CustomerList();
	    }
	    public void verification()
	    {
	    	search.sendKeys(props.getProperty("changedname"));
	    	for(WebElement row:table2)
	    	{
	    		String text=row.getText();
	    		Assert.assertEquals(text,"No matching records found");
	    	}
	    }

	    
}
