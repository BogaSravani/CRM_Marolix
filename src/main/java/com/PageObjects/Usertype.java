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

public class Usertype  extends Testbase{

	public Usertype() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//addnew
    @FindBy(xpath="//a[contains(@class,'btn-add')]/i[contains(@class,'fa-plus')]")
    WebElement addnewbtn;
    //type name
    @FindBy(id="TypeName")
    WebElement Typename;
    //type code
    @FindBy(id="TypeCode")
    WebElement typecode;
    //save
    @FindBy(xpath="//button[contains(@class,'serchgaptop')]")
    WebElement save;
    //text
    @FindBy(id="mydatatable_info")
    WebElement text;
    @FindBy(xpath="//input[contains(@class,'form-control-sm')]")
    WebElement search;
   @FindBy(xpath="//i[contains(@class,'fa-pencil')]")
   WebElement edit;
   @FindBy(xpath="//table[@id='mydatatable']/tbody/tr/td[3]")
  List<WebElement> table;
    public Usertype(WebDriver driver)throws Throwable
    {
    	PageFactory.initElements(driver,this);
    }
    public void addNewUser() throws InterruptedException
    {
    	Utils.waitForElement(addnewbtn);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click()",addnewbtn);
    	Typename.sendKeys(props.getProperty("Typename"));
    	typecode.sendKeys(props.getProperty("Typecode")); 
    	//Thread.sleep(2000);
       js.executeScript("arguments[0].click()",save);
    }
    
    public void editUser() throws InterruptedException{
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	search.sendKeys(props.getProperty("Typename"));
    	js.executeScript("arguments[0].click()",edit);
    	typecode.clear();
    	typecode.sendKeys(props.getProperty("Changedcode"));
    	js.executeScript("arguments[0].click()",save);
    	 search.clear();
    	search.sendKeys(props.getProperty("Changedcode")); 
    }
    public void verification()
    {
    	
    	for(WebElement row:table)
    	{
    		String text=row.getText();
    		if(text.equals(props.getProperty("Changedcode")))
    		{
    			Assert.assertEquals(text,props.getProperty("Changedcode"));
    			break;
    		}
    	}	}
    }

