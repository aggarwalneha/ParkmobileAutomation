package com.company.appl.PageClasses;

import com.company.appl.Config.libraryFunctions;

public class StartParking {
	
	public static void clickStartParking(){
		//Retrieve startParking link
		
		libraryFunctions.clickLink("StartParkingLink"); //"StartParkingLink" is OR property name
	}
	
	public static void UserOnVerifyStartParkingPage(){
		libraryFunctions.explicitwait("StartParkingPageVerify_Span", 20);//"StartParkingPageVerify_Span" is OR property name
	}
	
	public static void VerifyUserTab(int TimeOut){
		libraryFunctions.explicitwait("UserTabVerify", TimeOut);//"UserTabVerify" is OR property name
	}
	
	public static void StartParking_User(double waittimeout,String LPN_Value, String Zone_Value,String location){
		clickStartParking();
		//UserOnVerifyStartParkingPage();
		//VerifyUserTab(waittimeout);
		libraryFunctions.clickLink("User_Tab");//"User_Tab" is OR property name
		//VerifyUserTab(waittimeout);
		libraryFunctions.selectDropdown("LPN", LPN_Value);//"StartParkingLink" is OR property name
		libraryFunctions.enterText("Zone", Zone_Value);//"Zone" is OR property name
		libraryFunctions.click("StartParkingButton");
		
	}
	
	
	
	

}
