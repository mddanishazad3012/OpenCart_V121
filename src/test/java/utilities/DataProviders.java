package utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		//taking xl file from testData
		String path=".\\testData\\Opencart_LoginData.xlsx";
		//creating an object for XLUtility
		ExcelUtility xlutil=new ExcelUtility(path);
		
		//getting no of rows and columns
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",	1);
		//created for two dimension array which can store the data user and password
		String[][] logindata=new String[totalrows][totalcols];
		
		//read data from xl storing in two dimensional array
		for(int i=1; i<=totalrows; i++) //1
		{
			for(int j=0; j<totalcols; j++)//0 i is rows , j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);//1, 0
			}
		}
		return logindata; //returning two dimensional array
		
	}
}
