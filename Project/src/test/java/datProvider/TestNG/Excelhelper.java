package datProvider.TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excelhelper {
	
	private static HSSFSheet ExcelWSheet;
	 
	private static HSSFWorkbook ExcelWBook;

	private static HSSFCell Cell;

	private static HSSFRow Row;
	
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new HSSFWorkbook(ExcelFile);
		 
		ExcelWSheet = ExcelWBook.getSheet(SheetName);

	}

	 public static String getCellData(int RowNum, int ColNum){
		 
		 
		 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		 
			String CellData = Cell.getStringCellValue();

			return CellData;
		 
	 }
	 @SuppressWarnings("deprecation")
	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception {
		 
		 Row  = ExcelWSheet.getRow(RowNum);
		 
			Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

	 }

	 public static int getRowContains(String sTestCaseName, int colNum) {
		 int rowCount = Excelhelper.getRowUsed();
		 int i;
		 for (i=0 ; i<=rowCount; i++){
			 
				if  (Excelhelper.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

					break;
				}
			}
			return i;
	 }

	 public static int getRowUsed() {
		 
		 int RowCount = ExcelWSheet.getLastRowNum();
		 return RowCount;
		 
	 }
	 
}
