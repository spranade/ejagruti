package ejagruti.finsys.config;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Operations {
	
	//ReadAllExcelFIle filename, sheetname
	
	public static int GetRowCount(String filename, int sheetno) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		int rowcount= worksheet.getLastRowNum();
		return rowcount+1;
	}
	
	public static int GetRowCount(String filename, String sheetname) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		int rowcount= worksheet.getLastRowNum();
		return rowcount+1;
	}
	
	public static int GetColumnCount(String filename, int sheetno, int rowno) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		int colcount= worksheet.getRow(rowno).getLastCellNum();
		return colcount;
	}
	
	public static int GetColumnCount(String filename, String sheetname, int rowno) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		int colcount= worksheet.getRow(rowno).getLastCellNum();
		return colcount;
	}
	
	public static String GetCellData(String filename,int sheetno, int colno, int rowno) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		String cellstring= worksheet.getRow(rowno).getCell(colno).getStringCellValue();
		return cellstring;
	}
	
	public static String GetCellData(String filename, String sheetname, int colno, int rowno) throws IOException {
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		String cellstring= worksheet.getRow(rowno).getCell(colno).getStringCellValue();
		return cellstring;
		
	}
	
	public static void SetCellData(String filename, int sheetno,int colno,int rowno,String datastring) throws IOException{
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheetAt(sheetno);
		
		XSSFRow row= worksheet.createRow(rowno);
		XSSFCell cell = row.createCell(colno);
		cell.setCellValue(datastring);
		FileOutputStream fileout= new FileOutputStream(filename);
		workbook.write(fileout);
		
	}
	
	public static void SetCellData(String filename, String sheetname,int colno,int rowno,String datastring) throws IOException{
		
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		XSSFRow row= worksheet.createRow(rowno);
		XSSFCell cell = row.createCell(colno);
		cell.setCellValue(datastring);
		FileOutputStream fileout= new FileOutputStream(filename);
		workbook.write(fileout);
	}
	
	
	public static Hashtable<Integer, String[]> ReadAllExcelFile(String filename, int sheetno) throws IOException{
	 Hashtable<Integer,String[]> readexcel=new Hashtable<Integer,String[]>();
	 
	FileInputStream file= new FileInputStream(new File(filename));
	XSSFWorkbook workbook= new XSSFWorkbook(file);
	XSSFSheet worksheet =workbook.getSheetAt(sheetno);
	int usedrows= worksheet.getLastRowNum();
	
	for(int i=0;i<=usedrows;i++)
		{
		int usedcolnum= worksheet.getRow(i).getLastCellNum();//getCell(colno).getStringCellValue();
		String[] rowarr=new String[usedcolnum];	
		for(int j=0;j<usedcolnum;j++)
			{
			XSSFCell cellstring1 =worksheet.getRow(i).getCell(j);
			if(cellstring1!=null)
			{
			String cellstring=cellstring1.toString();
			rowarr[j]=cellstring;
			//readexcel.put(j,cellstring);
			} else
				{
				String cellstring="";
				rowarr[j]=cellstring;
				}
			}
			readexcel.put(i,rowarr);	
			//System.out.println(Arrays.toString(rowarr));		
		//System.out.println(readexcel);
		System.out.println(Arrays.toString(readexcel.get(i)));
	}	
	
//	public Hashtable<Integer, String[]> Execute(Map<String, String> TestInput) throws InterruptedException 
	return readexcel;
	}
		
	public static Hashtable<Integer, String[]> ReadAllExcelFile(String filename, String sheetname) throws IOException{
		Hashtable<Integer,String[]> readexcel=new Hashtable<Integer,String[]>();
		 
		FileInputStream file= new FileInputStream(new File(filename));
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet worksheet =workbook.getSheet(sheetname);
		int usedrows= worksheet.getLastRowNum();
		
		for(int i=0;i<=usedrows;i++)
			{
			int usedcolnum= worksheet.getRow(i).getLastCellNum();//getCell(colno).getStringCellValue();
			String[] rowarr=new String[usedcolnum];	
			for(int j=0;j<usedcolnum;j++)
				{
				XSSFCell cellstring1 =worksheet.getRow(i).getCell(j);
				if(cellstring1!=null)
				{
				String cellstring=cellstring1.toString();
				rowarr[j]=cellstring;
				//readexcel.put(j,cellstring);
				} else
					{
					String cellstring="";
					rowarr[j]=cellstring;
					}
				}
				readexcel.put(i,rowarr);	
				//System.out.println(Arrays.toString(rowarr));		
			//System.out.println(readexcel);
			System.out.println(Arrays.toString(readexcel.get(i)));
		
			}	
			
//			public Hashtable<Integer, String[]> Execute(Map<String, String> TestInput) throws InterruptedException 
			return readexcel;
	
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException{
	
	int rowcount= GetRowCount("E:\\eclipse-workspace\\ejagruti\\Excel_Operations.xlsx","Sheet1");
	System.out.println(rowcount);	
	int colcount= GetColumnCount("E:\\eclipse-workspace\\ejagruti\\Excel_Operations.xlsx","Sheet1",1);
	System.out.println("colcount: "+colcount);	
	String cellstring = GetCellData("E:\\eclipse-workspace\\ejagruti\\Excel_Operations.xlsx","Sheet1",1,0);
	//GetCellData(String filename,int sheetno, int colno, int rowno);
	//System.out.println(cellstring);	
	//SetCellData("E:\\eclipse-workspace\\ejagruti\\Excel_Operations.xlsx","Sheet1",2,6,"BBBBBBBB");
	//SetCellData(filename, sheetno, colno, rowno, datastring);	
	
	ReadAllExcelFile("E:\\eclipse-workspace\\ejagruti\\Excel_Operations.xlsx","Sheet1");
	}


	

}
