package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public  FileInputStream fis;
	public  XSSFWorkbook wf;
	public  XSSFSheet sheet;
	String path;
	public ExcelUtility(String path)
	{
		this.path = path;
	}

	public  String celldata(int rowno, int colno, String sheetname) {
		String celvalue = "";
		try {
			fis = new FileInputStream(path);
			wf = new XSSFWorkbook(fis);
			sheet = wf.getSheet(sheetname);
			celvalue = sheet.getRow(rowno).getCell(colno).getStringCellValue();
		} catch (Exception e) {
			System.out.println("Problem in Excel cell data" + e);
		}
		return celvalue;
	}

	public  int rowcount(String sheetname) {
		int rowcount = 0;
		try {
			fis = new FileInputStream(path);
			wf = new XSSFWorkbook(fis);
			sheet = wf.getSheet(sheetname);
			rowcount = sheet.getLastRowNum();
		} catch (Exception e) {
			System.out.println("Problem in Excel row count" + e);
		}
		return rowcount;
	}
	public int columncount(String sheetname)
	{
		int colcount =0;
		try {
		fis = new FileInputStream(path);
		wf = new XSSFWorkbook(fis);
		sheet = wf.getSheet(sheetname);
		colcount=sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			System.out.println("Problem in Excel column count" + e);
		}
		return colcount;
	}
}
