package test.bajaj.selenium;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import datProvider.TestNG.XLAPITest;

public class ExcelTabTest {

	public static void main(String[] args) throws Exception {
		XLAPITest xls= new XLAPITest("C:\\AnkitOXY\\Bajaj\\Book1.xls");
		
		 HSSFSheet sheet = xls.wb.getSheet("Sheet1");
		 System.out.println(sheet.getLastRowNum());

	//	Object[][] x = xls.getTableArray("C:\\AnkitOXY\\Bajaj\\Book1.xls", "Sheet1");
	//	System.out.println(x);
		
		/*
				Object a[][]= new Object[][] {{xls.getCellData("Sheet1",1, "FirstName"),xls.getCellData("Sheet1",1, "LastName"),xls.getCellData("Sheet1",1, "Address"),xls.getCellData("Sheet1",1, "Email")},
			   {xls.getCellData("Sheet1",2, "FirstName"),xls.getCellData("Sheet1",2, "LastName"),xls.getCellData("Sheet1",2, "Address"),xls.getCellData("Sheet1",2, "Email")},		
				   {xls.getCellData("Sheet1",3, "FirstName"),xls.getCellData("Sheet1",3, "LastName"),xls.getCellData("Sheet1",3, "Address"),xls.getCellData("Sheet1",3, "Email")},
				   {xls.getCellData("Sheet1",4, "FirstName"),xls.getCellData("Sheet1",4, "LastName"),xls.getCellData("Sheet1",4, "Address"),xls.getCellData("Sheet1",4, "Email")},
				   
				};*/

		}
	}
