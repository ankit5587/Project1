package datProvider.TestNG;

public class ReadData {

	public static void main(String[] args) throws Exception {
		XLAPITest xls = new XLAPITest("C:\\AnkitOXY\\Bajaj\\Book1.xls");
		//		System.out.println(xls.getCellData("sheet1", 0, 0));
//		System.out.println(xls.getCellData("sheet1", 10, 3));
		System.out.println(xls.getCellData("sheet1", 3, 1));
		System.out.println(xls.getCellData("sheet1", 3, "Password"));
		System.out.println(xls.getCellData("sheet1", 2, "Result"));
		System.out.println(xls.getCellData("sheet1", 2, "UserName"));
		
	}

}
