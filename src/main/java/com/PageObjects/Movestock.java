package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class Movestock extends Testbase{
		//movefrom
		@FindBy(id="movedFromD")
		WebElement MoveFrom;
		//MoveTo
		@FindBy(id="movedToD")
		WebElement MoveTo;
		//modelno
		@FindBy(id="invId")
		WebElement modelNo;
		//Movingqty
		@FindBy(id="qtymoving")
		WebElement movingqty;
		//add btn
		@FindBy(id="btnAdd")
		WebElement Add;
		//savebtn
		@FindBy(id="btnSave")
		WebElement savebtn;
		//refrence/notes
		@FindBy(id="MoStNot")
		WebElement notes;
		//verification
	 
	public Movestock(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}


	public StockMovement warehousetoshowroom() throws Throwable {
		Utils.dropdownBy(props.getProperty("Movefrom"),MoveFrom);
		Utils.dropdownBy(props.getProperty("Moveto"),MoveTo);
		Utils.dropdownBy(props.getProperty("Modelno"),modelNo);
		movingqty.clear();
		movingqty.sendKeys(props.getProperty("Quantity"));
		notes.sendKeys(props.getProperty("Note"));
		Add.click();
		savebtn.click();
		return  new StockMovement();
		
	}
	public StockMovement showroomtowarehouse() throws Throwable
	{
		Utils.dropdownBy(props.getProperty("Moveto"),MoveFrom);
		Utils.dropdownBy(props.getProperty("Movefrom"),MoveTo);
		Utils.dropdownBy(props.getProperty("Modelno"),modelNo);
		movingqty.clear();
		movingqty.sendKeys(props.getProperty("Quantity"));
		notes.sendKeys(props.getProperty("Notes"));
		Add.click();
		savebtn.click();
		return new StockMovement();
		
	}
}
