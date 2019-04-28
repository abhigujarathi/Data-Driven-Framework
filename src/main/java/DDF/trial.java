package DDF;

import Library.ExcelDataConfig;

public class trial {

	public static void main(String[] args) throws Exception {
		ExcelDataConfig excel= new ExcelDataConfig("/home/hp/eclipse-workspace/Data_Driven_Apache/src/main/java/ExcelFile/TestDataDDA.xlsx", "Data_Sheet");
		System.out.println(excel.getData( 2, 0));


	}

}
