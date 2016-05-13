package com.company.appl.Runner;

import java.lang.reflect.Method;
import java.util.HashMap;
import org.testng.annotations.DataProvider;

import com.company.appl.Config.Constants;
import com.company.appl.Config.libraryFunctions;

public class DataProviderClass {
	
	public static HashMap<String, HashMap<String, String>> testdata;
	
	@DataProvider(name = "TestDataProvider")
	public static Object[][] getDataFromDataProvider(Method m){
		testdata = new HashMap<String, HashMap<String, String>>();
		testdata = libraryFunctions.ReadExcelData(Constants.user_testdata_excel, Constants.userDataSheet_excel);
		return new Object[][]{
			{testdata}};
		}
	}

