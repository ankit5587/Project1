package datProvider.TestNG;

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadDataByColNumber {
	
	
	public static void main(String[] args) throws Exception {
		
	
	FileInputStream fis = new FileInputStream("C:\\AnkitOXY\\Bajaj\\Book1.xls");
	HSSFWorkbook wb = new HSSFWorkbook(fis);
	HSSFSheet sheet1 = wb.getSheet("sheet1");
	
	HSSFRow row = sheet1.getRow(1);
	
	HSSFCell cell = row.getCell(2);
	
	String value = cell.getStringCellValue();
	String value1 =String.valueOf(cell);
	
	System.out.println(value1+value);
	wb.close();
	}
}
