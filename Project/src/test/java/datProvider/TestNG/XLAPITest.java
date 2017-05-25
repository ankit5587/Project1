package datProvider.TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class XLAPITest {

	public FileInputStream fis = null;
	public HSSFWorkbook wb = null;
	public HSSFSheet sheet = null;
	public HSSFRow row = null;
	public HSSFCell cell = null;

	public XLAPITest(String XlFilePath) throws Exception {

		fis = new FileInputStream(XlFilePath);
		wb = new HSSFWorkbook(fis);
	}

	public String getCellData(String Sheet, int rowNo, int colNo) {

		sheet = wb.getSheet(Sheet);

		row = sheet.getRow(rowNo);

		cell = row.getCell(colNo);

		if (cell.getCellTypeEnum() == CellType.STRING)
			return cell.getStringCellValue();

		else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
			String cellValue = String.valueOf(cell.getNumericCellValue());

			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				DateFormat df = new SimpleDateFormat("dd/MM/yy");
				Date date = cell.getDateCellValue();
				cellValue = df.format(date);
			}

			return cellValue;
		}

		else if (cell.getCellTypeEnum() == CellType.BLANK)
			return "";

		else
			return String.valueOf(CellType.BOOLEAN);
	}

	public String getCellData(String Sheet, int rowNo, String colName) {

		sheet = wb.getSheet(Sheet);
		row = sheet.getRow(0);

		int colNo = -1;

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
				colNo = i;
				break;
			}
		}
		System.out.println(colNo);
		row = sheet.getRow(rowNo);
		cell = row.getCell(colNo);

		if (cell.getCellTypeEnum() == CellType.STRING)
			return cell.getStringCellValue();

		else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
			String cellValue = String.valueOf(cell.getNumericCellValue());

			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				DateFormat df = new SimpleDateFormat("dd/MM/yy");
				Date date = cell.getDateCellValue();
				cellValue = df.format(date);
			}

			return cellValue;
		}

		else if (cell.getCellTypeEnum() == CellType.BLANK)
			return "";

		else
			return String.valueOf(CellType.BOOLEAN);
	}

	public Object[][] getTableArray(String XlFilePath, String Sheet) throws Exception
	{
		String[][] tabArray = null;

		sheet = wb.getSheet("sheet1");

		int startRow = 1;
		int startCol = 1;
		int ci, cj;

		row = sheet.getRow(0);
		
		int totalRows = sheet.getLastRowNum();

		int totalCols = row.getLastCellNum();
		
		//System.out.println(totalCols+"   " +totalRows);

		tabArray = new String[totalRows][totalCols-1];

		ci = 0;cj=0;
		for (int i = startRow; i <= totalRows; i++, ci++) 
		{
			cj = 0;
			for (int j = startCol; j <totalCols; j++, cj++) 
			{
				tabArray[ci][cj] = getCellData(Sheet, i, j);
				System.out.println(tabArray[ci][cj]);
			}
		}
		
		
		return tabArray;
		
		

	}
	
	public  String getTestCaseName(String sTestCase)
	{
		String value = sTestCase;
		int posi = value.indexOf("@");
		value = value.substring(0, posi);
		posi = value.lastIndexOf(".");	
		value = value.substring(posi + 1);
		return value;
		
	}
	
	public  int getRowContains(String sTestCaseName, int colNum)
	{
		int i;
		int rowCount = sheet.getLastRowNum();
		for ( i=0 ; i<rowCount; i++)
		{
			XLAPITest xls = null;
			if(xls.getCellData("sheet1", i,colNum).equalsIgnoreCase(sTestCaseName)){
				break;
		}
	}
	
		return i;
	}
}
