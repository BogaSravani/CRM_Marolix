package com.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Testbase;

public class UserType extends Testbase {
	public UserType()throws Throwable {
		super();
	}
	JavascriptExecutor js;
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
 
	  js = (JavascriptExecutor) driver; 
	  js.executeScript("arguments[0].click()",addnew);
	  typename.sendKeys(props.getProperty("Typename"));
	  typecode.sendKeys(props.getProperty("Typecode"));
	  js.executeScript("arguments[0].click()",save);
	  
  }
  public void edituser() throws InterruptedException
  {
	  js = (JavascriptExecutor) driver; 
	  search.sendKeys(props.getProperty("Typename"));
	  js.executeScript("arguments[0].click()",edit);
	  typecode.clear();  
	  typecode.sendKeys(props.getProperty("Changedcode"));
	  Thread.sleep(2000);
	  js.executeScript("arguments[0].click()",save);
	  search.sendKeys(props.getProperty("Changedcode"));
  }
  public void verification()
  {
	  for(WebElement row:table)
	  {
		  String text=row.getText();
		  if(text.equals(props.getProperty("Changedcode")))
		  {
			  Assert.assertEquals(props.getProperty("Changedcode"),text);
			  break;
		  }
	  }
  }
}
