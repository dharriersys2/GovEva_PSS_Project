package com.goveva.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");
		try {

			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);

		}
		catch(Exception e){
			System.out.println("Exception is" + e.getMessage());

		}




	}

	public String applicationURL() {
		String url = pro.getProperty("baseURL");

		return url;
	}

	public String applicationUsername() {
		String un = pro.getProperty("username");
		return un;

	}

	public String applicationPassword() {
		String pw = pro.getProperty("password");
		return pw;

	}

	public String applicationComapnyName() {
		String cName = pro.getProperty("companyname");
		return cName;

	}

	public String getChromePath() {
		String cromebrowserPath = pro.getProperty("chromePath");
		return cromebrowserPath;

	}


	public String getFirefoxPath() {
		String firefoxbrowserPath = pro.getProperty("firefoxPath");
		return firefoxbrowserPath;

	}

	public String getEdgePath() {
		String edgebrowserPath = pro.getProperty("edgePath");
		return edgebrowserPath;

	}






}
