package com.comcast.crm.generic.file_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./ConfigAppData/commondata.properties");
		Properties property=new Properties();
		property.load(fis);
		String data=property.getProperty(key);
		return data;
	}
}
