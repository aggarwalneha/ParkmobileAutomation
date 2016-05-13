package com.company.appl.Runner;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.appl.Config.Constants;
import com.company.appl.Config.libraryFunctions;
import com.company.appl.PageClasses.*;

public class TestRunner {
	public static HashMap<Object,Object> testdata;
	//public static Properties prop = null;
	
	@BeforeSuite
	public void beforeSuiteMethod() throws IOException{
		libraryFunctions.loadOR(Constants.Path_OR);
		libraryFunctions.loadProp(Constants.Path_Prop);
		libraryFunctions.IntializeDriver();
		libraryFunctions.navigateToUrl(Constants.url);
		libraryFunctions.implicitWait();
	}
	
	@AfterMethod
	public void AfterTestMethod(){
		tearDown.Do_Logoff();
	}
	
	@Test(dataProvider = "TestDataProvider")
	public void Login_Success(HashMap<Object,Object> map) 
	{
		String Email = map.get("loginName").toString();
		String Password = map.get("password").toString();
		Login.Success_Login(Email, Password);	
	 
	}
	@Test(dependsOnMethods = { "Login_Success" }, dataProvider = "TestDataProvider")
	public void StartParking(HashMap<Object,Object> map){
		
		double waittimeout = ((Double)(map.get("waittimeout"))).doubleValue();
		
		String LPN_Value = map.get("LPN_Value").toString();
		String Zone_Value = map.get("Zone_Value").toString();
		String Location = map.get("Location").toString();
		String Email = map.get("loginName").toString();
		String Password = map.get("password").toString();
		Login.Success_Login(Email, Password);	
		StartParking.StartParking_User(waittimeout,LPN_Value,Zone_Value,Location);
	}
	@DataProvider(name = "TestDataProvider")
	public static Object[][] getDataFromDataProvider(Method m){
		String TestMethodName = m.getName();
		String MethodName =libraryFunctions.RetrieveTestDataScenarioNameMatchingTestMethod(TestMethodName);
		testdata = new HashMap<Object,Object>();
		int Row = libraryFunctions.MatchExcelColumnData(Constants.DataSheetScenarioCol, MethodName, Constants.user_testdata_excel, Constants.userDataSheet_excel);
		testdata = libraryFunctions.ReadExcelDataToHashMapForSpecificRow(Row, Constants.user_testdata_excel, Constants.userDataSheet_excel);
		
		return new Object[][]{
			{testdata}};
		}
  
}
