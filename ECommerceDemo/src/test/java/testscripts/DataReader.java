package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	String dataPath = System.getProperty("user.dir") + "//src//test//resources//testData//Data.xlsx";


	
	public String readCredentials(String credentials)
	{
		String name="";
		
		
		FileInputStream fin;
		XSSFWorkbook workbook=null;
		try {
			fin=new FileInputStream(dataPath);
			workbook=new XSSFWorkbook(fin);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		XSSFSheet loginSheet=workbook.getSheetAt(0);
		int numRows=loginSheet.getLastRowNum();
		
		for(int i=0;i<numRows+1;)
		{
	
			XSSFRow row=loginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(credentials))
			{
				name=row.getCell(1).getStringCellValue();
			}
			i=i+1;
		}
		
		return name;
		
		
	}


	}

