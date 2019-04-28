package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	
	public ExcelDataConfig(String excelpath, String sheetname) throws Exception {
		File src = new File(excelpath);
		FileInputStream fis= new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet=wb.getSheet(sheetname);
	}
	
	public String getData (int rownum, int columnno) {
		String data=sheet.getRow(rownum).getCell(columnno).getStringCellValue();
		return data;
	}
	
	public int getrowcount(String sheetname) {
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
		//rowcount=rowcount+1;
		return rowcount;
	}

}
