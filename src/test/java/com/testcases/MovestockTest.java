package com.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObjects.Homepage;
import com.PageObjects.Login_functionality;
import com.PageObjects.Movestock;
import com.PageObjects.StockMovement;
import com.base.Testbase;

public class MovestockTest extends Testbase {
	public MovestockTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	 Login_functionality lf;
	 Homepage h;
	 Movestock m;
	 StockMovement sm;
	 @BeforeMethod
	 public void setup() throws Throwable {

			Initialization();
			 lf = new Login_functionality(driver);
			 h=new Homepage(driver);
			 m=new Movestock(driver);
			 sm=new StockMovement(driver);
			 lf.Dologin();
			  
	 }
	 @Test(priority=1)
	 public void warehouseToshowroom() throws Throwable
	 {
		 
		 h.movestock();
		 m.warehousetoshowroom();
		 sm.verifyWHtoSR();
		 
	 }
	 @Test(priority=2)
	 public void showroomtowarehouse() throws Throwable
	 {
		  
		 h.movestock();
		 m.showroomtowarehouse();
		 sm.verifySRtoWH();
	 }
}
