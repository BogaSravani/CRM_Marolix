package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class CompanyData extends Testbase
{

	public CompanyData() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	 public CompanyData(WebDriver driver)throws Throwable {
		PageFactory.initElements(driver,this);
	}
		//companywebsite
		@FindBy(name="CompanyWebsite")
		WebElement companyWeb;
		//warehousenum
		@FindBy(name="WarehousePhoneNumbers")
		WebElement warehouseno;
		//save
		@FindBy(xpath="//button[text()=' Save']")
		WebElement save;
		public Company editcompany() throws Throwable
		{
			companyWeb.clear();
			 companyWeb.sendKeys(props.getProperty("companywebsite"));
			 warehouseno.clear();
			 warehouseno.sendKeys(props.getProperty("warehousenum"));
			 Utils.javaScriptClick(save);
			return new Company();	
		}
}
