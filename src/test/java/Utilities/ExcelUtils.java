package Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;
	
	public static void main(String[] args) {
	/*	String FilePath = "C://Users//saukala//Desktop//SampleData_DAR_0622.xlsx" ;
		try {
			getTableArray(FilePath, "DAR");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 1;

			int startCol = 0;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();

			// you can write a function as well to get Column count

			int totalCols = 25;

			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j < totalCols; j++, cj++) {

					tabArray[ci][cj] = getCellData(i, j);

					System.out.println(tabArray[ci][cj]);

				}

			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			CellType dataType = Cell.getCellType();

			if (dataType == CellType.BLANK) {

				return "";

			} else if (dataType == CellType.NUMERIC){

				long cellValue = (long) Cell.getNumericCellValue();
				String cellData = String.valueOf(cellValue);
				return cellData;

			} 
			else {

				String CellData = Cell.getStringCellValue();

				return CellData;

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}

	
	
	
	public static void setDCRNumber(String rowName,String colName, String value) throws Exception {	
		String sheet="DAR";
		
		FileInputStream fsIP= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\DAR_RecordType_HCP.xlsx"); //Read the spreadsheet that needs to be updated
		                 
						ExcelWBook = new XSSFWorkbook(fsIP); //Access the workbook
		                 
		                ExcelWSheet = ExcelWBook.getSheet(sheet); //Access the worksheet, so that we can update / modify it.
		             
		                //CellType dataType = Cell.getCellType();
		                // declare a Cell object
		                //	int row= getRowCount("DAR","DCRName");  
		                int	row= getRowNumber(rowName);
		                int col= getColumnNumber(colName);
		    			Cell = ExcelWSheet.getRow(row).getCell(col);
		            
		             // Access the second cell in second row to update the value
		                Cell.setCellValue(value);  // Get current cell value value and overwrite the value
					System.out.println("cell value is: "+Cell.getStringCellValue());
		                fsIP.close(); //Close the InputStream
		                
		                FileOutputStream output_file =new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\DAR_RecordType_HCP.xlsx");  //Open FileOutputStream to write updates
		                 
		                ExcelWBook.write(output_file); //write changes
		                 
		                output_file.close();  //close the stream    
		                System.out.println("Done");	            
	}
	

	private static int getColumnNumber(String colName) throws Exception {
	
		int colValue = 0;
String SheetName= "DAR";
		FileInputStream ExcelFile = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//DAR_RecordType_HCP.xlsx"));

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		int startRow = 0;

		int startCol = 0;
	//	int totalRows = ExcelWSheet.getLastRowNum();

		// you can write a function as well to get Column count

		int totalCols = 25;

		for (int i = 0; i < totalCols; i++) {
				String data = getCellData(0, i );
				if(data.equals(colName)) {
					colValue=i;
					break;
				}
				}
			
		return colValue;
	}

	private static int getRowNumber(String rowNumber) throws IOException {
		int rowValue = 0;
String SheetName= "DAR";
		FileInputStream ExcelFile = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//DAR_RecordType_HCP.xlsx"));

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		int startRow = 1;

		int startCol = 0;

		int ci, cj;

		int totalRows = ExcelWSheet.getLastRowNum();

		// you can write a function as well to get Column count

		int totalCols = 25;

		ci = 0;

		for (int i = startRow; i <= totalRows; i++, ci++) {

			cj = 0;

			for (int j = startCol; j < totalCols; j++, cj++) {

			String data;
			try {
				data = getCellData(i, j);
				if(data.equals(rowNumber)) {
					rowValue=i;
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
			}

		}

		return rowValue;
	}

	public static int getRowCount(String sheet, String string2) throws Exception {
		int colCount=0;
		FileInputStream fsIP= new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//DAR_RecordType_HCP.xlsx")); //Read the spreadsheet that needs to be updated
        
        XSSFWorkbook wb=null;
		try {
			wb = new XSSFWorkbook(fsIP);
		} catch (IOException e) {	
			e.printStackTrace();
		} 
         
        XSSFSheet worksheet = wb.getSheet(sheet); 
        for(int i=0;i<1000;i++) {
        	
       String data= getCellData(i, 20);
       System.out.println("value is : "+data);
        	 if(data.equals("")) {
        		 colCount=i;
        	 }
        }
		return colCount;

		}	
	}