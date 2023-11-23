package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class ConditionTypeData extends Testbase{

	public ConditionTypeData() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//condition name
    @FindBy(id="ConditionName")
    WebElement Conditionname;
    //save
    @FindBy(xpath="//button[contains(@class,'btn-success')]")
    WebElement save;
    public ConditionTypeData(WebDriver driver)throws Throwable
    {
    	PageFactory.initElements(driver,this);
    }
    public Condition addCondition(String conditionname) throws Throwable
    {
    	Conditionname.sendKeys(conditionname);
    	Utils.javaScriptClick(save);
		return new Condition();  	
    }
    public Condition editcondition(String Editedname) throws Throwable
    {
    	Conditionname.clear();
    	Conditionname.sendKeys(Editedname);
    	Utils.javaScriptClick(save);
		return new Condition();
    }
    
}
