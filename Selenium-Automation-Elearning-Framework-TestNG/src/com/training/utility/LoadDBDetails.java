package com.training.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.training.bean.DBBean;
import com.training.bean.SignupDBBean;

/**
 * 
 * @author Naveen
 * @see will load the db details and shall be used in connection class
 */
public class LoadDBDetails {
	public static DBBean getDBDetails() {

		try {
			Properties properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/db.properties");
			properties.load(inStream);

			DBBean dbBean = new DBBean(); 
			
			dbBean.setUrl(properties.getProperty("url"));
			dbBean.setDriver(properties.getProperty("driver"));
			// getting the user name if not present (by default - root ) 
			//dbBean.setFirstName(properties.getProperty("FirstName"));
			//dbBean.setLastName(properties.getProperty("LastName"));
			//dbBean.setEmail(properties.getProperty("email"));
			dbBean.setUserName(properties.getProperty("username", "root"));
			dbBean.setPassword(properties.getProperty("password"));
			//dbBean.setConfirmPass(properties.getProperty("confirmpass"));
			//dbBean.setPhone(properties.getProperty("phone"));
			return dbBean; 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}


}
