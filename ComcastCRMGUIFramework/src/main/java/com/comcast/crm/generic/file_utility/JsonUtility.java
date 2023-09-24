package com.comcast.crm.generic.file_utility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fileReader=new FileReader("./ConfigAppData/appCommonData.json");
		
		JSONParser  parser=new JSONParser();
		
		Object obj=parser.parse(fileReader);
		
		JSONObject jObj=(JSONObject) obj;
		
		String data=(String) jObj.get(key);
		
		return data;
	}
}
