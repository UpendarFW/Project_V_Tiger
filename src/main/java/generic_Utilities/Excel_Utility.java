package generic_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String SHEETNAME,int rowNum,int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream(IConsatnts_Utility.excelfileConstant);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		Row r=sh.getRow(rowNum);
		Cell c=r.getCell(cellNum);
		
		String value=c.getStringCellValue();
		return value;	
	}
	
	public void writeDataintoExcel(String SHEETNAME,int rowNum,int cellNum,String cellValue) throws Throwable {
		FileInputStream fis=new FileInputStream(IConsatnts_Utility.excelfileConstant);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		Row r=sh.createRow(rowNum);
		Cell c=r.createCell(cellNum);
		c.setCellValue(cellValue);
		
		FileOutputStream fos=new FileOutputStream(IConsatnts_Utility.excelfileConstant);
		book.write(fos);
		
		System.out.println(cellValue+"--->"+"Added Sucessfully");
		
		book.close();
	}
	
	public Object[][] readMultipleExceldata(String SHEETNAME) throws Throwable {
		FileInputStream fis=new FileInputStream(IConsatnts_Utility.excelfileConstant);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(SHEETNAME);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object [][] data=new Object[lastRow][lastCell];
		
		for (int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}
