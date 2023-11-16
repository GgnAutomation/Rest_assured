package api.utilities;

import org.testng.annotations.DataProvider;

public class Data_provider {

	String path = System.getProperty("user.dir")+"//Test_Data//dumy_data.xlsx";
	ExcelUtility ob;
	@DataProvider(name ="Data")
	public String[][] getallData()
	{
		ob = new ExcelUtility(path);
		int colcount = ob.columncount("Sheet1");
		int rowcount = ob.rowcount("Sheet1");
		String apidata[][] = new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=ob.celldata(i, j, "Sheet1");
			}
		}
		return apidata;
	}
	@DataProvider(name ="UserNames")
	public String[] getusername()
	{
		ob = new ExcelUtility(path);
		int rowcount = ob.rowcount("Sheet1");
		String username[] = new String[rowcount];
		for(int k=1;k<=rowcount;k++)
		{
			username[k-1]=ob.celldata(k, 1, "Sheet1");
		}
		return username;
		
	}
}
