package com.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObjects.Homepage;
import com.PageObjects.Inventory;
import com.PageObjects.Login_functionality;
import com.PageObjects.Usertype;
import com.base.Testbase;

public class UsertypeTest extends Testbase{

	public UsertypeTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	Login_functionality lf;
	 Homepage h; 
    Usertype u;
		  
		@BeforeMethod

		public void setup() throws Throwable {

			Initialization();
			 lf = new Login_functionality(driver);
			 h=new Homepage(driver);
			 u=new Usertype(driver);
	 	}
		@Test(priority=1)
		public void adduser() throws Throwable
		{
		lf.Dologin();
		h.users();	
		u.addNewUser();
		}
		@Test(priority=2)
		public void edituser() throws Throwable
		{
			lf.Dologin();
			h.users();
			u.editUser();
			u.verification();	
		}
		
}
