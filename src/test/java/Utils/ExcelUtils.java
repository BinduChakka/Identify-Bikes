package Utils;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import PageObjectModel.Newbikes;

public class ExcelUtils
{
	public static FileOutputStream fp;
	public static void excelOutput(List<String>model,List<String>price,List<String>launchdates) throws IOException
	{
		fp=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\Excel.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet1=wb.createSheet("New Bike Details");
		XSSFSheet sheet2=wb.createSheet("Popular Cars");
		int row=0;
		//System.out.println(model.size());
		for(int i=0;i<model.size();i++)
		{
			if(Newbikes.index.contains(i))
			{
				XSSFRow rows=sheet1.createRow(row);			
				rows.createCell(0).setCellValue(model.get(i));
				//System.out.println(model.get(i));
				rows.createCell(1).setCellValue(price.get(i));
				rows.createCell(2).setCellValue(launchdates.get(i));
				row+=1;
			}
		}
		wb.write(fp);
		wb.close();
		fp.close();
	}
	public static void excelOutput(List<String> popularcars) throws IOException
	{
		String path = System.getProperty("user.dir")+"\\TestData\\Excel.xlsx";
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Popular Cars");
		//fp=new FileOutputStream(System.getProperty("user.dir")+"TestData\\ExcelSheet.xlsx");
		for(int i=0;i<popularcars.size();i++) {
				XSSFRow rows=sheet.createRow(i);			
				rows.createCell(0).setCellValue(popularcars.get(i));				
		}
		fp=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\Excel.xlsx");
		wb.write(fp);
		wb.close();
		fp.close();
	}
}
 
 
