package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.Signupbean;
import com.training.dao.ElearningSignupDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class SignupDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<Signupbean> list = new ElearningSignupDAO().getSignup(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(Signupbean temp : list){
			Object[]  obj = new Object[7]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.getEmail();
			obj[3] = temp.getUserName(); 
			obj[4] = temp.getPass(); 
			obj[5] = temp.getConfirmPass();
			obj[6] = temp.getPhone();
			
			
			result[count ++] = obj; 
		}
				
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\SoundaryavalliRamach\\IBM\\Automation-Selenium\\signupdata.xlsx"; 
		String SheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName, SheetName);
	}
	
	/*@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}*/
}
