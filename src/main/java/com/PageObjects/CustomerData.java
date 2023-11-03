package com.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Testbase;

public class CustomerData extends Testbase{

	public CustomerData() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//customer name
    @FindBy(name="FullName")
    WebElement name;
    //mobile no
    @FindBy(name="MobileNumber")
    WebElement mblno;
    //email
    @FindBy(name="EmailId")
    WebElement email;
    //wtsapp no
    @FindBy(name="WhatsAppNumber")
    WebElement whatsappno;
    //orgname
    @FindBy(name="OrganigationName")
    WebElement orgname;
    //orgadd
    @FindBy(name="OrginizationAddress")
    WebElement orgadd;
    //orgno
    @FindBy(name="OrganizationNumber")
    WebElement orgno;
    //orgemail
    @FindBy(name="OrganizationEmailId")
    WebElement orgemail;
    //gst no
    @FindBy(name="GSTNumber")
    WebElement gstno;
    //save
    @FindBy(xpath="//button[text()=' Save']")
    WebElement save;
    public CustomerData(WebDriver driver) throws Throwable
    {
    	PageFactory.initElements(driver,this);
    }
    public CustomerList addcustomer() throws Throwable
    {
    	name.sendKeys(props.getProperty("name"));
    	mblno.sendKeys(props.getProperty("mobile"));
    	email.sendKeys(props.getProperty("email"));
    	whatsappno.sendKeys(props.getProperty("wtsappno"));
    	orgname.sendKeys(props.getProperty("orgname"));
    	orgadd.sendKeys(props.getProperty("orgadd"));
    	orgno.sendKeys(props.getProperty("orgno"));
    	orgemail.sendKeys(props.getProperty("orgemail"));
    	gstno.sendKeys(props.getProperty("gstno"));
    	save.click();
		return  new CustomerList();
    }
    
}

