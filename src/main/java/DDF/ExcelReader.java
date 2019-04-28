package DDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static void main(String[] args) throws Exception  {
		
		File src= new File("/home/hp/eclipse-workspace/Data_Driven_Apache/src/main/java/ExcelFile/TestDataDDA.xlsx");
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Data_Sheet");
		
	/*	String data0=sheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println(data0);*/
		
		int rowcount=sheet.getLastRowNum();
		
		for (int i=1; i<=rowcount;i++) {
			String data= sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		}
				
	}
	

}
