package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class LocationTypeData  extends Testbase
{

	public LocationTypeData() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//location name
    @FindBy(id="LocationName")
    WebElement locationname;
    //save
    @FindBy(xpath="//button[contains(@class,'btn-success')]")
    WebElement save;
    public LocationTypeData(WebDriver driver)throws Throwable
    {
    	PageFactory.initElements(driver,this);
    }
    public  Location addlocation() throws Throwable
    {
    	locationname.sendKeys(props.getProperty("location"));
    	 Utils.javaScriptClick(save);
		return new Location();
    }
    public  Location editlocation() throws Throwable
    {
    	locationname.clear();
    	locationname.sendKeys(props.getProperty("clocation"));
    	Utils.javaScriptClick(save);
		return new Location();
    	
    }
}
