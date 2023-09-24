package com.comcast.crm.generic.file_utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int columnNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testData.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		String data=workbook.getSheet(sheetName).getRow(rowNum).getCell(columnNum).toString();
		workbook.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws Throwable, IOException {
FileInputStream fis=new FileInputStream("./TestData/testData.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		workbook.close();
		return workbook.getSheet(sheetName).getPhysicalNumberOfRows();
		 
	}
	
	
	public void setDataIntoExcel(String sheetName, int rowNum, int columnNum, String data) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("./TestData/testData.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		Cell cell=workbook.getSheet(sheetName).getRow(rowNum).createCell(columnNum);
		cell.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./TestData/testData.xlsx");
	  workbook.write(fos);
	  workbook.close();
	}
	


}
