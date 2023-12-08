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

public class UserType extends Testbase {
	public UserType()throws Throwable {
		super();
	}
	@FindBy(xpath="//a[@href='/Master/UserTypeData']")
	WebElement addnew;
	@FindBy(id="TypeName")
	WebElement typename;
	@FindBy(id="TypeCode")
	WebElement typecode;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement save;
	@FindBy(xpath="//input[contains(@class,'form-control-sm')]")
	WebElement search;
	@FindBy(xpath="//button[contains(@class,'btn-add btn-sm')]")
	WebElement edit;
	@FindBy(xpath="//table[@id='mydatatable']/tbody/tr/td[3]")
	List<WebElement> table;
  public UserType(WebDriver driver) throws Throwable
{
	PageFactory.initElements(driver,this);
}
   
public void adduser()
  {
	  Utils.javaScriptClick(addnew);
	  typename.sendKeys(props.getProperty("Typename"));
	  typecode.sendKeys(props.getProperty("Typecode"));
	  Utils.javaScriptClick(save);  
  }
  public void edituser() throws InterruptedException
  {
	  search.sendKeys(props.getProperty("Typename"));
	  Utils.javaScriptClick(edit);
	  typecode.clear();  
	  typecode.sendKeys(props.getProperty("Changedcode"));
	  Thread.sleep(2000);
	  Utils.javaScriptClick(save);
	  search.sendKeys(props.getProperty("Changedcode"));
  }
  public void verification()
  {
	  for(WebElement row:table)
	  {
		  String text=row.getText();
			  Assert.assertEquals(props.getProperty("Changedcode"),text);
	  }
  }
}
